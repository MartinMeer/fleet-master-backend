# Working with Maven in Container: Best Practices

You're absolutely right! When using this containerized development environment, you should use Maven inside the container rather than your local Maven installation. This ensures consistent builds, dependencies, and environment settings across all development machines.

## Maven in Container: Complete Guide

### 1. Accessing Maven in the Container

You have a few ways to work with Maven in your container:

#### Option A: Execute Maven Commands Directly in Container

```bash
# Open a terminal in the container
docker exec -it javadev bash

# Navigate to your project directory
cd /workspaces

# Run Maven commands
mvn clean install
mvn spring-boot:run
```

#### Option B: Run Single Maven Commands from Host

```bash
# Run a specific Maven command without entering the container
docker exec -it javadev mvn -f /workspaces/pom.xml clean install
```

#### Option C: Create Shell Script Helpers

Create a `mvn-docker.sh` script on your host machine:

```bash
#!/bin/bash
# Save this as mvn-docker.sh and make executable with: chmod +x mvn-docker.sh

docker exec -it javadev mvn -f /workspaces/pom.xml "$@"
```

Then use it like regular Maven:
```bash
./mvn-docker.sh clean install
./mvn-docker.sh spring-boot:run
```

### 2. IDE Configuration

#### VS Code

If using VS Code with the Remote SSH extension:

1. Open VS Code
2. Use Remote SSH to connect to your VM
3. Open Terminal in VS Code
4. Run Maven commands directly (which will use the container's Maven)

#### IntelliJ IDEA

Configure IntelliJ to use the container's Maven:

1. Open your project in IDEA
2. Go to `Settings/Preferences` > `Build, Execution, Deployment` > `Build Tools` > `Maven`
3. Click `+` to add a new Maven installation
4. Select `From Docker` or create a custom Maven wrapper:

Create a Maven wrapper script (`mvnw`) in your project root:

```bash
#!/bin/bash
docker exec -i javadev mvn "$@"
```

Make it executable:
```bash
chmod +x mvnw
```

Then configure IntelliJ to use this wrapper.

### 3. Working with the Maven Cache

Your Docker Compose configuration already mounts a `maven-cache` volume to `/home/vscode/.m2` in the container, which means:

- Maven dependencies will be cached between container restarts
- You won't need to download dependencies repeatedly
- Build performance will be improved

You can inspect the cache with:

```bash
docker exec -it javadev ls -la /home/vscode/.m2/repository
```

### 4. Custom Maven Settings

If you need custom Maven settings:

```bash
# Create a custom settings.xml
docker exec -it javadev bash -c 'cat > /home/vscode/.m2/settings.xml << EOF
<settings>
  <mirrors>
    <mirror>
      <id>your-mirror</id>
      <name>Your Maven Mirror</name>
      <url>https://your-repo-url/repository/maven-public/</url>
      <mirrorOf>*</mirrorOf>
    </mirror>
  </mirrors>
</settings>
EOF'
```

### 5. Running Tests

Run tests inside the container:

```bash
docker exec -it javadev mvn test
```

For specific test classes:

```bash
docker exec -it javadev mvn test -Dtest=YourTestClass
```

### 6. Debugging Maven Builds

For debugging Maven issues:

```bash
docker exec -it javadev mvn clean install -X
```

### 7. Maven Plugins & Java Versions

Your container image already includes Java 21 (from the base image `mcr.microsoft.com/devcontainers/java:1-21-bullseye`). To ensure your Maven build uses this version:

Check your pom.xml has:

```xml
<properties>
    <maven.compiler.source>21</maven.compiler.source>
    <maven.compiler.target>21</maven.compiler.target>
    <java.version>21</java.version>
</properties>
```

### 8. Helpful Maven Commands for Your Project

Here are some common Maven commands you'll use with your Jakarta backend:

```bash
# Clean and build
docker exec -it javadev mvn clean install

# Skip tests during build
docker exec -it javadev mvn clean install -DskipTests

# Run your application
docker exec -it javadev mvn spring-boot:run

# Build production JAR
docker exec -it javadev mvn clean package

# Check for dependency updates
docker exec -it javadev mvn versions:display-dependency-updates

# Generate project information site
docker exec -it javadev mvn site
```

## Advantages of Using Container Maven vs. Local Maven

1. **Environment Consistency**: Everyone uses the exact same Maven version and JDK
2. **Isolation**: No conflicts with other projects or system dependencies
3. **Portability**: Works the same way on any machine that can run Docker
4. **Dependency Management**: Maven cache is stored in a Docker volume
5. **Integration**: Direct access to the PostgreSQL database container
6. **Resource Management**: Build resource usage is contained within Docker limits

## Common Issues and Troubleshooting

### Permission Problems

If you encounter permission issues:

```bash
docker exec -it javadev bash
sudo chown -R vscode:vscode /home/vscode/.m2
```

### Memory Issues During Build

If Maven runs out of memory:

```bash
docker exec -it javadev mvn clean install -Dmaven.compiler.fork=true -Dmaven.compiler.maxmem=2048m
```

### Network Issues with Dependencies

If dependencies can't be downloaded:

```bash
# Check network connectivity
docker exec -it javadev ping -c 3 maven.org

# Try with a specific repository
docker exec -it javadev mvn -U clean install -Dmaven.repo.remote=https://repo1.maven.org/maven2
```

## Summary: Best Practice Workflow

1. **Development**:
    - Edit code on your local machine
    - Files are automatically synced to container via mount
    - Run Maven commands in container
    - Access application at http://localhost:8080

2. **Building**:
    - Always build with container Maven
    - Use `docker exec -it javadev mvn clean install`

3. **Debugging**:
    - Configure your IDE to connect to the remote JVM in container
    - For Maven issues, use verbose flags: `-X` or `-e`

4. **Database**:
    - Access directly from Java code using `localhost:5432`
    - Data is persisted in the `postgres-data` volume

Following this workflow ensures consistent builds, proper dependency management, and seamless integration with your PostgreSQL database - all in a controlled environment that matches your production setup.

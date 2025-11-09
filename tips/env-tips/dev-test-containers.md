# Jakarta Project Setup with Dev & Test Containers

## Development Environment Setup Plan

This guide provides step-by-step instructions for setting up a Jakarta EE backend with DevContainers for development and TestContainers for integration testing.

## Prerequisites

- IntelliJ IDEA (Ultimate preferred for full Jakarta EE support)
- Docker Desktop installed and running
- Maven-based Jakarta EE project
- PostgreSQL database requirements

## 1. DevContainer Setup

### 1.1 Install DevContainer Plugin in IntelliJ

1. Open IntelliJ IDEA
2. Navigate to `Settings/Preferences > Plugins`
3. Search for "Dev Containers" or "Remote Development"
4. Install the plugin and restart IntelliJ

### 1.2 Create DevContainer Configuration

1. Create a `.devcontainer` directory in your project root
2. Create two files inside this directory:

`devcontainer.json`:
```json
{
  "name": "Jakarta EE Development",
  "dockerComposeFile": "docker-compose.yml",
  "service": "app",
  "workspaceFolder": "/workspace",
  "customizations": {
    "vscode": {
      "extensions": [
        "vscjava.vscode-java-pack",
        "redhat.vscode-microprofile"
      ]
    }
  },
  "forwardPorts": [8080],
  "remoteUser": "vscode"
}
```

`docker-compose.yml`:
```yaml
version: '3.8'

services:
  app:
    build: 
      context: .
      dockerfile: Dockerfile
    volumes:
      - ../:/workspace:cached
      - maven-cache:/root/.m2
    command: sleep infinity
    networks:
      - backend

  postgres:
    image: postgres:16
    restart: unless-stopped
    environment:
      POSTGRES_PASSWORD: postgres
      POSTGRES_USER: postgres
      POSTGRES_DB: jakartadb
    volumes:
      - postgres-data:/var/lib/postgresql/data
    ports:
      - "5432:5432"
    networks:
      - backend

volumes:
  maven-cache:
  postgres-data:

networks:
  backend:
```

`Dockerfile`:
```dockerfile
FROM mcr.microsoft.com/vscode/devcontainers/java:17

# Install Maven
ARG MAVEN_VERSION=3.9.6
RUN mkdir -p /usr/share/maven /usr/share/maven/ref \
  && curl -fsSL -o /tmp/apache-maven.tar.gz https://apache.osuosl.org/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
  && tar -xzf /tmp/apache-maven.tar.gz -C /usr/share/maven --strip-components=1 \
  && rm -f /tmp/apache-maven.tar.gz \
  && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

# Install additional tools (optional)
RUN apt-get update && apt-get install -y curl wget jq

# Set environment variables
ENV MAVEN_HOME /usr/share/maven
ENV MAVEN_CONFIG "/root/.m2"
```

### 1.3 Open Project in DevContainer

1. From IntelliJ, go to `File > Open in Dev Container`
2. Select your project
3. Wait for the container to build and start
4. IntelliJ will reopen connected to the development container

## 2. TestContainers Setup

### 2.1 Add TestContainers Dependencies

Add to your `pom.xml`:

```xml
<dependencies>
    <!-- TestContainers Core -->
    <dependency>
        <groupId>org.testcontainers</groupId>
        <artifactId>testcontainers</artifactId>
        <version>1.19.3</version>
        <scope>test</scope>
    </dependency>
    
    <!-- JUnit 5 extension for TestContainers -->
    <dependency>
        <groupId>org.testcontainers</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>1.19.3</version>
        <scope>test</scope>
    </dependency>
    
    <!-- PostgreSQL module for TestContainers -->
    <dependency>
        <groupId>org.testcontainers</groupId>
        <artifactId>postgresql</artifactId>
        <version>1.19.3</version>
        <scope>test</scope>
    </dependency>
    
    <!-- JUnit 5 dependencies -->
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.10.1</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

### 2.2 Configure TestContainers for Integration Tests

Create a base test class:

```java
package com.example.test;

import org.junit.jupiter.api.BeforeAll;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public abstract class AbstractIntegrationTest {

    @Container
    protected static final PostgreSQLContainer<?> POSTGRES = 
        new PostgreSQLContainer<>("postgres:16")
            .withDatabaseName("testdb")
            .withUsername("test")
            .withPassword("test");

    @BeforeAll
    static void setupJdbcProperties() {
        // Set system properties for your Jakarta persistence unit
        System.setProperty("jakarta.persistence.jdbc.url", POSTGRES.getJdbcUrl());
        System.setProperty("jakarta.persistence.jdbc.user", POSTGRES.getUsername());
        System.setProperty("jakarta.persistence.jdbc.password", POSTGRES.getPassword());
    }
}
```

### 2.3 Create an Integration Test

```java
package com.example.test;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest extends AbstractIntegrationTest {
    
    private UserRepository userRepository = new UserRepository();
    
    @Test
    void testCreateAndRetrieveUser() {
        // Test your repository with a real PostgreSQL instance
        User user = new User();
        user.setUsername("testuser");
        user.setEmail("test@example.com");
        
        User savedUser = userRepository.save(user);
        assertNotNull(savedUser.getId());
        
        User retrievedUser = userRepository.findById(savedUser.getId());
        assertEquals("testuser", retrievedUser.getUsername());
    }
}
```

## 3. Database Configuration

### 3.1 Configure Jakarta Persistence Unit for Development

Create or update `src/main/resources/META-INF/persistence.xml`:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence version="3.0" xmlns="https://jakarta.ee/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="https://jakarta.ee/xml/ns/persistence 
             https://jakarta.ee/xml/ns/persistence/persistence_3_0.xsd">
    
    <persistence-unit name="jakartaPU" transaction-type="JTA">
        <properties>
            <property name="jakarta.persistence.jdbc.driver" value="org.postgresql.Driver"/>
            <property name="jakarta.persistence.jdbc.url" value="jdbc:postgresql://postgres:5432/jakartadb"/>
            <property name="jakarta.persistence.jdbc.user" value="postgres"/>
            <property name="jakarta.persistence.jdbc.password" value="postgres"/>
            
            <!-- Hibernate properties -->
            <property name="hibernate.show_sql" value="true"/>
            <property name="hibernate.format_sql" value="true"/>
            <property name="hibernate.hbm2ddl.auto" value="update"/>
        </properties>
    </persistence-unit>
</persistence>
```

## 4. Build & Run Project

### 4.1 Build within DevContainer

```bash
mvn clean package
```

### 4.2 Run Integration Tests

```bash
mvn verify
```

## 5. Next Steps

- Set up database migrations with Flyway or Liquibase
- Configure CI/CD pipeline with GitHub Actions
- Add OpenAPI/Swagger for API documentation
- Set up monitoring and logging infrastructure

## Troubleshooting

### Common DevContainer Issues

- **Docker not running**: Ensure Docker Desktop is running before opening DevContainer
- **Port conflicts**: Check if ports 8080 or 5432 are already in use on your host machine
- **Volume mounting issues**: Verify Docker has permission to access your project directory

### TestContainers Issues

- **Docker socket not found**: Ensure Docker is properly configured for TestContainers
- **Slow tests**: Consider using TestContainers' reuse feature for faster test execution

---

Would you like me to elaborate on any specific section of this plan?

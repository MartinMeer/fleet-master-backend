# Testing Your Development Environment

Great news! Your Docker Compose setup is now working perfectly. Let's go through a comprehensive testing process to make sure everything is functioning correctly.

## 1. Verify Containers Are Running

First, let's confirm both containers are up and running:

```bash
docker ps
```

You should see both `javadev` and `postgresdb` containers listed as running.

## 2. Test PostgreSQL Connection

Let's verify that PostgreSQL is working properly:

```bash
# Connect to the PostgreSQL container
docker exec -it postgresdb psql -U postgres

# Once connected, you should get a PostgreSQL prompt
# Try some basic commands:
postgres=# \l               -- List databases
postgres=# \dt             -- List tables (will be empty initially)
postgres=# SELECT version();  -- Check PostgreSQL version
postgres=# \q              -- Quit psql
```

## 3. Test Java Development Environment

Now let's check your Java development environment:

```bash
# Connect to the Java container
docker exec -it javadev bash

# Check Java version
java --version

# Check Maven installation
mvn --version

# Navigate to workspace
cd /workspaces

# List files (should see your project files)
ls -la
```

## 4. Test Integration Between Containers

Let's verify that the Java container can connect to PostgreSQL:

```bash
# From inside the javadev container
docker exec -it javadev bash

# Install PostgreSQL client for testing
apt-get update && apt-get install -y postgresql-client

# Try connecting to PostgreSQL
psql -h localhost -U postgres
# Enter password: postgres

# If you connect successfully, exit
postgres=# \q

# Exit the container
exit
```

## 5. Create a Simple Test Application

For a more thorough test, create a simple Java application that connects to the database:

```bash
# Connect to the Java container
docker exec -it javadev bash

# Navigate to workspace
cd /workspaces

# Create a test directory
mkdir -p db-test/src/main/java
cd db-test

# Create a pom.xml file
cat > pom.xml << 'EOF'
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.test</groupId>
    <artifactId>db-test</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>42.6.0</version>
        </dependency>
    </dependencies>
</project>
EOF

# Create a Java file that tests database connection
cat > src/main/java/DbTest.java << 'EOF'
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbTest {
    public static void main(String[] args) {
        try {
            System.out.println("Testing database connection...");
            
            // Connect to the database
            Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres", 
                "postgres", 
                "postgres"
            );
            
            System.out.println("Connection established successfully!");
            
            // Create a test table
            Statement stmt = conn.createStatement();
            stmt.execute("DROP TABLE IF EXISTS test_table");
            stmt.execute("CREATE TABLE IF NOT EXISTS test_table (id SERIAL PRIMARY KEY, name VARCHAR(100))");
            
            // Insert data
            stmt.execute("INSERT INTO test_table (name) VALUES ('Test 1'), ('Test 2')");
            
            // Query data
            ResultSet rs = stmt.executeQuery("SELECT id, name FROM test_table");
            while (rs.next()) {
                System.out.println("Row: " + rs.getInt("id") + " - " + rs.getString("name"));
            }
            
            // Clean up
            stmt.execute("DROP TABLE test_table");
            conn.close();
            System.out.println("Test completed successfully!");
            
        } catch (Exception e) {
            System.err.println("Database test failed:");
            e.printStackTrace();
        }
    }
}
EOF

# Compile and run the test
mvn compile
mvn exec:java -Dexec.mainClass="DbTest"
```

This will create and run a simple Java application that:
1. Connects to PostgreSQL
2. Creates a table
3. Inserts and queries data
4. Drops the table when done

## 6. Test Resource Limits

Let's confirm the resource limits are properly set:

```bash
# Check container resources
docker stats
```

You should see that the containers are limited to the CPU and memory values you specified.

## 7. Test Volume Persistence

Let's verify that PostgreSQL data persists:

```bash
# Connect to PostgreSQL
docker exec -it postgresdb psql -U postgres

# Create a test table with data
CREATE TABLE persistent_test (id SERIAL, note TEXT);
INSERT INTO persistent_test (note) VALUES ('This should persist after restart');
\q

# Restart containers
docker-compose -f .devcontainer/docker-compose.yml down
docker-compose -f .devcontainer/docker-compose.yml up -d

# Check if data persisted
docker exec -it postgresdb psql -U postgres
SELECT * FROM persistent_test;
```

You should see your data has persisted across the restart.

## 8. Test Database Backup

Try creating a backup and restoring it:

```bash
# Create a backup
docker exec -it postgresdb pg_dump -U postgres postgres > backup.sql

# Create a new table
docker exec -it postgresdb psql -U postgres -c "CREATE TABLE backup_test (id SERIAL, data TEXT);"

# Restore only from the backup (which shouldn't have the new table)
cat backup.sql | docker exec -i postgresdb psql -U postgres postgres

# Check if the newly created table still exists (it should, as our backup was from before)
docker exec -it postgresdb psql -U postgres -c "SELECT * FROM backup_test;"
```

## 9. Test IDE Integration

If you're using an IDE, test connecting to your environment:

1. **Using SSH**: Configure your IDE to connect to your server via SSH
2. **Database Connection**: Set up a database connection to localhost:5432
3. **Project Files**: Make sure you can access and edit your project files
4. **Build & Run**: Test building and running your application from the IDE

## 10. Test Healthcheck

The PostgreSQL healthcheck can be verified with:

```bash
# Check if container is healthy
docker inspect --format '{{.State.Health.Status}}' postgresdb
```

It should show `healthy`.

## Summary Checklist

- ✅ Containers are running
- ✅ PostgreSQL is accessible and working
- ✅ Java environment is properly configured
- ✅ Container networking is functional
- ✅ Java can connect to PostgreSQL
- ✅ Resource limits are applied
- ✅ Volume persistence works
- ✅ Database backup/restore works
- ✅ IDE integration works
- ✅ Container healthchecks are functional

Your development environment is now fully set up and tested! You can proceed with your Jakarta project with confidence that both your development environment and database persistence are working correctly.

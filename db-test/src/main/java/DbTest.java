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

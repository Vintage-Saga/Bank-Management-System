package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConnectionFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/schema"; // Update with your database name
    private static final String USER = "root"; // Update with your database username
    private static final String PASSWORD = "Kaari@2006"; // Update with your database password

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC Driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void initializeDatabase() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
             
            // Read schema.sql file and execute the SQL commands
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                ConnectionFactory.class.getResourceAsStream("schema.sql")));
            String line;
            StringBuilder sql = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sql.append(line).append("\n");
            }
            statement.execute(sql.toString());
            System.out.println("Database initialized successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
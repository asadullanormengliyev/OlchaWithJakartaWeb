package pdp.uz.olchawithjakartaweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DatabaseConnection {

    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "0000";
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";

    protected Connection connection() {
        try {
            Class.forName("org.postgresql.Driver"); // Drayverni yuklash
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("PostgreSQL driver not found", e);
        } catch (SQLException e) {
            throw new RuntimeException("Database connection failed", e);
        }
    }

}

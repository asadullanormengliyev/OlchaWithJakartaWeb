package pdp.uz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "5555";

    protected Connection connection() {
        try {
            return DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

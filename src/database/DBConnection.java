package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // We establish the info for the connection to the database (as good practice this should be moved to a .env, will do later)
    private static final String URL = "jdbc:msql://localhost:3306/school_management";
    private static final String USER = "root";
    private static final String PASSWORD = "pass123";


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

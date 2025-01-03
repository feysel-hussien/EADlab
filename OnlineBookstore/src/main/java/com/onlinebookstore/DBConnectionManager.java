package com.onlinebookstore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
@Setter
@NoArgsConstructor
public class DBConnectionManager {
    private String jdbcUrl = "jdbc:mysql://localhost:3306/BookstoreDB";
    private String username = "root";
    private String password = "7079"; 

    private Connection connection;

    public void openConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Database connection established successfully.");
        }
    }

    // Method to close a database connection
    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("Database connection closed successfully.");
        }
    }
}

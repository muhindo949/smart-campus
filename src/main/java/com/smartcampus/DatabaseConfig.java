package com.smartcampus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    private static final String URL =
            getEnv("DB_URL", "jdbc:mysql://localhost:3306/smart_campus");

    private static final String USER =
            getEnv("DB_USER", "smartcampus");

    private static final String PASSWORD =
            getEnv("DB_PASSWORD", "smartcampus123");

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            throw new SQLException(
                    "MySQL JDBC Driver not found.",
                    e
            );
        }

        return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
        );
    }

    private static String getEnv(
            String name,
            String defaultValue) {

        String value = System.getenv(name);

        if (value == null || value.isBlank()) {
            return defaultValue;
        }

        return value;
    }
}

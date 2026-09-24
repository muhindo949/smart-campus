package com.smartcampus;

import java.sql.Connection;

public class DatabaseTest {

    public static void main(String[] args) {
        try {
            Connection conn = DatabaseConfig.getConnection();

            System.out.println("================================");
            System.out.println("DATABASE CONNECTION SUCCESSFUL");
            System.out.println("================================");
            System.out.println("Database: " + conn.getCatalog());

            conn.close();

        } catch (Exception e) {
            System.out.println("DATABASE CONNECTION FAILED");
            e.printStackTrace();
        }
    }
}

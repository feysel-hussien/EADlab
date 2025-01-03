package com.onlinebookstore;

public class TestDBConnection {
    public static void main(String[] args) {
        DBConnectionManager dbManager = new DBConnectionManager();

        try {
            dbManager.openConnection();
            System.out.println("Connection successful!");
            dbManager.closeConnection();
            System.out.println("Connection closed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

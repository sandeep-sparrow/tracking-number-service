package com.engineeringwithsandeep.learning.functional;

public class DatabaseConnection {

    private DatabaseConnection() {
        System.out.println("Establishing database connection");
    }

    public static DatabaseConnection connect() {
        return new DatabaseConnection();
    }

    public void query(String query) {
        System.out.println("Executing query: " + query);
    }
}

package com.example.ecommerce;

public class App {
    public static void main(String[] args) {
        System.out.println("Project Running");
        String csvPath = "products.csv"; // Make sure it's in the root directory or give full path
        CSVLoader.loadCSV(csvPath);
    }
}

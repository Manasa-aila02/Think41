package com.example.ecommerce;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CSVLoader {

    public static void loadCSV(String csvPath) {
        String sql = "INSERT INTO products (id, cost, category, name, brand, retail_price, department, sku, distribution_center_id) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (
            BufferedReader reader = new BufferedReader(new FileReader(csvPath));
            Connection conn = DB_Util.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            String line;
            reader.readLine(); // skip header

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                stmt.setInt(1, Integer.parseInt(data[0]));
                stmt.setDouble(2, Double.parseDouble(data[1]));
                stmt.setString(3, data[2]);
                stmt.setString(4, data[3]);
                stmt.setString(5, data[4]);
                stmt.setDouble(6, Double.parseDouble(data[5]));
                stmt.setString(7, data[6]);
                stmt.setString(8, data[7]);
                stmt.setInt(9, Integer.parseInt(data[8]));

                stmt.executeUpdate();
            }

            System.out.println("CSV data inserted successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

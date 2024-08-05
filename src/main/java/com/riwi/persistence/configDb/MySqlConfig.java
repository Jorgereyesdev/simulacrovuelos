package com.riwi.persistence.configDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConfig {

    private static Connection connection;

    public static Connection openConnection() {

        String url = "jdbc:mysql://localhost:3306/riwi";
        String user = "root";
        String password = "reyes608";

        try {
            connection = DriverManager.getConnection(url, user, password);

            System.out.println("Connection established");
        } catch (SQLException error) {
            throw new RuntimeException("ERROR: Connection failed" + error.getMessage());
        }

        return connection;
    }

    public static void closeConnection() {

        if (connection != null) {
            try {
                connection.close();

                System.out.println("Connection closed");
            } catch (SQLException error) {
                throw new RuntimeException(error.getMessage());
            }
        }
    }
}

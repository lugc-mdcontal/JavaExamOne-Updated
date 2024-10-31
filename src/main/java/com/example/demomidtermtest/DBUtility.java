package com.example.demomidtermtest;

import java.util.ArrayList;
import java.sql.*;

public class DBUtility {
    private static String user = "student";
    private static String password = "student";
    private static String connectionURL = "jdbc:mysql://localhost:3306/javatest";

    public static ArrayList<Employee> getEmployees() throws SQLException {
        ArrayList<Employee> employees = new ArrayList<>();

        try (
                Connection connection = DriverManager.getConnection(connectionURL, user, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM employee")
        ) {
            while (resultSet.next()) {
                employees.add(new Employee(
                        resultSet.getInt("employeeId"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("phoneNumber"),
                        resultSet.getDate("hireDate"),
                        resultSet.getString("jobCode")
                ));
            }
        }

        return employees;
    }

    public static ArrayList<String> getAreaCodes() {
        ArrayList<String> areaCodes = new ArrayList<>();

        try (
                Connection connection = DriverManager.getConnection(connectionURL, user, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT phoneNumber FROM employee")
        ) {
            while (resultSet.next()) {
                String phoneNumber = resultSet.getString("phoneNumber");
                String[] parts = phoneNumber.split("\\.");

                if (!areaCodes.contains(parts[0])) {
                    areaCodes.add(parts[0]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        areaCodes.sort(String::compareTo);

        return areaCodes;
    }
}
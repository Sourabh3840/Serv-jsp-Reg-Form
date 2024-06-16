package com.sourabh.task.dao;
import java.util.ArrayList;
import java.util.List;

import com.sourabh.task.model.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HomeDao {

    public static List<Employee> getAllEmployees() throws ClassNotFoundException {
        String query = "SELECT * FROM employee";
        List<Employee> employeeList = new ArrayList<>();
		Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo1?allowPublicKeyRetrieval=true&useSSL=false", "root", "Sourabh@123");
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                Employee employee = new Employee();
                employee.setFirstname(rs.getString("first_name"));
                employee.setLastname(rs.getString("last_name"));
                employee.setUsername(rs.getString("username"));
                employee.setAddress(rs.getString("address"));
                employee.setContact(rs.getString("contact"));
                employee.setGender(rs.getString("gender"));
                employee.setState(rs.getString("state"));
                employee.setCity(rs.getString("city"));

                employeeList.add(employee);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return employeeList;
    }
}

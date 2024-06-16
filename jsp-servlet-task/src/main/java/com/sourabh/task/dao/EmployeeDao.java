package com.sourabh.task.dao;
import com.sourabh.task.model.Employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.SQLException;

public class EmployeeDao {

	public int registerEmployee(Employee employee) throws ClassNotFoundException {
		String Query = "INSERT INTO employee" + "(first_name,last_name,username,password,address,contact,gender,state,city) VALUES" +
	"(?,?,?,?,?,?,?,?,?);";
		int result =0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo1?allowPublicKeyRetrieval=true&useSSL=false","root","Sourabh@123");

				PreparedStatement preparedStatement= connection.prepareStatement(Query)){
				preparedStatement.setString(1,employee.getFirstname());
				preparedStatement.setString(2,employee.getLastname());
				preparedStatement.setString(3,employee.getUsername());
				preparedStatement.setString(4,employee.getPassword());
				preparedStatement.setString(5,employee.getAddress());
				preparedStatement.setString(6,employee.getContact());
				preparedStatement.setString(7,employee.getGender());
				preparedStatement.setString(8,employee.getState());
				preparedStatement.setString(9,employee.getCity());

				System.out.println(preparedStatement);
				result= preparedStatement.executeUpdate();

		}catch (SQLException e){
			e.printStackTrace();
		}
		return result;
	}
}

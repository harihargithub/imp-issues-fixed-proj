package com.greatlearning.emp.main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.greatlearning.emp.entity.Employee;

public class Main {

	static JdbcTemplate jdbcTemplateOBJ;

	// To configure the database
	static SimpleDriverDataSource dataSourceOBJ;

	// Configure the database
	static String USERNAME = "root";
	static String PASSWORD = "1504mysqlrp7@#";
	static String URL = "jdbc:mysql://localhost:3306/employee_details";

	public static SimpleDriverDataSource getDatabaseConnection() {

		// Inform the Spring code about the database
		dataSourceOBJ = new SimpleDriverDataSource();

		try {
			// Setting driver class
			dataSourceOBJ.setDriver(new com.mysql.cj.jdbc.Driver());
			dataSourceOBJ.setUrl(URL);
			dataSourceOBJ.setUsername(USERNAME);
			dataSourceOBJ.setPassword(PASSWORD);
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return dataSourceOBJ;
	}

	public static void main(String[] args) {
		// Inform the Spring code about the database
		jdbcTemplateOBJ = new JdbcTemplate(getDatabaseConnection());

		if (null != jdbcTemplateOBJ) {

			// SQL insert query
			String sqlInsertQuery = "INSERT INTO Employee(name,email,address,phoneno) VALUES (?,?,?,?)";
			for (int counter = 1; counter < 5; counter++) {
				jdbcTemplateOBJ.update(sqlInsertQuery, "Employee" + counter, "Employee" + counter + "@gl.in", "delhi",
						"1234567899");

				// Records expected to get inserted as:
				// 1. Employee1, Employee1@gl.in, delhi, 1234567899
				// 2. Employee2, Employee2@gl.in, delhi, 1234567899
				// etc.
			}

			// SQL update
			String sqlUpdateQuery = "UPDATE Employee SET email = ? WHERE name = ?";
			jdbcTemplateOBJ.update(sqlUpdateQuery, "admin@gl.in", "Employee2");

			// SQL Read Statement
			String sqlSelectQuery = "SELECT name, email, address, phoneno FROM Employee";
			List<Employee> listEmployee = jdbcTemplateOBJ.query(sqlSelectQuery, new RowMapper<Employee>() {
				public Employee mapRow(ResultSet result, int rowNum) throws SQLException {
					Employee employeeOBJ = new Employee();
					employeeOBJ.setName(result.getString("name"));
					employeeOBJ.setEmail(result.getString("email"));
					employeeOBJ.setAddress(result.getString("address"));
					employeeOBJ.setPhoneno(result.getString("phoneno"));
					return employeeOBJ;
				}
			});
			System.out.println(listEmployee);

			// SQL Delete
			String sqlDeleteQuery = "DELETE FROM Employee WHERE name = ?";
			jdbcTemplateOBJ.update(sqlDeleteQuery, "Employee1");

			// Close the connection
		} else {
			System.out.println("Please check connection");
		}
	}
}

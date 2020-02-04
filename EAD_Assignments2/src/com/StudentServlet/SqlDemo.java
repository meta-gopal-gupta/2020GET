package com.StudentServlet;

import java.sql.*;

public class SqlDemo {

	public static Connection createSqlConnection(String db_name,
			String user_name, String password) throws Exception {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
					+ db_name, user_name, password);
			System.out.println("connection success");
		} catch (Exception e) {
		
			System.out.println(e);
		}

		return con;

	}
}

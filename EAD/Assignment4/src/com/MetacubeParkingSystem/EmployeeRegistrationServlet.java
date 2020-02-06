package com.MetacubeParkingSystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmployeeRegistrationServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse responce) throws IOException{
		HttpSession session=request.getSession();  
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String organization = request.getParameter("organization");
		try {
			Connection con = sqlConnection.sqlConnect("ParkingSystem", "root", "1234");
			Statement stmt = con.createStatement();
			stmt.executeUpdate("CREATE TABLE if not exists user (id int(5) primary key AUTO_INCREMENT, name varchar(40), email varchar(40),mobile varchar(20),password varchar(25),gender varchar(20),organization varchar(40))");
			stmt.executeUpdate(String.format("insert into user(name,email,mobile,password,gender,organization) values('%s','%s','%s','%s','%s','%s')",name,email,mobile, password, gender,organization));
			
			ResultSet result = stmt.executeQuery(String.format("SELECT * FROM user WHERE 	email='%s' AND password='%s'",email,password));
			result.next();
			session.setAttribute("userId",result.getString("id"));
			PrintWriter out = responce.getWriter();
			
			out.println("<html>");
			out.println("<body>");
			out.println("<link href=\"index.css\" rel=\"StyleSheet\"");
			out.println("<div class=\"outerBox\"><div class=\"innerUpperBox\"><h1>Employee Registration Successfull</h1></div>");
			out.println("<a href=\"../../../EAD_ssignment4/VehicleRegistration.jsp\"><div class=\"innerBox\"><h1>Register Vehicle</h1></div></a>");
			out.println("<a href=\"../../../EAD_ssignment4/HomePage.jsp\"><div class=\"innerBox\"><h1>Home<br> Page</h1></div></a></div>");
			out.println("</body>");
			out.println("</html>");
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

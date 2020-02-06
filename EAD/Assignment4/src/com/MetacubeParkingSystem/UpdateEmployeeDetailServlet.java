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

public class UpdateEmployeeDetailServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();  
		if (session.getAttribute("userId") == null) {
			String site = new String("index.jsp");
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site);
		}
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String organization = request.getParameter("organization");
		int employeeId = Integer.parseInt((String)session.getAttribute("userId"));
		
		try {
			Connection con = sqlConnection.sqlConnect("ParkingSystem", "root", "1234");
			Statement stmt = con.createStatement();
			stmt.executeUpdate(String.format("UPDATE user SET name='%s',email='%s' , mobile='%s', password='%s',gender='%s',organization='%s' WHERE id=%d",
					name, email, mobile, password, gender,
					organization,employeeId));
			PrintWriter out = response.getWriter();
			
			out.println("<html>");
			out.println("<body>");
			out.println("<link href=\"index.css\" rel=\"StyleSheet\"");
			out.println("<a href=\"../../../EAD_ssignment4/HomePage.jsp\"><span id=\"home\">Home</span></a>");
			out.println("<div class=\"outerBox\"><div class=\"innerUpperBox\"><h1>Employee Detail's Updated</h1></div>");
			out.println("<a href=\"../../../EAD_ssignment4/HomePage.jsp\"><div class=\"innerBox\"><h1>Home<br> Page</h1></div></a></div>");
			out.println("</body>");
			out.println("</html>");
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

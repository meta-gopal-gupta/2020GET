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
public class SignInServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse responce) throws IOException{
		HttpSession session=request.getSession();  
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		try {
			Connection con = sqlConnection.sqlConnect("ParkingSystem", "root", "1234");
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(String.format("SELECT * FROM user WHERE 	email='%s' AND password='%s'",email,password));
			PrintWriter out = responce.getWriter();
			
			out.println("<html>");
			out.println("<body>");
			out.println("<link href=\"index.css\" rel=\"StyleSheet\"");
			out.println("<div class=\"outerBox\">");
			
			if(!result.next()){
				out.println("<div class=\"outerBox\"><div class=\"innerUpperBox\"><h1>Email or Password Wrong</h1></div>");
				out.println("<a href=\"../../../EAD_ssignment4/SignIn.html\"><div class=\"innerBox\"><h1>Sign In</h1></div></a>");
				out.println("<a href=\"../../../EAD_ssignment4/EmployeeRegistration.html\"><div class=\"innerBox\"><h1>Sign Up</h1></div></a></div>");
			}
			else{
				session.setAttribute("userId",result.getString("id"));
				out.println("<div class=\"outerBox\"><div class=\"innerUpperBox\"><h1>Sign In Successfull</h1></div>");
				out.println("<a href=\"../../../EAD_ssignment4/SelectPass.jsp\"><div class=\"innerBox\"><h1>Select Plan</h1></div></a>");
				out.println("<a href=\"../../../EAD_ssignment4/HomePage.jsp\"><div class=\"innerBox\"><h1>Home<br> Page</h1></div></a></div>");
			}
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package com.MetacubeParkingSystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VehicleRegistrationServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse responce) throws IOException{
		String vehicleCompanyName = request.getParameter("vehicleCompanyName");
		String vehicleType = request.getParameter("vehicleType");
		String vehicleNumber = request.getParameter("vehicleNumber");
		String employeeId = request.getParameter("employeeId");
		String vehileDiscription = request.getParameter("vehileDiscription");
		try {
			Connection con = sqlConnection.sqlConnect("ParkingSystem", "root", "1234");
			Statement stmt = con.createStatement();
			stmt.executeUpdate("CREATE TABLE if not exists vehicleData (id int(5) primary key AUTO_INCREMENT, vehicleCompanyName varchar(40), vehicleType varchar(40),vehicleNumber varchar(10),employeeId varchar(25),vehileDiscription varchar(50) )");
			stmt.executeUpdate(String.format("insert into vehicleData(vehicleCompanyName,vehicleType,vehicleNumber, employeeId, vehileDiscription) values('%s','%s','%s','%s','%s')",vehicleCompanyName,vehicleType,vehicleNumber, employeeId, vehileDiscription));
			PrintWriter out = responce.getWriter();
			
			out.println("<html>");
			out.println("<body>");
			out.println("<link href=\"index.css\" rel=\"StyleSheet\"");
			out.println("<a href=\"../../../EAD_ssignment4/HomePage.jsp\"><span id=\"home\">Home</span></a>");
			out.println("<div class=\"outerBox\"><div class=\"innerUpperBox\"><h1>Vehicle Registration Successfull</h1></div>");
			out.println("<a href=\"../../../EAD_ssignment4/SelectPass.jsp\"><div class=\"innerBox\"><h1>Select Pass</h1></div></a>");
			out.println("<a href=\"../../../EAD_ssignment4/HomePage.jsp\"><div class=\"innerBox\"><h1>Home<br> Page</h1></div></a></div>");
			out.println("</body>");
			out.println("</html>");
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

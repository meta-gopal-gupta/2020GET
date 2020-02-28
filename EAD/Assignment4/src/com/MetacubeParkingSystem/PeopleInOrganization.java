package com.MetacubeParkingSystem;

import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PeopleInOrganization extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();  
		if (session.getAttribute("userId") == null) {
			String site = new String("index.jsp");
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site);
		}
		String Id = (String)session.getAttribute("userId");
		try {
			Connection con = sqlConnection.sqlConnect("ParkingSystem", "root", "1234");
			Statement stmt = con.createStatement();
			ResultSet companyResult = stmt.executeQuery(String.format("SELECT * FROM user WHERE id=%s",Id));
			companyResult.next();
			String Company = companyResult.getString("organization");
			
			ResultSet result = stmt.executeQuery(String.format("SELECT * FROM user WHERE organization='%s'",Company));
			result.next();
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<link href=\"index.css\" rel=\"StyleSheet\"");
			
			out.println("<body>");
			out.println("<a href=\"../../../EAD_ssignment4/HomePage.jsp\"><span id=\"home\">Home</span></a>");
			out.println("<div class=\"outerBox\">");
			out.println("<table border=\"1px\">");
			out.println("<tr><th>SN</th><th>Name</th><th>Email</th><th>Mobile</th><th>Gender</th></tr>");
			int countSequence = 1;
			while (result.next()) {
				if(Id.equals(result.getString("id"))){
					continue;
				}
				out.println("<tr><td>" + countSequence++ + "</td><td>"
						+ result.getString("name") + "</td><td>"
						+ result.getString("email") + "</td><td>"
						+ result.getString("mobile") + "</td><td>"
						+ result.getString("gender") + "</td></tr>");
			}
			out.println("</table>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

package com.StudentServlet;

import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchStudentServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse responce) {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		Connection con;
		try {
			con = SqlDemo.createSqlConnection("StudentManagement", "root",
					"1234");
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(String.format("SELECT * FROM StudentBase where firstName='%s' AND lastName='%s' order by class", firstName,lastName));

			PrintWriter out = responce.getWriter();
			out.println("<html>");
			out.println("<link href=\"index.css\" rel=\"StyleSheet\"");
			out.println("<body>");
			out.println("<div class=\"outerBox\">");
			out.println("<table border=\"1px\">");
			out.println("<tr><th>SN</th><th>FirstName</th><th>LastName</th><th>FatherName</th><th>Email</th><th>Class</th><th>Age</th><th>Update</th></tr>");
			while (result.next()) {
				out.println("<tr><td>" + result.getString("id") + "</td><td>"
						+ result.getString("firstName") + "</td><td>"
						+ result.getString("lastName") + "</td><td>"
						+ result.getString("fathername") + "</td><td>"
						+ result.getString("email") + "</td><td>"
						+ result.getString("class") + "</td><td>"
						+ result.getString("age")
						+ "</td><td><a href=\"UpdateStudentDetail.jsp?id="+ result.getString("id") +"\">update</a></td></tr>");
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

package com.StudentServlet;

import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse responce){
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String fatherName = request.getParameter("fatherName");
		String email = request.getParameter("email");
		String className = request.getParameter("class");
		String age = request.getParameter("age");
		Connection con;
		try {
			con = SqlDemo.createSqlConnection("StudentManagement", "root", "1234");
			Statement stmt = con.createStatement();
			stmt.executeUpdate("CREATE TABLE if not exists StudentBase (id int(10) primary key AUTO_INCREMENT, firstName varchar(20),lastName varchar(20), fatherName varchar(40), email varchar(40),class varchar(10),age varchar(10) )");
			stmt.executeUpdate(String.format("insert into StudentBase(firstName,lastName , fatherName, email,class,age) values('%s','%s','%s','%s','%s','%s')",firstName,lastName,fatherName, email, className, age));
			PrintWriter out = responce.getWriter();
			
			out.println("<html>");
			out.println("<link href=\"index.css\" rel=\"StyleSheet\"");
			out.println("<body>");
			out.println("<div class=\"outerBox\">");
			out.println("<a href=\"../../../EAD_Assignments2/AddStudent.html\"><div class=\"innerBox\"><h1>Add Student Detail</h1></div></a>");
			out.println("<a href=\"ShowAllStudent\"><div class=\"innerBox\"><h1>Show All Student</h1> </div> </a>");
			out.println("<a href=\"../../../EAD_Assignments2/SearchStudent.html\"><div class=\"innerBox\"><h1>Search Student</h1></div></a>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

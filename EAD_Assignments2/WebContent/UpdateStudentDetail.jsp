<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "com.StudentServlet.*"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="index.css" rel="stylesheet">
</head>
<body>
	<%
	String Id = request.getParameter("id");
	Connection con;
	try {
		con = SqlDemo.createSqlConnection("StudentManagement", "root",
				"1234");
		Statement stmt = con.createStatement();
		ResultSet result = stmt.executeQuery(String.format("SELECT * FROM StudentBase WHERE ID=%s",Id));
		result.next();
		String firstName = result.getString("firstName");
		String lastName = result.getString("lastName");
		String fatherName = result.getString("fatherName");
		String email = result.getString("email");
		String className = result.getString("class");
		String age = result.getString("age");
		%>
		<div class="outerBox">
		<form action="UpdateStudentDetail" method="post">
            <fieldset id="firstNameField">
                <legend>&nbsp;Student Id&nbsp; </legend>
                <input id="id" type="text" value="<%= Id %>"  name="id" readonly>
            </fieldset>
            <fieldset id="firstNameField">
                <legend>&nbsp;First Name&nbsp; </legend>
                <input id="firstName" type="text" value="<%= firstName %>"  name="firstName" required>
            </fieldset>
            <fieldset id="secondNameField">
                <legend>&nbsp;Last Name&nbsp; </legend>
                <input id="lastName" type="text" value="<%= lastName %>" placeholder="Enter Last Name....." name="lastName" required>
            </fieldset>
            <fieldset id="fatherNameField">
                <legend>&nbsp;Father's Name&nbsp; </legend>
                <input id="fatherName" type="text" value="<%= fatherName %>"  placeholder="Enter Father Name....." name="fatherName" required>
            </fieldset>
            <fieldset id="nameField">
                <legend>&nbsp; Email&nbsp; </legend>
                <input id="email" type="email" value="<%= email  %>"  placeholder="Enter email....." name="email" readonly>
            </fieldset>
            <fieldset id="nameField">
                <legend>&nbsp; Class &nbsp; </legend>
                <input id="class" type="text" value="<%= className %>"  placeholder="Enter Class....." name="class" required>
            </fieldset>
            <fieldset id="nameField">
                <legend>&nbsp; Age&nbsp; </legend>
                <input id="age" type="text" value="<%= age  %>"  placeholder="Enter Age....." name="age" required>
            </fieldset>
            <input type="Submit" name="Submit">
        </form>
        </div>
		
		
		<%
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	%>
</body>
</html>
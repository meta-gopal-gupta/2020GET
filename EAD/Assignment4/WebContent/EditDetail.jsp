<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.MetacubeParkingSystem.*"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="index.css" rel="stylesheet">
</head>
<body>

	<a href="HomePage.jsp"><span id="home">Home</span></a>
	<%
	if (session.getAttribute("userId") == null) {
		String site = new String("index.jsp");
		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", site);
	}
	String employeeId = (String) session.getAttribute("userId");
	Connection con;
	try {
		con = sqlConnection.sqlConnect("ParkingSystem", "root", "1234");
		Statement stmt = con.createStatement();
		ResultSet result = stmt.executeQuery(String.format(
				"SELECT * FROM user WHERE Id='%s'",
				employeeId));
		result.next();
		String name = result.getString("name");
		String email = result.getString("email");
		String mobile = result.getString("mobile");
		String password = result.getString("password");
		String gender = result.getString("gender");
		String organization = result.getString("organization");
		
		%>
		<div class="box">
		<div class="employeeDetail">
			<div class="boxTitle">
				<h1>Employee Detail</h1>
			</div>
			<div class="boxContent">
				<form action="UpdateEmployeeDetail" method="post">
					<fieldset id="nameField">
						<legend>&nbsp; Name&nbsp; </legend>
						<input id="name" value="<%= name  %>" type="text" placeholder="Enter Name....."
							name="name" required>
					</fieldset>
					<fieldset id="emailField">
						<legend>&nbsp; Email&nbsp; </legend>
						<input id="email" value="<%= email  %>"  type="email" placeholder="Enter Email....."
							name="email" required>
					</fieldset>
					<fieldset id="mobileField">
						<legend>&nbsp; Mobile &nbsp;</legend>
						<input id="mobile" value="<%= mobile %>"  type="number" placeholder="Enter Mobile....."
							name="mobile" required>
					</fieldset>
					<fieldset id="passwordField">
						<legend> &nbsp;Password&nbsp; </legend>
						<input id="password" value="<%= password %>"  type="password"
							placeholder="Enter Password....." name="password" required>
					</fieldset>
					<fieldset id="rePasswordField">
						<legend> &nbsp;Re Password&nbsp; </legend>
						<input id="rePassword" value="<%= password %>"  type="password"
							placeholder=" Re Enter Password....." name="rePassword" required>
					</fieldset>
					<fieldset>
						<legend> &nbsp;Gender&nbsp; </legend>
						<input type="radio" id="male" value="Male" name="gender" checked>
						<label for="male">Male</label> <input type="radio" id="female"
							value="Female" name="gender"> <label for="female">Female</label>
					</fieldset>
					<fieldset>
						<legend> &nbsp;Organization&nbsp; </legend>
						<input  list="organizationName" value="<%= organization %>"  type="text" name="organization" required>

						<datalist id="organizationName">
							<option value="Metacube">
							<option value="In TIme Tech">
							<option value="Google">
							<option value="Facebook">
							<option value="Linkedin">
						</datalist>
					
					</fieldset>
					<input type="submit" name="submit">

					<!-- <button onclick="checkValidation()">Next</button> -->
				</form>
			</div>
		</div>
	</div>
		
		
		
		<%
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.MetacubeParkingSystem.*"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%
	if (session.getAttribute("userId") == null) {
		String site = new String("index.jsp");
		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", site);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="index.css" rel="stylesheet">
</head>
<body>
<a href="HomePage.jsp"><span id="home">Home</span></a>
	<div class="box">
		<div class="employeeDetail">
			<div class="boxTitle">
				<h1>Employee Vehicle Detail</h1>
			</div>
			<div class="boxContent">
				<form action="VehicleRegistration" method="post">
					<fieldset id="vehicleCompanyNameField">
						<legend>&nbsp; Vehicle Company Name&nbsp; </legend>
						<input id="vehicleName" type="text"
							placeholder="Enter Vehicle Company Name....."
							name="vehicleCompanyName" required>
					</fieldset>
					<fieldset id="vehicleTypeField">
						<legend>&nbsp; Vehicle Type&nbsp; </legend>
						<select name="vehicleType" id="vehicleType">
							<option disabled selected hidden>Select Vehicle</option>
							<option value="Cycle">Cycle</option>
							<option value="Bicycle">Bycycle</option>
							<option value="Car">Car</option>
						</select>
					</fieldset>
					<fieldset id="vehicleNumberField">
						<legend>&nbsp; Vehicle Number &nbsp;</legend>
						<input id="vehicleNumber" type="text"
							placeholder="Enter Vehicle Number ....." name="vehicleNumber"
							required>
					</fieldset>
					<fieldset id="employeeIdField">
						<legend> &nbsp;Employee ID&nbsp; </legend>
						<input id="employeeId" type="text"
							value="<%=(String) session.getAttribute("userId")%>"
							name="employeeId" readonly>
					</fieldset>
					<fieldset id="vehicleDiscriptionField">
						<legend> &nbsp;Vehicle Description&nbsp; </legend>
						<textarea id="vehicleDiscription" name="vehicleDiscription"
							placeholder="My vehicle is..........."></textarea>
					</fieldset>
					<input type="submit" name="Submit">
					<!-- <button onclick="checkVehicleDetailValidation()">Next</button> -->
				</form>
			</div>
		</div>
	</div>
</body>
</html>
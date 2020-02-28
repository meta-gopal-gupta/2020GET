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


	String employeeId = (String) session.getAttribute("userId");
	Connection con;
	try {
		con = sqlConnection.sqlConnect("ParkingSystem", "root", "1234");
		Statement stmt = con.createStatement();
		ResultSet result = stmt.executeQuery(String.format(
				"SELECT * FROM vehicleData WHERE employeeId='%s'",
				employeeId));

		result.next();
		if(!result.next()){
			String location = new String("VehicleRegistration.jsp");
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", location);
		}
		String vehicleType = result.getString("vehicleType");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Parking System</title>
<link href="index.css" rel="stylesheet">
<script src="index.js"></script>

</head>
<body>
<a href="HomePage.jsp"><span id="home">Home</span></a>
	<div class="box">
		<div class="planDetail">
			<div class="boxTitle">
				<h1>Select Plan</h1>
			</div>
			<div class="boxContent">

				<input type="radio" id="daily" name="price"> <label
					id="dailyPrice" class="price" for="daily">
					<p>Daily</p> <br>
					<h1 id="dailyPriceRate">10 INR</h1>
				</label> <input type="radio" id="monthly" name="price"> <label
					id="monthlyPrice" class="price" for="monthly">
					<p>Monthly</p> <br>
					<h1 id="monthlyPriceRate">100 INR</h1>
				</label> <input type="radio" id="yearly" name="price" checked> <label
					id="yearlyPrice" class="price" for="yearly">
					<p>Yearly</p> <br>
					<h1 id="yearlyPriceRate">500 INR</h1>
				</label> <select id="currencyType" onchange="changeCurrency()">
					<option value="INR" selected>INR</option>
					<option value="USD">USD</option>
					<option value="YEN">YEN</option>
				</select><br>

				<button onclick="calculateMoney()">Next</button>
			</div>
		</div>
		<div class="priceDetail">
			<div class="boxTitle">
				<h1>Payable Amount</h1>
			</div>
			<div class="boxContent">
				<div class="totalPrice">
					<p>Total Amount</p>
					<br>
					<h1 id="priceRate">10 INR</h1>
				</div>
				<button onclick="calculatesMoney('<%=vehicleType%>')">Pay</button>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
changeCurrency("<%=vehicleType%>");
</script>
</html>
<%
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
%>

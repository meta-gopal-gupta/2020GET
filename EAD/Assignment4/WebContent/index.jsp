<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
if(session.getAttribute("userId")!=null){
	 String site = new String("HomePage.jsp");
     response.setStatus(response.SC_MOVED_TEMPORARILY);
     response.setHeader("Location", site); 
}
%>
<!DOCTYPE html>

<head>
    <title>Add Student Page</title>
   	<link rel="styleSheet" href="index.css">
</head>

<body>
    <div class="outerBox">
        <a href="SignIn.html">
            <div class="innerBox">
                <h1>SignIn</h1>
            </div>
        </a>
        <a href="EmployeeRegistration.html">
            <div class="innerBox">
                <h1>SignUp</h1>
            </div>
        </a>
    </div>
</body>

</html>
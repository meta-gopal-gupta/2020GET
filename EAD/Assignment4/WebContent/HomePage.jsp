<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
if(session.getAttribute("userId")==null){
	 String site = new String("index.jsp");
     response.setStatus(response.SC_MOVED_TEMPORARILY);
     response.setHeader("Location", site); 
}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="index.css" rel="stylesheet">

<title>Insert title here</title>
</head>
<body>
    <div class="outerBox">
        <a href="SelectPass.jsp">
            <div class="innerBox">
                <h1>Select Pass</h1>
            </div>
        </a>
        <a href="SignOut.jsp">
            <div class="innerBox">
                <h1>Sign Out</h1>
            </div>
        </a>
        <a href="EditDetail.jsp">
            <div class="innerBox">
                <h1>Edit</h1>
            </div>
        </a>
        <a href="PeopleInOrganization">
            <div class="innerBox">
                <h1>Colleague's</h1>
            </div>
        </a>
    </div>
</body>
</html>
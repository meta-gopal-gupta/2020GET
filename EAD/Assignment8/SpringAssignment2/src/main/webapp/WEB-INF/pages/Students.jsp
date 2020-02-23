<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@include file="../includes/header.jsp" %>


<table class="table table-striped">
    <thead>
      <tr>
      	<th>Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Father Name</th>
        <th>Email</th>
        <th>Class</th>
        <th>Age</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${students}" var="employee">


 <tr>   <td>${employee.id}</td>
        <td>${employee.firstName}</td>
        <td>${employee.lastName}</td>
        <td>${employee.fatherName}</td>
        <td>${employee.email}</td>
        <td>${employee.className}</td>
        <td>${employee.age}</td>
      </tr>

</c:forEach>
     
      
    </tbody>
  </table>



<%@include file="../includes/footer.jsp" %>


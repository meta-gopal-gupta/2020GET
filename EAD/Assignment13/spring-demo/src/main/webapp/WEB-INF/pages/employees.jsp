<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@include file="../includes/header.jsp" %>
<c:set value="1" var="sequenceNumber"/>

<table class="table table-striped">
    <thead>
      <tr>
      	<th>SN</th>
      	<th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Mobile</th>
        <th>Gender</th>
        <th>Organization</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${employees}" var="employee">

 	<tr> 
 		<td><c:out value="${sequenceNumber}"/></td>
 		<c:set var="sequenceNumber" value="${sequenceNumber + 1}"/>
 		<td>${employee.id}</td>
        <td>${employee.name}</td>
        <td>${employee.email}</td>
        <td>${employee.mobileNumber}</td>
        <td>${employee.gender}</td>
        <td>${employee.organization}</td>
      </tr>

</c:forEach>
     
      
    </tbody>
  </table>



<%@include file="../includes/footer.jsp" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="../includes/header.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/signup" var="userActionUrl" />


	<form:form modelAttribute="employee" action="${userActionUrl}">

		<form:errors />
		<form:hidden path="id"/>
		
		<div class="form-group">
			<form:label path="name">Name</form:label>
			<form:input path="name" type="text" class="form-control"
				id="exampleInputName1" placeholder="Name" />
			<form:errors path="name" cssClass="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="gender">Gender</form:label><br>
			<div class="form-control">
				<div class="form-check form-check-inline">
				  <form:radiobutton path="gender" class="form-check-input" id="inlineRadio1" value="Male"/>
				  <label class="form-check-label" for="inlineRadio1">Male</label>
				</div>
				<div class="form-check form-check-inline">
				  <form:radiobutton path="gender" class="form-check-input" value="Female"/>
				  <label class="form-check-label" for="inlineRadio2">Female</label>
				</div>
				<form:errors path="gender" cssClass="text-danger" />
			</div>
			
		</div>
		<div class="form-group">
			<form:label path="email">Email address</form:label>
			<form:input path="email" type="text" class="form-control"
				id="exampleInputEmail1" placeholder="Email" />
			<form:errors path="email" cssClass="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="password">Password</form:label>
			<form:input path="password" type="password" class="form-control"
				id="password" placeholder="password" />
			<form:errors path="password" cssClass="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="confirmPassword">Confirm Password</form:label>
			<form:input path="confirmPassword" type="password" class="form-control"
				id="confirmPassword" placeholder="confirmPassword" />
			<form:errors path="confirmPassword" cssClass="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="mobileNumber">Mobile Number</form:label>
			<form:input path="mobileNumber" type="text" class="form-control"
				id="mobileNumber" placeholder="mobileNumber" />
			<form:errors path="mobileNumber" cssClass="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="organization">Organization</form:label>
			<form:input path="organization" type="text" class="form-control"
				id="organization" placeholder="organization" />
			<form:errors path="organization" cssClass="text-danger" />
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>		
	
	</form:form>
<%@include file="../includes/footer.jsp" %>
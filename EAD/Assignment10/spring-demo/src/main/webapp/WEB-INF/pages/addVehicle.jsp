<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="../includes/header.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/addVehicle" var="userActionUrl" />


	<form:form modelAttribute="vehicle" action="${userActionUrl}">

		<form:errors />
		<form:hidden path="id"/>
		
		<div class="form-group">
			<form:label path="vehicleCompanyName">Vehicle Company Name</form:label>
			<form:input path="vehicleCompanyName" type="text" class="form-control"
				id="vehicleCompanyName" placeholder="vehicleCompanyName" />
			<form:errors path="vehicleCompanyName" cssClass="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="vehicleType">Vehicle Type</form:label>
			<form:input path="vehicleType" type="text" class="form-control"
				id="vehicleType" placeholder="vehicleType" />
			<form:errors path="vehicleType" cssClass="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="vehicleNumber">Vehicle Number</form:label>
			<form:input path="vehicleNumber" type="text" class="form-control"
				id="vehicleNumber" placeholder="vehicleNumber" />
			<form:errors path="vehicleNumber" cssClass="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="employeeId">Employee Id</form:label>
			<form:input path="employeeId" type="text" class="form-control"
				id="employeeId" />
			<form:errors path="employeeId" cssClass="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="vehicleDiscription">Vehicle Description</form:label>
			<form:input path="vehicleDiscription" type="text" class="form-control"
				id="vehicleDiscription" placeholder="vehicleDiscription" />
			<form:errors path="vehicleDiscription" cssClass="text-danger" />
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>		
	
	</form:form>
<%@include file="../includes/footer.jsp" %>
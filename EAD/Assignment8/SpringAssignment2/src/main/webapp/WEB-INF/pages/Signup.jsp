<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="../includes/header.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/Signup" var="userActionUrl" />


	<form:form modelAttribute="student" action="${userActionUrl}">

		<form:errors />
		<form:hidden path="id"/>
		<div class="form-group">
			<form:label path="firstName">First Name</form:label>
			<form:input path="firstName" type="text" class="form-control" id="firstName" placeholder="firstName" />
			<form:errors path="firstName" cssClass="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="lastName">Last Name</form:label>
			<form:input path="lastName" type="text" class="form-control"
				id="lastName" placeholder="lastName" />
			<form:errors path="lastName" cssClass="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="fatherName">Father Name</form:label>
			<form:input path="fatherName" type="text" class="form-control"
				id="fatherName" placeholder="fatherName" />
			<form:errors path="fatherName" cssClass="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="email">Email address</form:label>
			<form:input path="email" type="text" class="form-control"
				id="exampleInputEmail1" placeholder="Email" />
			<form:errors path="email" cssClass="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="className">Class</form:label>
			<form:input path="className" type="number" class="form-control"
				id="className" placeholder="className" />
			<form:errors path="className" cssClass="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="age">Age</form:label>
			<form:input path="age" type="number" class="form-control"
				id="age" placeholder="age" />
			<form:errors path="age" cssClass="text-danger" />
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>		
	
	</form:form>
<%@include file="../includes/footer.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="../includes/header.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/signin" var="userActionUrl" />


	<form:form modelAttribute="signin" action="${userActionUrl}">

		<form:errors />
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
		<button type="submit" class="btn btn-primary">Submit</button>		
	
	</form:form>
<%@include file="../includes/footer.jsp" %>
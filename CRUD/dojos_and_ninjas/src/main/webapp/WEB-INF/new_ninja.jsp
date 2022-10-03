<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New Ninja</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<h1>New Ninja</h1>
	<form:form action="/ninjas" method="POST" modelAttribute="ninja">
	
		<div>
 			<form:label path="dojo">Dojo:</form:label>
 			<form:errors path="dojo"/>
			<form:select path="dojo">
				<c:forEach var="oneDojo" items="${dojos}">
				<option value="${oneDojo.id}"><c:out value="${oneDojo.name}"></c:out></option>
				</c:forEach>
			</form:select>
		</div>
		
		<div>
			<form:label path="firstName">First Name:</form:label>
			<form:errors path="firstName"/>
			<form:input path="firstName" type="text"/>
		</div>
		
		<div>
			<form:label path="lastName">Last Name:</form:label>
			<form:errors path="lastName"/>
			<form:input path="lastName" type="text"/>
		</div>
		
		<div>
			<form:label path="age">Age:</form:label>
			<form:errors path="age"/>
			<form:input path="age" type="text"/>
		</div>
		
		<input type="submit" value="Create"/>
		
	</form:form>

   
</body>
</html>
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
    <title>Save Travels Index</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>



<body>

	<h1>Save Travels</h1>
	
	<table>
		<tr>
			<th>Expense</th>
			<th>Vendor</th>
			<th>Amount</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="ex" items="${expenses}">
		<tr>
			<td><a href="expenses/${ex.id}"><c:out value="${ex.expenseName}"></c:out></a></td>
			<td><c:out value="${ex.vendor}"></c:out></td>
			<td>$<c:out value="${ex.amount}"></c:out></td>
			<td>
				<a href="/expenses/edit/${ex.id}">edit</a>
				<form action="/expenses/delete/${ex.id}" method="post">
					<input type="hidden" name="_method" value="delete"/>
					<input type="submit" value="Delete"/>
				</form>
			</td>
		</tr>
		</c:forEach>
	</table>
	
	<h3>Add an expense</h3>
	
	<form:form action="/expenses/new" method="post" modelAttribute="expense">
	    <p>
	        <form:label path="expenseName">Expense Name</form:label>
	        <form:errors path="expenseName"/>
	        <form:input path="expenseName"/>
	    </p>
	    <p>
	        <form:label path="vendor">Vendor</form:label>
	        <form:errors path="vendor"/>
	        <form:textarea path="vendor"/>
	    </p>
	    <p>
	        <form:label path="amount">Amount</form:label>
	        <form:errors path="amount"/>
	        <form:input path="amount"/>
	    </p>
	    <p>
	        <form:label path="description">Description</form:label>
	        <form:errors path="description"/>     
	        <form:input path="description"/>
	    </p>    
	    <input type="submit" value="Submit"/>
	</form:form>
	

</body>



</html>
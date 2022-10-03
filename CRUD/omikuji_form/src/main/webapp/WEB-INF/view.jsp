<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container-fluid">

	<div class="row">
    	<div class="col">
    	</div>
    	<div class="col">
    	
	
			<h1>Here's your Omikuji!</h1>
			
			<div class="container-fluid p-3 mb-2 bg-info text-white border border-2 border-dark">
			
				<h2>In <c:out value="${number}"/> years, you will live in <c:out value="${city}"/> with <c:out value="${person}"/> as your roomate, <c:out value="${proEndeavorOrHobby}"/> for a living. The next time you see a <c:out value="${livingThing}"/>, you will have good luck. Also, <c:out value="${somethingNice}"/>.</h2>
			
			</div>
			
			<a href="/form">Go Back</a>
			
		</div>
		<div class="col">
    	</div>
    </div>
</div>
	
</body>
</html>
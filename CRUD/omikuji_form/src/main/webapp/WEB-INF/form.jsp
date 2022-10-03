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
			<h1>Send an Omikuji!</h1>
		
				<form class="border border-2 border-dark" action="/form/process" method = "POST">
					<label>Pick any number from 5 to 25</label>
			    	<select class="form-select" id="floatingSelect" aria-label="Floating label select example" name="number">
						<option selected="">Open this select menu</option>
			    		<option value="5">5</option>
			    		<option value="6">6</option>
			    		<option value="7">7</option>
			    		<option value="8">8</option>
			    		<option value="9">9</option>
			    		<option value="10">10</option>
			    		<option value="11">11</option>
			    		<option value="12">12</option>
			    		<option value="13">13</option>
			    		<option value="14">14</option>
			    		<option value="15">15</option>
			    		<option value="16">16</option>
			    		<option value="17">17</option>
			    		<option value="18">18</option>
			    		<option value="19">19</option>
			    		<option value="20">20</option>
			    		<option value="21">21</option>
			    		<option value="22">22</option>
			    		<option value="23">23</option>
			    		<option value="24">24</option>
			    		<option value="25">25</option>
			    		
			    	</select>
					<label>Enter the name of any city</label>
			    	<input class="form-control" id="floatingInput" type='text' name='city'>
			    	<label>Enter the name of any real person</label>
			    	<input class="form-control" id="floatingInput" type='text' name='person'>
			    	<label>Enter professional endeavor or hobby</label>
			    	<input class="form-control" id="floatingInput" type='text' name='proEndeavorOrHobby'>
			 		<label>Enter any type of living thing</label>
			 		<input class="form-control" id="floatingInput" type='text' name='livingThing'>
					<label>Say something nice to someone</label>  
					<textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea" style="height: 100px" name="somethingNice"></textarea>
					<label>Send and show a friend</label><br>
					<button class="btn btn-primary float-end" value="submit">Submit</button> 	
				</form>
			
			</div>
	    	<div class="col">
	    	</div>
	  </div>	
</div>

</body>
</html>
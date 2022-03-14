<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href='https://fonts.googleapis.com/css?family=Baloo' rel='stylesheet'>
</head>
<body>
<h3>Book Show </h3>
<div class="movie-container">
     <label> Movie Name : </label> 
      <c:out value="${book}" />
      <br><br>
	<label for="seatbooking">Set date :</label>		  
    <input type="date" name="show_date" id="showdate" >
   <br><br>
	<label>Select Show Time:</label> 

	<input type="radio" name="start_time" value="9:00 am" checked> 9:00 am
	
	<input type="radio" name="start_time" value="12:00 pm"> 12:00 pm
	<input type="radio" name="start_time" value="4:00 pm"> 4:00 pm
	<input type="radio" name="start_time" value="9:00 pm"> 9:00 pm
	</div>
</body>
</html>
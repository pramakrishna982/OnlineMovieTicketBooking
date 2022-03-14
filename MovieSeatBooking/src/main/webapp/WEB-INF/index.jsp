<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ page
	isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body>
<html>
<script type="text/javascript">
function myFunction() {
	  // Declare variables
	  var input, filter, table, tr, td, i, txtValue;
	  input = document.getElementById("keyword");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("movieTable");
	  tr = table.getElementsByTagName("tr");

	  // Loop through all table rows, and hide those who don't match the search query
	  for (i = 0; i < tr.length; i++) {
	    td = tr[i].getElementsByTagName("td")[1];
	    if (td) {
	      txtValue = td.textContent || td.innerText;
	      if (txtValue.toUpperCase().indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    }
	  }
	}
</script>
<style>
body{background-color:white;}
h1{
color:black;
text-align:center;
background-color:#264d73;
}

input{
float:right;
width:150px;
height:30px;
}

td {
  padding: 10px;
  text-align: center;
  color:black;
}
table{
border-collapse: collapse;
}
table.center {
  margin-left: auto; 
  margin-right: auto;
}

tr:hover {background-color: #242333; }

tr:hover, td:active{color:white;}


*{ 
margin:0; 
padding:0; 
} 
nav
{ 
width:100%;
height:17%; 
display: flex; 
margin-bottom:-4%;
position:fixed;
} 
.Logo
{ 
width:50%; 
height:50%; 
background-color:#FFFACD; 
background-image: linear-gradient(to right, #FFFACD , #B0E0E6);
} 
.Logo img
{ 
margin-top:3px;
width:87px;
 height:70px;
 margin-left:20px; 
} 
.login
{ 
width:50%; 
height:50%; 
background-color:#B0E0E6; 
text-align:right;
background-image: linear-gradient(to right, #B0E0E6,#FFFACD);
}
ul{ 
list-style: none; 
padding:40px;
} 
li{  
padding:25px; 
display:inline; 
}
</style>
<body>
<nav>
<div class="Logo">
<img src="C:\Users\rkodakandla\git\repository\onlineticket\src\main\webapp\resource\img\Bomma.jpg"class="img-rounded">
</div> 
<div class="login"> 
<ul> 
<li><b><a href="rr.html">LOGIN</a></b></li> 
<li><b><a href="manju.html">ADMIN LOGIN</a></b></li> 
</ul> 
</div>
</nav>

<h1>Movies</h1>
<!-- <div class="movie-container"> -->
<!--      <label> Movie Name : </label>  -->
<%-- 		<c:forEach var="movie" items="${book}"> --%>
<%-- 			<label>${movie.name}</label> --%>
<%-- 		</c:forEach> --%>
<input type="text" id="keyword" onkeyup="myFunction()" placeholder="Search for movie names.." title="Type in a name">
<br/>
<form action="http://localhost:8082/MovieSeatBooking/booking/book" >
<table id="movieTable" class="center">

<c:forEach var="ShowMovie" items="${movieslist}">
<tr>
<td><img src="data:image/jpg;base64,${ShowMovie.base64Image}" width="240" height="300"/></td>
<td>${ShowMovie.name}</td>
<td>${ShowMovie.language}</td>
<td>${ShowMovie.duration}</td>
<td>${ShowMovie.cast_names}</td>
<td><button type="submit" class="selectmovie" name="btnSubmit" value="${ShowMovie.id}">Book</button></td>
</tr>
</c:forEach>
</table>
</form>
</body>
</html>
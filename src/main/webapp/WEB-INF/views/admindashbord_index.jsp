<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/index.css"/>" rel="stylesheet">

</head>
<body>
	<div class="txtpos">
		<div id="mainbox" onclick="openFunction()">&#9776;</div>
		<div id="menu" class="sidemenu">
			<hr color="black">
			<a href="/Job_agency/admin/adminlist">Admin List</a>
			<hr color="black">
			<a href="/Job_agency/Ticket">Ticket</a>
			<hr color="black">
			
			<a href="/Job_agency/admin/ticketorder">Ticket Order</a>
			<hr color="black">
			
			<a href="/Job_agency/jobpost/alljobpost">All Job Post</a>
			<hr color="black">
			
			<a href="/Job_agency/employer/allemployer">All Employer</a>
			<hr color="black">
			
			<a href="/Job_agency/Industry">Industry</a>
			<hr color="black">
			
			<a href="/Job_agency/Level">Level</a>
			<hr color="black">
			
			<a href="/Job_agency/Position">Position</a>
			<hr color="black">
			
			<a href="/Job_agency/Language">Language</a>
			<hr color="black">
			
			<a href="#" class="closebtn" onclick="closeFunction()"
				style="border: none;">&times;</a>
		</div>
		
		<h1>
			<img class=logo src="<c:url value='/resources/img/logo.png' />" alt="My Image">Lanbra job
		</h1>
		<br>



	</div>
	<script type="text/javascript">
	
function openFunction(){
document.getElementById("menu").style.width="300px";
document.getElementById("mainbox").style.marginleft="300px";
document.getElementById("mainbox").innerHTML="";
}

function closeFunction(){
document.getElementById("menu").style.width="0px";
document.getElementById("mainbox").style.marginleft="0px";
document.getElementById("mainbox").innerHTML="&#9776;";
}

var slideIndex = 0;

</script>
</body>
</html>
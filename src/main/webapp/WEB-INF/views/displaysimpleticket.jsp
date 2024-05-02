<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/index.css" />
<style>
.h1 {
	background-color: #333;
	color: #00FF00;
	text-align: center;
	padding: 20px 0;
	border-radius: 12px;
	width: 40%;
	position: absolute;
	top: 15%; /* Align to the top */
	left: 10%;
}

.Lanbra {
	text-align: center;
}

.pos {
	position: absolute;
	top: 35%; /* Align to the top */
	left: 10%;
}

table {
	width: 40%;
	border-collapse: collapse;
	background-color: #fff;
	border: 2px solid #ddd;
}

th, td {
	padding: 8px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

th {
	background-color: #f2f2f2;
}

.action-buttons a {
	display: inline-block;
	margin-right: 5px;
	padding: 5px 10px;
	text-decoration: none;
	color: #fff;
	border-radius: 3px;
}

.edit-button {
	background-color: #007bff;
}

.delete-button {
	background-color: #dc3545;
}

.add-button {
	background-color: #28a745;
}

/* right form css */
.header {
	background-color: #333;
	color: #00FF00;
	text-align: center;
	padding: 10px 0;
	border-radius: 12px;
}

.loginclass {
	max-width: 400px;
	margin: 0 auto;
	padding: 20px;
	border: 3px solid #7b7777;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

#position {
	position: absolute;
	top: 20%; /* Align to the top */
	right: 10%;
	width: 40%;
}

input {
	width: 95%;
	padding: 8px;
	margin-bottom: 16px;
	box-sizing: border-box;
	border: 1px solid #ccc;
	border-radius: 4px;
}

.sub {
	background-color: #3bc940;
	color: white;
	padding: 10px 15px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	font-size: 16px;
}

.sub:hover {
	background-color: #353f36;
}

.errorcolor {
	color: red;
}

.form-select {
	width: 150px;
	height: 30px;
	border-radius: 8px;
}

/* cssfor logout */
.adminlogout {
	border-radius: 10px;
	background-color: #3498db;
	color: #fff;
	text-decoration: none;
	font-size: 23px;
	width: 150px;
	height: 30px;
	position: absolute;
	right: 100px;
	top: 70px;
}

.adminlogout:hover {
	background-color: #2980b9;
}
button {
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

button:hover {
  opacity:1;
}

/* Float cancel and delete buttons and add an equal width */
.cancelbtn, .deletebtn {
  float: left;
  width: 50%;
}

/* Add a color to the cancel button */
.cancelbtn {
  background-color: #ccc;
  color: black;
}

/* Add a color to the delete button */
.deletebtn {
  background-color: #f44336;
}

/* Add padding and center-align text to the container */
.container {
  padding: 16px;
  text-align: center;
}

/* The Modal (background) */
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  padding-top: 50px;
}

/* Modal Content/Box */
.modal-content {
  background-color: #fefefe;
  border: 1px solid #888;
  position: absolute;
 top: 50%;
 left: 50%;
 transform: translate(-50%, -50%);
  width: 80%;
  max-width: 300px; /* Could be more or less, depending on screen size */
}

/* Style the horizontal ruler */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 15px;
}
 

.close {
  position: absolute;
  right: 10px;
  top: 10px;
  font-size: 24px;
  font-weight: bold;
  color: #f1f1f1;
}

.close:hover,
.close:focus {
  color: #f44336;
  cursor: pointer;
}


.clearfix::after {
  content: "";
  clear: both;
  display: table;
}


@media screen and (max-width: 300px) {
  .cancelbtn, .deletebtn {
     width: 100%;
  }
}

.container {
  border: 1px solid #ccc;
  padding: 20px;
  border-radius: 10px;
  background-color: #fff;
  max-width: 400px;
  margin: 0 auto;
}

h3 {
  font-size: 20px;
  margin-top: 0;
}

p {
  margin-bottom: 20px;
}

.cancelbtn {
  background-color: #4caf50; /* Confirm color */
  color: #fff;
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.deletebtn {
  background-color: #f44336; /* Warning color */
  color: #fff;
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}


.cancelbtn:hover, .deletebtn:hover {
  opacity: 0.8;
}

</style>
</head>
<body>
	<div class="txtpos">
		<div id="mainbox" onclick="openFunction()">&#9776;</div>
		<div id="menu" class="sidemenu">
			<hr color="black">


			<a href="/Job_agency/SimpleTicket">Ticket</a>
			<hr color="black">

			<a href="/Job_agency/admin/simpleticketorder">Ticket Order</a>
			<hr color="black">

			<a href="/Job_agency/jobpost/simplealljobpost">All Job Post</a>
			<hr color="black">

			<a href="/Job_agency/employer/simpleallemployer">All Employer</a>
			<hr color="black">

			<a href="/Job_agency/SimpleIndustry">Industry</a>
			<hr color="black">

			<a href="/Job_agency/SimpleLevel">Level</a>
			<hr color="black">

			<a href="/Job_agency/SimplePosition">Position</a>
			<hr color="black">

			<a href="/Job_agency/SimpleLanguage">Language</a>
			<hr color="black">
			<a href="#" class="closebtn" onclick="closeFunction()"
				style="border: none;">&times;</a>
		</div>




		<h1 class="Lanbra">
			<img class=logo src="resources/img/logo.png" alt="Image">
			Lanbra job
		</h1>
		<a href="#" class="adminlogout" onclick="document.getElementById('id').style.display='block'">LogOut</a>
	</div>
	
	 <div id="id" class="modal">
			           <div class="container">  
			              <h3>LogOut</h3>
			              <p>Are you sure you want to logout this page?</p>
			              <div>
			                  <button type="button" onclick="document.getElementById('id').style.display='none'" class="cancelbtn">No</button>
			                 <a href="/Job_agency/logout/"> <button type="button" class="deletebtn">Yes</button></a>
			              </div>
			        </div> 
			      </div>
	
	<h1 class="h1">Ticket</h1>
	<table class="pos">
		<thead>
			<tr>
				<th>Code Number</th>
				<th>Post</th>
				<th>Price</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="ticket" items="${tickets}">
				<tr>

					<td>${ticket.code_number}</td>
					<td>${ticket.post}</td>
					<td>${ticket.amount}</td>

					<td> <button onclick="openDeleteModal('${ticket.id}')">Delete</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div id="ticketModal" class="modal">
    <div class="container">    
        <h3>Delete Ticket</h3>
        <p>Are you sure you want to delete this item?</p>
        <div>
            <button type="button" onclick="closeDeleteModal()" class="cancelbtn">No</button>
            <button id="confirmDeleteBtn" type="button" class="deletebtn">Yes</button>
        </div>
    </div> 
</div>

	<div class="txtpos">
		<form:form action="addsimpleticket" method="post"
			modelAttribute="ticket">
			<div class="loginclass" id="position">
				<div>
					<h2 class="header">Create New Ticket</h2>
				</div>

				<div class="errorcolor">${error}</div>
				<div>
					<form:label path="code_number">Enter Code Number</form:label>
					<form:input path="code_number"></form:input>
					<form:errors path="code_number" class="errorcolor"></form:errors>
				</div>
				<div>
					<form:label path="post">Enter Number Of Post</form:label>
					<form:input path="post" type="number"></form:input>
					<form:errors path="post" class="errorcolor"></form:errors>
				</div>
				<div>
					<form:label path="amount">Enter Amount</form:label>
					<form:input path="amount" type="number"></form:input>
					<form:errors path="amount" class="errorcolor"></form:errors>
				</div>

				<div>
					<form:select path="admin_id" class="form-select">
						<form:option value="0">Select Admin</form:option>
						<c:forEach var="a" items="${admins}">
							<form:option value="${a.id}">${a.name}</form:option>
						</c:forEach>
					</form:select>
					<form:errors path="admin_id" class="errorcolor"></form:errors>
				</div>
				<br>
				<div>
					<input type="submit" value="Add" class="sub" />
				</div>
			</div>

		</form:form>
	</div>
	
	<script>
    var ticketIdToDelete;

    function openDeleteModal(id) {
    	ticketIdToDelete = id;
        var modal = document.getElementById('ticketModal');
        modal.style.display = "block";
    }

    function closeDeleteModal() {
        var modal = document.getElementById('ticketModal');
        modal.style.display = "none";
    }

    window.onclick = function(event) {
        var modal = document.getElementById('ticketModal');
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }

    document.getElementById('confirmDeleteBtn').addEventListener('click', function() {
      
        fetch('deletesimpleticket/' + ticketIdToDelete, {
            method: 'GET'
        })
        .then(response => {
            if (response.ok) {
               
                location.reload(); 
            } else {
               
                console.error('Failed to delete ticket');
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
    });
</script>
	


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

var currentUrl = window.location.href;

// Remove the query parameters
var cleanedUrl = currentUrl.split("?")[0];

// Update the URL without query parameters
window.history.replaceState({}, document.title, cleanedUrl);

</script>
</body>
</html>
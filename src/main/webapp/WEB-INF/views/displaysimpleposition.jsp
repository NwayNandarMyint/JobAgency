<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/index.css"/>
    <style>
       .h1 {
  background-color: #333;
  color: #00FF00;
  text-align: center;
  padding: 20px 0;
  border-radius: 12px;
  width: 30%;
  position: absolute;
  top: 15%; /* Align to the top */
  left: 15%;
}

.Lanbra {
  text-align: center;
}

.pos {
  position: absolute;
  top: 35%; /* Align to the top */
  left: 15%;
}

table {
  width: 30%;
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
  width: 20%;
  margin: 0 auto;
  padding: 20px;
  border: 3px solid #7b7777;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

#rightpos{
  position: absolute;
  top: 20%; /* Align to the top */
  right: 15%;
}

input {
  width: 90%;
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
		
		/* cssfor logout */

.adminlogout{
    border-radius: 10px;
    background-color: #3498db;
    color: #fff;
    text-decoration: none;
   	font-size: 23px;
    width:150px;
    height:30px;
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

/* Clear floats */
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
            <a href="#" class="closebtn" onclick="closeFunction()" style="border: none;">&times;</a>
    </div>




	<h1 class="Lanbra"><img class=logo src="resources/img/logo.png" alt="Image" > Lanbra job</h1>
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
	
    <h1 class="h1" >Position</h1>
	<table class="pos">
		<thead>
			<tr>
				<th>Name</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="position" items="${positions}">
				<tr>
					
					<td>${position.name}</td>
					
					<td> <button onclick="openDeleteModal('${position.id}')">Delete</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div id="positionModal" class="modal">
    <div class="container">    
        <h3>Delete Position</h3>
        <p>Are you sure you want to delete this item?</p>
        <div>
            <button type="button" onclick="closeDeleteModal()" class="cancelbtn">No</button>
            <button id="confirmDeleteBtn" type="button" class="deletebtn">Yes</button>
        </div>
    </div> 
</div>

<div class="txtpos">
	<form:form action="addsimpleposition" method="post"
			modelAttribute="position">
			<div class="loginclass" id="rightpos">
				<div>
					<h2 class="header">Add New Position</h2>
				</div>

				<div class="errorcolor">${error.allErrors}</div>

				<div>
					<form:input path="name" placeholder="Enter Position"></form:input>
					<form:errors path="name" class="errorcolor"></form:errors>
				</div>

				<div>
					<input type="submit" value="Add" class="sub" />
				</div>
			</div>

		</form:form>
</div>

<script>
    var positionIdToDelete;

    function openDeleteModal(id) {
    	positionIdToDelete = id;
        var modal = document.getElementById('positionModal');
        modal.style.display = "block";
    }

    function closeDeleteModal() {
        var modal = document.getElementById('positionModal');
        modal.style.display = "none";
    }

    window.onclick = function(event) {
        var modal = document.getElementById('positionModal');
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }

    document.getElementById('confirmDeleteBtn').addEventListener('click', function() {
      
        fetch('deletesimpleposition/' + positionIdToDelete, {
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

</script>
</body>
</html>
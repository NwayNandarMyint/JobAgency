<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lanbra Job</title>
<link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">
<style>
.h1 {
	background-color: #333;
	color: #00FF00;
	text-align: center;
	padding: 20px 0;
    border-radius: 12px;
    width: 80%;
    position: absolute;
 	top: 15%; 
  	left: 10%;
}

table {
	width: 70%;
	border-collapse: collapse;
	background-color: #fff;
	border: 2px solid #ddd;
	position: absolute;
    top: 35%; 
    left: 10%;
    
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

.employer-logo{
				
				width: 70px;
				height: auto;
            	border-radius: 8px 0 0 8px;
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

.success {
        background-color: #dff0d8; /* green background */
        color: #3c763d; /* dark green text */
    }

    .cancel {
        background-color: #f2dede; /* red background */
        color: #a94442; /* dark red text */
    }

    .need-to-confirm {
        background-color: #fcf8e3; /* yellow background */
        color: #8a6d3b; /* dark yellow text */
    }
    
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
 
/* The Modal Close Button (x) */
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

/* Change styles for cancel button and delete button on extra small screens */
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

/* Add hover effects */
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
            <a href="/Job_agency/admin/SuperAdmin">Admin List</a>
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
            <a href="#" class="closebtn" onclick="closeFunction()" style="border: none;">&times;</a>
        </div>  
        <h1 class="Lanbra">
            <img class=logo src="<c:url value='/resources/img/logo.png' />" alt="My Image">
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


    <h1 class="h1">Ticket Order</h1>
    <table id="example" class="display" style="width:80%">
        <thead>
            <tr>
                <th>Company Name</th>
                <th>Screen shot</th>
                <th>Ticket NO</th>
                <th>Payment Date</th>
                <th>Actions</th>
                <th>Confirm</th>
                
            </tr>
        </thead>
        <tbody>
            <c:forEach var="order" items="${ticketorders}">
                <tr>
                    <td>${order.employer_name}</td>
                    <td><img class="employer-logo" src="data:image/jpeg;base64,${order.getscreen_shot}" alt="Ticket Order Photo"></td>
                    <td>${order.ticket_id}</td>
                    <td>${order.payment_date}</td>
                    <td class="action-buttons">
                        <a href="/Job_agency/admin/confirmticket?em_id=${order.employer_id}&&tc_id=${order.ticket_id}&&employer_ticketid=${order.id}" class="add-button">Accept</a>
                        <a href="/Job_agency/admin/cancelticket?employer_ticketid=${order.id}" class="delete-button">Reject</a>
                    </td>
                    <c:choose>
		                <c:when test="${order.is_Approved eq 1}">
		                    <td class="success">Success Order</td>
		                </c:when>
		                <c:when test="${order.is_Approved eq 0}">
		                    <td class="need-to-confirm">Need To Confirm Order</td>
		                </c:when>
		                <c:when test="${order.is_Approved eq 2}">
		                    <td class="cancel">Cancel Order</td>
		                </c:when>
		                <c:otherwise>
		                    <td>Unknown Status</td>
                		</c:otherwise>
            	</c:choose>
                </tr>
            </c:forEach>
        </tbody>
    </table>
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
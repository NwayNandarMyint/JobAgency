<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Lanbra Job Agency</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
<style>
header {
	background-color: #f0f0f0;
	padding: 15px;
	text-align: center;
	border-radius: 8px;
	margin-bottom: 10px;
}

.employer-logo-name {
	display: flex;
	align-items: center;
}

.employer-logo {
	max-width: 100px;
	height: auto;
	border-radius: 50%;
	margin-right: 15px;
}

.employer-detail {
	text-align: left;
}

.employer-name {
	font-size: 1.5em;
	font-weight: bold;
	margin-bottom: 5px;
}

.employer-description {
	font-size: 1.2em;
	color: #666;
}

.wrapper {
	display: flex;
	gap: 20px; /* Adjust the gap between left and right sessions */
}

.leftsession {
	display: flex;
	margin-top: 10px;
	margin-left: 60px;
	/* background-color: #096483; */
	flex-direction: row;
	gap: 10px; /* Adjust the gap between cards as needed */
}

.collection {
	display: flex;
	flex-direction: column;
	color: white;
	justify-content: space-between;
	border: 1px solid #ddd;
	border-radius: 8px;
	padding: 15px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	background-color: #838109;
}

/* Optional: Add hover effect */
.collection:hover {
	background-color: #096483;
}

.collection div {
	margin-bottom: 10px;
}

/* Vertical Line */
.vertical-line {
	border-left: 7px solid #ddd;
	height: 100%;
	margin: 0 20px; /* Adjust the margin as needed */
}

.rightsession {
	max-width: 600px;
	margin-top: 90px;
	margin-left: 70px;
	padding: 20px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	background-color: #fff;
	border-radius: 8px;
	margin-bottom: 150px;
}

.rightsession h2 {
	text-align: center;
	color: #333;
}

.rightsession label {
	display: block;
	margin: 10px 0;
	font-weight: bold;
	color: #555;
}

.rightsession .form-select {
	width: 100%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 4px;
}

.rightsession input[type="file"] {
	width: 100%;
	margin: 10px 0;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 4px;
}

.rightsession input[type="submit"] {
	width: 100%;
	padding: 12px;
	background-color: #4caf50;
	color: #fff;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

.rightsession input[type="submit"]:hover {
	background-color: #45a049;
}

.log-out a {
	text-decoration: none;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

.log-out a:hover {
	background-color: #2980b9;
}

.popup {
	width: 400px;
	background: #F8F9F9;
	position: absolute;
	top: 0;
	left: 50%;
	transform: translate(-50%, -50%);
	text-align: center;
	padding: 0 30px 30px;
	visibility: hidden;
	color: black;
	transition: transform 0.4s, top 0.4s;
}

.open-popup {
	visibility: visible;
	top: 20%;
	transform: translate(-50%, -50%);
}

.popup img {
	width: 100px;
	margin-top: -50px;
	border-radius: 50%;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
}

.popup h2 {
	font-size: 30px;
	font-weight: 500;
	margin: 15px 0 5px;
}

.popup button {
	width: 100%;
	margin-top: 10px;
	padding: 10px 0;
	background: #6fd649;
	color: #fff;
	border: 0;
	outline: none;
	font-size: 18px;
	border-radius: 4px;
	cursor: pointer;
	box-shadow: 0 5px 5px rgba(0, 0, 0, 0.2);
}

.errorcolor {
	color: red;
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
<body>
	<div class="dashboard-river">

		<div class="dashboard-container">

			<div class="dashboard">

				<div class="ui-row-1">

					<div class="logo-comp">
						<div>
							<svg version="1.1" xmlns="http://www.w3.org/2000/svg"
								xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
								viewBox="0 0 297 297" xml:space="preserve">
              <g>
                <path
									d="M48.523,73.196h18.131c5.597,0,10.137-4.536,10.137-10.134c0-5.6-4.54-10.137-10.137-10.137H48.523 c-5.599,0-10.137,4.537-10.137,10.137C38.387,68.66,42.925,73.196,48.523,73.196z" />
                <path
									d="M47.628,123.657c0-5.598-4.54-10.137-10.137-10.137H19.357c-5.599,0-10.135,4.539-10.135,10.137 c0,5.597,4.536,10.135,10.135,10.135h18.134C43.088,133.792,47.628,129.254,47.628,123.657z" />
                <path
									d="M277.643,95.387h-18.135c-5.597,0-10.137,4.539-10.137,10.135c0,5.601,4.54,10.137,10.137,10.137h18.135 c5.599,0,10.135-4.536,10.135-10.137C287.777,99.926,283.241,95.387,277.643,95.387z" />
                <path
									d="M140.148,203.69v83.173c0,5.598,4.54,10.137,10.137,10.137c5.599,0,10.137-4.539,10.137-10.137V203.69h93.406 c5.597,0,10.137-4.539,10.137-10.136c0-5.598-4.54-10.137-10.137-10.137H227.05c3.911-8.197,5.898-17.617,5.898-28.209 c0-29.299-21.058-60.583-39.637-88.187c-5.055-7.506-9.829-14.599-13.809-21.124c-1.689-3.791-1.094-19.677,1.284-34.106 c0.487-2.938-0.344-5.942-2.271-8.212c-1.926-2.27-4.752-3.58-7.73-3.58h-40.998c-2.977,0-5.803,1.313-7.729,3.58 c-1.924,2.268-2.755,5.271-2.273,8.21c2.383,14.432,2.978,30.316,1.288,34.107c-3.984,6.527-8.759,13.619-13.813,21.126 c-18.579,27.604-39.639,58.887-39.639,88.186c0,10.592,1.987,20.012,5.902,28.209H46.745c-5.601,0-10.137,4.539-10.137,10.137 c0,5.597,4.536,10.136,10.137,10.136H140.148z M202.707,183.418H97.864c-6.701-7.003-9.968-16.27-9.968-28.209 c0-23.111,19.222-51.669,36.182-76.865c5.209-7.738,10.13-15.05,14.363-21.993c4.769-7.819,4.27-23.774,2.954-36.077h17.781 c-1.316,12.302-1.813,28.257,2.952,36.077c4.233,6.943,9.153,14.252,14.362,21.992c16.96,25.197,36.184,53.755,36.184,76.866 C212.675,167.148,209.406,176.417,202.707,183.418z" />
              </g>
            </svg>
						</div>
						<p>LANBRA JOB</p>
					</div>
				</div>

				<div class="ui-row-2">

					<div class="left-sidebar">

						<div>
							<h1>L</h1>
						</div>

						<div>
							<h1>A</h1>
						</div>

						<div>
							<h1>N</h1>
						</div>

						<div>
							<h1>B</h1>
						</div>

						<div>
							<h1>R</h1>
						</div>

						<div>
							<h1>A</h1>
						</div>

						<div>
							<svg xmlns="http://www.w3.org/2000/svg" fill="currentColor"
								class="bi bi-star-fill" viewBox="0 0 16 16">
              <path
									d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z" />
            </svg>
						</div>

						<div>
							<h1>J</h1>
						</div>

						<div>
							<h1>O</h1>
						</div>

						<div>
							<h1>B</h1>
						</div>

					</div>

					<div class="main-content">

						<div class="header">

							<div class="page-display">
								<h1>Let's Explore Your Job</h1>
							</div>
							<div class="clay-category">
								<svg viewBox="0 0 512 512" xmlns="http://www.w3.org/2000/svg">
                <path
										d="M329.3 99.64l-39.7 10.46c-30.2 26.1-62.7 50.9-96.7 75.1l-6.7 21-34.1 7.3c-22.6 15.3-45.6 30.4-68.82 45.5l120.32 18.4 213.9-167.1c-27.7-3.8-56.9-7.5-88.2-10.66zm103.4 21.56l-61.4 47.9-43 53.1-45 15.7-65 50.7 20.8 115.1c65.6-54.6 127.6-109.4 187-163.1l-5.6-31.2 42.1-1.9c8.3-7.4 16.5-14.9 24.6-22.3zM61.58 277.6c-21.15 39.9-32.01 70.6-36.83 95.8 9.21 1.1 18.3 2.2 27.28 3.5l16.76-30.6 5.52 34c53.29 8.6 103.09 20.5 152.19 32.1l-26.9-117.6-66-10.1z" />
              </svg>
								<p>
									<a href="#" class="log-out" onclick="document.getElementById('id').style.display='block'">LogOut</a>
								</p>
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

						</div>
						<hr>

						<header>
							<div class="employer-logo-name">
								<img class="employer-logo"
									src="data:image/jpeg;base64,${employer.logoString}"
									alt="Company Logo">
								<div class="employer-detail">
									<div class="employer-name">${employer.name}</div>
									<div class="employer-description">${employer.industry_name}</div>
								</div>
							</div>
						</header>
						<br>

						<jsp:include page="employerlinkpage.jsp"></jsp:include>
						<br>
						<div class="leftsession">
							<c:forEach var="ticket" items="${tickets}">
								<div class="collection">
									<div>Code Number :${ticket.code_number}</div>
									<div>Available Post :${ticket.post}</div>
									<div>Price : ${ticket.amount}</div>
								</div>
							</c:forEach>
						</div>
						<!-- Ticket buying place -->
						<div class="rightsession">
							<form:form action="/Job_agency/employer/ticket" method="post"
								modelAttribute="ticketorder" enctype="multipart/form-data">

								<h2 class="header">To Buy Ticket</h2>
								<div>
									<form:label path="ticket_id">Select Code Number Want To Buy</form:label>
									<div class="errorcolor">${receivedloginerror}</div>
									<div class="errorcolor">${error}</div>
									<form:select path="ticket_id" cssClass="form-select">
										<form:option value="0">Select Code</form:option>
										<c:forEach var="ticket" items="${tickets}">
											<form:option value="${ticket.id}">${ticket.code_number}</form:option>
										</c:forEach>
									</form:select>
									<form:errors path="ticket_id" cssClass="text-danger"></form:errors>
								</div>
								<div>
									<form:label path="screen_shot">Send a screenshot of bill payment to confirm ticket purchase!</form:label>
									<form:input path="screen_shot" type="file" required="required"></form:input>
									<form:errors path="screen_shot" cssClass="text-danger"></form:errors>
								</div>
								

								<div>
									<br><input type="submit" value="Send Photo">
								</div>
							</form:form>
							<div class="popup" id="popup">
								<img
									src="https://www.shutterstock.com/image-vector/green-check-mark-icon-circle-260nw-576516469.jpg">
								<h2>Thank You!</h2>
								<p>Ticket Order is Successful</p>
								<p>Please Wait A Few Minutes To Access !</p>
								<a href="/Job_agency/employer/displayemployer/"><button
										type="button">Ok</button></a>
							</div>
						</div>

					</div>

				</div>

			</div>

		</div>

	</div>
	<script>
	 const popup = document.getElementById("popup");
	    //var result=0;
	    var result = ${result};
	    const openPopup = ()=>{
	      popup.classList.add("open-popup");
	    }
	  
	    
	    if(result === 1 ){
	      openPopup();
	    }
		
		
	</script>
</body>
</html>
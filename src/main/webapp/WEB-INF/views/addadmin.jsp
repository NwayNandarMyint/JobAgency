
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
header {
	padding: 10px;
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.buttons {
	display: flex;
	gap: 10px;
}

.buttons button {
	padding: 6px 12px;
	/* Adjust button padding */
	background-color: #3228bd;
	border: none;
	color: white;
	cursor: pointer;
	border-radius: 4px;
}

.buttons button:hover {
	background-color: #5e5959;
}

.logo {
	width: 55px;
	/* Adjust the logo width as needed */
	height: auto;
	/* Maintain aspect ratio */
}

body {
	font-family: Arial, sans-serif;
	background-image:
		url("https://media.istockphoto.com/id/1499722823/photo/adult-businesswoman-looking-for-a-new-job-over-the-digital-tablet-sitting-in-the-living-room.jpg?s=1024x1024&w=is&k=20&c=Slv-7i0gxAF0FY2XNrODLTLHIQOL26-TtPwhOFm_F0g=");
	background-size: cover;
	background-repeat: no-repeat;
	background-attachment: fixed;
}

.container {
	width: 500px;
	margin: 50px auto;
	background-color: #C0C0C0;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.header {
	text-align: center;
	margin-bottom: 20px;
}

.header h1 {
	color: #333;
}

div {
	margin-bottom: 15px;
}

form label {
	display: block;
	margin-bottom: 5px;
	color: #555;
}

form input, form select {
	width: 100%;
	padding: 8px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

.form select {
	height: 30px;
}

.sub {
	background-color: #4caf50;
	color: #fff;
	padding: 10px 15px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	margin-top: 10px;
}

.sub:hover {
	background-color: #45a049;
}

.custom-form {
	margin-top: 50px;
	/* Move the form 50 pixels down from its original position */
	margin-left: 800px;
	/* Move the form 20 pixels to the right from its original position */
}

.custom-note {
	text-align: center;
	font-family: Arial, sans-serif;
	font-size: 25px;
}

button[type="submit"] {
	width: 100%;
	padding: 12px;
	border: none;
	border-radius: 4px;
	background-color: #ff6600; /* Button background */
	color: #fff;
	cursor: pointer;
	font-size: 16px;
}

button[type="submit"]:hover {
	background-color: #e66000; /* Darker button color on hover */
}
</style>
</head>
<body>
	<header>
		<img src='<c:url value="/resources/img/logo.png"/>' alt="image"
			class="logo">
		<h2 style="color: rgb(249, 46, 46);">Lanbra Job</h2>
		<div class="buttons">
			<button onclick="home()">Home Page</button>
			<button onclick="register()">Company Register</button>
		</div>
	</header>

	<div class="custom-form">

		<form:form action="addadmin" method="post" modelAttribute="admin">

			<div class="container">
				<div class="text-danger">${error}</div>

				<div>
					<h1 class="header">Create a New Profile</h1>
				</div>

				<div>
					<form:input path="name" placeholder="Enter Full Name"></form:input>
					<form:errors path="name" cssClass="text-danger"></form:errors>
				</div>

				<div>
					<form:input path="email" placeholder="Enter Email"></form:input>
					<form:errors path="email" cssClass="text-danger"></form:errors>
				</div>

				<div>
					<form:input path="password" type="password" placeholder="Enter Password"></form:input>
					<form:errors path="password" cssClass="text-danger"></form:errors>
				</div>
				
				<div>        
				      <form:select  path="role_id"  class="form-select">
				      <form:option value="0">Select Role</form:option>     
				      <c:forEach var="role" items="${roles}">
				           <form:option value="${role.id}">${role.role}</form:option>
				       </c:forEach>
				      </form:select>
				      <form:errors path="role_id" cssClass="text-danger"></form:errors>
    			</div>
				
				<div>
					<button type="submit" class="btn btn-primary">Add</button>
				</div>
				
			</div>
		</form:form>
	</div>
	<script>
		function home() {

			window.location.href = "/job_agency/";
			console.log('Login clicked');
		}

		function register() {
			window.location.href = "/job_agency/addcompany";
			console.log('Register clicked');
		}
	</script>
</body>

</html>
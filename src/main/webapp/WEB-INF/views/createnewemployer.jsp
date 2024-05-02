<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body, h1, h2, h3, p, form, label, input, select {
	margin: 0;
	padding: 0;
}

body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
}

.container {
	width: 400px;
	margin: 50px auto;
	background-color: #fff;
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
</style>
</head>
<body>
	<form:form action="/Job_agency/employer/addemployer" method="post"
		modelAttribute="employer" enctype="multipart/form-data">
		<div class="container">
			<div>
				<h2 class="header">Sing Up New Employer Account</h2>
			</div>

			<div class="errorcolor">${error}</div>

			<div>
				<form:input path="logo" type="file"
					placeholder="Choose Company Profile" required="required"></form:input>
				<form:errors path="logo" cssClass="text-danger"></form:errors>
			</div>
			<div>
				<form:input path="name" placeholder="Enter Full Compnay Name"></form:input>
				<form:errors path="name" cssClass="text-danger"></form:errors>
			</div>
			<div>
				<form:input path="email" placeholder="Enter Your E-mail"></form:input>
				<form:errors path="email" cssClass="text-danger"></form:errors>
			</div>
			<div>
				<form:input path="password" type="password"
					placeholder="Enter Password"></form:input>
				<form:errors path="password" cssClass="text-danger"></form:errors>
			</div>
			<div>
				<form:input path="phone_number"
					placeholder="Enter Your Phone Number"></form:input>
				<form:errors path="phone_number" cssClass="text-danger"></form:errors>
			</div>
			<div>
				<form:select path="industry_id" class="form-select">
					<form:option value="0">Select Industry</form:option>
					<c:forEach var="industry" items="${industries}">
						<form:option value="${industry.id}">${industry.name}</form:option>
					</c:forEach>
				</form:select>
				<div class="text-danger">${Industry_error}</div>
			</div>
			<div>
				<p>
					By continuing, you agree to <a href="#">Terms and Conditions</a>
				</p>
			</div>
			<div>
				<input type="submit" value="Register" class="sub"
					onclick="registerUser()">
			</div>
			<div>
				Already have an account? <a href="/Job_agency/employer/">Login</a>
			</div>
		</div>
	</form:form>
	<div class="popup" id="popup">
		<img
			src="https://www.shutterstock.com/image-vector/green-check-mark-icon-circle-260nw-576516469.jpg">
		<p>Register Successful</p>
		<p>Please Login To See Profile !</p>
		<a href="/Job_agency/employer/"><button type="button">Ok</button></a>
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
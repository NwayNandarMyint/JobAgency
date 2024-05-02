
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

.popup{
  
    width:400px;
    background: #F8F9F9;
    position: absolute;
    top:0;
    left:50%;
    transform:translate(-50%,-50%);
    text-align: center;
    padding: 0 30px 30px;
    visibility: hidden;
    color: black;
    transition:transform 0.4s, top 0.4s;
    
  }
  
.open-popup{ 
    visibility: visible;
    top:20%;
    transform:translate(-50%,-50%);
  }
  
.popup img{
    width:100px;
    margin-top: -50px;
    border-radius: 50%;
    box-shadow: 0 2px 5px rgba(0,0,0,0.2);
  }
  
  .popup button{
    width:100%;
    margin-top: 10px;
    padding: 10px 0;
    background: #6fd649;
    color:#fff;
    border:0;
    outline:none;
    font-size: 18px;
    border-radius:4px;
    cursor: pointer;
    box-shadow: 0 5px 5px rgba(0,0,0,0.2);
  }
	
</style>
</head>
<body>
	<header>
		<img src='<c:url value="/resources/img/logo.png"/>' alt="image"
			class="logo">
		<h2 style="color: rgb(249, 46, 46);">Lanbra Job</h2>
		<div class="buttons">
			<button><a href="/Job_agency/candidate/userHome">Go to Home </a></button>
			
			
		</div>
	</header>

	<div class="custom-form">

		<form:form action="/Job_agency/candidatecv/addcandidatecv" method="post" modelAttribute="candidatecv" enctype="multipart/form-data">

			<div class="container">
				<div class="text-danger">${error}</div>

				<div>
					<h1 class="header">Create Your CV Form</h1>
				</div>
				<div>
					<form:input type="hidden" path="job_post_id" value="${post.id}"></form:input>
				</div>
				  <div>
					<form:input path="applied_position" value="${post.position_name}"></form:input>
					<form:errors path="applied_position" cssClass="text-danger"></form:errors>
				</div>
				<div>
					<form:input path="expected_salary" placeholder="Enter Expected Salary"></form:input>
					<form:errors path="expected_salary" cssClass="text-danger"></form:errors>
				</div>
				
				<div>
					<form:input path="certificates" placeholder="Enter Other Certificates"></form:input>
					<form:errors path="certificates" cssClass="text-danger"></form:errors>
				</div>
				<div class="mb-3">		
					<form:label path="languages"  class="form-label">Language</form:label>						
					<form:select multiple="true" path="languages" class="form-control">
    					<form:options items="${languagesOptionList}" itemValue="id" itemLabel="name"/>
					</form:select>
					<form:errors path="languages" cssClass="text-danger"></form:errors>
				</div>
				<div>
					<form:label path="cv_photo">Upload Your Photo</form:label>
					<form:input path="cv_photo" type="file" accept=".pdf,.doc,.docx,.jpefg,.png" required="required"></form:input>
					<form:errors path="cv_photo" cssClass="text-danger"></form:errors>
				</div>

				<div>
					<form:label path="cv_form">Upload Your CV_Form</form:label>
					<form:input path="cv_form" type="file" accept=".pdf,.doc,.docx" required="required"></form:input>
					<form:errors path="cv_form" cssClass="text-danger"></form:errors>
				</div>
				<div>
					<form:textarea path="work_experience" placeholder="Enter Your Work Experience"></form:textarea>
					<form:errors path="work_experience" cssClass="text-danger"></form:errors>
				</div>
				<div>
					<button type="submit" class="btn btn-primary">Send</button>
				</div>
			</div>
		</form:form>
		<div class="popup" id="popup">
                <img src="https://www.shutterstock.com/image-vector/green-check-mark-icon-circle-260nw-576516469.jpg">
                <p> Successful Sending</p>
                <a href="/Job_agency/jobpost/viewall"><button type="button">Ok</button></a>
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
	
		
	</div>
	
</body>
</html>
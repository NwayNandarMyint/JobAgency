<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" >
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

form input,
form select {
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
  margin-top:10px;
}

.sub:hover {
  background-color: #45a049;
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
  
  .popup h2{
    font-size: 30px;
    font-weight: 500;
    margin: 15px 0 5px;
  
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
		<form:form action="addcandidate" method="post" modelAttribute="checkcandidate">
		<div class="container">
		<div>
								<h1>Create a New Profile</h1>
							</div>

							<div>
								<form:input path="name" placeholder="Enter Full Name"></form:input>
								<form:errors path="name" cssClass="text-danger"></form:errors>
							</div>

							<div>
								<form:input path="email" placeholder="Enter Your Email"></form:input>
								<form:errors path="email" cssClass="text-danger"></form:errors>
							</div>

							<div>
								<form:input path="password" type="password" placeholder="Enter Your Password"></form:input>
								<form:errors path="password" cssClass="text-danger"></form:errors>
							</div>

							<div>
								<form:input path="phone" placeholder="Enter Your Phone Number"></form:input>
								<form:errors path="phone" cssClass="text-danger"></form:errors>
							</div>
							
							<div>
								<form:label path="date_of_birth">Enter Your Birthday</form:label>
								<form:input path="date_of_birth" type="date"></form:input>
								<form:errors path="date_of_birth" cssClass="text-danger"></form:errors>
							</div>
							
							<div>
								<form:input path="nationality" placeholder="Enter Your Nationality"></form:input>
								<form:errors path="nationality" cssClass="text-danger"></form:errors>
							</div>
							
							<div>
								<div>
									<form:select path="marital_status"><option selected="selected" value="" >Enter Your Marital_status</option>
										<option value="single">Single</option>
										<option value="married">Married</option>
										<option value="other">Other</option>
									</form:select>
								</div>
								<form:errors path="marital_status" cssClass="text-danger"></form:errors>
							</div>
							
							<div>
								<div>
									<form:select path="gender">
										<option selected="selected" value="">Your
											Gender</option>
										<option value="male">Male</option>
										<option value="female">Female</option>
										<option value="other">Other</option>
									</form:select>
								</div>
								<form:errors path="gender" cssClass="text-danger"></form:errors>
							</div>
							
							<div>
								<form:input path="contact_address" placeholder="Enter Your Contact Address"></form:input>
								<form:errors path="contact_address" cssClass="text-danger"></form:errors>
							</div>
				
							<div>
								<form:input path="parmanent_address" placeholder="Enter Your Permanent Address"></form:input>
								<form:errors path="parmanent_address" cssClass="text-danger"></form:errors>
							</div>
							
							<div>
								<form:input path="education_background" placeholder="Enter Education Background"></form:input>
								<form:errors path="education_background" cssClass="text-danger"></form:errors>
							</div>

							<div>
								<button type="submit" class="btn btn-primary">Register</button>
							</div>
				
							<div>
							Go to >> <a href="/Job_agency/candidate/" style="color: green; text-decoration: none;">Login</a>
							</div>

					  </div>
		          </form:form>
		          <div class="popup" id="popup">
		                <img src="https://www.shutterstock.com/image-vector/green-check-mark-icon-circle-260nw-576516469.jpg">
		                <h2>Thank You!</h2>
		                <p>Register Successful</p>
		                 <p>Please Login To View Profile !</p>
		                <a href="/Job_agency/candidate/"><button type="button">Ok</button></a>
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



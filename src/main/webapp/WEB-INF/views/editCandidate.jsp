
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
 .container {
            width: 50%;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border: 1px solid #646262;
        }

        h3 {
            text-align: center;
            color: #333;
        }

        .form-group {
            margin-bottom: 15px;
             
        }

        label {
            display: block;
            margin-bottom: 5px;
            color: #666;
        }
        input{
        	 width: 100%;
            padding: 8px;
            border-radius: 4px;
            border: 1px solid #3b3a3a;
        }

        input[type="email"],
        input[type="password"],
        select {
            width: 100%;
            padding: 8px;
            border-radius: 4px;
            border: 1px solid #3b3a3a;
        }

        button[type="submit"] {
            background-color: #4caf50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        button[type="submit"]:hover {
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
<div class="dashboard-river">

  <div class="dashboard-container">

    <div class="dashboard">

      <div class="ui-row-1">

        <div class="logo-comp">
          <div><svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 297 297" xml:space="preserve">
              <g>
                <path d="M48.523,73.196h18.131c5.597,0,10.137-4.536,10.137-10.134c0-5.6-4.54-10.137-10.137-10.137H48.523 c-5.599,0-10.137,4.537-10.137,10.137C38.387,68.66,42.925,73.196,48.523,73.196z" />
                <path d="M47.628,123.657c0-5.598-4.54-10.137-10.137-10.137H19.357c-5.599,0-10.135,4.539-10.135,10.137 c0,5.597,4.536,10.135,10.135,10.135h18.134C43.088,133.792,47.628,129.254,47.628,123.657z" />
                <path d="M277.643,95.387h-18.135c-5.597,0-10.137,4.539-10.137,10.135c0,5.601,4.54,10.137,10.137,10.137h18.135 c5.599,0,10.135-4.536,10.135-10.137C287.777,99.926,283.241,95.387,277.643,95.387z" />
                <path d="M140.148,203.69v83.173c0,5.598,4.54,10.137,10.137,10.137c5.599,0,10.137-4.539,10.137-10.137V203.69h93.406 c5.597,0,10.137-4.539,10.137-10.136c0-5.598-4.54-10.137-10.137-10.137H227.05c3.911-8.197,5.898-17.617,5.898-28.209 c0-29.299-21.058-60.583-39.637-88.187c-5.055-7.506-9.829-14.599-13.809-21.124c-1.689-3.791-1.094-19.677,1.284-34.106 c0.487-2.938-0.344-5.942-2.271-8.212c-1.926-2.27-4.752-3.58-7.73-3.58h-40.998c-2.977,0-5.803,1.313-7.729,3.58 c-1.924,2.268-2.755,5.271-2.273,8.21c2.383,14.432,2.978,30.316,1.288,34.107c-3.984,6.527-8.759,13.619-13.813,21.126 c-18.579,27.604-39.639,58.887-39.639,88.186c0,10.592,1.987,20.012,5.902,28.209H46.745c-5.601,0-10.137,4.539-10.137,10.137 c0,5.597,4.536,10.136,10.137,10.136H140.148z M202.707,183.418H97.864c-6.701-7.003-9.968-16.27-9.968-28.209 c0-23.111,19.222-51.669,36.182-76.865c5.209-7.738,10.13-15.05,14.363-21.993c4.769-7.819,4.27-23.774,2.954-36.077h17.781 c-1.316,12.302-1.813,28.257,2.952,36.077c4.233,6.943,9.153,14.252,14.362,21.992c16.96,25.197,36.184,53.755,36.184,76.866 C212.675,167.148,209.406,176.417,202.707,183.418z" />
              </g>
            </svg></div>
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
            <svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
              <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z" />
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
           

          </div>
          <hr>
           <div class="container">
            <form:form method="POST" action="/Job_agency/candidate/editCandidate" modelAttribute="updatecandidate" enctype="multipart/form-data">
                <div><h3>Update Profile Here</h3></div>
                <div class="form-group">
                	<form:label path="name">Enter Name:</form:label>
					<form:input path="name" value="${candidate.name}"></form:input>
					<form:errors path="name" cssClass="text-danger"></form:errors>
                </div>
                <div class="form-group">
                   <form:label path="email">Enter Email:</form:label>
                   <form:input path="email" value="${candidate.email}"></form:input>
					<form:errors path="email" cssClass="text-danger"></form:errors>
                </div>
                <div class="form-group">
                   <form:label path="password">Enter Password:</form:label>
                   <form:input path="password" type="password" value="${candidate.password}"></form:input>
					<form:errors path="password" cssClass="text-danger"></form:errors>
                </div>
                <div class="form-group">
                   <form:label path="phone">Enter phone:</form:label>
                   <form:input path="phone"  value="${candidate.phone}"></form:input>
				   <form:errors path="phone" cssClass="text-danger"></form:errors>
                </div>
     
				<div class="form-group">
					<form:label path="date_of_birth">Enter Your Birthday</form:label>
					<form:input path="date_of_birth" type="date" value="${candidate.date_of_birth}"></form:input>
					<form:errors path="date_of_birth" cssClass="text-danger"></form:errors>
				</div>
							
				<div class="form-group">
					<form:label path="nationality">Enter Your Nationality:</form:label>
					<form:input path="nationality" value="${candidate.nationality}"></form:input>
					<form:errors path="nationality" cssClass="text-danger"></form:errors>
				</div>
							
				<div class="form-group">
					<form:select path="marital_status">
						<form:option selected="selected" value="${candidate.marital_status}">Select Your Marital_status</form:option>
						<form:option value="single">Single</form:option>
						<form:option value="married">Married</form:option>
						<form:option value="other">Other</form:option>
					</form:select>
					<form:errors path="marital_status" cssClass="text-danger"></form:errors>
				</div>
							
				<div class="form-group">		
					<form:select path="gender">
						<form:option selected="selected" value="${candidate.gender}">Your Gender</form:option>
						<form:option value="male">Male</form:option>
						<form:option value="female">Female</form:option>
						<form:option value="other">Other</form:option>
					</form:select>
					<form:errors path="gender" cssClass="text-danger"></form:errors>
				</div>	
				<div class="form-group">
					<form:label path="contact_address">Enter Your Contact Address:</form:label>
					<form:input path="contact_address" value="${candidate.contact_address}"></form:input>
					<form:errors path="contact_address" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="parmanent_address">Enter Your Permanent Address:</form:label>
					<form:input path="parmanent_address" value="${candidate.parmanent_address}"></form:input>
					<form:errors path="parmanent_address" cssClass="text-danger"></form:errors>
				</div>	
				<div class="form-group">
				<form:label path="education_background">Enter Your Education Background:</form:label>
				<form:input path="education_background" value="${candidate.education_background}"></form:input>
				<form:errors path="parmanent_address" cssClass="text-danger"></form:errors>
				</div>
				<div class="form-group">
				<button type="submit" class="btn btn-primary">Update</button>
				</div>
            </form:form>
            <div class="popup" id="popup">
                <img src="https://www.shutterstock.com/image-vector/green-check-mark-icon-circle-260nw-576516469.jpg">
                <h2>Thank You!</h2>
                <p>Update Profile Successful !</p>
                <a href="/Job_agency/candidate/displayCandidate"><button type="button">Ok</button></a>
           </div>
      
        </div>

      </div>

    </div>

  </div>

</div>
<!-- partial -->
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
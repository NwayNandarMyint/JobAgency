<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Lanbra Job Agency</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
<style type="text/css">


.search-form {
  display: flex;
}

.search-input {
	width:300px;
  flex: 1;
  padding: 10px;
  border: 2px solid #F5F835;
  border-radius: 8px;
}

.search-btn {
  background-color: #43DA2B; /* Button background color */
  color: #ffffff; /* Button text color */
  border: none;
  border-radius: 8px;
  padding: 10px 15px;
  margin-left: 8px;
  cursor: pointer;
}

.search-btn:hover {
  background-color: #3AA52F; /* Button background color on hover */
}	

	.image-container {
        display: grid;
        grid-template-columns: repeat(6, 1fr); /* Four columns */
        gap: 20px; /* Adjust the gap between images */
    }
	

	.rounded-circle {
        width: 110px; /* Adjust the size as needed */
        height: 110px; /* Adjust the size as needed */
        border-radius: 50%; /* Makes the image circular */
        overflow: hidden; /* Hides image overflow */
         border: 2px solid #313030; /* White border */
         box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    }

.topjob{	
	width: 180px;	
	height: 180px;
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
<!-- partial:index.partial.html -->
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
          			 <img src='<c:url value="/resources/img/logo.png"/>' alt="image" class="logo">
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
           				 <div class="clay-category">
              					<svg viewBox="0 0 512 512" xmlns="http://www.w3.org/2000/svg">
              					 <path d="M329.3 99.64l-39.7 10.46c-30.2 26.1-62.7 50.9-96.7 75.1l-6.7 21-34.1 7.3c-22.6 15.3-45.6 30.4-68.82 45.5l120.32 18.4 213.9-167.1c-27.7-3.8-56.9-7.5-88.2-10.66zm103.4 21.56l-61.4 47.9-43 53.1-45 15.7-65 50.7 20.8 115.1c65.6-54.6 127.6-109.4 187-163.1l-5.6-31.2 42.1-1.9c8.3-7.4 16.5-14.9 24.6-22.3zM61.58 277.6c-21.15 39.9-32.01 70.6-36.83 95.8 9.21 1.1 18.3 2.2 27.28 3.5l16.76-30.6 5.52 34c53.29 8.6 103.09 20.5 152.19 32.1l-26.9-117.6-66-10.1z" />
              					</svg>
             					 <p><a href="#" style="color: green; text-decoration: none;" onclick="document.getElementById('id').style.display='block'">Logout</a></p>
            			</div>
           <div id="id" class="modal">
           <div class="container">  
              <h3>LogOut</h3>
              <p>Are you sure you want to logout in this page?</p>
              <div>
                  <button type="button" onclick="document.getElementById('id').style.display='none'" class="cancelbtn">No</button>
                 <a href="/Job_agency/logout/"> <button type="button" class="deletebtn">Yes</button></a>
              </div>
        </div> 
      </div>
           				 <div class="clay-category">
             				 <svg viewBox="0 0 512 512" xmlns="http://www.w3.org/2000/svg">
                			 <path d="M329.3 99.64l-39.7 10.46c-30.2 26.1-62.7 50.9-96.7 75.1l-6.7 21-34.1 7.3c-22.6 15.3-45.6 30.4-68.82 45.5l120.32 18.4 213.9-167.1c-27.7-3.8-56.9-7.5-88.2-10.66zm103.4 21.56l-61.4 47.9-43 53.1-45 15.7-65 50.7 20.8 115.1c65.6-54.6 127.6-109.4 187-163.1l-5.6-31.2 42.1-1.9c8.3-7.4 16.5-14.9 24.6-22.3zM61.58 277.6c-21.15 39.9-32.01 70.6-36.83 95.8 9.21 1.1 18.3 2.2 27.28 3.5l16.76-30.6 5.52 34c53.29 8.6 103.09 20.5 152.19 32.1l-26.9-117.6-66-10.1z" />
             				 </svg>
             				 <p><a href="/Job_agency/candidate/displayCandidate" style="color: green; text-decoration: none;">Profile</a></p>
                   		 </div>

         		   </div>
          			<div class="large-banner">
            			<h2>Search Your job at Lanbra</h2><br>
            	  
   			 				<form class="search-form" role="search" action="/Job_agency/jobpost/secrchjobpost" method="get">
     		 					<input class="search-input" type="search" name="data" placeholder="Search With Position" aria-label="Search">
      							<button class="search-btn" type="submit">Search</button>
    						</form>
          			</div>

          			<hr>
          			
          			<h2 >Top Companies</h2>
                
                <div class="image-container">
              <c:forEach var="employer" items="${employers}" varStatus="loopTime">
                  <c:if test="${loopTime.index < 6}">
                      <a href="/Job_agency/candidate/detail/${employer.id}">
                          <img src="data:image/jpeg;base64,${employer.logoString}" alt="Company Logo" class="rounded-circle">
                      </a>
                  </c:if>
              </c:forEach>
          </div>  
                <br>
                <button class="search-btn"><a href="/Job_agency/employer/viewall" style="color: green; text-decoration: none;">View All Companies</a></button>
                <hr>
          			
					<h2 >Recent Job Post</h2>
         			<div class="featured-clay">
            				<div>
              					 <div><img src="data:image/jpeg;base64,${employer1.logoString}" alt="image" class="topjob"></div>
              				 	 <div>
                						<h2>Company Name : ${employer1.name}</h2>
               							 <p>Industry Name : ${employer1.industry_name}<br>
               			 			   	<c:forEach var="post" items="${jobpost}" varStatus="time">
							   				 <c:if test="${time.count == fn:length(jobpost)}"> 
							       				  address: ${post.address}<br>
							      				  Position: ${post.position_name}
							   				  </c:if>
										</c:forEach>
               			 			   	</p>
               			 				<a href="/Job_agency/candidate/postdetail/${employer1.id}" title="Company Detail">view</a>
              					 </div>
              				 	 	
               				</div>
							<div>
              					 <div><img src="data:image/jpeg;base64,${employer2.logoString}" alt="image" class="topjob"></div>
              				 	 <div>
                						<h2>Company Name : ${employer2.name}</h2>
               							 <p>Industry Name : ${employer2.industry_name}<br>
               			 			   	<c:forEach var="post" items="${jobpost2}" varStatus="time">
							   				 <c:if test="${time.count == fn:length(jobpost2)}"> 
							       				  address: ${post.address}<br>
							      				  Position: ${post.position_name}
							   				  </c:if>
										</c:forEach>
               			 			   	 	</p>
               			 				<a href="/Job_agency/candidate/postdetail/${employer2.id}" title="Company Detail">view</a>
              					 </div>
              				 	 	
               				</div>
               				<div>
              					 <div><img src="data:image/jpeg;base64,${employer3.logoString}" alt="image" class="topjob"></div>
              				 	 <div>
                						<h2>Company Name : ${employer3.name}</h2>
               							 <p>Industry Name : ${employer3.industry_name}<br>
               			 			   	<c:forEach var="post" items="${jobpost3}" varStatus="time">
							   				 <c:if test="${time.count == fn:length(jobpost3)}"> 
							       				  address: ${post.address}<br>
							      				  Position: ${post.position_name}
							   				  </c:if>
										</c:forEach>
               			 			   	 	</p>
               			 				<a href="/Job_agency/candidate/postdetail/${employer3.id}" title="Company Detail">view</a>
              					 </div>
              				 	 	
               				</div>
               				
               				<div>
              					 <div><img src="data:image/jpeg;base64,${employer4.logoString}" alt="image" class="topjob"></div>
              				 	 <div>
                						<h2>Company Name : ${employer4.name}</h2>
               							 <p>Industry Name : ${employer4.industry_name}<br>
               			 			   	<c:forEach var="post" items="${jobpost4}" varStatus="time">
							   				 <c:if test="${time.count == fn:length(jobpost4)}"> 
							       				  address: ${post.address}<br>
							      				  Position: ${post.position_name}
							   				  </c:if>
										</c:forEach>
               			 			   	 	</p>
               			 				<a href="/Job_agency/candidate/postdetail/${employer4.id}" title="Company Detail">view</a>
              					 </div>
              				 	 	
               				</div>
               				
               				<div>
              					 <div><img src="data:image/jpeg;base64,${employer5.logoString}" alt="image" class="topjob"></div>
              				 	 <div>
                						<h2>Company Name : ${employer5.name}</h2>
               							 <p>Industry Name : ${employer5.industry_name}<br>
               			 			   	<c:forEach var="post" items="${jobpost5}" varStatus="time">
							   				 <c:if test="${time.count == fn:length(jobpost5)}"> 
							       				  address: ${post.address}<br>
							      				  Position: ${post.position_name}
							   				  </c:if>
										</c:forEach>
               			 			   	 	</p>
               			 				<a href="/Job_agency/candidate/postdetail/${employer5.id}" title="Company Detail">view</a>
              					 </div>
              				 	 	
               				</div>
               				
               				<div>
              					 <div><img src="data:image/jpeg;base64,${employer6.logoString}" alt="image" class="topjob"></div>
              				 	 <div>
                						<h2>Company Name : ${employer6.name}</h2>
               							 <p>Industry Name : ${employer6.industry_name}<br>
               			 			   <c:forEach var="post" items="${jobpost6}" varStatus="time">
							   				 <c:if test="${time.count == fn:length(jobpost6)}"> 
							       				  address: ${post.address}<br>
							      				  Position: ${post.position_name}
							   				  </c:if>
										</c:forEach>
               			 			   	 	</p>
               			 				<a href="/Job_agency/candidate/postdetail/${employer6.id}" title="Company Detail">view</a>
              					 </div>
              				 	 	
               				</div>
              				
        			 </div>

                       <button class="search-btn"><a href="/Job_agency/jobpost/viewall" style="color: green; text-decoration: none;">View All Jobs</a></button>
						<br>
          			 <hr>

          			<div class="featured-users">
            	  		<h2>Best Web<br><span>For Job</span></h2>
					</div>
        	   </div>

      	 </div>
      
      
      

    </div>

  </div>

</div>
<!-- partial -->
 <script type="text/javascript">
 
//Get the current URL
 var currentUrl = window.location.href;

 // Remove the query parameters
 var cleanedUrl = currentUrl.split("?")[0];

 // Update the URL without query parameters
 window.history.replaceState({}, document.title, cleanedUrl);

 
 </script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
				/* Navigation bar styling */
		nav {
		    background-color: #333;
		    padding: 10px;
		    text-align: center;
		    border-radius: 8px;
		}
		
		/* Navigation link styling */
		nav a {
		    text-decoration: none;
		    color: #fff;
		    padding: 10px 15px;
		    margin: 0 20px; /* Reduced margin for a cleaner look */
		    font-weight: bold;
		    border-radius: 5px;
		    transition: background-color 0.3s ease, color 0.3s ease; /* Added color transition */
		}
		
		/* Hover effect for the navigation links */
		nav a:hover {
		    background-color: #555;
		    color: #fff; /* Set the text color on hover */
		}
		
		/* Active link style */
		nav a.active {
		    background-color: #007bff;
		    color: #fff;
		}
		
		/* Container for the navigation links */
		nav ul {
		    list-style: none;
		    padding: 0;
		    display: flex;
		    justify-content: center;
		}
		
		/* Style for each navigation list item */
		nav li {
		    margin: 0 20px;
		}
		
		/* Improved spacing for better readability */
		nav a:not(:last-child) {
		    margin-right: 20px;
		}

</style>
</head>
<body>
	<nav>
        <a href="/Job_agency/employer/displayemployer">Profile</a> |
        <a href="/Job_agency/employer/ticket">Ticket Page</a> |
        <a href="/Job_agency/jobpost/post">Job Post Upload</a> |
        <a href="/Job_agency/employer/updateemployer">Update Profile</a>
        <a href="/Job_agency/employer/viewallcv">Received CV Form</a>
         <a href="/Job_agency/employer/jobposthistory">History</a>
    </nav>
</body>
</html>
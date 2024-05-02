 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Lanbra Job Agency Login</title>
    <style>
        /* Reset some default styles */
        body, h2, p, form, label, input {
            margin: 0;
            padding: 0;
        }

        body {
            font-family: Arial, sans-serif;
        }

        .background-container {
            background-image: url("https://www.shutterstock.com/image-photo/selective-new-career-recruitment-sites-260nw-2299628847.jpg");
            background-color: #1a1a1a; /* Dark background color */
            background-size: cover;
            display: flex;
            height: 100vh;
        }

        .left-section,
        .right-section {
            flex: 1;
        }

        .left-section {
            background-color: none;
            margin: 70px auto;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 0 rgba(0, 0, 0, 0);
            text-align: center;
            margin-left: 50px;
            color: #fff; /* Text color */
        }

        .left-section h1 {
            color: #6C2EBA;
        }

        .container {
            width: 400px;
            margin: 50px auto;
            background-color: #333; /* Dark background color */
            margin-top: 70px;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            color: #fff; /* Text color */
        }

        .header {
            text-align: center;
            margin-bottom: 20px;
        }

        .header h2 {
            color: #fff; /* Text color */
        }

        div {
            margin-bottom: 15px;
        }

        form label {
            display: block;
            margin-bottom: 5px;
            color: #ddd; /* Lighter text color */
        }

        form input {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #555; /* Darker border color */
            border-radius: 4px;
            box-sizing: border-box;
            background-color: #444; /* Darker input background color */
            color: #fff; /* Text color */
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
        
        .errorcolor {
 			color: red;
		}
        
    </style>
</head>
<body>
    <div class="background-container">
        <div class="left-section">
            <h1>Lanbra Job Agency</h1>
            <h2>Open Lanbra Job Agency Data Here =></h2>
        </div>
        <div class="right-section">
            <form:form action="/Job_agency/admin/checkadmin" method="post" modelAttribute="checkadmin">
            
                <div class="container">
                    <div>
                        <h2 class="header">Admin Login Here!</h2>
                    </div>
                    
                    <div class="errorcolor">${receivedloginerror}</div>
                    <div>
                    
                        <form:input path="email" type="email" placeholder="Enter Your E-Mail"></form:input>
                        <div  class="errorcolor">${receivedemailerror}</div>
                    </div>
                    <div>
                        <form:input path="password" type="password" placeholder="Enter Your Password"></form:input>
                        <div  class="errorcolor">${receivedpassworderror}</div>
                    </div>
                    <div>
                        <input type="submit" value="Login" class="sub"/>
                    </div>
                    <div>
                    	<p><a href="#">Forget Password!</a></p>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</body>
</html>

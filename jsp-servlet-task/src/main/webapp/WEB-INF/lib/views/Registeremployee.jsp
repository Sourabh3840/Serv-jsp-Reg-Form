<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration form</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

 <script type="text/javascript">
        function LoginPage() {
            window.location.href = "Login";
        }
    </script>
    <script type="text/javascript">
        function HomePage() {
            window.location.href = "Home";
        }
    </script>
    
       <script type="text/javascript">
        window.onload = function() {
            <% if (session.getAttribute("registrationSuccess") != null) { %>
                alert("Registered successfully!");
                <% session.removeAttribute("registrationSuccess"); %>
            <% } %>
        };
    </script>

</head>
<body>
	
	<div align="center">
	<h1>Employee Registration Form </h1>
	<form action="<%= request.getContextPath() %>/register" method="post">
	<table style="width:80%">
	<tr>
	<td>First Name </td>
	<td><input class="form-control" type="text" name="firstname"></td>
	</tr>
	<tr>
	<td>Last Name </td>
	<td><input class="form-control" type="text" name="lastname"></td>
	</tr>
	<tr>
	<td>UserName </td>
	<td><input class="form-control" type="text" name="username"></td>
	</tr>
	<tr>
	<td>Password </td>
	<td><input class="form-control" type="password" name="password"></td>
	</tr>
	<tr>
	<td>Address </td>
	<td><input class="form-control" type="text" name="Address"></td>
	</tr>
	<tr>
	<td>Contact No. </td>
	<td><input class="form-control" type="text" name="contact"></td>
	</tr>
	
	<tr>
	<td>Gender</td>
	<td><input class="form-control" type="text" name="gender"></td>
	</tr>
	
	<tr>
	<td>State </td>
	<td><input class="form-control" type="text" name="state"></td>
	</tr>
	
	<tr>
	<td>City </td>
	<td><input class="form-control" type="text" name="city"></td>
	</tr>
	<tr>
	</tr>
	
	</table>
	<input class="btn btn-success" type="submit" value="Submit">
	</form>
	<br>
	<center><button class="btn btn-primary" onclick="LoginPage()">Login Page</button> </center>
	
	</div>
</body>
</html>
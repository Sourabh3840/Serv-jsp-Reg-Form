<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>     	
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">


 <script type="text/javascript">
        function HomePage() {
            window.location.href = "Home";
        }
    </script>
    <script type="text/javascript">
        function SignUpPage() {
            window.location.href = "register";
        }
    </script>
    
     <script type="text/javascript">
        window.onload = function() {
            <% if (session.getAttribute("loginSuccess") != null) { %>
                alert("invalid credentials");
                <% session.removeAttribute("loginSuccess"); %>
            <% } %>
        };
    </script>

</head>
<body>
<div align="center">
<h2>User Login</h2>
<form action="<%= request.getContextPath() %>/Login" method="post">
	Enter Username : 
	<input class="form-control" type="text" name="username">
	<br>
	
	Enter Password : 
	<input class="form-control" type="password" name="password">
	
	<br>		
	<center><input class="btn btn-success" type="submit" name="Login"></center>
			
</form>
<br>
	  <button class="btn btn-primary" onclick="SignUpPage()">SignUp</button></center>

</div>
</body>
</html>
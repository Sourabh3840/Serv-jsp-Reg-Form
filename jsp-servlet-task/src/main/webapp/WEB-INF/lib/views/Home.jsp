<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.ResultSet" %>
    <%@ page import="java.util.List" %>
    <%@ page import="com.sourabh.task.model.Employee" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Data</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
    
    <script type="text/javascript">
        function LoginPage() {
            window.location.href = "Login";
        }
    </script>
    <script type="text/javascript">
        function SignUpPage() {
            window.location.href = "register";
        }
    </script>
    
</head>
<body>

<%
    List<Employee> employeeList = (List<Employee>) request.getAttribute("employeeList");

    if (employeeList != null && !employeeList.isEmpty()) {
%>
    <table class="table">
        <tr>
            <th scope="col">First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">Username</th>
            <th scope="col">Address</th>
            <th scope="col">Contact</th>
            <th scope="col">gender</th>
            <th scope="col">State</th>
            <th scope="col">City</th>
          </tr>
<%
        for (Employee employee : employeeList) {
%>
        <tr>
            <td><%= employee.getFirstname() %></td>
            <td><%= employee.getLastname() %></td>
            <td><%= employee.getUsername() %></td>
            <td><%= employee.getAddress() %></td>
            <td><%= employee.getContact() %></td>
             <td><%= employee.getGender() %></td>
             <td><%= employee.getState() %></td>
             <td><%= employee.getCity() %></td>
              </tr>
<%
        }
%>
    </table>
<%
    } else {
%>
    <p>No data found</p>
<%
    }
%>

<br>
<br>
	<center><button class="btn btn-primary" onclick="LoginPage()">Login Page</button>  <button class="btn btn-primary" onclick="SignUpPage()">SignUp</button></center>
	


</body>
</html>
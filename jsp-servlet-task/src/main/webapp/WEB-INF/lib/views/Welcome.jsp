<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sourabh.task.model.Employee" %>
  <%@ page import="java.sql.ResultSet" %>
    <%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>

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

</head>
<body>

<%
    Employee employee = (Employee) request.getAttribute("employee");

    if (employee != null) {
    	
    
        List<Employee> employeeList = (List<Employee>) request.getAttribute("employeeList");

        if (employeeList != null && !employeeList.isEmpty()) {
   
%>
    <h2>Welcome, <%= employee.getFirstname() %> <%= employee.getLastname() %></h2>
    
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
        for (Employee employee1 : employeeList) {
            if(employee1.getFirstname().equals(employee.getFirstname()) && employee1.getLastname().equals(employee.getLastname())) {
          	  continue;
            }
            
      
%>

	  <tr>
            <td><%= employee1.getFirstname() %></td>
            <td><%= employee1.getLastname() %></td>
            <td><%= employee1.getUsername() %></td>
            <td><%= employee1.getAddress() %></td>
            <td><%= employee1.getContact() %></td>
             <td><%= employee1.getGender() %></td>
             <td><%= employee1.getState() %></td>
             <td><%= employee1.getCity() %></td>
              </tr>
              
              <%
            
              
        }
%>
    </table>
    <%
    }
%>
<%
    } else {
%>
    <p>No employee data found</p>
<%
    }
%>

</body>
</html>
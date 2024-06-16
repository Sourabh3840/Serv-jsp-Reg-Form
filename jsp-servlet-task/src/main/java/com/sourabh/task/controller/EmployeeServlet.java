package com.sourabh.task.controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;


import com.sourabh.task.dao.*;
import com.sourabh.task.model.Employee;

@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmployeeDao employeeDao = new EmployeeDao();
       int res=0;
    public EmployeeServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/lib/views/Registeremployee.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String Address = request.getParameter("Address");
		String contact = request.getParameter("contact");
		String gender = request.getParameter("gender");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		
		Employee employee = new Employee();
		employee.setFirstname(firstname);
		employee.setLastname(lastname);
		employee.setUsername(username);
		employee.setPassword(password);
		employee.setAddress(Address);
		employee.setContact(contact);
		employee.setGender(gender);
		employee.setState(state);
		employee.setCity(city);		
		try {
			 res =employeeDao.registerEmployee(employee);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res !=0) {
			out.println("<script type='text/javascript'>");
			 out.println("alert('employee successfully registred ');");
			 out.println("</script>");
			 
	            request.getSession().setAttribute("registrationSuccess", true);
	            response.sendRedirect(request.getContextPath() +"/register");

			 
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/lib/views/Registeremployee.jsp");
		//dispatcher.forward(request, response);
			// response.sendRedirect("/WEB-INF/lib/views/Registeremployee.jsp");
		}
	}

}

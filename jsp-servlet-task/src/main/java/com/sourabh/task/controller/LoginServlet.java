package com.sourabh.task.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.RequestDispatcher;

import com.sourabh.task.dao.EmployeeLoginDao;
import com.sourabh.task.dao.HomeDao;
import com.sourabh.task.model.Employee;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    Employee e= null;
    public LoginServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/lib/views/Login.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String un=request.getParameter("username");
		String pwd=request.getParameter("password");
		try {
			 e =EmployeeLoginDao.loginEmployee(un,pwd);	
			 if(e == null){
		            request.getSession().setAttribute("loginSuccess", true);

				 out.println("<script type='text/javascript'>");
				 out.println("alert('Invalid credentials');");
				 out.println("</script>");
				// out.println("<font color=red size=18>Login Failed.. try again<br>");
				// out.println("<a href='Login'>Click here to try again</a>");
		            response.sendRedirect(request.getContextPath() +"/Login");

				 //RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/lib/views/Login.jsp");
				// rd.forward(request, response);
			 }else {
				 if(e.getFirstname() != null) {
					// List<Employee> employeeList = HomeDao.getAllEmployees();
					 List<Employee> employeeList = EmployeeLoginDao.getAllEmployees();

			            request.setAttribute("employeeList", employeeList);
					 request.setAttribute("employee",e);
				 RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/lib/views/Welcome.jsp");
				 rd.forward(request, response);
				 }}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			} } }

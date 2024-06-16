package com.sourabh.task.controller;

import com.sourabh.task.dao.HomeDao;
import com.sourabh.task.model.Employee;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Home")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Employee> employeeList = HomeDao.getAllEmployees();
            request.setAttribute("employeeList", employeeList);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/lib/views/Home.jsp");
            rd.forward(request, response);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}

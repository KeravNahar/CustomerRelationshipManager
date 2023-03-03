package com.wu.crmdemo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wu.crmdemo.dao.CustomerDAO;

/**
 * Servlet implementation class DeleteCustomerController
 */
@WebServlet("/DeleteCustomerController")
public class DeleteCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lastName = request.getParameter("lastName");		
		CustomerDAO customerDAO = new CustomerDAO();
		customerDAO.deleteCustomer(lastName);
		
		response.sendRedirect("DisplayCustomerServlet");
	}


}

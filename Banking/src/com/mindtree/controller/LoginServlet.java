package com.mindtree.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mindtree.entity.Customers;
import com.mindtree.service.CustomerService;
import com.mindtree.service.DataInitialize;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customers cust = new Customers();
		cust.setUsername(request.getParameter("loginuserfield"));
		cust.setPassword(request.getParameter("loginpassfield"));
		DataInitialize dataObj = new DataInitialize();
		dataObj.dataSet();
		HttpSession session = request.getSession();
/*		if(session != null)
		{
			session.invalidate();
			session = request.getSession();
			response.sendRedirect("index.jsp");
		}*/
		CustomerService custServ = new CustomerService();
		cust = custServ.customerValidate(cust); 
		if(cust != null) 
		{
			/*session = request.getSession(false);*/
			session.setAttribute("currentUser", cust);
			/*response.sendRedirect("home.jsp");*/
			RequestDispatcher requestDispatcher =
				    request.getRequestDispatcher("home.jsp");
			requestDispatcher.forward(request, response);
		}
		else
		{
			response.sendRedirect("invalidlogin.jsp");
		}

		
	}

}

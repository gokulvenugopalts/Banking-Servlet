package com.mindtree.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String navig = request.getParameter("homelink");
		if(navig.equals("Fund Transfer"))
		{
			System.out.println("here");
			RequestDispatcher rq = request.getRequestDispatcher("fundtransfer.jsp");
			rq.forward(request, response);
		}
		else if(navig.equals("Generate Report"))
		{
			RequestDispatcher rq = request.getRequestDispatcher("generateReport.jsp");
			rq.forward(request, response);
		}
		else
		{
			RequestDispatcher rq = request.getRequestDispatcher("home.jsp");
			rq.forward(request, response);
		}
	}

}

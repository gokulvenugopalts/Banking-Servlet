package com.mindtree.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mindtree.dao.jdbc.TransferInterface;
import com.mindtree.entity.Customers;
import com.mindtree.service.TransactionService;

/**
 * Servlet implementation class TransferGetServlet
 */
@WebServlet("/TransferGetServlet")
public class TransferGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Customers cust = new Customers();
		cust = (Customers) session.getAttribute("currentUser");
		String d = request.getParameter("generatedate");
		TransactionService trsc = new TransactionService();
		System.out.println(d);
		String res = trsc.transferGet(d);
		PrintWriter out = response.getWriter();
		out.println(res);
	}

}

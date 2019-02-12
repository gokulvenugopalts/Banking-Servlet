package com.mindtree.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mindtree.entity.Customers;
import com.mindtree.service.AccountService;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountService accSer = new AccountService();
		HttpSession session = request.getSession();
		Customers cust = (Customers) session.getAttribute("currentUser");
		cust = new Customers();
		cust.setPassword("123456");
		cust.setUsername("ahad");
		cust.setCustomerid(1);
		String res = accSer.accountget(cust);
		PrintWriter out = response.getWriter();
		out.println(res);
	}

}

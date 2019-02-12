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
import com.mindtree.service.BeneficiaryService;

/**
 * Servlet implementation class BeneficiaryAccServlet
 */
@WebServlet("/BeneficiaryAccServlet")
public class BeneficiaryAccServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		BeneficiaryService benSer = new BeneficiaryService();
		Customers cust = new Customers();
	/*	cust = (Customers) session.getAttribute("currentUser");*/
		
		cust.setPassword("123456");
		cust.setUsername("ahad");
		cust.setCustomerid(1);
		Customers custben = new Customers();
		custben.setUsername(request.getParameter("transferAcc"));
		String res = benSer.getBeneficiaryAcc(cust,custben);
		PrintWriter out = response.getWriter();
		out.println(res);
	}

}

package com.mindtree.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mindtree.entity.Customers;
import com.mindtree.service.AccountService;
import com.mindtree.service.BeneficiaryService;


/**
 * Servlet implementation class BeneficiaryServlet
 */
@WebServlet("/BeneficiaryServlet")
public class BeneficiaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		BeneficiaryService benSer = new BeneficiaryService();
		Customers cust = (Customers) session.getAttribute("currentUser");
		cust = new Customers();
		cust.setPassword("123456");
		cust.setUsername("ahad");
		cust.setCustomerid(1);
		String res = benSer.getBeneficiary(cust);
		PrintWriter out = response.getWriter();
		out.println(res);
		
	}

}

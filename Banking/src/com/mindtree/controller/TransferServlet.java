package com.mindtree.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mindtree.entity.Accounts;
import com.mindtree.entity.Beneficiary;
import com.mindtree.entity.Customers;
import com.mindtree.entity.Transactions;
import com.mindtree.service.TransactionService;

/**
 * Servlet implementation class TransferServlet
 */
@WebServlet("/TransferServlet")
public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Transactions trsnObj = new Transactions();
		HttpSession session = request.getSession();
		Customers cust = new Customers();
		Accounts accBen = new Accounts();
		Accounts acc = new Accounts();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = new Date();
		
		
		cust = (Customers) session.getAttribute("currentUser");
		String custacc = request.getParameter("transferAcc");
		System.out.println(custacc);
		
		acc = getCustAcc(request, response);
		accBen= getBenAcc(request, response);
		try {
			
		trsnObj.setCustomeracc(acc);
		trsnObj.setCustomerid(acc);
		trsnObj.setTransactionsamt(Double.parseDouble(request.getParameter("transferAmt")));
		trsnObj.setBeneficiaryaccountno(accBen.getAccno());
		trsnObj.setDot(sim.parse(sim.format(d)));
			
		TransactionService trscObj = new TransactionService();
		boolean res = trscObj.transfer(trsnObj);
		PrintWriter out = response.getWriter();
		out.println(res);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public Accounts getCustAcc(HttpServletRequest request, HttpServletResponse response)
	{
		Accounts acc = new Accounts();
		String custacc = (String) request.getParameter("transferAcc");
		System.out.println("sadasda : "+custacc);
		int accno = Integer.parseInt(custacc.substring(3, 13));
		int balance = Integer.parseInt(custacc.substring(18));
		acc.setAccno(accno);
		acc.setBalance(balance);
		return acc;
	}
	public Accounts getBenAcc(HttpServletRequest request, HttpServletResponse response)
	{
		Accounts acc = new Accounts();
		
		acc.setAccno(Integer.parseInt(request.getParameter("BeneficiaryAccStyle")));
		return acc;
	}
}

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
import com.mindtree.entity.Customers;
import com.mindtree.entity.Transactions;
import com.mindtree.service.TransactionService;

/**
 * Servlet implementation class TransferProcessServlet
 */
@WebServlet("/TransferProcessServlet")
public class TransferProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
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
		String custacc = (String) request.getParameter("transferAcc");
		
		acc = getCustAcc(request, response);
		accBen= getBenAcc(request, response);
		try {
			
		trsnObj.setCustomeracc(acc);
		trsnObj.setCustomerid(acc);
		trsnObj.setTransactionsamt(Double.parseDouble(request.getParameter("transferAmt")));
		trsnObj.setBeneficiaryaccountno(accBen.getAccno());
		trsnObj.setDot(sim.parse(sim.format(d)));
			
		TransactionService trscObj = new TransactionService();
		boolean res = trscObj.transferProcess(trsnObj);
		if(res)
		{
			System.out.println("Transfer Successful.");
		}
		else
		{
			System.out.println("Something went wrong.");
		}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String custacc = (String) req.getParameter("transferAcc");
		System.out.println(custacc);
		doPost(req, resp);
	}
	public Accounts getCustAcc(HttpServletRequest request, HttpServletResponse response)
	{
		Accounts acc = new Accounts();
		String custacc = (String) request.getParameter("transferAcc");
		System.out.println("sadasda : "+custacc);
		int accno = Integer.parseInt(custacc.substring(3, 13));
		int balance = Integer.parseInt(custacc.substring(18));
		System.out.println("acc"+accno);
		System.out.println("balance"+balance);
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

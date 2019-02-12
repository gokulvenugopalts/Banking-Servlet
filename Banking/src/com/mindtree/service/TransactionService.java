package com.mindtree.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.mindtree.dao.jdbc.ConnectionInterface;
import com.mindtree.dao.jdbc.TransferInterface;
import com.mindtree.dao.jdbcimpl.ConnectionJdbcImpl;
import com.mindtree.dao.jdbcimpl.TransactionJdbcImpl;
import com.mindtree.entity.Transactions;

public class TransactionService {
	TransferInterface trObj;
	ConnectionInterface cus;
	public boolean transfer(Transactions trsnObj)
	{
		cus = new ConnectionJdbcImpl();
		try {
			Connection conn = cus.daoConnect();
			trObj = new TransactionJdbcImpl();
			if(trObj.transferCheck(trsnObj, conn))
			{
				cus.daoConnect();
				return true;
			}
			else
				cus.daoConnect();
				return false;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean transferProcess(Transactions trsnObj)
	{
		cus = new ConnectionJdbcImpl();
		try {
			Connection conn = cus.daoConnect();
			trObj = new TransactionJdbcImpl();
				trObj.tranferRegister(conn, trsnObj);
				cus.daoDisConnect(conn);
				return true;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	public String transferGet(String d)
	{
		cus = new ConnectionJdbcImpl();
		trObj = new TransactionJdbcImpl();
		ArrayList<Transactions> trArr = new ArrayList<Transactions>();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sim.format(d));
		try {
			System.out.println(sim.parse(sim.format(d)));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String res = "";
		try {
			Connection conn = cus.daoConnect();
			trArr = trObj.transferRegisterGet(conn, sim.parse(sim.format(d)));
			for(int i =0; i<trArr.size(); i++)
			{
				res+=trArr.get(i).getCustomeracc()+":"+trArr.get(i).getBeneficiaryaccountno()+":"+trArr.get(i).getTransactionsamt()+"-";
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
}

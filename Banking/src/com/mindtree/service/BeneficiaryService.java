package com.mindtree.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mindtree.dao.jdbc.BeneficiaryInterface;
import com.mindtree.dao.jdbc.ConnectionInterface;
import com.mindtree.dao.jdbcimpl.BeneficiaryJdbcImpl;
import com.mindtree.dao.jdbcimpl.ConnectionJdbcImpl;
import com.mindtree.entity.Customers;
import com.mindtree.entity.Accounts;
import com.mindtree.entity.Beneficiary;

public class BeneficiaryService {
	ConnectionInterface conObj ;
	public String getBeneficiary(Customers cust)
	{
		conObj = new ConnectionJdbcImpl();
		String resName="";
		try {
			Connection conn = conObj.daoConnect();
			BeneficiaryInterface ben = new BeneficiaryJdbcImpl();
			ArrayList<Beneficiary> benArr = new ArrayList<Beneficiary>();
			benArr = ben.getBeneficiary(conn, cust);
			
			if(!benArr.isEmpty())
			{
				for(int i=0;i<benArr.size();i++)
				{
					resName+=benArr.get(i).getBeneficiaryname()+"-";
				}
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resName;
		
	}
	public String getBeneficiaryAcc(Customers cust,Customers custben)
	{
		conObj = new ConnectionJdbcImpl();
		String res="";
		try {
			Connection conn = conObj.daoConnect();
			BeneficiaryInterface ben = new BeneficiaryJdbcImpl();
			ArrayList<Beneficiary> benArr = new ArrayList<Beneficiary>();
			benArr = ben.getBeneficiaryAcc(conn, cust,custben);
			if(!benArr.isEmpty())
			{
				for(int i=0;i<benArr.size();i++)
				{
					res+=benArr.get(i).getBeneficiaryacc()+"-";
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
}

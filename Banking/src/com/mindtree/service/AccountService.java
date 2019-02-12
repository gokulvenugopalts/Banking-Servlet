package com.mindtree.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mindtree.dao.jdbc.AccountInterface;
import com.mindtree.dao.jdbc.ConnectionInterface;
import com.mindtree.dao.jdbcimpl.AccountJdbcImpl;
import com.mindtree.dao.jdbcimpl.ConnectionJdbcImpl;
import com.mindtree.dao.jdbcimpl.CustomerJdbcImpl;
import com.mindtree.entity.Accounts;
import com.mindtree.entity.Customers;

public class AccountService {
	public String accountget(Customers cust)
	{
		ConnectionInterface conObj = new ConnectionJdbcImpl();
		String res = "";
		try {
			Connection conn = conObj.daoConnect();
			AccountInterface accOb = new AccountJdbcImpl();
			ArrayList<Accounts> accArr = new ArrayList<Accounts>();
			accArr = accOb.accountGet(conn, cust);
			for(int i=0;i<accArr.size();i++)
			{
				res+=accArr.get(i).getAccno()+":"+accArr.get(i).getBalance()+"-";
			}
			return res;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
}

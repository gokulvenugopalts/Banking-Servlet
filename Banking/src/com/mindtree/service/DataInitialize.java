package com.mindtree.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.mindtree.dao.jdbc.AccountInterface;
import com.mindtree.dao.jdbc.BeneficiaryInterface;
import com.mindtree.dao.jdbc.ConnectionInterface;
import com.mindtree.dao.jdbc.CustomerInterface;
import com.mindtree.dao.jdbc.DbCheckInterface;
import com.mindtree.dao.jdbcimpl.AccountJdbcImpl;
import com.mindtree.dao.jdbcimpl.BeneficiaryJdbcImpl;
import com.mindtree.dao.jdbcimpl.ConnectionJdbcImpl;
import com.mindtree.dao.jdbcimpl.CustomerJdbcImpl;
import com.mindtree.dao.jdbcimpl.DbCheckJdbcImpl;

public class DataInitialize {
	public void dataSet()
	{
		ConnectionInterface conObj = new ConnectionJdbcImpl();
		try {
			Connection conn = conObj.daoConnect();
			DbCheckInterface dbchk = new DbCheckJdbcImpl();
			if (!dbchk.dbCheck(conn)) {
				CustomerInterface cusObj = new CustomerJdbcImpl();
				cusObj.customerEnter(conn);
				AccountInterface accObj = new AccountJdbcImpl();
				accObj.accountEnter(conn);
				BeneficiaryInterface benObj = new BeneficiaryJdbcImpl();
				benObj.beneficiaryEnter(conn);
			}
			conObj.daoDisConnect(conn);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

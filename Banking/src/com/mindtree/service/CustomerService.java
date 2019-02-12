package com.mindtree.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.mindtree.dao.jdbc.ConnectionInterface;
import com.mindtree.dao.jdbc.CustomerInterface;
import com.mindtree.dao.jdbcimpl.ConnectionJdbcImpl;
import com.mindtree.dao.jdbcimpl.CustomerJdbcImpl;
import com.mindtree.entity.Customers;


public class CustomerService {
	public Customers customerValidate(Customers cust)
	{
		ConnectionInterface conObj = new ConnectionJdbcImpl();
		CustomerInterface cusObj = new CustomerJdbcImpl();
		try {
			Connection conn = conObj.daoConnect();
			cust = cusObj.customerValidate(conn, cust);
			if(cust !=null)
			{
				return cust;
			}
			else
				return null;
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

package com.mindtree.dao.jdbcimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mindtree.dao.jdbc.AccountInterface;
import com.mindtree.entity.Accounts;
import com.mindtree.entity.Customers;

public class AccountJdbcImpl implements AccountInterface{
	public ArrayList<Accounts> accountGet(Connection conn, Customers cust) throws SQLException
	{
		PreparedStatement pr = conn.prepareStatement("select * from accounts where customerid=?");
		pr.setInt(1, cust.getCustomerid());
		ResultSet rs = pr.executeQuery();
		ArrayList<Accounts> arrCus = new ArrayList<Accounts>();
		while(rs.next())
		{
			Accounts acc = new Accounts();
			acc.setAccno(rs.getInt(1));
			acc.setBalance(rs.getDouble(2));
			Customers c = new Customers();
			c.setCustomerid(rs.getInt(3));
			acc.setCustomerid(c);
			arrCus.add(acc);
		}
		return arrCus;
		
	}
	public void accountEnter(Connection conn) throws SQLException
	{
		CallableStatement cs = conn.prepareCall("{call accountsprocedure(?,?,?)}");
		
		cs.setInt(1, 876543210);
		cs.setDouble(2, 25000);
		cs.setInt(3, 1);
		cs.addBatch();
		cs.setInt(1, 123456780);
		cs.setDouble(2, 10000);
		cs.setInt(3, 1);
		cs.addBatch();
		cs.setInt(1, 543216780);
		cs.setDouble(2, 2500);
		cs.setInt(3, 1);
		cs.addBatch();
		

		cs.setInt(1, 876543211);
		cs.setDouble(2, 25000);
		cs.setInt(3, 2);
		cs.addBatch();
		cs.setInt(1, 123456781);
		cs.setDouble(2, 35000);
		cs.setInt(3, 2);
		cs.addBatch();
		cs.setInt(1, 543216781);
		cs.setDouble(2, 25000);
		cs.setInt(3, 2);
		cs.addBatch();
		
		
		cs.setInt(1, 876543212);
		cs.setDouble(2, 5000);
		cs.setInt(3, 3);
		cs.addBatch();
		cs.setInt(1, 123456782);
		cs.setDouble(2, 15000);
		cs.setInt(3, 3);
		cs.addBatch();
		cs.setInt(1, 543216782);
		cs.setDouble(2, 10000);
		cs.setInt(3, 3);
		cs.addBatch();
		
		
		cs.setInt(1, 876543213);
		cs.setDouble(2, 40000);
		cs.setInt(3, 4);
		cs.addBatch();
		cs.setInt(1, 123456783);
		cs.setDouble(2, 25000);
		cs.setInt(3, 4);
		cs.addBatch();
		cs.setInt(1, 543216783);
		cs.setDouble(2, 2000);
		cs.setInt(3, 4);
		cs.addBatch();
		
		
		cs.setInt(1, 876543214);
		cs.setDouble(2, 1000);
		cs.setInt(3, 5);
		cs.addBatch();
		cs.setInt(1, 123456784);
		cs.setDouble(2, 5000);
		cs.setInt(3, 5);
		cs.addBatch();
		cs.setInt(1, 543216784);
		cs.setDouble(2, 25000);
		cs.setInt(3, 5);
		cs.addBatch();
		
		cs.executeBatch();
	}
}

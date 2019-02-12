package com.mindtree.dao.jdbcimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mindtree.dao.jdbc.CustomerInterface;
import com.mindtree.entity.Customers;
import com.mysql.jdbc.PreparedStatement;

public class CustomerJdbcImpl implements CustomerInterface{
	public Customers customerValidate(Connection conn, Customers cust) throws SQLException
	{
		PreparedStatement pr = (PreparedStatement) conn.prepareStatement("select * from customers where username= ? and password=?");
		pr.setString(1, cust.getUsername());
		pr.setString(2, cust.getPassword());
		ResultSet rs = pr.executeQuery();
		if(rs.next())
		{
			cust.setCustomerid(rs.getInt(1));
			cust.setFirstname(rs.getString(2));
			cust.setLastname(rs.getString(3));
			return cust;
		}
		else
		{
			return null;
		}
		
	}
	public void customerEnter(Connection conn) throws SQLException
	{
		CallableStatement cs = conn.prepareCall("{call customersprocedure(?,?,?,?,?)}");
		
		cs.setInt(1, 1);
		cs.setString(2,"ahad");
		cs.setString(3,"abdul");
		cs.setString(4,"ahad");
		cs.setString(5,"123456");
		cs.addBatch();
		
		
		cs.setInt(1, 2);
		cs.setString(2,"cherian");
		cs.setString(3,"roy");
		cs.setString(4,"cherian");
		cs.setString(5,"123456");
		cs.addBatch();
		
		
		cs.setInt(1, 3);
		cs.setString(2,"koshi");
		cs.setString(3,"sihvaram");
		cs.setString(4,"koshi");
		cs.setString(5,"123456");
		cs.addBatch();

		
		cs.setInt(1, 4);
		cs.setString(2,"bhadusha");
		cs.setString(3,"bhadu");
		cs.setString(4,"bhadusha");
		cs.setString(5,"123456");
		cs.addBatch();
		
		
		cs.setInt(1, 5);
		cs.setString(2,"rahul");
		cs.setString(3,"chandran");
		cs.setString(4,"rahul");
		cs.setString(5,"123456");
		cs.addBatch();
		
		
		int[] count = cs.executeBatch();
	}
}

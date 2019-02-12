package com.mindtree.dao.jdbcimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mindtree.dao.jdbc.BeneficiaryInterface;
import com.mindtree.entity.Accounts;
import com.mindtree.entity.Beneficiary;
import com.mindtree.entity.Customers;

public class BeneficiaryJdbcImpl implements BeneficiaryInterface{
	public ArrayList<Beneficiary> getBeneficiary(Connection conn, Customers cust) throws SQLException
	{
		PreparedStatement pr = conn.prepareStatement("select * from beneficiaries where customerid = '"+cust.getCustomerid()+"'");
		ResultSet rs = pr.executeQuery();
		ArrayList<Beneficiary> benArr = new ArrayList<Beneficiary>();
		while(rs.next())
		{
			Beneficiary ben = new Beneficiary();
			ben.setBeneficiaryname(rs.getString(2));
			System.out.println(ben.getBeneficiaryname());
			Accounts acc = new Accounts();
			acc.setAccno(rs.getInt(3));
			ben.setBeneficiaryacc(acc);
			Customers cus = new Customers();
			cus.setCustomerid(rs.getInt(4));
			ben.setCustomerId(cus);
			benArr.add(ben);
		}
		return benArr;
	}
	public ArrayList<Beneficiary> getBeneficiaryAcc(Connection conn, Customers cust,Customers custben) throws SQLException
	{
		PreparedStatement pr = conn.prepareStatement("select * from beneficiaries where beneficiaryname='"+custben.getUsername()+"' and "
				+ "customerid = '"+cust.getCustomerid()+"'");
		ResultSet rs = pr.executeQuery();
		ArrayList<Beneficiary> benArr = new ArrayList<Beneficiary>();
		while(rs.next())
		{
			Beneficiary ben = new Beneficiary();
			ben.setBeneficiaryname(rs.getString(2));
			
			Accounts acc = new Accounts();
			acc.setAccno(rs.getInt(3));
			ben.setBeneficiaryacc(acc);
			Customers cus = new Customers();
			cus.setCustomerid(rs.getInt(4));
			ben.setCustomerId(cus);
			benArr.add(ben);
		}
		return benArr;
	}
	public void beneficiaryEnter(Connection conn) throws SQLException
	{
		
		CallableStatement cs = conn.prepareCall("{call beneficiaryprocedure(?,?,?)}");
		
		cs.setString(1,"cherian");
		cs.setInt(2, 123456781);
		cs.setInt(3, 1);
		cs.addBatch();
		cs.setString(1,"bhadusha");
		cs.setInt(2, 876543213);
		cs.setInt(3, 1);
		cs.addBatch();
		cs.setString(1,"rahul");
		cs.setInt(2, 123456784);
		cs.setInt(3, 1);
		cs.addBatch();
		
		cs.setString(1,"koshi");
		cs.setInt(2, 123456782);
		cs.setInt(3, 2);
		cs.addBatch();
		cs.setString(1,"koshi");
		cs.setInt(2, 876543212);
		cs.setInt(3, 2);
		cs.addBatch();
		cs.setString(1,"ahad");
		cs.setInt(2, 123456780);
		cs.setInt(3, 2);
		cs.addBatch();
		
		cs.setString(2,"rahul");
		cs.setInt(2, 543216784);
		cs.setInt(3, 3);
		cs.addBatch();
		cs.setString(2,"ahad");
		cs.setInt(2, 123456780);
		cs.setInt(3, 3);
		cs.addBatch();
		
		cs.setString(1,"cherian");
		cs.setInt(2, 876543211);
		cs.setInt(3, 4);
		cs.addBatch();
		
		cs.setString(1,"cherian");
		cs.setInt(2, 123456781);
		cs.setInt(3, 5);
		cs.addBatch();
		cs.setString(1,"bhadusha");
		cs.setInt(2, 876543213);
		cs.setInt(3, 5);
		cs.addBatch();
		cs.setString(2,"ahad");
		cs.setInt(2, 123456780);
		cs.setInt(3, 5);
		cs.addBatch();
		cs.setString(1,"koshi");
		cs.setInt(2, 876543212);
		cs.setInt(3, 5);
		cs.addBatch();
		
		int[] count = cs.executeBatch();
	}
}

package com.mindtree.dao.jdbcimpl;

import java.util.ArrayList;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.mindtree.dao.jdbc.TransferInterface;
import com.mindtree.entity.Accounts;
import com.mindtree.entity.Beneficiary;
import com.mindtree.entity.Transactions;



public class TransactionJdbcImpl implements TransferInterface{
	public boolean transferCheck(Transactions trsn, Connection conn) throws SQLException
	{
		PreparedStatement pr = conn.prepareStatement("select * from accounts where accountno = '?'");
		pr.setInt(1, trsn.getCustomeracc());
		ResultSet rs = pr.executeQuery();
		while(rs.next())
		{
			if(rs.getDouble(2)>=trsn.getTransactionsamt())
			{
				return true;
			}
		}
		return false;
	}
	public void tranferRegister(Connection conn, Transactions trsn) throws SQLException, ParseException
	{
		PreparedStatement pr = conn.prepareStatement("insert into transactions (customeracc,beneficiaryaccountno,dot,transactionsamt)"
				+ "values(?,?,?,?)");
		SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		pr.setInt(1, trsn.getCustomeracc());
		pr.setInt(2, trsn.getBeneficiaryaccountno());
		pr.setTimestamp(3, (Timestamp) simp.parse(simp.format(trsn.getDot())));
		pr.setDouble(4, trsn.getTransactionsamt());
		pr.executeUpdate();
		
		PreparedStatement pr2 = conn.prepareStatement("update accounts set balance = ((select balance from accounts where accountno = ?) - ?) where accountno = ?");
		pr2.setInt(1, trsn.getCustomeracc());
		pr2.setDouble(2, trsn.getTransactionsamt());
		pr2.setInt(3, trsn.getCustomeracc());
		pr2.executeUpdate();
		
		PreparedStatement pr3 = conn.prepareStatement("update accounts set balance = ((select balance from accounts where accountno = ?) + ?) where accountno = ?");
		pr3.setInt(1, trsn.getBeneficiaryaccountno());
		pr3.setDouble(2, trsn.getTransactionsamt());
		pr3.setInt(3, trsn.getBeneficiaryaccountno());
		pr3.executeUpdate();
	}
	public ArrayList<Transactions> transferRegisterGet(Connection conn, Date d) throws SQLException, ParseException
	{
		PreparedStatement pr = conn.prepareStatement("select * from transactions where Date(dot)='?'");
		SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd");
		pr.setDate(1,(java.sql.Date) simp.parse(simp.format(d)));
		ResultSet rs = pr.executeQuery();
		ArrayList<Transactions> trArr = new ArrayList<Transactions>();
		while(rs.next())
		{
			Transactions trObj = new Transactions();
			Accounts acc = new Accounts();
			Accounts accBen = new Accounts();
			Beneficiary benObj = new Beneficiary();
			
			acc.setAccno(rs.getInt(2));
			accBen.setAccno(rs.getInt(3));
			benObj.setBeneficiaryacc(accBen);
			trObj.setDot(simp.parse(simp.format(rs.getDate(3))));
			trObj.setTransactionsamt(rs.getDouble(4));
			
			trArr.add(trObj);
		}
		return trArr;
	}
}

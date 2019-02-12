package com.mindtree.dao.jdbcimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mindtree.dao.jdbc.DbCheckInterface;

public class DbCheckJdbcImpl implements DbCheckInterface{
	public boolean dbCheck(Connection conn) throws SQLException
	{
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from customers");
		if(rs.next())
		{
			rs = st.executeQuery("select * from accounts");
			if(rs.next())
			{
				rs = st.executeQuery("select * from beneficiaries");
				if(rs.next())
				{
					return true;
				}
				else
					return false;
			}
			else
				return false;
		}
		else
			return false;
		
	}
}

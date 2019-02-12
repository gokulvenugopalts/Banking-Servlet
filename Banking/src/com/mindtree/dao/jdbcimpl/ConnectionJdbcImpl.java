package com.mindtree.dao.jdbcimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mindtree.dao.jdbc.ConnectionInterface;

public class ConnectionJdbcImpl implements ConnectionInterface{
	String db_url = "jdbc:mysql://localhost/bankingapp";
	public Connection daoConnect() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(db_url,"root", "Welcome123");
		return conn;
	}
	public void daoDisConnect(Connection conn) throws SQLException
	{
		conn.close();
	}
}

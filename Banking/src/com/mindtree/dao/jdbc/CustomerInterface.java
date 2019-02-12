package com.mindtree.dao.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import com.mindtree.entity.Customers;

public interface CustomerInterface {
	public void customerEnter(Connection conn) throws SQLException;
	public Customers customerValidate(Connection conn, Customers cust) throws SQLException;
}

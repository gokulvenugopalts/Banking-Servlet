package com.mindtree.dao.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mindtree.entity.Accounts;
import com.mindtree.entity.Customers;

public interface AccountInterface {
	public void accountEnter(Connection conn) throws SQLException;
	public ArrayList<Accounts> accountGet(Connection conn, Customers cust) throws SQLException;
}

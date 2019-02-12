package com.mindtree.dao.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionInterface {
	public Connection daoConnect() throws ClassNotFoundException, SQLException;
	public void daoDisConnect(Connection conn) throws SQLException;
}

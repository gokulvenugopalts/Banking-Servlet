package com.mindtree.dao.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public interface DbCheckInterface {
	public boolean dbCheck(Connection conn) throws SQLException;
}

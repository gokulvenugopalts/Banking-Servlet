package com.mindtree.dao.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import com.mindtree.entity.Transactions;


public interface TransferInterface {
	public boolean transferCheck(Transactions trsn, Connection conn) throws SQLException;
	public void tranferRegister(Connection conn, Transactions trsn) throws SQLException, ParseException;
	public ArrayList<Transactions> transferRegisterGet(Connection conn, Date d) throws SQLException, ParseException;
}

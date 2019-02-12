package com.mindtree.dao.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mindtree.entity.Beneficiary;
import com.mindtree.entity.Customers;

public interface BeneficiaryInterface {
	public void beneficiaryEnter(Connection conn) throws SQLException;
	public ArrayList<Beneficiary> getBeneficiary(Connection conn, Customers cust) throws SQLException;
	public ArrayList<Beneficiary> getBeneficiaryAcc(Connection conn, Customers cust,Customers custben) throws SQLException;
}

package com.mindtree.entity;

import java.util.Date;

public class Transactions {
	private int transactionsid;
	private int customerid;
	private int customeracc;
	private int beneficiaryaccountno;
	private Date dot;
	private double transactionsamt;
	public int getTransactionsid() {
		return transactionsid;
	}
	public void setTransactionsid(int transactionsid) {
		this.transactionsid = transactionsid;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(Accounts acc) {
		this.customerid = acc.getCustomerid();
	}
	public Date getDot() {
		return dot;
	}
	public void setDot(Date dot) {
		this.dot = dot;
	}
	public double getTransactionsamt() {
		return transactionsamt;
	}
	public void setTransactionsamt(double transactionsamt) {
		this.transactionsamt = transactionsamt;
	}
	public int getCustomeracc() {
		return customeracc;
	}
	public void setCustomeracc(Accounts acc) {
		this.customeracc = acc.getAccno();
	}
	public int getBeneficiaryaccountno() {
		return beneficiaryaccountno;
	}
	public void setBeneficiaryaccountno(int beneficiaryaccountno) {
		this.beneficiaryaccountno = beneficiaryaccountno;
	}
	
	
}

package com.mindtree.entity;

public class Accounts {
	private int accno;
	private double balance;
	private int customerid;
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(Customers cust) {
		this.customerid = cust.getCustomerid();
	}
}

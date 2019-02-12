package com.mindtree.entity;

public class Beneficiary {
	private int beneficiaryid;
	private String beneficiaryname;
	private int beneficiaryacc;
	private int customerId;
	public int getBeneficiaryid() {
		return beneficiaryid;
	}
	public void setBeneficiaryid(int beneficiaryid) {
		this.beneficiaryid = beneficiaryid;
	}
	public String getBeneficiaryname() {
		return beneficiaryname;
	}
	public void setBeneficiaryname(String beneficiaryname) {
		this.beneficiaryname = beneficiaryname;
	}
	public int getBeneficiaryacc() {
		return beneficiaryacc;
	}
	public void setBeneficiaryacc(Accounts acc) {
		this.beneficiaryacc = acc.getAccno();
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Customers cus) {
		this.customerId = cus.getCustomerid();
	}
}

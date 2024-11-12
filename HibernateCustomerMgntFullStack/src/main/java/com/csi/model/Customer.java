package com.csi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue
	@Column(name = "cust_id")
	private int custId;
	
	@Column(name = "cust_name")
	private String custName;
	
	@Column(name = "cust_address")
	private String custAddress;
	
	@Column(name = "cust_contact_number")
	private long custContactNumber;
	
	@Column(name = "cust_account_balance")
	private double custAccountBalance;
	
	@Column(name = "cust_gender")
	private String custGender;
	
	@Column(name="cust_dob")
	private Date custDOB;
	
	@Column(name = "cust_emailid")
	private String custEmailId;
	
	@Column(name = "cust_password")
	private String custPassword;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String custName, String custAddress, long custContactNumber, double custAccountBalance,
			String custGender, Date custDOB, String custEmailId, String custPassword) {
		super();
		this.custName = custName;
		this.custAddress = custAddress;
		this.custContactNumber = custContactNumber;
		this.custAccountBalance = custAccountBalance;
		this.custGender = custGender;
		this.custDOB = custDOB;
		this.custEmailId = custEmailId;
		this.custPassword = custPassword;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public long getCustContactNumber() {
		return custContactNumber;
	}

	public void setCustContactNumber(long custContactNumber) {
		this.custContactNumber = custContactNumber;
	}

	public double getCustAccountBalance() {
		return custAccountBalance;
	}

	public void setCustAccountBalance(double custAccountBalance) {
		this.custAccountBalance = custAccountBalance;
	}

	public String getCustGender() {
		return custGender;
	}

	public void setCustGender(String custGender) {
		this.custGender = custGender;
	}

	public Date getCustDOB() {
		return custDOB;
	}

	public void setCustDOB(Date custDOB) {
		this.custDOB = custDOB;
	}

	public String getCustEmailId() {
		return custEmailId;
	}

	public void setCustEmailId(String custEmailId) {
		this.custEmailId = custEmailId;
	}

	public String getCustPassword() {
		return custPassword;
	}

	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custAddress=" + custAddress
				+ ", custContactNumber=" + custContactNumber + ", custAccountBalance=" + custAccountBalance
				+ ", custGender=" + custGender + ", custDOB=" + custDOB + ", custEmailId=" + custEmailId
				+ ", custPassword=" + custPassword + "]";
	}
	
	
}

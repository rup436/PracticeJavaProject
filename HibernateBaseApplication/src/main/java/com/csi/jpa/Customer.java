package com.csi.jpa;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ibm.icu.text.SimpleDateFormat;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue
	private int custId;
	
	private String custName;
	
	private String custAddress;
	
	@Temporal(TemporalType.DATE)
	private Date custDOB;
	
	private long custContactNumber;

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

	public Date getCustDOB() {
		return custDOB;
	}

	public void setCustDOB(Date custDOB) {
		this.custDOB = custDOB;
	}

	public long getCustContactNumber() {
		return custContactNumber;
	}

	public void setCustContactNumber(long custContactNumber) {
		this.custContactNumber = custContactNumber;
	}

	@Override
	public String toString() {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
		
		String dobDate= simpleDateFormat.format(custDOB);
				
		return "Customer [custId=" + custId + ", custName=" + custName + ", custAddress=" + custAddress + ", custDOB="
				+ dobDate + ", custContactNumber=" + custContactNumber + "]";
	} 
	
	
}

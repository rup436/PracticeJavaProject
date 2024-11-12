package com.csi.jpa;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private int empId;
	
	private String empName;
	private String empAddress;
	private long empContactNumber;
	
	@Temporal(TemporalType.DATE)
	private Date empDob;
	private String empRole;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public long getEmpContactNumber() {
		return empContactNumber;
	}
	public void setEmpContactNumber(long empContactNumber) {
		this.empContactNumber = empContactNumber;
	}
	public Date getEmpDob() {
		return empDob;
	}
	public void setEmpDob(Date empDob) {
		this.empDob = empDob;
	}
	public String getEmpRole() {
		return empRole;
	}
	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}
	@Override
	public String toString() {
		
		SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
		String dob= date.format(empDob);
		
		return "Employee [empId=" + empId + ", empName=" + empName + ", empAddress=" + empAddress
				+ ", empContactNumber=" + empContactNumber + ", empDob=" +dob + ", empRole=" + empRole + "]";
		
	}
	
	

	

}

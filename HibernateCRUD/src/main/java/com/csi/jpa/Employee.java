package com.csi.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ibm.icu.text.SimpleDateFormat;

@Entity
@Table(name = "emp_details")
public class Employee {
	@Id
	@GeneratedValue
	@Column(name = "emp_id")
	private int empId;
	
	@Column(name = "emp_name")
	private String empName;
	
	@Column(name = "emp_address")
	private String empAddress;
	
	@Column(name = "emp_contact_number")
	private long empContactNumber;
	
	@Column(name = "emp_salary")
	private double empSalary;
	
	@Column(name = "emp_dob")
	@Temporal(TemporalType.DATE)
	private Date empDOB;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String empName, String empAddress, long empContactNumber, double empSalary, Date empDOB) {
		super();
		this.empName = empName;
		this.empAddress = empAddress;
		this.empContactNumber = empContactNumber;
		this.empSalary = empSalary;
		this.empDOB = empDOB;
	}

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

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	public Date getEmpDOB() {
		return empDOB;
	}

	public void setEmpDOB(Date empDOB) {
		this.empDOB = empDOB;
	}

	@Override
	public String toString() {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		String dobDate= simpleDateFormat.format(empDOB);
		return "Employee [empId=" + empId + ", empName=" + empName + ", empAddress=" + empAddress
				+ ", empContactNumber=" + empContactNumber + ", empSalary=" + empSalary + ", empDOB=" + dobDate + "]";
	}
	
	
	
}

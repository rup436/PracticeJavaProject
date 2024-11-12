package com.csi.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private int empId;

	private String empName;

	private long empSalary;

	private Address address;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String empName, long empSalary, Address address) {
		super();
		this.empName = empName;
		this.empSalary = empSalary;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + ", address=" + address
				+ "]";
	}

}

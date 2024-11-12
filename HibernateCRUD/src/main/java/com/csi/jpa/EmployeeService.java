package com.csi.jpa;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.ibm.icu.text.SimpleDateFormat;

public class EmployeeService {

	private static SessionFactory factory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory(); 
	
	public static void main(String[] args) {
		
		EmployeeService employeeservice = new EmployeeService();
		//employeeservice.updateData(1);
		//employeeservice.saveData();
		employeeservice.getAllData();
		employeeservice.deleteData(2);
	}
	
	
	void saveData()//create
	{
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Date dobDate = null;
		
		SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			dobDate = date.parse("11-10-1909");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Employee employee = new Employee("vikrant", "pcmc", 878327, 889212, dobDate);
	
		session.save(employee);
		
		transaction.commit();	
	}
	
	void getAllData()//read
	{
		Session session = factory.openSession();
		
		session.createQuery("from Employee").list().forEach(System.out::println);
	}
	
	void updateData(int empId)//update
	{
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Date dobDate = null;
		
		SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			dobDate = date.parse("12-10-1999");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Employee employee= (Employee)session.get(Employee.class, empId);
		employee.setEmpName("swara jadhav");
		employee.setEmpAddress("india");
		employee.setEmpContactNumber(999999);
		employee.setEmpSalary(459999);
		employee.setEmpDOB(dobDate);
		
		session.update(employee);
		
		transaction.commit();	
	}
	
	void deleteData(int empId)//delete
	{
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Employee employee = (Employee) session.get(Employee.class, empId);
		
		session.delete(employee);
		transaction.commit();
		
	}
}

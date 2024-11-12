package com.csi.jpa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class CustomerService {
	
	private static SessionFactory factory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	public static void main(String[] args) {
		saveData();
		showData();
	}
	
	static void saveData()
	{
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Customer customer = new Customer();
		Date dobDate=null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			dobDate= simpleDateFormat.parse("10-11-1998");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		customer.setCustName("vikrant");
		customer.setCustAddress("nashik");
		customer.setCustDOB(dobDate);
		customer.setCustContactNumber(1132312122);
		
		session.save(customer);
		transaction.commit();
	}
	
	
	static void showData()
	{
		Session session = factory.openSession();
		
		List<Customer> customers= session.createQuery("from Customer").list();
		
		customers.forEach(System.out::println);
		
	}
}

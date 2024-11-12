package com.csi.jpa;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Service {
	
	private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
	
	public static void main(String[] args) {
		saveData();
		getAllData();
	}
	
	static void saveData()
	{
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Address address = new Address("MH", "Pune", 411412);
		
		Employee employee = new Employee("Dinesh", 123212, address);
		
		session.save(employee);
		
		transaction.commit();
		
	}
	
	
	static void getAllData()
	{
		Session session = factory.openSession();
		
		List<Employee> employees = session.createQuery("from Employee").list();
		
		employees.forEach(System.out::println);
	}
	
	
	
}

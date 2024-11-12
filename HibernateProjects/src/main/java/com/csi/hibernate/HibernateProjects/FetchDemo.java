package com.csi.hibernate.HibernateProjects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	public static void main(String[] args) {
		//get, load
		
		  Configuration cfg = new Configuration();
	        
	        cfg.configure();
	       
	       SessionFactory factory = cfg.buildSessionFactory();
	   Session session = factory.openSession();
	   //get-student:106
		/*
		 * Student student=(Student)session.get(Student.class, 101);
		 * System.out.println(student);
		 * 
		 * Address ad = session.get(Address.class, 1);
		 * System.out.println(ad.getStreet()+":"+ad.getCity()+":"+ad.getImage());
		 */
	  Student student1 =session.load(Student.class, 101);
	  System.out.println(student1.getName());
	  session.close();
	  factory.close();
	}
}

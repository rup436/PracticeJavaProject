package com.csi.hibernate.HibernateProjects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
public static void main(String[] args) {
	Configuration cfg = new Configuration();
	cfg.configure();
	SessionFactory factory = cfg.buildSessionFactory();
	Student student = new Student();
	
	student.setId(11);
	student.setName("mahesh chaudhari");
	student.setCity("malavali");
	
	Certificate  certificate = new Certificate();
	
	certificate.setCourse("Android");
	certificate.setDuration("2 months");
	student.setCerti(certificate);
	
	Student student1 = new Student();
	
	student1.setId(11);
	student1.setName("mahesh dhari");
	student1.setCity("sanechauk");
	
	Certificate  certificate1 = new Certificate();
	
	certificate1.setCourse("hibernate");
	certificate1.setDuration("2.5 months");
	student1.setCerti(certificate);
	
	Session s = factory.openSession();
	Transaction tx = s.beginTransaction();
	
	s.save(student);
	s.save(student1);
	
	
	
	tx.commit();
	s.close();
	factory.close();
	
	
}
}

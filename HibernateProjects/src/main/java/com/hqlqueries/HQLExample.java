package com.hqlqueries;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.csi.hibernate.HibernateProjects.Student;

public class HQLExample {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session s = factory.openSession();
		
		String query= "from Question";
		
		Query q= s.createQuery(query);
		
		List<Student>list=q.list();
		
		for(Student student:list)
		{
			System.out.println(student.getName());
		}
		factory.close();
		s.close();
		
	}
}

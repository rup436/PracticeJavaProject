package com.csi.jpa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Services {

	private static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	public static void main(String[] args) {
		saveData();
		showData();
	}

	static void saveData() {
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		Employee employee = new Employee();

		employee.setEmpName("Bhavana Mali");
		employee.setEmpAddress("khandala");
		employee.setEmpContactNumber(891236856);

		Date dobDate = null;

		SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");

		try {
			dobDate = date.parse("10-11-1999");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		employee.setEmpDob(dobDate);
		employee.setEmpRole("housekeeping");

		session.save(employee);
		tx.commit();
	}

	static void showData() {
		Session session = factory.openSession();

		List<Employee> list = session.createQuery("from Employee").list();

		for (Employee employee : list) {
			System.out.println(employee.getEmpName() + " : " + employee.getEmpAddress() + " : "
					+ employee.getEmpContactNumber() + " : " + employee.getEmpDob());
		}

	}
}

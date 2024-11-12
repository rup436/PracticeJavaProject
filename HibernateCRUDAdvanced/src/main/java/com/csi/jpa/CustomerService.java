package com.csi.jpa;

import java.util.Comparator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class CustomerService {

	SessionFactory factory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();

	public static void main(String[] args) {

		CustomerService customerService = new CustomerService();
		// customerService.signUp();
		// customerService.getAllData();
		// customerService.singIn("SWARA@CS.COM", "SWARA@2022");
		// customerService.getDataById(1);
		// customerService.updateData(2);
		// customerService.deleteDataById(3);
		// customerService.sortByName();
		// customerService.sortByAccountBalance();
		// customerService.filterDataByAccountBalance(50000);
		customerService.deleteAllData();
	}

	void signUp() {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Customer customer = new Customer("AKSHAY", "PUNE", 45564657, 50000., "AKSHAY@CS.COM", "AKSHAY@2022");
		session.save(customer);
		transaction.commit();

	}

	void singIn(String custEmailId, String custPassword) {
		boolean flag = false;

		Session session = factory.openSession();

		List<Customer> customers = session.createQuery("from Customer").list();

		for (Customer customer : customers) {
			if (customer.getCustEmailId().equals(custEmailId) && customer.getCustpassword().equals(custPassword)) {

				flag = true;
			}
		}

		if (flag) {
			System.out.println("signIn succesfully");
		} else {
			System.out.println("Invalid credentials please try again!!!!!!");
		}
	}

	void getDataById(int custId) {

		/*
		 * Session session = factory.openSession(); Customer customer = (Customer)
		 * session.get(Customer.class, custId); System.out.println(customer);
		 */

		Session session = factory.openSession();
		List<Customer> customers = session.createQuery("from Customer").list();

		customers.stream().filter(cust -> cust.getCustId() == custId).forEach(System.out::println);

	}

	void getAllData() {
		Session session = factory.openSession();

		List<Customer> customers = session.createQuery("from Customer").list();

		customers.forEach(System.out::println);
	}

	void updateData(int custId) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Customer customers = (Customer) session.get(Customer.class, custId);
		customers.setCustName("Ram");
		customers.setCustAccountBalance(98000.11);

		customers.setCustpassword("Ram@2022");
		customers.setCustEmailId("Ram@cs.com");
		session.update(customers);
		transaction.commit();

	}

	void deleteDataById(int custId) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Customer customers = (Customer) session.get(Customer.class, custId);

		session.delete(customers);
		transaction.commit();
	}

	void sortByName() {
		Session session = factory.openSession();
		List<Customer> customers = session.createQuery("from Customer").list();

		customers.stream().sorted((c1, c2) -> c2.getCustName().compareTo(c1.getCustName()))
				.forEach(System.out::println);
	}

	void sortByAccountBalance() {
		Session session = factory.openSession();
		List<Customer> customers = session.createQuery("from Customer").list();

		customers.stream().sorted(Comparator.comparingDouble(Customer::getCustAccountBalance))
				.forEach(System.out::println);
	}

	void filterDataByAccountBalance(double accountBalance) {
		Session session = factory.openSession();
		List<Customer> customers = session.createQuery("from Customer").list();

		customers.stream().filter(cust -> cust.getCustAccountBalance() >= accountBalance).forEach(System.out::println);
	}

	void deleteAllData() {
		Session session = factory.openSession();
		List<Customer> customers = session.createQuery("from Customer").list();

		for (Customer customer : customers) {

			Transaction transaction = session.beginTransaction();
			session.delete(customer);
			transaction.commit();
		}

	}
}

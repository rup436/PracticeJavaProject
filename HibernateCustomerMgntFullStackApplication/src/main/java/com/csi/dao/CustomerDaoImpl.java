package com.csi.dao;

import java.util.Comparator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.csi.model.Customer;

public class CustomerDaoImpl implements CustomerDao{

	private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
	
	@Override
	public void signUp(Customer customer) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		
		Transaction transcation = session.beginTransaction();
		
		session.save(customer);
		transcation.commit();
	}

	@Override
	public boolean signIn(String custEmailId, String custPassword) {
		
		boolean flag = false;
		
		for(Customer customers : getAllData())
		{
			if(customers.getCustEmailId().equals(custEmailId)&&customers.getCustPassword().equals(custPassword));
			
			flag = true;
			
		}
		
		return flag;
	}

	@Override
	public Customer getDataById(int custId) {
	
		Session session = factory.openSession();
		
		Customer customer = (Customer)session.get(Customer.class, custId);
		
		
		return customer;
	}

	@Override
	public List<Customer> getAllData() {
		// TODO Auto-generated method stub
		
		Session session = factory.openSession();
		
		return session.createQuery("from createQuery").list();
	}

	@Override
	public void updateData(int custId, Customer customer) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Customer customer2 = getDataById(custId);
		
		customer2.setCustName(customer2.getCustName());
		customer2.setCustAddress(customer2.getCustAddress());
		customer2.setCustContactNumber(customer2.getCustContactNumber());
		customer2.setCustAccountBalance(customer2.getCustAccountBalance());
		customer2.setCustGender(customer2.getCustGender());
		customer2.setCustDOB(customer.getCustDOB());
		customer2.setCustEmailId(customer2.getCustEmailId());
		customer2.setCustPassword(customer2.getCustPassword());
		
		session.save(customer2);
		transaction.commit();
		
	}

	@Override
	public void deleteDataById(int custId) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Customer customer = getDataById(custId);
		
		session.delete(customer);
		transaction.commit();
		
	}

	@Override
	public void deleteAllData() {
		Session session = factory.openSession();
		
	
	for(Customer customer : getAllData()) {
		
		Transaction transaction = session.beginTransaction();
		
		session.delete(customer);
		transaction.commit();
		}	
	}

	@Override
	public List<Customer> sortByCustName() {
		// TODO Auto-generated method stub
		return getAllData().stream().sorted((c1, c2) ->c1.getCustName().compareTo(c2.getCustName())).toList();
	}

	@Override
	public List<Customer> sortByAccountBalance() {
		
		// TODO Auto-generated method stub
		return getAllData().stream().sorted(Comparator.comparingDouble(Customer:: getCustAccountBalance)).toList();
	}

	@Override
	public List<Customer> sortByDOB() {
		// TODO Auto-generated method stub
		return getAllData().stream().sorted((c1, c2) -> c1.getCustDOB().compareTo(c2.getCustDOB())).toList();
	}

	@Override
	public List<Customer> filterByName(String custName) {
		// TODO Auto-generated method stub
		return getAllData().stream().filter(cust -> cust.getCustName().equals(custName)).toList();
	}

	@Override
	public List<Customer> filterByAccountBalance(double custAccountBalance) {
		// TODO Auto-generated method stub
		return getAllData().stream().filter(t ->t.getCustAccountBalance()>=custAccountBalance).toList();
	}

}

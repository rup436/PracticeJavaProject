package com.csi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.csi.model.Customer;

public class CustomerDaoImpl implements CustomerDao{

	SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
	@Override
	public void signUp(Customer customer) {
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(customer);
		transaction.commit();
		
	}

	@Override
	public boolean signIn(String custEmailId, String custPassword) {
		boolean status = false;
		
		for(Customer customer: getAllData())
		{
			if(customer.getCustEmailId().equals(custEmailId) && customer.getCustPassword().equals(custPassword))
			{
				status = true;
			}
		}
		
		return status;
	}

	@Override
	public List<Customer> getAllData() {
		
		Session session = factory.openSession();
		
		return session.createQuery("from Customer").list();
	}

}

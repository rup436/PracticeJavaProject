package com.csi.service;

import java.util.List;

import com.csi.dao.CustomerDaoImpl;
import com.csi.model.Customer;

public class CustomerServiceImpl implements CustomerService{

	CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
	@Override
	public void signUp(Customer customer) {
		// TODO Auto-generated method stub
		customerDaoImpl.signUp(customer);
	}

	@Override
	public boolean signIn(String custEmailId, String custPassword) {
	
		return customerDaoImpl.signIn(custEmailId, custPassword);
	}

	@Override
	public List<Customer> getAllData() {
		// TODO Auto-generated method stub
		return customerDaoImpl.getAllData();
	}

}

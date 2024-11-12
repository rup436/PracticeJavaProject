package com.csi.service;

import java.util.List;

import com.csi.dao.CustomerDao;
import com.csi.dao.CustomerDaoImpl;
import com.csi.model.Customer;

public class CustomerServiceImpl implements CustomerService{
	
	CustomerDao customerDaoImpl = new CustomerDaoImpl();

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
	public Customer getDataById(int custId) {
		// TODO Auto-generated method stub
		return  customerDaoImpl.getDataById(custId);
	}

	@Override
	public List<Customer> getAllData() {
		// TODO Auto-generated method stub
		return  customerDaoImpl.getAllData();
	}

	@Override
	public void updateData(int custId, Customer customer) {
		// TODO Auto-generated method stub
		 customerDaoImpl.updateData(custId, customer);
	}

	@Override
	public void deleteDataById(int custId) {
		// TODO Auto-generated method stub
		 customerDaoImpl.deleteDataById(custId);
	}

	@Override
	public void deleteAllData() {
		// TODO Auto-generated method stub
		 customerDaoImpl.deleteAllData();
	}

	@Override
	public List<Customer> sortByCustName() {
		// TODO Auto-generated method stub
		return  customerDaoImpl.sortByCustName();
	}

	@Override
	public List<Customer> sortByAccountBalance() {
		// TODO Auto-generated method stub
		return  customerDaoImpl.sortByAccountBalance();
	}

	@Override
	public List<Customer> sortByDOB() {
		// TODO Auto-generated method stub
		return  customerDaoImpl.sortByDOB();
	}

	@Override
	public List<Customer> filterByName(String custName) {
		// TODO Auto-generated method stub
		return  customerDaoImpl.filterByName(custName);
	}

	@Override
	public List<Customer> filterByAccountBalance(double custAccountBalance) {
		// TODO Auto-generated method stub
		return  customerDaoImpl.filterByAccountBalance(custAccountBalance);
	}
	
	
}

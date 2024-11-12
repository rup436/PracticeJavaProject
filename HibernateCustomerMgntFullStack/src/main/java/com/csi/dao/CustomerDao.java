package com.csi.dao;

import java.util.List;

import com.csi.model.Customer;

public interface CustomerDao {

	public void signUp(Customer customer);

	public boolean signIn(String custEmailId, String custPassword);

	public List<Customer> getAllData();
}

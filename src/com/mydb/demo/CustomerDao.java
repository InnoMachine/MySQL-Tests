package com.mydb.demo;

import java.util.List;

public interface CustomerDao {
	public void add(Customer c);
	public void update(Customer c);
	public void delete(int id);
	public Customer getCustomerById(int id);
	public List<Customer> query();
}

//CRUD create retrieve update delete
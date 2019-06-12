package home.joci.springdemo.service;

import java.util.List;

import home.joci.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer customer);

	public Customer getCustomerById(int id);

	public void delete(Customer customer);
	
}

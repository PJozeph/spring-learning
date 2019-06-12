package home.joci.springdemo.dao;

import java.util.List;

import home.joci.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer customer);

	public Customer getCustomerById(int id);

	public void delete(Customer customer);
}

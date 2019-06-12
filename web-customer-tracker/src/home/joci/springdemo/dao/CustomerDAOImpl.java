package home.joci.springdemo.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import home.joci.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		return sessionFactory.getCurrentSession()
				.createQuery("FROM Customer order by lastName",Customer.class)
				.getResultList();
	}

	@Override
	public void saveCustomer(Customer customer) {
		sessionFactory.getCurrentSession()
		.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomerById(int id) {
		return sessionFactory.getCurrentSession()
				.get(Customer.class,id);
	}

	@Override
	public void delete(Customer customer) {
		sessionFactory.getCurrentSession().delete(customer);
	}

}

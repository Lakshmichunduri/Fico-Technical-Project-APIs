package apis.source.dao;

import apis.source.model.Customer;

public interface CustomerDao {

	public void addCustomer(Customer customer);
	
	public Customer getCustomer(Integer customerId);
	
	public Customer getPassword(String username);
	
	public Customer updateCustomer(Customer customer);
	
	public String usernameExists(String username);
}

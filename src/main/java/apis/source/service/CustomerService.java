package apis.source.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apis.source.dao.CustomerDao;
import apis.source.dto.CustomerResponse;
import apis.source.model.Customer;

@Transactional
@Service
public class CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	public CustomerResponse addCustomer(Customer customer) {
		CustomerResponse customerResponse = new CustomerResponse();
		customerDao.addCustomer(customer);
		customerResponse.setCustomer(customer);
		return customerResponse;
	}
	
	public CustomerResponse getCustomer(Integer customerId) {
		CustomerResponse customerResponse = new CustomerResponse();
		customerResponse.setCustomer(customerDao.getCustomer(customerId));
		return customerResponse;
	}
	
	public CustomerResponse getPassword(String username) {
		CustomerResponse customerResponse = new CustomerResponse();
		customerResponse.setCustomer(customerDao.getPassword(username));
		return customerResponse;
	}
	
	public CustomerResponse updateCustomer(Customer customer) {
		CustomerResponse customerResponse = new CustomerResponse();
		customerResponse.setCustomer(customerDao.updateCustomer(customer));
		return customerResponse;
	}
	
	public CustomerResponse usernameExists(String username) {
		CustomerResponse customerResponse = new CustomerResponse();
		customerResponse.setUsernameExists(customerDao.usernameExists(username));
		return customerResponse;
	}
	
}

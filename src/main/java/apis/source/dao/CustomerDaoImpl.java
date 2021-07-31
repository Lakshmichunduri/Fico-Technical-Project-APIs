package apis.source.dao;

import java.util.List;
import java.sql.Date;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import apis.source.dto.AddressResponse;
import apis.source.dto.MaritalStatusResponse;
import apis.source.model.Address;
import apis.source.model.Customer;
import apis.source.model.MaritalStatus;
import apis.source.service.AddressService;
import apis.source.service.CustomerService;
import apis.source.service.MaritalStatusService;
import apis.util.Utility;

@Repository
public class CustomerDaoImpl implements CustomerDao{
	
	@Autowired
	private SessionFactory factory;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private MaritalStatusService maritalStatusService;
	
	@Autowired
	private CustomerService customerService;
	
	private Utility<Customer> utility = new Utility<>();
	
	private Session getSession() {
		Session session = null;
		try {
			session = factory.getCurrentSession();
		} catch (HibernateException ex) {
			session = factory.openSession();
		}
		return session;
	}
	
	@Override
	public void addCustomer(Customer customer) {
		// set customerId
		Session session = getSession();
		customer.setCustomerId(getMaxCustomerIdInTable()+1);
		
		//add address in address table and set their id in customer table
		Address customerAddress = new Address();
		if(customer.getAddress() != null) {
			customerAddress = customer.getAddress();
		}
		AddressResponse addressResponse = addressService.setAddress(customerAddress);
		customer.setAddressId(addressResponse.getAddress().getAddressId());
		
		Address customerEmploymentAddress = new Address();
		if(customer.getEmploymentAddress() != null) {
			customerAddress = customer.getEmploymentAddress();
		}
		AddressResponse employmentAddressResponse = addressService.setAddress(customerEmploymentAddress);
		customer.setEmploymentAddressId(employmentAddressResponse.getAddress().getAddressId());
		
		//set maritalStatus
		MaritalStatusResponse maritalStatusResponse = maritalStatusService.getMaritalStatusByStatus(customer.getMaritalStatus());
		customer.setMaritalStatusId(maritalStatusResponse.getMaritalStatus().getId());
		
		long millis=System.currentTimeMillis();
		customer.setDateOfBirth(new Date(millis));
		session.save(customer);
		
	}

	@Override
	public Customer getCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Customer customer = (Customer) session.get(Customer.class, customerId);
		
		AddressResponse addressResponse = addressService.getAddress(customer.getAddressId());
		customer.setAddress(addressResponse.getAddress());
		
		AddressResponse employmentAddressResponse = addressService.getAddress(customer.getEmploymentAddressId());
		customer.setEmploymentAddress(employmentAddressResponse.getAddress());
		
		MaritalStatusResponse maritalStatusResponse = maritalStatusService.getMaritalStatusById(customer.getMaritalStatusId());
		customer.setMaritalStatus(maritalStatusResponse.getMaritalStatus().getStatus());
		
		return customer;
	}
	
	@Override
	public Customer getPassword(String username) {
		Session session = getSession();
		Query query = session.createSQLQuery("select PASSWORD from customer where USERNAME = '" + username + "'");
		List<String> customers = query.list();
		//System.out.println(customers);
		Customer customer = new Customer();
		if((customers.size() != 0) && (customers.get(0) != null)) {
			customer.setPassword(customers.get(0));
		}
		return customer;
	}
	
	@Override
	public Customer updateCustomer(Customer customer) {
		Session session = getSession();
		
		AddressResponse addressResponse = addressService.updateAddress(customer.getAddress());
		
		AddressResponse employmentAddressResponse = addressService.updateAddress(customer.getEmploymentAddress());
		
		MaritalStatusResponse maritalStatusResponse = maritalStatusService.getMaritalStatusByStatus(customer.getMaritalStatus());
		customer.setMaritalStatusId(maritalStatusResponse.getMaritalStatus().getId());
		
		Customer unUpdated = customerService.getCustomer(customer.getCustomerId()).getCustomer();
		utility.mergeNonNullFields(unUpdated,customer);
		return unUpdated;
//		session.update(customer);
	}
	
	@Override
	public String usernameExists(String username) {
		Session session = getSession();
		Criteria criteria = session.createCriteria(Customer.class).add(Restrictions.eq("username", username));
		List<Customer> customers = criteria.list();
		if(customers.size() == 0) {
			return "false";
		}
		return "true";
	}
	
	public Integer getMaxCustomerIdInTable() {
		Session session = getSession();
		Query query = session.createSQLQuery("select max(CUSTOMER_ID) from customer");
		List<Integer> maxId = query.list();
		if((maxId.size() != 0) && (maxId.get(0) != null)) {
			return maxId.get(0);
		}
		return 0;
	}
}

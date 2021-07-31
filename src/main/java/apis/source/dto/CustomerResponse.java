package apis.source.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import apis.source.model.Customer;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class CustomerResponse {

	private Customer customer;
	
	private String usernameExists = "true";

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getUsernameExists() {
		return usernameExists;
	}

	public void setUsernameExists(String usernameExists) {
		this.usernameExists = usernameExists;
	}
}

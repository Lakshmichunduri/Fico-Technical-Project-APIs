package apis.source.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apis.source.dto.CustomerResponse;
import apis.source.model.Customer;
import apis.source.service.CustomerService;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("")
	public CustomerResponse addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}
	
	@GetMapping("/userId/{customerId}")
	public CustomerResponse getCustomer(@PathVariable Integer customerId) {
		return customerService.getCustomer(customerId);
	}
	
	@GetMapping("/username/{username}")
	public CustomerResponse getPassword(@PathVariable String username) {
		return customerService.getPassword(username);
	}
	
	@PutMapping("")
	public CustomerResponse updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}
	
	@GetMapping("/usernameExists/{username}")
	public CustomerResponse usernameExists(@PathVariable String username) {
		return customerService.usernameExists(username);
	}
}

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

import apis.source.dto.AddressResponse;
import apis.source.model.Address;
import apis.source.service.AddressService;

@CrossOrigin
@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping("")
	public AddressResponse setAddress(@RequestBody Address address) {
		return addressService.setAddress(address);
		
	}
	
	@GetMapping("/{addressId}")
	public AddressResponse getAddress(@PathVariable String addressId) {
		return addressService.getAddress(addressId);
	}
	
	@PutMapping("")
	public AddressResponse updateAddress(@RequestBody Address address) {
		return addressService.updateAddress(address);
	}
}

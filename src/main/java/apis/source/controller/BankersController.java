package apis.source.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apis.source.dto.BankersResponse;
import apis.source.model.Bankers;
import apis.source.service.BankersService;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class BankersController {
	
	@Autowired
	private BankersService bankersService;
	

	@GetMapping("")
	public BankersResponse getAllBankersList() {
		return bankersService.getAllBankers();
	}
	
	@PostMapping("")
	public BankersResponse addBanker(@RequestBody Bankers banker)
	{
		return bankersService.addBanker(banker);
	}
	
	@GetMapping("/{username}")
	public BankersResponse getPassword(@PathVariable String username)
	{
		return bankersService.getPassword(username);
	}
	
	@GetMapping("/usernameExists/{username}")
	public BankersResponse usernameExists(@PathVariable String username)
	{
		return bankersService.usernameExists(username);
	}
	
}



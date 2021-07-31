package apis.source.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apis.source.dto.LoanPurposeResponse;
import apis.source.model.LoanPurpose;
import apis.source.service.LoanPurposeService;

@CrossOrigin
@RestController
@RequestMapping("/loanPurpose")
public class LoanPurposeController {
	
	@Autowired
	private LoanPurposeService loanPurposeService;
	
	@GetMapping("")
	public LoanPurposeResponse getLoanPurposes()
	{
		return loanPurposeService.getAllLoanPurpose();
	}
	
	
//	@GetMapping("/id/{id}")
//	public LoanPurposeResponse getPurposeById(@PathVariable Integer id)
//	{
//		return loanPurposeService.getPurposeById(id);
//	}
	
	
	@GetMapping("/purpose/{purpose}")
	public LoanPurposeResponse getIdByPurpose(@PathVariable String purpose)
	{
		return loanPurposeService.getIdByPurpose(purpose);
	}
	
	
	@PostMapping("")
	public LoanPurposeResponse addPurpose(@RequestBody LoanPurpose loanpurpose)
	{
		return loanPurposeService.addPurpose(loanpurpose);
	}
}

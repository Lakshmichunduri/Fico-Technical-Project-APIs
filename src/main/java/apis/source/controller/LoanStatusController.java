package apis.source.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apis.source.dto.LoanStatusResponse;
import apis.source.model.LoanStatus;
import apis.source.service.LoanStatusService;

@CrossOrigin
@RestController
@RequestMapping("/loanStatus")
public class LoanStatusController {
	
	@Autowired
	private LoanStatusService loanStatusService; 
	
	
	@GetMapping("")
	public LoanStatusResponse getLoanStatuses() {
		return loanStatusService.getAllLoanStatus();
	}
	
	@GetMapping("/id/{id}")
	public LoanStatusResponse getStatusById(@PathVariable Integer id)
	{
		return loanStatusService.getStatusbyId(id);
	}
	
	@GetMapping("/status/{status}")
	public LoanStatusResponse getIdByStatus(@PathVariable String status)
	{
		return loanStatusService.getIdByStatus(status);
	}
	
	@PostMapping("")
	public LoanStatusResponse addStatus(@RequestBody LoanStatus loanstatus)
	{
		return loanStatusService.addStatus(loanstatus);
	}

}



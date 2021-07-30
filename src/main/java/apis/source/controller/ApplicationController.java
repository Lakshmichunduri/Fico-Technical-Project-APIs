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

import apis.source.dto.ApplicationResponse;
import apis.source.model.Application;
import apis.source.service.ApplicationService;

@CrossOrigin
@RestController
@RequestMapping("/application")
public class ApplicationController {
	
	@Autowired
	private ApplicationService applicationService;
	
	@PostMapping("")
	public ApplicationResponse addApplication(@RequestBody Application application) {
		return applicationService.addApplication(application);
	}
	
	@GetMapping("/applicationId/{applicationId}")
	public ApplicationResponse getApplication(@PathVariable Integer applicationId) {
		return applicationService.getApplication(applicationId);
	}
	
	@GetMapping("/userId/{customerId}")
	public ApplicationResponse getAllApplicationsWithCustomerId(@PathVariable Integer customerId) {
		return applicationService.getAllApplicationsWithCustomerId(customerId);
	}
	
	@PutMapping("")
	public ApplicationResponse updateApplication(@RequestBody Application application) {
		return applicationService.updateApplication(application);
	}
	
	@GetMapping("")
	public ApplicationResponse getallApplications() {
		return applicationService.getallApplications();
	}
}

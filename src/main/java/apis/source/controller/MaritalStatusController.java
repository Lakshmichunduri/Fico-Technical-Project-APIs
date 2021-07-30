package apis.source.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apis.source.dto.MaritalStatusResponse;
import apis.source.model.MaritalStatus;
import apis.source.service.MaritalStatusService;

@CrossOrigin
@RestController
@RequestMapping("/maritalStatus")
public class MaritalStatusController {
	
	@Autowired
	private MaritalStatusService maritalStatusService;
	
	@GetMapping("")
	public MaritalStatusResponse getAllMaritalStatus() {
		return maritalStatusService.getAllMaritalStatus();
	}
	
	@GetMapping("/{id}")
	public MaritalStatusResponse getMaritalStatusById(@PathVariable int id) {
		return maritalStatusService.getMaritalStatusById(id);
	}
	
	@PostMapping("")
	public MaritalStatusResponse setMaritalStatus(@RequestBody MaritalStatus maritalStatus) {
		return maritalStatusService.setMaritalStatus(maritalStatus);
	}
}

package apis.source.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apis.source.dto.BureauDataResponse;
import apis.source.service.BureauDataService;

@CrossOrigin
@RestController
@RequestMapping("/bureau")
public class BureauDataController {
	
	@Autowired
	private BureauDataService bureauDataService;
	
	@GetMapping("/{id}")
	public BureauDataResponse getDataBySSN(@PathVariable Integer id) {
		return bureauDataService.getDataBySSN(id);
	}
}

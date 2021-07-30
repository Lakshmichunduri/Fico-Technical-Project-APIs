package apis.source.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apis.source.dao.ApplicationDao;
import apis.source.dto.ApplicationResponse;
import apis.source.model.Application;

@Service
@Transactional
public class ApplicationService {
	
	@Autowired
	private ApplicationDao applicationDao;
	
	public ApplicationResponse addApplication(Application application) {
		ApplicationResponse applicationResponse = new ApplicationResponse();
		applicationDao.addApplication(application);
		applicationResponse.setApplication(application);
		return applicationResponse;
	}
	
	public ApplicationResponse getApplication(Integer applicationId) {
		ApplicationResponse applicationResponse = new ApplicationResponse();
		applicationResponse.setApplication(applicationDao.getApplication(applicationId));
		return applicationResponse;
	}
	
	public ApplicationResponse getAllApplicationsWithCustomerId(Integer customerId) {
		ApplicationResponse applicationResponse = new ApplicationResponse();
		applicationResponse.setApplications(applicationDao.getAllApplicationsWithCustomerId(customerId));
		return applicationResponse;
	}
	
	public ApplicationResponse updateApplication(Application application) {
		ApplicationResponse applicationResponse = new ApplicationResponse();
		//applicationDao.updateApplication(application);
		applicationResponse.setApplication(applicationDao.updateApplication(application));
		return applicationResponse;
	}
	
	public ApplicationResponse getallApplications() {
		ApplicationResponse applicationResponse = new ApplicationResponse();
		applicationResponse.setApplications(applicationDao.getallApplications());
		return applicationResponse;
	}
}

package apis.source.dao;

import java.util.List;

import apis.source.model.Application;
import apis.source.model.BureauData;
import apis.util.BureauResponse;

public interface ApplicationDao {
	
	public BureauResponse addApplication(Application application);
	
	public Application getApplication(Integer applicationId);
	
	public List<Application> getAllApplicationsWithCustomerId(Integer customerId);
	
	public Application updateApplication(Application application);
	
	public List<Application> getallApplications();
}

package apis.source.dao;

import java.util.List;

import apis.source.model.Application;

public interface ApplicationDao {
	
	public void addApplication(Application application);
	
	public Application getApplication(Integer applicationId);
	
	public List<Application> getAllApplicationsWithCustomerId(Integer customerId);
	
	public Application updateApplication(Application application);
	
	public List<Application> getallApplications();
}

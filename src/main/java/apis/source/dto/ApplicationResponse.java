package apis.source.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import apis.source.model.Application;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class ApplicationResponse {
	
	private Application application;
	
	private List<Application> applications;

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public List<Application> getApplications() {
		return applications;
	}
	
	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}
	
}

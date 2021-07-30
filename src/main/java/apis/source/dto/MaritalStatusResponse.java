package apis.source.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import apis.source.model.MaritalStatus;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class MaritalStatusResponse {
	
//	private String status;
//	private String Date;
	private List<MaritalStatus> maritalStatuses;
	private MaritalStatus maritalStatus;
	
//	public String getStatus() {
//		return status;
//	}
//	public void setStatus(String status) {
//		this.status = status;
//	}
//	public String getDate() {
//		return Date;
//	}
//	public void setDate(String date) {
//		Date = date;
//	}
	public List<MaritalStatus> getMaritalStatuses() {
		return maritalStatuses;
	}
	public void setMaritalStatuses(List<MaritalStatus> maritalStatuses) {
		this.maritalStatuses = maritalStatuses;
	}
	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
}

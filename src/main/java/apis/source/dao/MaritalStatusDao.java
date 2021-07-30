package apis.source.dao;

import java.util.List;

import apis.source.model.MaritalStatus;

public interface MaritalStatusDao {
	public List<MaritalStatus> getAllMaritalStatus();
	
	public MaritalStatus getMaritalStatusById(int id);
	
	public void setMaritalStatus(MaritalStatus maritalStatus);
	
	public MaritalStatus getMaritalStatusByStatus(String status);
}

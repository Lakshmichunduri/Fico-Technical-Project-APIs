package apis.source.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apis.source.dao.MaritalStatusDao;
import apis.source.dto.MaritalStatusResponse;
import apis.source.model.MaritalStatus;

@Service
@Transactional
public class MaritalStatusService {
	
	@Autowired
	private MaritalStatusDao maritalStatusDao;
	
	public MaritalStatusResponse getAllMaritalStatus() {
		MaritalStatusResponse response = new MaritalStatusResponse();
		response.setMaritalStatuses(maritalStatusDao.getAllMaritalStatus());
		return response;
	}
	
	public MaritalStatusResponse getMaritalStatusById(int id) {
		MaritalStatusResponse response = new MaritalStatusResponse();
		response.setMaritalStatus(maritalStatusDao.getMaritalStatusById(id));
		return response;
	}
	
	public MaritalStatusResponse setMaritalStatus(MaritalStatus maritalStatus) {
		MaritalStatusResponse response = new MaritalStatusResponse();
		maritalStatusDao.setMaritalStatus(maritalStatus);
		response.setMaritalStatus(maritalStatus);
		return response;
	}
	
	public MaritalStatusResponse getMaritalStatusByStatus(String status) {
		MaritalStatusResponse response = new MaritalStatusResponse();
		response.setMaritalStatus(maritalStatusDao.getMaritalStatusByStatus(status));   
		return response;
	}
}

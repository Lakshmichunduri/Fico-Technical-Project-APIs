package apis.source.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import apis.source.dao.LoanPurposeDao;
import apis.source.dto.LoanPurposeResponse;
import apis.source.model.LoanPurpose;

@Service
@Transactional
public class LoanPurposeService {
	
	@Autowired
	private LoanPurposeDao loanPurposeDao;
	
	public LoanPurposeResponse getAllLoanPurpose()
	{
		LoanPurposeResponse response = new LoanPurposeResponse();
		response.setLoanPurposes(loanPurposeDao.getLoanPurposes());
		return response;
	}
	
//	public LoanPurposeResponse getPurposeById(Integer id)
//	{
//		LoanPurposeResponse response = new LoanPurposeResponse();
//		response.setLoanPurpose(loanPurposeDao.getPurposeById(id));
//		return response;
//	}
	
	
	public LoanPurposeResponse getIdByPurpose(String purpose)
	{
		LoanPurposeResponse response = new LoanPurposeResponse();
		response.setLoanPurpose(loanPurposeDao.getIdByPurpose(purpose));
		return response;
	}
	
	
	public LoanPurposeResponse addPurpose(LoanPurpose loanpurpose)
	{
		LoanPurposeResponse response = new LoanPurposeResponse();
		loanPurposeDao.addPurpose(loanpurpose);
		response.setLoanPurpose(loanpurpose);
		return response;
	}
}

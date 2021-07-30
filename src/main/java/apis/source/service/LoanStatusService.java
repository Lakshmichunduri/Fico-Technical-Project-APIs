package apis.source.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apis.source.dao.LoanStatusDao;
import apis.source.dto.LoanStatusResponse;
import apis.source.model.LoanStatus;

@Service
@Transactional
public class LoanStatusService {
	
		@Autowired
		private LoanStatusDao loanStatusDao;
		
		// GET ALL LOAN STATUS
		public LoanStatusResponse getAllLoanStatus()
		{
			LoanStatusResponse response = new LoanStatusResponse();
			response.setLoanStatuses(loanStatusDao.getLoanStatuses());
			return response;
		}
		
		// GET STATUS BY ID
		public LoanStatusResponse getStatusbyId(Integer id)
		{
			LoanStatusResponse response = new LoanStatusResponse();
			response.setLoanStatus(loanStatusDao.getStatusById(id));
			return response;
		}
		
		// GET ID BY STATUS
		public LoanStatusResponse getIdByStatus(String status)
		{
			LoanStatusResponse response = new LoanStatusResponse();
			response.setLoanStatus(loanStatusDao.getIdByStatus(status));
			return response;
		}
		
		// ADD LOAN STATUS    
		public LoanStatusResponse addStatus(LoanStatus loanStatus)
		{
			LoanStatusResponse response = new LoanStatusResponse();
			loanStatusDao.addStatus(loanStatus);
			response.setLoanStatus(loanStatus);
			return response;
		}
		
}

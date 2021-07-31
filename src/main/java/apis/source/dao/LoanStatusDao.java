package apis.source.dao;

import java.util.List;

import apis.source.model.LoanStatus;

public interface LoanStatusDao {
	
		public List<LoanStatus> getLoanStatuses();
		
		public LoanStatus getStatusById(Integer id);
		
		public LoanStatus getIdByStatus(String status);
		
		public void addStatus(LoanStatus loanstatus);

}
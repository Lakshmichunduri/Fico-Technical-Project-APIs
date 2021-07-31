package apis.source.dao;

import java.util.List;
import apis.source.model.LoanPurpose;

public interface LoanPurposeDao {
	
	public List<LoanPurpose> getLoanPurposes();
	
	//public LoanPurpose getPurposeById(Integer id);
	
	public LoanPurpose getIdByPurpose(String Purpose);
	
	public void addPurpose(LoanPurpose loanPurpose);
	
}

package apis.source.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import apis.source.model.LoanPurpose;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class LoanPurposeResponse {
	
	private List<LoanPurpose> loanPurposes;
	private LoanPurpose loanPurpose;
	public List<LoanPurpose> getLoanPurposes() {
		return loanPurposes;
	}
	public void setLoanPurposes(List<LoanPurpose> loanPurposes) {
		this.loanPurposes = loanPurposes;
	}
	public LoanPurpose getLoanPurpose() {
		return loanPurpose;
	}
	public void setLoanPurpose(LoanPurpose loanPurpose) {
		this.loanPurpose = loanPurpose;
	}


}

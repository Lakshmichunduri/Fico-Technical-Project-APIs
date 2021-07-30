package apis.source.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import apis.source.model.LoanStatus;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class LoanStatusResponse {
	
	private List<LoanStatus> loanStatuses;
	private LoanStatus loanStatus;
	public List<LoanStatus> getLoanStatuses() {
		return loanStatuses;
	}
	public void setLoanStatuses(List<LoanStatus> loanStatuses) {
		this.loanStatuses = loanStatuses;
	}
	public LoanStatus getLoanStatus() {
		return loanStatus;
	}
	public void setLoanStatus(LoanStatus loanStatus) {
		this.loanStatus = loanStatus;
	}

}

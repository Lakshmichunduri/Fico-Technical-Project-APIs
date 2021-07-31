package apis.source.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import apis.source.model.Bankers;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class BankersResponse {
	private List<Bankers> bankersList;
	private Bankers banker;
	private String usernameExists = "true";

	public Bankers getBanker() {
		return banker;
	}

	public void setBanker(Bankers banker) {
		this.banker = banker;
	}

	public List<Bankers> getBankersList() {
		return bankersList;
	}

	public void setBankersList(List<Bankers> bankersList) {
		this.bankersList = bankersList;
	}

	public String getUsernameExists() {
		return usernameExists;
	}

	public void setUsernameExists(String usernameExists) {
		this.usernameExists = usernameExists;
	}
	

}

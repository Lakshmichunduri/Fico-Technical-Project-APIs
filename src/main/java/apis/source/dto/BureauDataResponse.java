package apis.source.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import apis.source.model.BureauData;
import apis.util.BureauResponse;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class BureauDataResponse {
	
	private BureauData bureauData;

	public BureauData getBureauData() {
		return bureauData;
	}

	public void setBureauData(BureauData bureauData) {
		this.bureauData = bureauData;
	}
	
}

package apis.source.dao;

import java.util.List;

import apis.source.model.Bankers;
import apis.source.model.MaritalStatus;

public interface BankersDao {
	
	public List<Bankers> getBankers();
	
	public void addBanker(Bankers banker);
	
	public Bankers getPassword(String username);
	
	public String usernameExists(String username);

}

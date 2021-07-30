package apis.source.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apis.source.dao.BankersDao;
import apis.source.dto.BankersResponse;
import apis.source.model.Bankers;

@Service
@Transactional
public class BankersService {

	@Autowired
	private BankersDao bankersDao;
	
	public BankersResponse getAllBankers() {
		BankersResponse response = new BankersResponse();
		response.setBankersList(bankersDao.getBankers());
		return response;
	}
	
	public BankersResponse addBanker(Bankers banker)
	{
		BankersResponse response = new BankersResponse();
		bankersDao.addBanker(banker);
		response.setBanker(banker);
		return response;
	}
	
	public BankersResponse getPassword(String username)
	{
		BankersResponse response = new BankersResponse();
		response.setBanker(bankersDao.getPassword(username));
		return response;
	}
	
	public BankersResponse usernameExists(String username)
	{
		BankersResponse response = new BankersResponse();
		response.setUsernameExists(bankersDao.usernameExists(username));
		return response;
	}
}

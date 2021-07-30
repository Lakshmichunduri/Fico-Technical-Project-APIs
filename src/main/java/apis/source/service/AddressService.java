package apis.source.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apis.source.dao.AddressDao;
import apis.source.dto.AddressResponse;
import apis.source.model.Address;

@Transactional
@Service
public class AddressService {
	
	@Autowired
	private AddressDao addressDao;
	
	public AddressResponse setAddress(Address address) {
		AddressResponse addressResponse = new AddressResponse();
		addressDao.setAddress(address);
		addressResponse.setAddress(address);
		return addressResponse;
		
	}
	
	public AddressResponse getAddress(String addressId) {
		AddressResponse addressResponse = new AddressResponse();
		addressResponse.setAddress(addressDao.getAddress(addressId));
		return addressResponse;
	}
	
	public AddressResponse updateAddress(Address address) {
		AddressResponse addressResponse = new AddressResponse();
		addressResponse.setAddress(addressDao.updateAddress(address));
		return addressResponse;
	}
}

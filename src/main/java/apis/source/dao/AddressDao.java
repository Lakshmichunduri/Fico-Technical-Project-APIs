package apis.source.dao;

import apis.source.model.Address;

public interface AddressDao {
	
	public void setAddress(Address address);
	
	public Address getAddress(String addressId);
	
	public Address updateAddress(Address address);
	
}

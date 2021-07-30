package apis.source.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import apis.source.model.Address;
import apis.source.model.MaritalStatus;
import apis.source.service.AddressService;
import apis.util.Utility;

@Repository

public class AddressDaoImpl implements AddressDao{
	@Autowired
	private SessionFactory factory;
	
	@Autowired 
	private AddressService addressService;
	
	private Utility<Address> utility = new Utility<>();
	
	private Session getSession() {
		Session session = null;
		try {
			session = factory.getCurrentSession();
		} catch (HibernateException ex) {
			session = factory.openSession();
		}
		return session;
	}

	@Override
	public void setAddress(Address address) {
		Session session = getSession();
		address.setAddressId(getAddressId());
		session.save(address);
		
	}

	@Override
	public Address getAddress(String addressId) {
		Session session = getSession();
		Address address = (Address) session.get(Address.class, addressId);
		return address;
	}
	
	@Override
	public Address updateAddress(Address address) {
		Session session = getSession();
		Address unUpdated = addressService.getAddress(address.getAddressId()).getAddress();
		utility.mergeNonNullFields(unUpdated,address);
		return unUpdated;
		//session.update(address);
		
	}
	
	public String getAddressId() {
		UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        return uuidAsString;
	}	
}

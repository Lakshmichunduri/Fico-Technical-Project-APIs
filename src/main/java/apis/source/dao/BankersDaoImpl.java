package apis.source.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import apis.source.model.Application;
import apis.source.model.Bankers;
import apis.source.model.MaritalStatus;

@Repository
public class BankersDaoImpl implements BankersDao {
	
	@Autowired
	private SessionFactory factory;
	
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
	public List<Bankers> getBankers() {
		Session session = getSession();
		Criteria criteria = session.createCriteria(Bankers.class);
		List<Bankers> bankers = criteria.list();
		return bankers;
	}
	
	public void addBanker(Bankers banker) {
		Session session = getSession();
		banker.setBanker_id(getMaxBankersInTable()+1);
		session.save(banker);
	}
	
	public Bankers getPassword(String username) {
		Session session = getSession();
		Query query = session.createSQLQuery("select PASSWORD from bankers where USERNAME='"+username+"'");
		Bankers banker = new Bankers();
		List<String> password = query.list();
		if((password.size() !=0)  && (password.get(0) != null))
		{
			banker.setPassword(password.get(0));
		}
		return banker;
	}
	
	@Override
	public String usernameExists(String username) {
		Session session = getSession();
		Criteria criteria = session.createCriteria(Bankers.class).add(Restrictions.eq("username", username));
		List<Bankers> bankers = criteria.list();
		if(bankers.size() == 0) {
			return "false";
		}
		return "true";
	}
	
	public Integer getMaxBankersInTable() 
	{
		Session session = getSession();
		Query query = session.createSQLQuery("select max(BANKER_ID) from bankers");
		List<Integer> maxId = query.list();
		if((maxId.size() != 0) && (maxId.get(0) != null)) 
		{
			return maxId.get(0);
		}
		return 0;
	}


	
	

}

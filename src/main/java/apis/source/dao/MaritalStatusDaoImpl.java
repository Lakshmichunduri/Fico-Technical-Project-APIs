package apis.source.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import apis.source.model.LoanStatus;
import apis.source.model.MaritalStatus;

@Repository
public class MaritalStatusDaoImpl implements MaritalStatusDao{
	
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
	public List<MaritalStatus> getAllMaritalStatus() {
		//System.out.println(getMaxIdInTable());
		Session session = getSession();
		Criteria criteria = session.createCriteria(MaritalStatus.class);
		List<MaritalStatus> maritalStatuses = criteria.list();
		return maritalStatuses;
	}

	@Override
	public MaritalStatus getMaritalStatusById(int id) {
		Session session = getSession();
		MaritalStatus maritalStatus = (MaritalStatus) session.get(MaritalStatus.class, id);
		return maritalStatus;
	}

	@Override
	public void setMaritalStatus(MaritalStatus maritalStatus) {
		// TODO Auto-generated method stub
		maritalStatus.setId(getMaxIdInTable()+1);
		Session session = getSession();
		session.save(maritalStatus);
	}

	public Integer getMaxIdInTable() {
		Session session = getSession();
		Query query = session.createSQLQuery("select max(id) from marital_status");
		List<Integer> maxId = query.list();
		if((maxId.size() != 0) && (maxId.get(0) != null)) {
			return maxId.get(0);
		}
		return 0;
	}
	
	public MaritalStatus getMaritalStatusByStatus(String status) {
		Session session = getSession();
		Query query = session.createSQLQuery("select id from marital_status where status = '" + status + "'");
		List<Integer> maritalStatusOfStatus = query.list();
		if(maritalStatusOfStatus.size() == 0) {
			return (new MaritalStatus());
		}
		MaritalStatus maritalStatus = new MaritalStatus();
		maritalStatus.setId(maritalStatusOfStatus.get(0));
		return maritalStatus;
	}

}

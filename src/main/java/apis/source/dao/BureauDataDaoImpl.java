package apis.source.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import apis.source.model.BureauData;
import apis.source.model.Customer;

@Repository
public class BureauDataDaoImpl implements BureauDataDao{
	
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
	public BureauData getDataBySSN(Integer id) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Criteria criteria = session.createCriteria(BureauData.class).add(Restrictions.eq("id", id));
		List<BureauData> bureaus = criteria.list();
		if(bureaus.size() != 0 && bureaus.get(0) != null) {
			return bureaus.get(0);
		}
		return new BureauData();
	}

}

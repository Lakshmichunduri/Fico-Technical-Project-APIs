package apis.source.dao;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import apis.source.model.Customer;
import apis.source.model.LoanPurpose;
import apis.source.model.LoanStatus;

@Repository
public class LoanPurposeDaoImpl implements LoanPurposeDao {
	
	// CREATING THE SESSION
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
	public List<LoanPurpose> getLoanPurposes() {
		Session session = getSession();
		Criteria criteria = session.createCriteria(LoanPurpose.class);
		List<LoanPurpose> loanpurposes = criteria.list();
		return loanpurposes;
	}

	@Override
	public LoanPurpose getIdByPurpose(String purpose) {
		Session session = getSession();
		LoanPurpose loanPurpose = new LoanPurpose();
		Criteria criteria = session.createCriteria(LoanPurpose.class).add(Restrictions.eq("purpose", purpose));
		List<LoanPurpose> loanPurposes = criteria.list();
		
		if((loanPurposes.size() != 0) && (loanPurposes.get(0) != null)) {
			return loanPurposes.get(0);
		}
		return loanPurpose;
	}
	
	@Override
	public void addPurpose(LoanPurpose loanPurpose) {
		Session session = getSession();
		loanPurpose.setUniqueId(getUniqueId());
		session.save(loanPurpose);
		
	}
	
	public String getUniqueId() {
		UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        return uuidAsString;
	}	

}

package apis.source.dao;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

//	@Override
//	public LoanPurpose getPurposeById(Integer id) {
//		Session session = getSession();
//		LoanPurpose loanpurpose = (LoanPurpose) session.get(LoanPurpose.class, id);
//		return loanpurpose;
//	}

	@Override
	public LoanPurpose getIdByPurpose(String Purpose) {
		Session session = getSession();
		Query query = session.createSQLQuery("Select id from loan_purpose where purpose='"+Purpose+"'");
		LoanPurpose loanPurpose = new LoanPurpose();
		List<Integer> ids = query.list();
		
		if((ids.size() != 0) && (ids.get(0) != null)) {
			loanPurpose.setId(ids.get(0));
		}
		return loanPurpose;
	}

	
	
	// CHECK THIS ONCE 
	// WE NEED TO FIX THE PURPOSE AND ID IN THIS MANNER FOR THE MODEL TO WORK 
	
	
	@Override
	public void addPurpose(LoanPurpose loanPurpose) {
		Session session = getSession();
		
		loanPurpose.setUniqueId(getUniqueId());
		
		String [] purpose0 = {"credit_card","major_purchase","wedding" };
		String [] purpose1 = {"car","house","vacation","home_improvement" };
		// String [] purpose2 = {"other","debt_consolidation","educational","medical","moving","renewable_energy","small_business"};
		
		if(Arrays.asList(purpose0).contains(loanPurpose.getPurpose())){
			loanPurpose.setId(0);
		}
		else if(Arrays.asList(purpose1).contains(loanPurpose.getPurpose())) {
			loanPurpose.setId(1);
		}
		else {
			loanPurpose.setId(2);
		}
		session.save(loanPurpose);
		
	}
	// FUNCTION FOR GENERATING NEXT LOAN_PURPOSE ID
	public Integer getMaxLoanPurposeInTable() 
	{
		Session session = getSession();
		Query query = session.createSQLQuery("select max(ID) from loan_purpose");
		List<Integer> maxId = query.list();
		if((maxId.size() != 0) && (maxId.get(0) != null)) 
		{
			return maxId.get(0);
		}
		return 0;
	}
	
	public String getUniqueId() {
		UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        return uuidAsString;
	}	

}

package apis.source.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import apis.source.model.Bankers;
import apis.source.model.LoanStatus;

@Repository
public class LoanStatusDaoImpl implements LoanStatusDao {
	
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

	//  GET ALL LOAN STATUSES
	@Override
	public List<LoanStatus> getLoanStatuses() {
		
		Session session = getSession();
		Criteria criteria = session.createCriteria(LoanStatus.class);
		List<LoanStatus> loanstatuses = criteria.list();
		return loanstatuses; 
	
	}

	// GET LOAN STATUS BY ID
	@Override
	public LoanStatus getStatusById(Integer id) {
		Session session = getSession();
		LoanStatus loanStatus = (LoanStatus) session.get(LoanStatus.class, id);
		return loanStatus;

	}

	
	
	// GET ID BY LOAN STATUS
	@Override
	public LoanStatus getIdByStatus(String status) {
		
		Session session = getSession();
		Query query = session.createSQLQuery("Select id from loan_status where status='"+status+"'");
		LoanStatus loanstatus = new LoanStatus();
		List<Integer> ids = query.list();
		
		if((ids.size() != 0) && (ids.get(0) != null)) {
			loanstatus.setId(ids.get(0));
		}
		return loanstatus;
	}

	
	// ADD STATUS
	@Override
	public void addStatus(LoanStatus loanstatus) {
		Session session = getSession();
		loanstatus.setId(getMaxloanstatusInTable()+1);
		session.save(loanstatus);
	}
	
	
	// FUNCTION FOR GENERATING NEXT LOAN_STATUS ID
	public Integer getMaxloanstatusInTable() 
	{
		Session session = getSession();
		Query query = session.createSQLQuery("select max(ID) from loan_status");
		List<Integer> maxId = query.list();
		if((maxId.size() != 0) && (maxId.get(0) != null)) 
		{
			return maxId.get(0);
		}
		return 0;
	}

}

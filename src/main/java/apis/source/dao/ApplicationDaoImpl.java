package apis.source.dao;

import java.lang.reflect.Field;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import apis.source.dto.LoanPurposeResponse;
import apis.source.model.Application;
import apis.source.model.MaritalStatus;
import apis.source.service.ApplicationService;
import apis.source.service.LoanPurposeService;
import apis.util.Utility;

@Repository
public class ApplicationDaoImpl implements ApplicationDao{

	@Autowired
	private SessionFactory factory;
	
	@Autowired
	private ApplicationService applicationService;
	
	@Autowired
	private LoanPurposeService loanPurposeService;
	
	private Utility<Application> utility = new Utility<>();
	
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
	public void addApplication(Application application) {
		Session session = getSession();
		application.setApplicationId(getMaxApplicationIdInTable()+1);
		LoanPurposeResponse loanPurposeResponse = loanPurposeService.getIdByPurpose(application.getLoanPurpose());
		application.setLoanPurposeId(loanPurposeResponse.getLoanPurpose().getId());
		session.save(application);
	}

	@Override
	public Application getApplication(Integer applicationId) {
		Session session = getSession();
		Application application = (Application) session.get(Application.class, applicationId);
		return application;
	}
	
	@Override
	public List<Application> getAllApplicationsWithCustomerId(Integer customerId) {
		Session session = getSession();
		Criteria criteria = session.createCriteria(Application.class).add(Restrictions.eq("customerId", customerId));
		List<Application> applications = criteria.list();
		return applications;
	}
	
	@Override
	public Application updateApplication(Application application) {
		Session session = getSession();
		Application unUpdated = applicationService.getApplication(application.getApplicationId()).getApplication();
		utility.mergeNonNullFields(unUpdated, application);
		return unUpdated;
	}

	@Override
	public List<Application> getallApplications() {
		Session session = getSession();
		Criteria criteria = session.createCriteria(Application.class);
		List<Application> applications = criteria.list();
		return applications;
	}
	
	public Integer getMaxApplicationIdInTable() {
		Session session = getSession();
		Query query = session.createSQLQuery("select max(APPLICATION_ID) from application");
		List<Integer> maxId = query.list();
		if((maxId.size() != 0) && (maxId.get(0) != null)) {
			return maxId.get(0);
		}
		return 0;
	}
}

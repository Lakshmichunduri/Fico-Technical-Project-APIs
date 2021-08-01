package apis.source.dao;

import java.lang.reflect.Field;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
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

import apis.source.dto.BureauDataResponse;
import apis.source.dto.CustomerResponse;
import apis.source.dto.LoanPurposeResponse;
import apis.source.model.Application;
import apis.source.model.BureauData;
import apis.source.model.Customer;
import apis.source.model.MaritalStatus;
import apis.source.service.ApplicationService;
import apis.source.service.BureauDataService;
import apis.source.service.CustomerService;
import apis.source.service.LoanPurposeService;
import apis.util.BureauResponse;
import apis.util.Utility;

@Repository
public class ApplicationDaoImpl implements ApplicationDao{

	@Autowired
	private SessionFactory factory;
	
	@Autowired
	private ApplicationService applicationService;
	
	@Autowired
	private LoanPurposeService loanPurposeService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private BureauDataService bureauDataService;
	
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
	public BureauResponse addApplication(Application application) {
		Session session = getSession();
		application.setApplicationId(getMaxApplicationIdInTable()+1);
		LoanPurposeResponse loanPurposeResponse = loanPurposeService.getIdByPurpose(application.getLoanPurpose());
		application.setLoanPurposeId(loanPurposeResponse.getLoanPurpose().getId());
		
		long millis=System.currentTimeMillis();
		application.setTimeStamp(new Date(millis));
		
		session.save(application);
		
		//get customerdata with customerid
		CustomerResponse customerResponse = customerService.getCustomer(application.getCustomerId());
		Customer customer = customerResponse.getCustomer();
		
		//get bureaudata with ssn
		BureauDataResponse bureauDataResponse = bureauDataService.getDataBySSN(customer.getSsnNumber());
		BureauData bureauData = bureauDataResponse.getBureauData();
		
		//processing the year
		String yearInString = bureauData.getEarliest_cr_line();
		String[] yearList = (yearInString.split(" "));
		String[] dates  = (yearList[0].split("/"));
		
		BureauResponse bureauResponse = new BureauResponse();
		
		bureauResponse.setAnnual_inc(customer.getAnnualSalary());
		bureauResponse.setDelinq_2yrs(bureauData.getDelinq_2yrs());
		bureauResponse.setEmp_length(customer.getWorkExpYears());
		bureauResponse.setInq_last_6mths(bureauData.getInq_last_6mths());
		bureauResponse.setLoan_amnt(application.getLoanAmount());
		bureauResponse.setMths_since_last_delinq(bureauData.getMths_since_last_delinq());
		bureauResponse.setMths_since_last_record(bureauData.getMths_since_last_record());
		bureauResponse.setOpen_acc(bureauData.getOpen_acc());
		bureauResponse.setPub_rec(bureauData.getPub_rec());
		bureauResponse.setPurpose(application.getLoanPurposeId());
		bureauResponse.setRevol_bal(bureauData.getRevol_bal());
		bureauResponse.setRevol_util(bureauData.getRevol_util());
		bureauResponse.setTotal_acc(bureauData.getTotal_acc());
		bureauResponse.setYear(Integer.parseInt(dates[2]));
		
		return bureauResponse;
		
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

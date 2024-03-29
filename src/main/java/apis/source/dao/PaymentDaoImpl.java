package apis.source.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import apis.source.model.Payment;


@Repository
public class PaymentDaoImpl implements PaymentDao{
	@Autowired
	private SessionFactory factory;

	public String payNow(Payment payment) {
		getSession().save(payment);
		return "Payment successfull with amount : " + payment.getAmount();
	}

	private Session getSession() {
		Session session = null;
		try {
			session = factory.getCurrentSession();
		} catch (HibernateException ex) {
			session = factory.openSession();
		}
		return session;
	}

	@SuppressWarnings("unchecked")
	public List<Payment> getTransactionInfo(String vendor) {
		return getSession().createCriteria(Payment.class).add(Restrictions.eq("vendor", vendor)).list();

	}
}

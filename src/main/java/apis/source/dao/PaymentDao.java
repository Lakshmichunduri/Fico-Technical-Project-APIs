package apis.source.dao;

import java.util.List;

import apis.source.model.Payment;

public interface PaymentDao {
	public String payNow(Payment payment);

	public List<Payment> getTransactionInfo(String vendor);
}


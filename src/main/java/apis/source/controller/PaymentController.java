package apis.source.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apis.source.dto.PaymentResponse;
import apis.source.model.Payment;
import apis.source.service.PaymentService;

@CrossOrigin
@RestController
@RequestMapping("/paymentResource")
public class PaymentController {
	@Autowired
	private PaymentService service;

	@PostMapping("/payNow")
	public PaymentResponse payInstant(@RequestBody Payment payment) {
//		System.out.println("payment in controller ");
//		System.out.println(payment);
		return service.pay(payment);
	}

	@GetMapping("/getTransactionByVendor/{vendor}")
	public PaymentResponse getTransaction(@PathVariable String vendor) {
		return service.getTx(vendor);
	}

}
package com.authservice.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.authservice.externalentity.Payment;

@FeignClient(name = "payment-service", url = "http://localhost:8085/")
public interface PaymentProxy {

	@PostMapping("/Payment/doPayment/{bookingid}")
	public Payment addPayment(@PathVariable int bookingid) throws Exception;

	@GetMapping("/Payment/getallpayment")
	public List<Payment> getallpayments();

	@GetMapping("/Payment/getpaymentbybookingid/{bookingid}")
	public Payment getpaymentbybookingid(@PathVariable int bookingid);

	@GetMapping("/Payment/getpaymentbypaymentid/{paymentid}")
	public Payment getpaymentbypaymentid(@PathVariable long paymentid);

	@GetMapping("/Payment/paymentCancel/{paymentid}")
	public String paymentCancel(@PathVariable long paymentid);
}

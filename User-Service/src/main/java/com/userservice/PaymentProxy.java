package com.userservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "payment-service", url = "http://localhost:8085/Payment")
public interface PaymentProxy {


	@PostMapping("/doPayment/{bookingid}")
	public Payment addPayment(@PathVariable int bookingid) throws Exception;
	
	@GetMapping("/getallpayment")
	public ResponseEntity<List<Payment>> getallpayments();
	@GetMapping("/getpaymentbybookingid/{bookingid}")
	public Payment getpaymentbybookingid(@PathVariable int bookingid);

	@GetMapping("/getpaymentbypaymentid/{paymentid}")
	public Payment getpaymentbypaymentid(@PathVariable long paymentid);

	@GetMapping("/paymentCancel/{paymentid}")
	public String paymentCancel(@PathVariable long paymentid);

}

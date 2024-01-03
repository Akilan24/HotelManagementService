package com.paymentservice;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface PaymentService {

	Payment doPayment(int bookingid);

	Payment getPaymentbyBookingId(int bookingid);

	List<Payment> getallpayment();

	String paymentCancel(long id);

	Payment getPaymentbyPaymentId(long id);

}

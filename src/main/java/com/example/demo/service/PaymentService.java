package com.example.demo.service;

import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Payment;
import com.example.demo.repository.PaymentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PaymentService implements PaymentServiceImpl {
	private Logger log = LoggerFactory.getLogger(PaymentService.class);
	@Autowired
	private PaymentRepository repository;

	// make payment
	public Payment doPayment(Payment payment) throws JsonProcessingException {
		payment.setPaymentStatus(paymentProcessing());
		payment.setTransactionId(UUID.randomUUID().toString()); //Transaction id wil be auto generated
		log.info("Payment Service Request : {}", new ObjectMapper().writeValueAsString(payment));
		return repository.save(payment);
	}
	
	
	//api should be 3rd party payment geteway(paytm,phonepy..)
	public String paymentProcessing() {
		return new Random().nextBoolean()?"success":"false";
	}
}

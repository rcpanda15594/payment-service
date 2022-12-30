package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Payment;
import com.example.demo.service.PaymentServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentServiceImpl service;
	
	@PostMapping("/doPayment")
	public Payment doPayment(@RequestBody Payment paymnt) throws JsonProcessingException {
		return service.doPayment(paymnt);
	}
}

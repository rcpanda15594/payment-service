package com.example.demo.service;

import com.example.demo.entity.Payment;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface PaymentServiceImpl {

	Payment doPayment(Payment paymnt) throws JsonProcessingException;

}

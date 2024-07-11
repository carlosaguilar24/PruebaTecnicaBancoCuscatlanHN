package com.pruebatecnica.carlosaguilar.cuscatlan.service;

import com.pruebatecnica.carlosaguilar.cuscatlan.Dto.PaymentRequest;
import com.pruebatecnica.carlosaguilar.cuscatlan.Dto.PaymentResponse;

public interface PaymentService {

    PaymentResponse paymentProcess(PaymentRequest paymentRequest);
}

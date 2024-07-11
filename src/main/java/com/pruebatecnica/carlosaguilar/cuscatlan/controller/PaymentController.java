package com.pruebatecnica.carlosaguilar.cuscatlan.controller;

import com.pruebatecnica.carlosaguilar.cuscatlan.Dto.PaymentRequest;
import com.pruebatecnica.carlosaguilar.cuscatlan.Dto.PaymentResponse;
import com.pruebatecnica.carlosaguilar.cuscatlan.service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cuscatlan/payment")
public class PaymentController {

    private final PaymentService paymentService;


    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public PaymentResponse paymentProcess(@RequestBody PaymentRequest paymentRequest){
        return this.paymentService.paymentProcess(paymentRequest);
    }




}

package com.pruebatecnica.carlosaguilar.cuscatlan.Dto;

import lombok.Data;

@Data
public class PaymentResponse {
    private String orderId;
    private String status;
    private String message;
    private double amount;
}

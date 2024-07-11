package com.pruebatecnica.carlosaguilar.cuscatlan.Dto;

import lombok.Data;

@Data
public class PaymentRequest {
    private Long orderId;
    private String customerName;
    private String cardNumber;
    private String cardHolderName;
    private String expirationDate;
    private int cvv;
    private String email;
    private String phoneNumber;
}

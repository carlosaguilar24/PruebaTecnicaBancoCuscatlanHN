package com.pruebatecnica.carlosaguilar.cuscatlan.service;

import com.pruebatecnica.carlosaguilar.cuscatlan.Dto.Order;
import com.pruebatecnica.carlosaguilar.cuscatlan.Dto.PaymentRequest;
import com.pruebatecnica.carlosaguilar.cuscatlan.Dto.PaymentResponse;
import com.pruebatecnica.carlosaguilar.cuscatlan.Dto.UpdateProduct;
import com.pruebatecnica.carlosaguilar.cuscatlan.Exceptions.PaymentException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService{

    private static final String EXPIRY_DATE_PATTERN = "^(0[1-9]|1[0-2])/([0-9]{2})$";
    private final OrderService orderService;

    public PaymentServiceImpl(OrderService orderService) {
        this.orderService = orderService;
    }

    public PaymentResponse paymentProcess(PaymentRequest paymentRequest){
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setOrderId(String.valueOf(paymentRequest.getOrderId()));
        try{
            validatePaymentRequest(paymentRequest);
            Order order = findOrderById(paymentRequest.getOrderId());
            if (order == null) {
                throw new PaymentException("Order not found for ID: " + paymentRequest.getOrderId());
            }

            if ("Completed".equals(order.getStatus())) {
                throw new PaymentException("Order with ID: " + paymentRequest.getOrderId() + " has already been completed.");
            }

            paymentResponse.setAmount(order.getTotal());
            UpdateProduct updateProduct = new UpdateProduct();
            updateProduct.setIdOrder(paymentRequest.getOrderId());
            updateProduct.setStatus("Completed");
            orderService.updateStatusOrder(updateProduct);
            paymentResponse.setStatus("success");
            paymentResponse.setMessage("Payment processed correctly");

        }catch (PaymentException e){
            paymentResponse.setStatus("failed");
            paymentResponse.setMessage(e.getMessage());
        }
            return paymentResponse;
    }

    private Order findOrderById(Long id) {
        return orderService.getOrderById(id).orElse(null);
    }

    private void validatePaymentRequest(PaymentRequest paymentRequest) throws PaymentException {
        if (!isCardNumberValid(paymentRequest.getCardNumber())) {
            throw new PaymentException("Invalid Card Number");
        }
        if (!isValidExpirationDate(paymentRequest.getExpirationDate())) {
            throw new PaymentException("Invalid Expiration Date, must be MM/YY");
        }
    }

    private boolean isCardNumberValid(String cardNumber) {
        if (cardNumber == null || cardNumber.length() != 16) {
            return false;
        }

        for (char c : cardNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidExpirationDate(String expirationDate) {
        Pattern pattern = Pattern.compile(EXPIRY_DATE_PATTERN);
        Matcher matcher = pattern.matcher(expirationDate);
        return matcher.matches();
    }
/*
    static class PaymentException extends Exception {
        public PaymentException(String message) {
            super(message);
        }
}

 */

}
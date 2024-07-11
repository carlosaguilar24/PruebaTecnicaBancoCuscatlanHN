package com.pruebatecnica.carlosaguilar.cuscatlan.service;

import com.pruebatecnica.carlosaguilar.cuscatlan.Dto.Order;
import com.pruebatecnica.carlosaguilar.cuscatlan.Dto.UpdateProduct;
import com.pruebatecnica.carlosaguilar.cuscatlan.Exceptions.PaymentException;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    public Order createOrder(Order order);

    public List<Order> getOrders();

    public Optional<Order> getOrderById(Long id);

    public List<Order> getOrderByClient(Long id);

    public boolean updateStatusOrder(UpdateProduct updateProduct) throws PaymentException;
}

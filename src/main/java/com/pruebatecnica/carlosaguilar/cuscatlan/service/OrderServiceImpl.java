package com.pruebatecnica.carlosaguilar.cuscatlan.service;

import com.pruebatecnica.carlosaguilar.cuscatlan.Dto.Order;
import com.pruebatecnica.carlosaguilar.cuscatlan.Dto.Product;
import com.pruebatecnica.carlosaguilar.cuscatlan.Dto.UpdateProduct;
import com.pruebatecnica.carlosaguilar.cuscatlan.Exceptions.OrderException;
import com.pruebatecnica.carlosaguilar.cuscatlan.Exceptions.PaymentException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    private final List<Order> orders = new ArrayList<>();
    private Long orderId = 1L;


    public Order createOrder(Order order){
        order.setId(orderId++);
        order.setStatus("In Process");
        calculateTotal(order);
        orders.add(order);
        return order;
    }

    @Override
    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }

    public Optional<Order> getOrderById(Long id){
        return orders.stream()
                .filter(o -> o.getId().equals(id))
                .findFirst();
    }

    public List<Order> getOrderByClient(Long id){

        return orders.stream().filter(order -> order.getClientId().equals(id)).collect(Collectors.toList());
    }


    public boolean updateStatusOrder(UpdateProduct updateProduct) {
        Optional<Order> optionalOrder = getOrderById(updateProduct.getIdOrder());
        if(optionalOrder.isEmpty()){
            return false;
        }
        optionalOrder.ifPresent(order -> order.setStatus(updateProduct.getStatus()));
        return true;
    }

    private void calculateTotal(Order order) {
        double totalItem = 0;
        double total = order.getTotal();
        for(Product product : order.getProducts()){
            totalItem = product.price * product.getQuantity();
            total = total + totalItem;
        }
    }
    }
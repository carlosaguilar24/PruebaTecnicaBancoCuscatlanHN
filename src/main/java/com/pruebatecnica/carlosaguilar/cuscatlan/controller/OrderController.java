package com.pruebatecnica.carlosaguilar.cuscatlan.controller;

import com.pruebatecnica.carlosaguilar.cuscatlan.Dto.Order;
import com.pruebatecnica.carlosaguilar.cuscatlan.Dto.UpdateProduct;
import com.pruebatecnica.carlosaguilar.cuscatlan.Exceptions.PaymentException;
import com.pruebatecnica.carlosaguilar.cuscatlan.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cuscatlan/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/createOrder")
    public Order createOrder(@RequestBody Order order){
        return this.orderService.createOrder(order);
    }

    @GetMapping("/getOrders")
    public List<Order> getOrders(){
        return this.orderService.getOrders();
    }

    @GetMapping("/getOrderById/{idOrder}")
    public Optional<Order> getOrderById(@PathVariable Long idOrder){
        return this.orderService.getOrderById(idOrder);
    }

    @GetMapping("/getOrderByClient/{idClient}")
    public List<Order> getOrderByClient(@PathVariable Long idClient){
        return this.orderService.getOrderByClient(idClient);
    }

    @PatchMapping("/updpateOrder")
    public boolean updateStatusOrder(@RequestBody UpdateProduct updateProduct) {
        try {
            return this.orderService.updateStatusOrder(updateProduct);
        } catch (PaymentException e) {
            throw new RuntimeException(e);
        }
    }

}

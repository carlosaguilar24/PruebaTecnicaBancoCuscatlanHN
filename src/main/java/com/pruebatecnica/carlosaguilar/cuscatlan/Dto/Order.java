package com.pruebatecnica.carlosaguilar.cuscatlan.Dto;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private Long id;
    private Long clientId;
    private List<Product> products;
    private Double total;
    private String status;
}

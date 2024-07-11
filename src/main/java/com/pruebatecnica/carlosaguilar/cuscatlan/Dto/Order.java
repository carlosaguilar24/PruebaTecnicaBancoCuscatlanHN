package com.pruebatecnica.carlosaguilar.cuscatlan.Dto;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private Long id;
    private Long clienteId;
    private List<Product> productos;
    private Double total;
    private String estado;
}

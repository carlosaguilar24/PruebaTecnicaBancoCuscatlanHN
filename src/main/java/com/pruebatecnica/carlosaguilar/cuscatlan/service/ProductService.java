package com.pruebatecnica.carlosaguilar.cuscatlan.service;

import com.pruebatecnica.carlosaguilar.cuscatlan.Dto.Product;

public interface ProductService {

    Product[] getProducts();
    Product getProductById(Long id);
}

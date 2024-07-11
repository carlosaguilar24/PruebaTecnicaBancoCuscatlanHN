package com.pruebatecnica.carlosaguilar.cuscatlan.controller;

import com.pruebatecnica.carlosaguilar.cuscatlan.Dto.Product;
import com.pruebatecnica.carlosaguilar.cuscatlan.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cuscatlan/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Product[] getProducts(){
        return this.productService.getProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return this.productService.getProductById(id);
    }

}

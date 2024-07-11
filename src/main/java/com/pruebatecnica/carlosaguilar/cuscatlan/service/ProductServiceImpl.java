package com.pruebatecnica.carlosaguilar.cuscatlan.service;

import com.pruebatecnica.carlosaguilar.cuscatlan.Abstract.AbstractClient;
import com.pruebatecnica.carlosaguilar.cuscatlan.Dto.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class ProductServiceImpl extends AbstractClient implements ProductService {

    public ProductServiceImpl(RestTemplate restTemplate){
        super(restTemplate);
    }
    @Override
    public Product[] getProducts() {
        String uri = baseUrl + "/products";
        log.info("Consultando productos en URL: {}", uri);
        try{
            ResponseEntity<Product[]> response =  restTemplate.getForEntity(uri, Product[].class);
            if(response.getStatusCode().is2xxSuccessful()){
                log.info("Productos consultados exitosamente {}", response.getStatusCode());
                return response.getBody();
            }
            log.info("No se obtuvieron los productos");
            throw new RuntimeException("No se pudieron obtener los productos");
        }catch (Exception e){
            log.error("Error al consultar productos", e);
            throw new RuntimeException("Error al consultar productos", e);
        }
    }

    @Override
    public Product getProductById(Long id){
        String uri = baseUrl + "/products/" + id;
        log.info("Consultando producto {} en URL: {}", id, uri);
        try{
            ResponseEntity<Product> response = restTemplate.getForEntity(uri, Product.class);
            if(response.getStatusCode().is2xxSuccessful()){
                log.info("Producto consultado exitosamente: {}", response.getStatusCode());
                return response.getBody();
            }
            log.info("No se obtuvo el producto");
            throw new RuntimeException("No se pudo obtener el producto con ID: " + id);
        }catch (Exception e){
            log.error("Error al consultar producto", e);
            throw new RuntimeException("Error al consultar producto", e);
            }
        }
    }

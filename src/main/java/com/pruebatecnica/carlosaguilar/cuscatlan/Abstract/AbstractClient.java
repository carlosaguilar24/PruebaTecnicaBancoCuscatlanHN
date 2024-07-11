package com.pruebatecnica.carlosaguilar.cuscatlan.Abstract;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class AbstractClient {

    @Value("${base.url}")
    protected String baseUrl;
    protected final RestTemplate restTemplate;
    public AbstractClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}

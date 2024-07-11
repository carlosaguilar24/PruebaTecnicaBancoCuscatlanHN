package com.pruebatecnica.carlosaguilar.cuscatlan.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.cbor.CBORFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.cbor.MappingJackson2CborHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppContext {
    @Bean
    RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper cborMapper = new ObjectMapper(new CBORFactory());
        MappingJackson2CborHttpMessageConverter converter = new MappingJackson2CborHttpMessageConverter(cborMapper);
        restTemplate.getMessageConverters().add(0, converter);
        return restTemplate;
    }

}


package com.pruebatecnica.carlosaguilar.cuscatlan.Dto;

import lombok.Data;

@Data
public class Product {
    public int id;
    public String title;
    public double price;
    public String description;
    public String category;
    public String image;
    public Rating rating;
}

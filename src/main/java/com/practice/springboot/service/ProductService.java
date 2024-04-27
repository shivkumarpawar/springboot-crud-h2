package com.practice.springboot.service;

import java.util.List;

import com.practice.springboot.entity.Product;

public interface ProductService {

    public Product getProductById(int id);
    public Product insertProduct(Product product);
    public boolean deleteProductById(int id);
    public List<Product> getAllProducts();
    
}

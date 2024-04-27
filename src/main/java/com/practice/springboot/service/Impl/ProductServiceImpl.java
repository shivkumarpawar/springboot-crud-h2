package com.practice.springboot.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.springboot.entity.Product;
import com.practice.springboot.repository.ProductRepository;
import com.practice.springboot.service.ProductService;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product insertProduct(Product product) {
       return productRepository.save(product); 
    }

    @Override
    public boolean deleteProductById(int id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true; 
        } else {
            return false; 
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    
    
}

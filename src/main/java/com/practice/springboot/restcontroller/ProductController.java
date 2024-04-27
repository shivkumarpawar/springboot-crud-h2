package com.practice.springboot.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.practice.springboot.entity.Product;
import com.practice.springboot.service.ProductService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@RestController
@RequestMapping("/api")

public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getProduct/{id}")
    public Product getProductsById(@PathVariable int id) {
        System.out.println("get mapping get called");
        return productService.getProductById(id);
        
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> listOfAllProducts = productService.getAllProducts();
        return new ResponseEntity<>(listOfAllProducts, HttpStatus.OK);
    }
    
    
    @PostMapping("/insert")
    public Product insertProduct(@RequestBody Product product) {
        return productService.insertProduct(product);
    }

    @DeleteMapping("/deleProduct/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id){
        boolean productDeleted = productService.deleteProductById(id);
        if (productDeleted) {
            return ResponseEntity.ok().build(); // HTTP status code: 200 OK
        } else {
            return ResponseEntity.notFound().build(); // HTTP status code: 404 NOT FOUND
        }
    
    }
}

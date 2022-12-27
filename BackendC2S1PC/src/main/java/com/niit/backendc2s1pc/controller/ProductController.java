package com.niit.backendc2s1pc.controller;

import com.niit.backendc2s1pc.domain.Product;
import com.niit.backendc2s1pc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class ProductController {

    ProductService productService;


    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    ResponseEntity<?> addProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @GetMapping("/products")
    ResponseEntity<?> findAllProducts(){
        return new ResponseEntity<>(productService.fetchAllProducts(),HttpStatus.OK);
    }

    @GetMapping("/product/{productId}")
    ResponseEntity<?> getProductByID(@PathVariable int productId){
        return new ResponseEntity<>(productService.fetchAProductById(productId), HttpStatus.FOUND);
    }

    @DeleteMapping("/product/{productId}")
    ResponseEntity<?> deleteProductById(@PathVariable int productId){
        return new ResponseEntity<>(productService.deleteProduct(productId), HttpStatus.OK);
    }

}

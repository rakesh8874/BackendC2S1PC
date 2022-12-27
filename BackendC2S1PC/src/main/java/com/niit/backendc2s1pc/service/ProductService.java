package com.niit.backendc2s1pc.service;

import com.niit.backendc2s1pc.domain.Product;

import java.util.List;

public interface ProductService {

    Product save(Product product);
    List<Product> fetchAllProducts();
    Product fetchAProductById(int id);
    String deleteProduct(int id);
}

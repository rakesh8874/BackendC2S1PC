package com.niit.backendc2s1pc.service;

import com.niit.backendc2s1pc.domain.Product;
import com.niit.backendc2s1pc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    ProductRepository product;

    @Autowired
    public ProductServiceImpl(ProductRepository userRepository) {
        this.product = userRepository;
    }


    @Override
    public Product save(Product product) {
        if(this.product.findById(product.getProductId()).isEmpty()){
            return this.product.save(product);
        }
        return null;
    }

    @Override
    public List<Product> fetchAllProducts() {
        return this.product.findAll();
    }

    @Override
    public Product fetchAProductById(int id) {
        return this.product.findById(id).get();
    }

    @Override
    public String deleteProduct(int id) {
        if(this.product.findById(id).isEmpty()){
            return "Product Doesn't Exist";
        }
        this.product.deleteById(id);
        return "Product Deleted Successfully";
    }
}

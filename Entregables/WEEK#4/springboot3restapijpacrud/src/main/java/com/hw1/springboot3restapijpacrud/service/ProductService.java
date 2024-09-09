package com.hw1.springboot3restapijpacrud.service;

import java.util.List;

import com.hw1.springboot3restapijpacrud.entity.Product;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
    Product save(Product product);
    void deleteById(Long id);
}

package com.hw1.springboot3restapijpacrud.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hw1.springboot3restapijpacrud.entity.Product;
@Repository

public interface ProductDao {
    List<Product> findAll();
    Product findById(Long id);
    Product save(Product product);
    void deleteById(Long id);
}

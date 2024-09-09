package com.hw1.springboot3restapijpacrud.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hw1.springboot3restapijpacrud.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}

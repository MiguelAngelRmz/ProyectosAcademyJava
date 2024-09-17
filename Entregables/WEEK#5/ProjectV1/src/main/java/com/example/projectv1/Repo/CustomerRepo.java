package com.example.projectv1.Repo;

import com.example.projectv1.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepo extends JpaRepository<Customer,Long>{
    
}

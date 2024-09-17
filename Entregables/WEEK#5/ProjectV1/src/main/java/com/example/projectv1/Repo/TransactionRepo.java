package com.example.projectv1.Repo;

import com.example.projectv1.Entity.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<Transaction, Long>{
    
}

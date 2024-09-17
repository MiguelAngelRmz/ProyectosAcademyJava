package com.example.projectv1.Controller;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectv1.Service.TransactionService;

@RestController
@RequestMapping("/api/transactions") 
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(
            @RequestParam String sourceAccountNumber,
            @RequestParam String destinationAccountNumber,
            @RequestParam BigDecimal amount) {
        
        // Using the 'transfer' method from TransactionService
        try {
            transactionService.transfer(sourceAccountNumber, destinationAccountNumber, amount);
            return new ResponseEntity<>("Transfer completed successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

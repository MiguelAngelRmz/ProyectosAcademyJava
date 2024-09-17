package com.example.projectv1.Entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;
    private String accountHolderName;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private BigDecimal balance;

    @ManyToOne
    private Customer customer;

   

    // Example of custom methods, if needed
    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            this.balance = this.balance.add(amount);
        } else {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
    }

    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0 && amount.compareTo(this.balance) <= 0) {
            this.balance = this.balance.subtract(amount);
        } else {
            throw new IllegalArgumentException("Invalid withdrawal amount or insufficient funds");
        }
    }
}

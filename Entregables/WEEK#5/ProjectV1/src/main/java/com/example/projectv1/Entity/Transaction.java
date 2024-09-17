package com.example.projectv1.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "source_account_id")
    private Account sourceAccount; // Account origin

    @ManyToOne
    @JoinColumn(name = "destination_account_id")
    private Account destinationAccount; // Account destination

    private BigDecimal amount;
    private LocalDateTime timestamp;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType; // e.g., deposit, withdrawal, transfer
}

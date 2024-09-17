package com.example.projectv1;


import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.projectv1.Entity.Account;

class AccountTest {

    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account();
        account.setBalance(BigDecimal.valueOf(1000.00));
    }

    @Test
    void deposit_ShouldIncreaseBalance() {
        BigDecimal depositAmount = BigDecimal.valueOf(500.00);

        account.deposit(depositAmount);

        assertEquals(BigDecimal.valueOf(1500.00), account.getBalance());
    }

    @Test
    void deposit_ShouldThrowExceptionForNegativeAmount() {
        BigDecimal depositAmount = BigDecimal.valueOf(-500.00);

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(depositAmount);
        });

        assertEquals("Deposit amount must be positive", thrown.getMessage());
    }

    @Test
    void withdraw_ShouldDecreaseBalance() {
        BigDecimal withdrawAmount = BigDecimal.valueOf(200.00);

        account.withdraw(withdrawAmount);

        assertEquals(BigDecimal.valueOf(800.00), account.getBalance());
    }

    @Test
    void withdraw_ShouldThrowExceptionForInvalidAmount() {
        BigDecimal withdrawAmount = BigDecimal.valueOf(1200.00);

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(withdrawAmount);
        });

        assertEquals("Invalid withdrawal amount or insufficient funds", thrown.getMessage());
    }

    @Test
    void withdraw_ShouldThrowExceptionForNegativeAmount() {
        BigDecimal withdrawAmount = BigDecimal.valueOf(-200.00);

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(withdrawAmount);
        });

        assertEquals("Invalid withdrawal amount or insufficient funds", thrown.getMessage());
    }
}

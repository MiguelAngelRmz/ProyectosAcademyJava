package com.example.projectv1;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.example.projectv1.Entity.Account;
import com.example.projectv1.Repo.AccountRepo;
import com.example.projectv1.Repo.TransactionRepo;
import com.example.projectv1.Service.TransactionService;

class TransactionServiceTest {

    @InjectMocks
    private TransactionService transactionService;

    @Mock
    private AccountRepo accountRepo;

    @Mock
    private TransactionRepo transactionRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void transfer_ShouldCompleteTransfer() {
        String sourceAccountNumber = "12345";
        String destinationAccountNumber = "67890";
        BigDecimal amount = BigDecimal.valueOf(100.00);
        
        Account sourceAccount = new Account();
        sourceAccount.setBalance(BigDecimal.valueOf(500.00));
        Account destinationAccount = new Account();
        destinationAccount.setBalance(BigDecimal.valueOf(200.00));
        
        when(accountRepo.findByAccountNumber(sourceAccountNumber)).thenReturn(Optional.of(sourceAccount));
        when(accountRepo.findByAccountNumber(destinationAccountNumber)).thenReturn(Optional.of(destinationAccount));
        
        transactionService.transfer(sourceAccountNumber, destinationAccountNumber, amount);

        assertEquals(BigDecimal.valueOf(400.00), sourceAccount.getBalance());
        assertEquals(BigDecimal.valueOf(300.00), destinationAccount.getBalance());

        verify(accountRepo, times(1)).save(sourceAccount);
        verify(accountRepo, times(1)).save(destinationAccount);
        verify(transactionRepo, times(1)).save(any()); // Ensure transactionRepo.save() is called
    }

    @Test
    void transfer_ShouldThrowExceptionWhenSourceAccountNotFound() {
        String sourceAccountNumber = "12345";
        String destinationAccountNumber = "67890";
        BigDecimal amount = BigDecimal.valueOf(100.00);
        
        when(accountRepo.findByAccountNumber(sourceAccountNumber)).thenReturn(Optional.empty());

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            transactionService.transfer(sourceAccountNumber, destinationAccountNumber, amount);
        });

        assertEquals("Origin account"+ sourceAccountNumber +"cannot be found", thrown.getMessage());
    }

    @Test
    void transfer_ShouldThrowExceptionWhenDestinationAccountNotFound() {
        String sourceAccountNumber = "12345";
        String destinationAccountNumber = "67890";
        BigDecimal amount = BigDecimal.valueOf(100.00);
        
        Account sourceAccount = new Account();
        sourceAccount.setBalance(BigDecimal.valueOf(500.00));

        when(accountRepo.findByAccountNumber(sourceAccountNumber)).thenReturn(Optional.of(sourceAccount));
        when(accountRepo.findByAccountNumber(destinationAccountNumber)).thenReturn(Optional.empty());

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            transactionService.transfer(sourceAccountNumber, destinationAccountNumber, amount);
        });

        assertEquals("Destination account"+ destinationAccountNumber +"cannot be found", thrown.getMessage());
    }

    @Test
    void transfer_ShouldThrowExceptionWhenInsufficientFunds() {
        String sourceAccountNumber = "12345";
        String destinationAccountNumber = "67890";
        BigDecimal amount = BigDecimal.valueOf(1000.00);
        
        Account sourceAccount = new Account();
        sourceAccount.setBalance(BigDecimal.valueOf(500.00));
        Account destinationAccount = new Account();
        
        when(accountRepo.findByAccountNumber(sourceAccountNumber)).thenReturn(Optional.of(sourceAccount));
        when(accountRepo.findByAccountNumber(destinationAccountNumber)).thenReturn(Optional.of(destinationAccount));

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            transactionService.transfer(sourceAccountNumber, destinationAccountNumber, amount);
        });

        assertEquals("NOT ENOUGH BALANCE IN THE ACCOUNT", thrown.getMessage());
    }

}

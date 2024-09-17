package com.example.projectv1;


import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.projectv1.Controller.AccountController;
import com.example.projectv1.Entity.Account;
import com.example.projectv1.Service.AccountService;

class AccountControllerTest {

    @InjectMocks
    private AccountController accountController;

    @Mock
    private AccountService accountService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createAccount_ShouldReturnCreatedAccount() {
        Account account = new Account();
        when(accountService.createAccount(account)).thenReturn(account);

        ResponseEntity<Account> response = accountController.createAccount(account);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(account, response.getBody());
    }

    @Test
    void createAccount_ShouldReturnInternalServerError() {
        Account account = new Account();
        when(accountService.createAccount(account)).thenThrow(new RuntimeException("Error"));

        ResponseEntity<Account> response = accountController.createAccount(account);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void getAccountByNumber_ShouldReturnAccount() {
        String accountNumber = "12345";
        Account account = new Account();
        when(accountService.getAccountByNumber(accountNumber)).thenReturn(Optional.of(account));

        ResponseEntity<Account> response = accountController.getAccountByNumber(accountNumber);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(account, response.getBody());
    }

    @Test
    void getAccountByNumber_ShouldReturnNotFound() {
        String accountNumber = "12345";
        when(accountService.getAccountByNumber(accountNumber)).thenReturn(Optional.empty());

        ResponseEntity<Account> response = accountController.getAccountByNumber(accountNumber);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void getAccountBalance_ShouldReturnBalance() {
        String accountNumber = "12345";
        BigDecimal balance = BigDecimal.valueOf(100.00);
        when(accountService.getAccountBalance(accountNumber)).thenReturn(balance);

        ResponseEntity<BigDecimal> response = accountController.getAccountBalance(accountNumber);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(balance, response.getBody());
    }

    @Test
    void getAccountBalance_ShouldReturnNotFound() {
        String accountNumber = "12345";
        when(accountService.getAccountBalance(accountNumber)).thenThrow(new RuntimeException("Account not found"));

        ResponseEntity<BigDecimal> response = accountController.getAccountBalance(accountNumber);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }
}

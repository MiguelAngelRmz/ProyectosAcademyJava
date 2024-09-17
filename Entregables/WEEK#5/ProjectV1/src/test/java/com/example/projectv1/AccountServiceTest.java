package com.example.projectv1;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.example.projectv1.Entity.Account;
import com.example.projectv1.Repo.AccountRepo;
import com.example.projectv1.Service.AccountService;

class AccountServiceTest {

    @InjectMocks
    private AccountService accountService;

    @Mock
    private AccountRepo accountRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createAccount_ShouldReturnCreatedAccount() {
        Account account = new Account();
        when(accountRepository.save(account)).thenReturn(account);

        Account createdAccount = accountService.createAccount(account);

        assertNotNull(createdAccount);
        verify(accountRepository, times(1)).save(account);
    }

    @Test
    void getAccountByNumber_ShouldReturnAccount() {
        String accountNumber = "12345";
        Account account = new Account();
        when(accountRepository.findByAccountNumber(accountNumber)).thenReturn(Optional.of(account));

        Optional<Account> foundAccount = accountService.getAccountByNumber(accountNumber);

        assertTrue(foundAccount.isPresent());
        assertEquals(account, foundAccount.get());
    }


    @Test
    void getAccountBalance_ShouldReturnBalance() {
        String accountNumber = "12345";
        BigDecimal balance = BigDecimal.valueOf(1000.00);
        Account account = new Account();
        account.setBalance(balance);
        when(accountRepository.findByAccountNumber(accountNumber)).thenReturn(Optional.of(account));

        BigDecimal accountBalance = accountService.getAccountBalance(accountNumber);

        assertEquals(balance, accountBalance);
    }

    
}

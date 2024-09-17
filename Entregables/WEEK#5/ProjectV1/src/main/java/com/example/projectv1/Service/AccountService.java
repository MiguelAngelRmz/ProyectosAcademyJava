package com.example.projectv1.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.projectv1.Entity.Account;
import com.example.projectv1.Repo.AccountRepo;


@Service
public class AccountService {
    
    private final AccountRepo accountRepo;

    public AccountService(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    // service to create a new account
    public Account createAccount(Account account) {
        account.setBalance(BigDecimal.ZERO); // start with zero 
        return accountRepo.save(account);
    }

    // aget account by number of account 
    public Optional<Account> getAccountByNumber(String accountNumber) {
        return accountRepo.findByAccountNumber(accountNumber);
    }

    // get de ammount of a account
    public BigDecimal getAccountBalance(String accountNumber) {
        return accountRepo.findByAccountNumber(accountNumber)
                .map(Account::getBalance)
                .orElseThrow(() -> new RuntimeException("DIDNT FIN THE ACCOUNT, PLEASE CHECK THE INFO AND TRY AGAIN"));
    }

    public List<Account> getAllAccounts() {
        return accountRepo.findAll();
    }
}

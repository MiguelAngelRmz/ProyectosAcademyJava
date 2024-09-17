package com.example.projectv1.Controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectv1.Entity.Account;
import com.example.projectv1.Service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    
    @Autowired
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // Endpoint to create a new account
    @PostMapping
   public ResponseEntity<Account> createAccount(@RequestBody Account account) {
    try {
        Account createdAccount = accountService.createAccount(account);
        return ResponseEntity.ok(createdAccount);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
    // Endpoint to get an account by number
    @GetMapping("/{accountNumber}")
    public ResponseEntity<Account> getAccountByNumber(@PathVariable String accountNumber) {
        Optional<Account> account = accountService.getAccountByNumber(accountNumber);
        return account.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint to get the balance of an account
    @GetMapping("/{accountNumber}/balance")
    public ResponseEntity<BigDecimal> getAccountBalance(@PathVariable String accountNumber) {
        try {
            BigDecimal balance = accountService.getAccountBalance(accountNumber);
            return ResponseEntity.ok(balance);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts(){
        List<Account> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    
}

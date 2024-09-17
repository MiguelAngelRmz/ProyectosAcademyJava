package com.example.projectv1.Service;

import com.example.projectv1.Entity.Account;
import com.example.projectv1.Repo.AccountRepo;
import com.example.projectv1.Entity.Transaction;
import com.example.projectv1.Repo.TransactionRepo;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;



@Service
public class TransactionService {

    private final AccountRepo accountRepo;
    private final TransactionRepo transactionRepo;

    public TransactionService(AccountRepo accountRepo, TransactionRepo transactionRepo) {
        this.accountRepo = accountRepo;
        this.transactionRepo = transactionRepo;
    }

    // TRANSFER BETWEEN ACCOUNTS
    public void transfer(String sourceAccountNumber, String destinationAccountNumber, BigDecimal amount) {
        Account sourceAccount = accountRepo.findByAccountNumber(sourceAccountNumber)
                .orElseThrow(() -> new RuntimeException("Origin account" + sourceAccountNumber + "cannot be found"));
        Account destinationAccount = accountRepo.findByAccountNumber(destinationAccountNumber)
                .orElseThrow(() -> new RuntimeException("Destination account" + destinationAccountNumber + "cannot be found"));

        if (sourceAccount.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("NOT ENOUGH BALANCE IN THE ACCOUNT");
        }

        // update the data
        sourceAccount.setBalance(sourceAccount.getBalance().subtract(amount));
        destinationAccount.setBalance(destinationAccount.getBalance().add(amount));

        // save a account modified
        accountRepo.save(sourceAccount);
        accountRepo.save(destinationAccount);

        // register the transaction made
        Transaction transaction = new Transaction();
        transaction.setSourceAccount(sourceAccount);
        transaction.setDestinationAccount(destinationAccount);
        transaction.setAmount(amount);
        transaction.setTimestamp(LocalDateTime.now());
        transactionRepo.save(transaction);
    
    }
}

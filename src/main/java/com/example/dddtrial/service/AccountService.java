package com.example.dddtrial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dddtrial.domain.model.Account;
import com.example.dddtrial.domain.model.Money;
import com.example.dddtrial.form.AccountForm;
import com.example.dddtrial.repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<AccountForm> getAccountDetails() {

        // 全件検索して AccountForm のリストに変換
        List<AccountForm> accountForms = accountRepository.findAll()
                .stream()
                .map(account -> new AccountForm(
                        account.getAccountName(),
                        account.getAccountNumber(),
                        String.valueOf(account.getBalance().getAmount())))
                .toList();
        return accountForms;
    }

    public void deposit(String accountNumber, double amount) {
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        account.deposit(new Money(amount, "USD")); // 通貨は適宜変更
        accountRepository.save(account);
    }

    public void withdraw(String accountNumber, double amount) {
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        account.withdraw(new Money(amount, "USD")); // 通貨は適宜変更
        accountRepository.save(account);
    }

    public Account getAccount(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }
}

package com.example.dddtrial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dddtrial.form.AccountForm;

@Service
public class AccountSenario {
    @Autowired
    private AccountService accountService;

    public List<AccountForm> deposit(AccountForm accountForm) {
        accountService.deposit(accountForm.getAccountNumber(), Double.valueOf(accountForm.getAmount()));
        List<AccountForm> accountForms = accountService.getAccountDetails();
        return accountForms;
    }
}

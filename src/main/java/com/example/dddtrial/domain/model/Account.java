package com.example.dddtrial.domain.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    private String accountNumber;
    private String accountName;

    @Embedded
    private Money balance;

    protected Account() {
    } // JPA用

    public Account(String accountName, String accountNumber, Money balance) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(Money money) {
        this.balance = new Money(this.balance.getAmount() + money.getAmount(), this.balance.getCurrency());
    }

    public void withdraw(Money money) {
        this.balance = new Money(this.balance.getAmount() - money.getAmount(), this.balance.getCurrency());
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Money getBalance() {
        return balance;
    }
}

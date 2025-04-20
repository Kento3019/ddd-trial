package com.example.dddtrial.form;

public class AccountForm {
    private String accountName;
    private String accountNumber;
    private String balance;
    private String amount; // 新しく追加されたフィールド

    public AccountForm() {
    }

    public AccountForm(String accountName, String accountNumber, String balance, String amount) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.amount = amount;
    }

    public AccountForm(String accountName, String accountNumber, String balance) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.amount = "0";
    }

    // Getters and Setters
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}

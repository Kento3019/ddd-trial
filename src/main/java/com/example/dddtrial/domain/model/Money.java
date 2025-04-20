package com.example.dddtrial.domain.model;

import jakarta.persistence.*;

@Embeddable
public class Money {
    private double amount;
    private String currency;

    protected Money() {
    } // JPA用

    public Money(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }
}

package com.gav;

import java.util.ArrayList;

/**
 * Created by Gav on 20-Apr-16.
 */
public class Customer {
    String name;
    double transactionAmount;
    ArrayList<Double> transactions = new ArrayList<Double>();

    public Customer(String name, double transactionAmount) {
        this.name = name;
        this.transactionAmount = transactionAmount;

        this.transactions.add(Double.valueOf(transactionAmount));
    }

    public void addTransaction(double transactionAmount){
        this.transactionAmount = transactionAmount;
        this.transactions.add(Double.valueOf(transactionAmount));
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public String getName() {
        return name;
    }
}

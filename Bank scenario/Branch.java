package com.gav;

import java.util.ArrayList;

/**
 * Created by Gav on 20-Apr-16.
 */
public class Branch {
    String branchName;
    ArrayList<Customer> customers = new ArrayList<Customer>();

    public Branch(String branchName, ArrayList<Customer> customers) {
        this.branchName = branchName;
        this.customers = customers;
    }

    public boolean addNewCustomer(String customerName, double initialTransaction){
        if(findCustomer(customerName) >=0){
            System.out.println("Customer already exists.");
            return false;
        }

        if(initialTransaction < 0.00){
            System.out.println("Transaction amount: " + initialTransaction +  " below 0.");
            return false;
        }

        System.out.println("Customer added succesfully.");
        Customer newCustomer = new Customer(customerName, initialTransaction);
        this.customers.add(newCustomer);
        return true;
    }

    public boolean addNewTransaction(Customer customer, double transactionAmount){
        int position = findCustomer(customer);
        if(position < 0){
            System.out.println("Unable to find customer");
            return false;
        }
        if(transactionAmount < 0.00) {
            System.out.println("Incorrect amount entered: " + transactionAmount);
            return false;
        }

        customer.addTransaction(transactionAmount);
        System.out.println("Successfully added transaction amount: £" + transactionAmount);
        return true;
    }

    public ArrayList findTransactions(String customerName){
        int position = findCustomer(customerName);
        if(position < 0){
            System.out.println("Unable to find customer");
            return null;
        }

        return this.customers.get(position).getTransactions();

    }

    private int findCustomer(Customer customer){
        return this.customers.indexOf(customer);
    }

    public Customer findCustomer(String branchName, String name){
        this.branchName = branchName;
        for(int i = 0; i < customers.size(); i++){
            Customer customer = customers.get(i);
            if(customer.getName().equals(name)){
                return customer;
            }
        }
        return null;
    }

    public int findCustomer(String name){
        for(int i = 0; i < customers.size(); i++){
            Customer customer = customers.get(i);
            if(customer.getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    public void printCustomers(){
        System.out.println("Branch name: " + this.branchName);
        System.out.println("");
        for(int i = 0; i < customers.size(); i++){
            String name = this.customers.get(i).getName();
            System.out.println("Name: " + name);
        }
    }
    public void printCustomersAndTransactions(){
        System.out.println("Branch name: " + this.branchName);
        System.out.println("");
        for(int i = 0; i < customers.size(); i++){
            String name = this.customers.get(i).getName();
            System.out.println("Name: " + name + ". Transactions: " + findTransactions(name));
        }
    }

    public String getBranchName() {
        return branchName;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}

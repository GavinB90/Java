package com.gav;

import java.util.ArrayList;

/**
 * Created by Gav on 20-Apr-16.
 */
public class Bank {
    ArrayList<Branch> branches = new ArrayList<Branch>();

    public Bank() {
    }

    public boolean addBranch(String branchName){
        int position = findBranch(branchName);
        if(position >= 0){
            System.out.println("Branch already exists.");
            return false;
        }
        ArrayList<Customer> customers = new ArrayList<Customer>();
        Branch newBranch = new Branch(branchName, customers);
        this.branches.add(newBranch);

        return true;
    }

    public boolean addNewCustomerToBranch(String branchName, String customerName, double initialTransaction){
        int position = findBranch(branchName);
        if(position < 0){
            System.out.println("Branch doesn't exist.");
            return false;
        }

        this.branches.get(position).addNewCustomer(customerName, initialTransaction);
        return true;
    }

    public boolean addTransaction(String branchName, String customerName, double transactionAmount){
        int branchPosition = findBranch(branchName);
        int customerPosition = findCustomerInBranch(branchName, customerName);
        Branch branch = branches.get(branchPosition);
        Customer customer = branch.findCustomer(branchName, customerName);
        if(branchPosition < 0 ){
//            System.out.println("Unable to find branch.");
            return false;
        }

        branch.addNewTransaction(customer, transactionAmount);
        return true;
    }

    public int findCustomerInBranch(String branchName, String customerName){
        for (int i=0; i < branches.size() ;i++){
            Branch branch = branches.get(i);
            if(branch.getBranchName().equals(branchName) && branch.findCustomer(customerName)>= 0){
                    return i;
            }
        }

        return -1;
    }


    public int findBranch(String branchName){
        for (int i=0; i < branches.size() ;i++){
            Branch branch = branches.get(i);
            if(branch.getBranchName().equals(branchName)){

                return i;
            }
        }
        return -1;
    }

    public String printBranchAndCustomers(String branchName, boolean showTransactions){
        int branchPosition = findBranch(branchName);

        if(branchPosition >= 0 && showTransactions){
            Branch branch  = branches.get(branchPosition);
            branch.printCustomersAndTransactions();
        }else if(branchPosition >= 0) {
            Branch branch = branches.get(branchPosition);
            branch.printCustomers();
        }else{
            System.out.println("Error...");
        }
        return "";
    }

}

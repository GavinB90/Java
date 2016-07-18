package com.gav;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank();

    public static void main(String[] args) {
	    boolean quit = false;
        openBank();
        printActions();

        while(!quit){
            System.out.println("\nEnter action: (5 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("Bank closed...");
                    quit = true;
                    break;
                case 1:
                    printBranchAndCustomers();
                    break;
                case 2:
                    addCustomer();
                    break;
                case 3:
                    addTransaction();
                    break;
                case 4:
                    addNewBranch();
                    break;
                case 5:
                    printActions();
                    break;
            }
        }
    }

    private static void addNewBranch(){
        System.out.println("Please enter the branch name: ");
        String branch = scanner.nextLine();

        if(bank.addBranch(branch)){
            System.out.println("Successfully added Branch " + branch + " to the bank." );
        }else{
            System.out.println("Unable to add branch");
        }
    }

    private static void addTransaction(){
        System.out.println("Please enter the Branch name: ");
        String branch = scanner.nextLine();
        System.out.println("Please enter the customer name: ");
        String name = scanner.nextLine();
        System.out.println("Please enter a transaction amount: ");
        double transaction = scanner.nextDouble();
        if(bank.addTransaction(branch, name, transaction)){
            System.out.println("Customer: " + name + " at Branch: " + branch + " added transaction amount: £" +
            transaction);
        }else{
            System.out.println("Unable to add transaction");
        }
    }

    private static void addCustomer(){
        System.out.println("Please enter the Branch name: ");
        String branch = scanner.nextLine();
        System.out.println("Please enter the customer name: ");
        String name = scanner.nextLine();
        System.out.println("Please enter an initial transaction amount: ");
        double transaction = scanner.nextDouble();
        if(bank.addNewCustomerToBranch(branch, name, transaction)){
            System.out.println("Branch: " + branch + " added Customer: " + name + " with initiial transaction: £" +
            transaction);
        }else {
            System.out.println("Unable to add customer");
        }
    }

    private static void printBranchAndCustomers(){
        System.out.println("Please enter the Branch name: ");
        String name = scanner.nextLine();
        System.out.println("Would you like the customers transactions? (1 for yes, 2 for no).");
        int transactions = scanner.nextInt();
        if(transactions == 1){
            System.out.println("");
            bank.printBranchAndCustomers(name, true);
            return;
        }else if(transactions == 2){
            bank.printBranchAndCustomers(name,false);
        }else{
            System.out.println("Incorrect input.");
            return;
        }

    }

    private static void printActions(){
        System.out.println( "\nAvailable actions:\npress");
        System.out.println( "0 - to shutdown\n"+
                "1 - to print contacts\n" +
                "2 - to add a new customer to a branch\n" +
                "3 - to add a transaction to an existing customer\n" +
                "4 - to add a new branch to the bank\n"+
                "5 - to print a list of available actions");
        System.out.println("Choose your action: ");
    }

    private static void openBank(){
        System.out.println("Bank is opening.");
    }
}

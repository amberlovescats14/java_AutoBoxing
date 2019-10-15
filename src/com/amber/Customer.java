package com.amber;

import java.util.ArrayList;

public class Customer {
    private ArrayList<Double> transactions = new ArrayList<>();
    private String name;
    private double balance;

    //CONSTRUCTOR
    public Customer(String name, Double deposit) {
        this.name = name;
        this.balance = deposit;
        transactions.add(deposit);
        System.out.println("Welcome "  + name);
        System.out.println(balance);
    }
    public Customer(String name){
        new Customer(name, 0.0);
    }

    public String getName() {
        return name;
    }

    //ADD_MONEY
    public void addMoney(double amount){
        transactions.add(amount);
        this.balance += amount;
        System.out.println("Thank you, new balance: " + balance);
    }
    public void withdrawMoney(Double amount){
        if(amount > balance) System.out.println("Unsufficiant Funds");
        else {
            transactions.add(amount * -1);
            this.balance -= amount;
            System.out.println("Thank you, new balance: " + balance);
        }
    }

    public void showTransactions(){
        System.out.println("___" + name + "'s Transactions___");
        transactions.forEach(t -> System.out.println(t));
        System.out.println("Current Balance " + balance);
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public double getBalance() {
        return balance;
    }
}

package com.amber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Branch {
    private String branchName;
    private ArrayList<Customer> customers = new ArrayList<>();

    public Branch(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchName() {
        return branchName;
    }
    private boolean findCustomer(String name) {
        List<Customer> match = customers.stream().filter(customer -> customer.getName().equals(name)).collect(Collectors.toList());
        if(match.size() > 0) return true;
        else return false;
    }
    public void addCustomer(String name, double initialAmount){
        if(!findCustomer(name)) customers.add(new Customer(name, initialAmount));
    }
    public void depositCustomerTransaction(String name, double amount){
        if(findCustomer(name)) {
            for(int i=0; i< customers.size();i++){
                if(customers.get(i).getName().equals(name)) {
                    Customer client = customers.get(i);
                    client.addMoney(amount);
                }
            }
        }
        else System.out.println("Customer Not Found");
    }
    public void withdrawCustomerTransaction(String name, double amount){
        if(findCustomer(name)){
            for(int i=0; i<customers.size();i++){
                if(customers.get(i).getName().equals(name)){
                    Customer client = customers.get(i);
                    client.withdrawMoney(amount);
                }
            }
        }
        else System.out.println("Customer Not Found");
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
    public void showCustomersAndTransactions() {
        System.out.println("_________");
        customers.forEach(customer -> System.out.println("Name: " +customer.getName()));
        System.out.println("___Trasactions____");
        customers.forEach(customer -> customer.showTransactions());
        System.out.println("---------");
    }
    public void showCustomers() {
        System.out.println("__List Of Customers__");
        customers.forEach(customer -> System.out.println("Name: " +customer.getName()));
        System.out.println("---------");
    }
    public void showingCustomerTransactions(String name){
        if(findCustomer(name)){
            for(int i=0;i<customers.size();i++){
                if(customers.get(i).getName().equals(name)){
                    Customer found = customers.get(i);
                    found.showTransactions();
                }
            }
        }
    }

}

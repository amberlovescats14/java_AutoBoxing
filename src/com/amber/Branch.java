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
        boolean answer = false;
        List<Customer> match = customers.stream().filter(customer -> customer.getName().equals(name)).collect(Collectors.toList());
        System.out.println("MATCH: " + match.size());
        if(match.size() > 0) return true;
        else return false;
    }
    public void addCustomer(String name, double initialAmount){
        if(!findCustomer(name)) customers.add(new Customer(name, initialAmount));
    }
    public void depositCustomerTransaction(String name, double amount){
        if(findCustomer(name)) {
            System.out.println("here");
//                    customers.forEach(customer -> customer.getName().indexOf(name));
            for(int i=0; i< customers.size();i++){
                if(customers.get(i).getName().equals(name)) {
                    int index = i;
                    Customer client = customers.get(index);
                    client.addMoney(amount);
                }
            }
        }
        else System.out.println("Customer Not Found");
    }
    public void withdrawCustomerTransaction(String name, double amount){
        if(findCustomer(name)){
            int index = customers.indexOf(name);
            Customer client = customers.get(index);
            client.withdrawMoney(amount);
        }
        else System.out.println("Customer Not Found");
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
    public void showCustomers() {
        System.out.println("SHOW");
        customers.forEach(customer -> System.out.println("FIRST: " +customer.getName()));
//        for(Customer customer: customers) System.out.println(customer.getName());
    }
}

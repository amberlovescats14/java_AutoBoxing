package com.amber;

import java.util.ArrayList;

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
        return customers.contains(name);
    }
    public void addCustomer(String name, double initialAmount){
        if(!findCustomer(name)) customers.add(new Customer(name, initialAmount));
    }
    public void addCustomerTransaction(String name, double amount){
        if(findCustomer(name)) {
            int index = customers.indexOf(name);
            Customer client = customers.get(index);
            client.addMoney(amount);
        }
        else System.out.println("Customer Not Found");
    }

}

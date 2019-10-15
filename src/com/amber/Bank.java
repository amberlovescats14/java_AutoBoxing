package com.amber;

import java.util.ArrayList;

public class Bank {
    private String bankName;
    private ArrayList<Branch> branches = new ArrayList<>();

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    public String getBankName() {
        return bankName;
    }
    private boolean findBranch(String name){
        return branches.contains(name);
    }
    public void addBranch(String name){
        if(!findBranch(name)) branches.add(new Branch(name));
    }

    // FULLY EXTENDED FUNCTIONS
    public void addCustomer(
            String branchName,
            String customerName,
            double amount){
        if(findBranch(branchName)){
            int index = branches.indexOf(branchName);
            Branch name = branches.get(index);
            name.addCustomer(customerName, amount);
        }
        else System.out.println("Transaction Incomplete");
    }

    public void depositAmount(
            String branchName,
            String customerName,
            double amount
    ){
        if(findBranch(branchName)){
            int index = branches.indexOf(branchName);
            Branch name = branches.get(index);
            name.depositCustomerTransaction(customerName, amount);
        }
        else System.out.println("Transaction Incomplete");
    }

    public void withdrawAmount(
            String branchName,
            String customerName,
            double amount
    ){
        if(findBranch(branchName)){
            int index = branches.indexOf(branchName);
            Branch name = branches.get(index);
            name.withdrawCustomerTransaction(customerName, amount);
        }
        else System.out.println("Transaction Inccomplete");
    }
    // SHOW BRANCHES
    public void showBranchList(){
        branches.forEach(branch -> System.out.println(branch));
    }
    // SHOW CUSTOMERS and/or TRANSACTIONS
    public void showCustomers(
            String branchName,
            boolean showTransactions
    ){
        if(findBranch(branchName)){
            int index = branches.indexOf(branchName);
            Branch name = branches.get(index);
            if(showTransactions){
               ArrayList<Customer> branchCustomer = name.getCustomers();
               for(int i=0; i<branchCustomer.size(); i++){
                   Customer oneCustomer = branchCustomer.get(i);
                   System.out.println("Customer Name: " + oneCustomer);
                   System.out.println("Current Balance: " + oneCustomer.getBalance());
                   System.out.println("__Transactions__");
                   oneCustomer.showTransactions();

               }

            }
            else name.showCustomers();
        }
        else System.out.println("Branch Not Found");
    }


}

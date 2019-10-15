package com.amber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        boolean answer = false;
        List<Branch> match =
                branches.stream().filter(customer -> customer.getBranchName().equals(name)).collect(Collectors.toList());
        if(match.size() > 0) return true;
        else return false;
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
            for(int i=0; i<branches.size();i++){
                if(branches.get(i).getBranchName().equals(branchName)){
                    Branch found = branches.get(i);
                    found.addCustomer(customerName, amount);
                }
            }
        }
        else System.out.println("Transaction Incomplete");
    }

    public void depositAmount(
            String branchName,
            String customerName,
            double amount
    ){
        if(findBranch(branchName)){
            for(int i=0; i< branches.size();i++){
                if(branches.get(i).getBranchName().equals(branchName)){
                    Branch found = branches.get(i);
                    found.depositCustomerTransaction(customerName, amount);
                }
            }
        }
        else System.out.println("Transaction Incomplete");
    }

    public void withdrawAmount(
            String branchName,
            String customerName,
            double amount
    ){
        if(findBranch(branchName)){
            for(int i=0; i<branches.size();i++){
                if(branches.get(i).getBranchName().equals(branchName)){
                    Branch found = branches.get(i);
                    found.withdrawCustomerTransaction(customerName, amount);
                }
            }
        }
        else System.out.println("Transaction Inccomplete");
    }
    // SHOW BRANCHES
    public void showBranchList(){
        branches.forEach(branch -> System.out.println(branch.getBranchName()));
    }
    // SHOW CUSTOMERS and/or TRANSACTIONS
    public void showCustomers(
            String branchName,
            boolean showTransactions
    ){
        if(findBranch(branchName)) {
            for(int i=0; i<branches.size();i++){
                if(branches.get(i).getBranchName().equals(branchName)){
                    if(showTransactions){
                        Branch found = branches.get(i);
                        found.showCustomersAndTransactions();

                    }
                    else {
                        Branch found = branches.get(i);
                        found.showCustomers();
                    }

                }
            }
        }
    }


}

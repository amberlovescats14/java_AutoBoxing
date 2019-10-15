package com.amber;

public class Main {

    public static void main(String[] args) {
        var usaa = new Bank("USAA");
        usaa.addBranch("San Antonio");
        usaa.addCustomer("San Antonio", "Amber Jones", 1250.00);
        usaa.addCustomer("San Antonio", "John Doe", 250.30);
        usaa.addCustomer("San Antonio", "Melanie Smith", 560.00);

        usaa.depositAmount("San Antonio", "Amber Jones", 200.00);
        usaa.depositAmount("San Antonio", "Amber Jones", 50.20);
        usaa.depositAmount("San Antonio", "Amber Jones", 200.00);

        usaa.addBranch("Austin");
        usaa.addCustomer("Austin", "Mason Charles", 30000.00);

        usaa.showCustomers("San Antonio", true);







    }
}

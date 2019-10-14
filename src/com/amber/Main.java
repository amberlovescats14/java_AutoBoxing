package com.amber;

public class Main {

    public static void main(String[] args) {
        var me = new Customer("Amber");
        me.addMoney(100.00);
        me.addMoney(50.50);
        me.withdrawMoney(20.00);
        me.showTransactions();

    }
}

package com.deeparishi.javaapp.corejavaconcepts.solid.dip;

public class DebitCard  implements BankCard{

    public void doTransaction(long Amount){
        System.out.println("Purchased using Debit Card and Amount - "+ Amount);
    }

    @Override
    public void doPurchaseSomething(long amount) {

    }
}

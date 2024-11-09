package com.deeparishi.javaapp.concepts.solid.isp;

/**
 * I - Interface Segregation Principle
 * States that the larger interface split into smaller ones. Because the implementation class
 use only the method that are required. We should not force the client to use the methods that they do not want to use

 * this principle similar to segregation responsibility principle
 */
public interface UPI {

    // @Supports both GPay and PhonePe
    public void payMoney();

    // @Supports both GPay and PhonePe
    public void getScratchCard();

    // @Supports only on GPay
    public void getCashBackAsCreditBalance();
}

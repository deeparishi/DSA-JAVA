package com.deeparishi.javaapp.concepts.solid.dip;

/**
 * D - Dependency Inversion Principle
 * States that we must abstraction instead of concrete implementation
   High level Modules should not depend on the low level module but both should depend on abstraction.

 * Let's take Shopping mall accept only debit card not credit card, at the time user only having the credit card
   not a debit card will leads to multiple changes in code as well, so Let's come up with common interface
   that should be implemented by the both cards, by this we can overcome from tight coupling
 */
public class ShoppingMall {

//    DebitCard debitCard;
//
//    ShoppingMall(DebitCard debitCard){
//        this.debitCard = debitCard;
//    }
    BankCard bankCard;

    ShoppingMall(BankCard bankCard){
        this.bankCard = bankCard;
    }
    public void doPurchaseSomething(long amount){
        bankCard.doPurchaseSomething(amount);
    }

    public static void main(String[] args) {
        BankCard debitCard = new DebitCard();
        BankCard creditCard = new CreditCard();
//        ShoppingMall shoppingMall = new ShoppingMall(creditCard);
        ShoppingMall shoppingMall = new ShoppingMall(debitCard);
        shoppingMall.doPurchaseSomething(1234);
    }
}

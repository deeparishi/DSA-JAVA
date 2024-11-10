package com.deeparishi.javaapp.corejavaconcepts.solid.srp;


    /**

       SINGLE RESPONSIBILITY PRINCIPLE
            States that every Java class must perform single functionality,
            Implementation of multiple functionalities will mash up the code

     * This below bank service perform all the functionality inside the single class which
       does not obey the law of SRP
     * So let's create different respective service for each method

     */
public class BankService {

    public void printPassbook(){

    }

    public void withdraw(){

    }

    public void deposit(){

    }

    public void getLoanInterestInfo(){

    }

    public void senOtp(){

    }

}

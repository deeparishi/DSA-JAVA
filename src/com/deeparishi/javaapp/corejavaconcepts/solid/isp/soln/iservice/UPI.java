package com.deeparishi.javaapp.corejavaconcepts.solid.isp.soln.iservice;

public interface UPI {

    // @Supports both GPay and PhonePe
    public void payMoney();

    // @Supports both GPay and PhonePe
    public void getScratchCard();

}

package com.deeparishi.javaapp.corejavaconcepts.designpatterns.creational.factory.impl;

import com.deeparishi.javaapp.corejavaconcepts.designpatterns.creational.factory.Notification;

public class EmailNotification implements Notification {


    @Override
    public void notifyUser() {
        System.out.println("Sending Notification via Email");
    }

}

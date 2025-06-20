package com.deeparishi.javaapp.corejavaconcepts.designpatterns.creational.factory.impl;

import com.deeparishi.javaapp.corejavaconcepts.designpatterns.creational.factory.Notification;

public class PushNotification implements Notification {

    @Override
    public void notifyUser() {
        System.out.println("Sending the push Notification");
    }

}

package com.deeparishi.javaapp.corejavaconcepts.designpatterns.creational.factory;

import com.deeparishi.javaapp.corejavaconcepts.designpatterns.creational.factory.impl.EmailNotification;
import com.deeparishi.javaapp.corejavaconcepts.designpatterns.creational.factory.impl.PushNotification;
import com.deeparishi.javaapp.corejavaconcepts.designpatterns.creational.factory.impl.SMSNotification;

import java.util.Optional;

public class NotificationFactory {

    public static Optional<Notification> createNotification(String type) {
        if (type.equalsIgnoreCase("EMAIL"))
            return Optional.of(new EmailNotification());
        else if (type.equalsIgnoreCase("SMS"))
            return Optional.of(new SMSNotification());
        else if (type.equalsIgnoreCase("PUSH"))
            return Optional.of(new PushNotification());
        return Optional.empty();
    }

}

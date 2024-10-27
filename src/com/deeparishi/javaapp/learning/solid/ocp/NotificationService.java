package com.deeparishi.javaapp.learning.solid.ocp;


/**
  O - Open Close Principle
 * According to new Requirements the class should be "open for extension but closed for modification"
 * The below interface methods applicable for notification service, so we're extending but not modifying the old base code
 */
public interface NotificationService {

    public void sendOtp(String medium);

    public void sendTransactionReport(String medium);

}

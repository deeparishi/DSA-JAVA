package com.deeparishi.javaapp.corejavaconcepts.designpatterns.structural.facade;

public class PracticeClass {

    public static void main(String[] args) {
        User user = new User("rishi", "rishi@org.com", "23456689");
        BookingFacade booking = new BookingFacade();
        booking.createBooking(user);

    }
}

class BookingFacade {

    public void createBooking(User user) {
        Ticket ticket = new Ticket(1, 234.78);
        PaymentSystem payment = new PaymentSystem(ticket);
        Notification notification = new Notification(user);
        payment.pay();
        notification.sendNotification();
    }

    public static void a(){

    }
}
class User {

    String name;
    String email;
    String mobile;

    public User(String name, String email, String mobile) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }
}

class Ticket {
    int id;
    double price;
    public Ticket(int id, double price) {
        this.id = id;
        this.price = price;
    }
}

class PaymentSystem {
    Ticket ticket;
    public PaymentSystem (Ticket ticket) { this.ticket = ticket; }
    public void pay() { System.out.println("paying the amount " + ticket.price); }
}

class Notification {
    User user;
    public Notification(User user) { this.user = user; }
    public void sendNotification() { System.out.println("Sending text to " + user.mobile); }
}
package com.deeparishi.javaapp.lld.socialmedia.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class User {

    private final int id;
    private final String name;
    private final int age;
    private final String location;
    private final LocalDate dob;
    private final Set<User> friends = new HashSet<>();
    private final Set<UserRequest> requestsSent = new HashSet<>();
    private final Set<UserRequest> requestReceived = new HashSet<>();
    private final LocalDateTime createdAt;

    public User(int id, String name, int age, String location, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.location = location;
        this.dob = dob;
        this.createdAt = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getLocation() {
        return location;
    }

    public LocalDate getDob() {
        return dob;
    }

    public Set<User> getFriends() {
        return friends;
    }


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void addFriend(User friend) {
        friends.add(friend);
    }

    public void addRecievedRequest(UserRequest request) {
        requestReceived.add(request);
    }

    public Set<UserRequest> getRequestsRecieved() {
        return requestReceived;
    }

    public void removeRecievedReq(UserRequest request) {
        requestReceived.remove(request);
    }

    public void addSentRequest(UserRequest request) {
        requestsSent.add(request);
    }

    public Set<UserRequest> getRequestsSent() {
        return requestsSent;
    }

    public void removeSentRequest(UserRequest userRequest) {
        requestsSent.remove(userRequest);
    }

    public void printInfo() {
        System.out.println("ID : " + id);
        System.out.println("name : " + name);
        System.out.println("age : " + age);
        System.out.println("location : " + location);
        System.out.println("dob : " + dob);
    }



}

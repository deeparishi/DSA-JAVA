package com.deeparishi.javaapp.lld.socialmedia.model;

import com.deeparishi.javaapp.lld.socialmedia.enums.Enums;

public class UserRequest {

    public UserRequest(int id, User from, User to) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.status = Enums.RequestStatus.PENDING;
    }

    private int id;
    private User from;
    private User to;
    private Enums.RequestStatus status;

    public int getId() {
        return id;
    }

    public User getFrom() {
        return from;
    }

    public User getTo() {
        return to;
    }

    public Enums.RequestStatus getStatus() {
        return status;
    }
}

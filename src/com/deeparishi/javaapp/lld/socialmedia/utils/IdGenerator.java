package com.deeparishi.javaapp.lld.socialmedia.utils;

public class IdGenerator {

    private Integer userUID = 1;
    private Integer userRequestUID = 2;
    private static final IdGenerator idGenerator = new IdGenerator();
    private IdGenerator() {}

    public static IdGenerator idGenerator() {
        return idGenerator;
    }

    public Integer newUserUId() {
        return ++userUID;
    }

    public Integer newRequestUID() {
        return ++userRequestUID;
    }
}

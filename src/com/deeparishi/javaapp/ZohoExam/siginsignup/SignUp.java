package com.deeparishi.javaapp.ZohoExam.siginsignup;

public class SignUp {


    private String userName;
    private String passWord;


    SignUp(String username, String password) {
        this.userName = username;
        this.passWord = password;
    }

    public String getUserName() {
        return userName;
    }


    public boolean authenticate(String inputPassword) {
        return passWord.equals(inputPassword);
    }


}
package com.deeparishi.javaapp.ZohoExam.siginsignup;

import java.util.ArrayList;

public class SignIn {

    ArrayList<SignUp> userList;
    ArrayList<String> heading;
    ArrayList<String> content;

    SignIn() {
        userList = new ArrayList<>();
    }

    public void addUser(SignUp up) {
        userList.add(up);
        System.out.println("Inserted  sucessfully!! ");
    }

    public boolean userValidate(String name, String password) {
        for (SignUp up : userList) {
            if (up.authenticate(password) && up.getUserName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void createNewPost(String Heading, String Content, String name) {

        heading = new ArrayList<>();
        content = new ArrayList<>();
        heading.add(Heading);
        content.add(Content);
        content.add(name);
    }

    public void viewAllPost() {
        int i = 0;
        while (i < heading.size())
            for (String p : heading) {
                System.out.println(p);
                break;
            }
        for (String pp : content) {
            System.out.println(pp);
            break;
        }
        i++;
    }

}


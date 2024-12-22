package com.deeparishi.javaapp.ZohoExam.siginsignup;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SignIn in = new SignIn();

        while (true) {
            System.out.println("1. Sign Up");
            System.out.println("2. Sign In");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter username: ");
                String signUpUsername = scanner.next();
                System.out.print("Enter password: ");
                String signUpPassword = scanner.next();
                SignUp up = new SignUp(signUpUsername, signUpPassword);
                in.addUser(up);
            }
            if (choice == 2) {
                System.out.print("Enter username: ");
                String signInUsername = scanner.next();
                System.out.print("Enter password: ");
                String signInPassword = scanner.next();
                while (true) {
                    if (in.userValidate(signInUsername, signInPassword)) {
                        System.out.println("1. Create");
                        System.out.println("2. view all");
                        System.out.println("3. Home");
                        System.out.print("Enter choie: ");
                        int choice1 = scanner.nextInt();
                        if (choice1 == 1) {
                            System.out.println("Enter your Heading: ");
                            String heading = scanner.next();
                            System.out.println("Enter Content: ");
                            String content = scanner.next();
                            if (heading != null) {
                                in.createNewPost(heading, content, signInUsername);
                            } else {
                                System.out.println("Enter heading and retry ");
                            }
                        }
                        if (choice1 == 2) {
                            in.viewAllPost();
                        }
                        if (choice1 == 3) {
                            break;
                        }
                    } else {
                        System.out.println("You have to create account");
                    }
                }
            }
        }
    }
}



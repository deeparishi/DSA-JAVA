package com.deeparishi.javaapp.lld.socialmedia;

import com.deeparishi.javaapp.lld.socialmedia.model.User;
import com.deeparishi.javaapp.lld.socialmedia.service.FriendService;
import com.deeparishi.javaapp.lld.socialmedia.service.UserService;

import java.util.Scanner;

public class SocialMediaPlatform {

    private final UserService userService;
    private final Scanner scanner;
    private final FriendService friendService;
    private User loggedInUser;

    public SocialMediaPlatform() {
        userService =  UserService.userService();
        scanner = new Scanner(System.in);
        friendService = FriendService.friendService();
    }

    public static void main(String[] args) {
        new SocialMediaPlatform().start();
    }

    private void start() {
        userService.init();
        while (true) {
            showMenus();
            int option = readOption();

            switch (option) {
                case 1 -> userService.addUser();
                case 2 -> loggedInUser = userService.login();
                case 3 -> {
                    if (isUserLoggedIn()) friendService.addFriends(loggedInUser);
                    else System.err.println("Please Sign in to access application :)");
                }
                case 4 -> friendService.manageRequest(loggedInUser);
                case 5 -> friendService.viewMyFriends(loggedInUser);
                case 0 -> exit();
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private boolean isUserLoggedIn() {
        return this.loggedInUser != null;
    }


    private int readOption() {
        while (true) {
            try {
                System.out.print("Select option: ");
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private void exit() {
        System.out.println("Exiting application.");
        scanner.close();
        System.exit(0);
    }

    private void showMenus() {
        System.out.println("\n--- Social Media Platform ---");
        System.out.println("1. Sign Up");
        System.out.println("2. Sign In");
        System.out.println("3. Add Friends");
        System.out.println("4. Manage Request");
        System.out.println("5. View My Friends");
        System.out.println("0. Exit");
    }
}

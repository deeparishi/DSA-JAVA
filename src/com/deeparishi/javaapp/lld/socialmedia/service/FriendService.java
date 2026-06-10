package com.deeparishi.javaapp.lld.socialmedia.service;

import com.deeparishi.javaapp.lld.socialmedia.model.User;
import com.deeparishi.javaapp.lld.socialmedia.model.UserRequest;
import com.deeparishi.javaapp.lld.socialmedia.utils.IdGenerator;

import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class FriendService {

    private final UserService userService;
    private final IdGenerator idGenerator;
    private final Scanner scanner;
    private static FriendService friendService;

    private FriendService() {
        this.scanner = new Scanner(System.in);
        this.userService = UserService.userService();
        this.idGenerator = IdGenerator.idGenerator();
    }

    public static FriendService friendService() {
        if (friendService == null) friendService = new FriendService();
        return friendService;
    }

    public void addFriends(User loggedInUserId) {
        while (true) {
            System.out.println("Friends from the Application");
            showAllNames(loggedInUserId);
            System.out.println("Enter username to add friends or 0 to back from this menu");
            String userName = scanner.nextLine();
            if (userName.equals("0"))
                break;
            giveRequest(userName, loggedInUserId);
        }
    }

    public void showAllNames(User loggedInUserId) {

        Map<Integer, User> userMap = userService.findAll();

        Set<Integer> friendIds = loggedInUserId.getFriends()
                .stream()
                .map(User::getId)
                .collect(Collectors.toSet());

        Set<Integer> requestReqSentIds = loggedInUserId.getRequestsSent()
                .stream()
                .map(r -> r.getTo().getId())
                .collect(Collectors.toSet());

        Set<Integer> requestReqRecievedIds = loggedInUserId.getRequestsRecieved()
                .stream()
                .map(r -> r.getFrom().getId())
                .collect(Collectors.toSet());

        userMap.values()
                .stream()
                .filter(user -> user.getId() != loggedInUserId.getId())
                .filter(user -> !friendIds.contains(user.getId()))
                .filter(user -> !requestReqSentIds.contains(user.getId()))
                .filter(user -> !requestReqRecievedIds.contains(user.getId()))
                .map(User::getName)
                .forEach(System.out::println);
    }

    public void giveRequest(String friendUserName, User loggedInUser) {

        Map<Integer, User> userMap = userService.findAll();

        Optional<User> friend = userMap.values()
                .stream()
                .filter(u -> u.getName().equalsIgnoreCase(friendUserName.trim()))
                .findFirst();

        if (friend.isPresent()) {
            UserRequest userRequest = new UserRequest(
                    idGenerator.newRequestUID(),
                    loggedInUser,
                    friend.get()
            );
            friend.get().addRecievedRequest(userRequest);
            loggedInUser.addSentRequest(userRequest);
        }
    }

    public void manageRequest(User loggedInUser) {

        while (true) {
            Map<Integer, User> userMap = userService.findAll();
            System.out.println("0. Back to Main Menu");
            System.out.println("1. New Request");
            System.out.println("2. Request Sent");
            int option = scanner.nextInt();
            switch (option) {
                case 0:
                    return;
                case 1:
                    recievedRequests(loggedInUser, userMap);
                case 2:
                    sentRequests(loggedInUser);
            }
        }
    }

    private void sentRequests(User loggedInUser) {
        if (loggedInUser.getRequestsSent().isEmpty()) {
            System.out.println("Sorry no request has been sent");
            return;
        }
        System.out.println("-------Below are sent requests-------------------");
        loggedInUser.getRequestsSent()
                .stream()
                .forEach(r -> System.out.println("username : " + r.getTo().getName() + " status : " + r.getStatus().name()));
    }

    private void recievedRequests(User loggedInUser, Map<Integer, User> userMap) {
        System.out.println("-------Below are received requests-------------------");
        loggedInUser.getRequestsRecieved()
                .forEach(r -> System.out.println("Name " + r.getFrom().getName() + " ID " + r.getFrom().getId()));

        while (true) {
            System.out.println("Enter UserID to view Request and more info or Else 0 to back manage request");
            int userId = scanner.nextInt();
            scanner.nextLine();
            if (userId == 0) break;
            User friend = userMap.getOrDefault(userId, null);
            Optional<UserRequest> friendReq = loggedInUser.getRequestsRecieved()
                    .stream()
                    .filter(r -> r.getFrom().getId() == userId)
                    .findFirst();

            if (friend != null && friendReq.isPresent()) {
                friend.printInfo();
                System.out.println("Enter yes to accept or no to reject ");
                String decision = scanner.nextLine();
                if (decision.equalsIgnoreCase("yes")) {
                    loggedInUser.addFriend(friend);
                    friend.addFriend(loggedInUser);
                    loggedInUser.removeRecievedReq(friendReq.get());
                    friend.removeSentRequest(friendReq.get());
                }
            } else {
                System.err.println("User Not found!");
            }
        }
    }

    public void viewMyFriends(User loggedInUser) {
        loggedInUser.getFriends()
                .stream()
                .forEach(f ->
                        System.out.println("Friend ID " + f.getId() + " Name " + f.getName())
                );
    }

}
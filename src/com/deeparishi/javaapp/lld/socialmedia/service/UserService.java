package com.deeparishi.javaapp.lld.socialmedia.service;

import com.deeparishi.javaapp.lld.socialmedia.model.User;
import com.deeparishi.javaapp.lld.socialmedia.utils.IdGenerator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class UserService {

    private final Scanner scanner = new Scanner(System.in);
    private final Map<Integer, User> userMap = new HashMap<>();
    private static UserService userService;
    IdGenerator idGenerator = IdGenerator.idGenerator();

    private UserService(){}

    public static UserService userService() {
        if (userService == null) userService = new UserService();
        return userService;
    }
    public void addUser() {

        System.out.print("Enter Your Name ");
        String name = scanner.nextLine();

        System.out.print("Enter Your Age ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Your Location ");
        String location = scanner.nextLine().trim();

        LocalDate dob = readValidDOB();

        User user = new User(
                idGenerator.newUserUId(),
                name, age, location,
                dob
        );
        userMap.put(user.getId(), user);
    }

    public User login() {
        System.out.println("Enter Your username ");
        String name = scanner.nextLine();
        for (Map.Entry<Integer, User> entry : userMap.entrySet()) {
            if (entry.getValue().getName().equalsIgnoreCase(name)) {
                System.out.println("Welcome to our Social Media Platform Mr " + entry.getValue().getName() + " Nice to have you here! ");
                return entry.getValue();
            }
        }
        System.err.println("User not found in this name, Please sign up Mr " + name);
        return null;
    }

    private LocalDate readValidDOB() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        while (true) {
            try {
                System.out.print("Enter Your DOB (dd-MM-yyyy): ");
                String dobInput = scanner.nextLine().trim();

                return LocalDate.parse(dobInput, formatter);

            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use dd-MM-yyyy.");
            }
        }
    }

    public Map<Integer, User> findAll() {
        return Collections.unmodifiableMap(userMap);
    }

    public Optional<User> findById(int id) {
        return Optional.ofNullable(userMap.get(id));
    }

    public void init() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        User deeparishi = new User(
                idGenerator.newUserUId(),
                "Deeparishi", 22, "CUD", LocalDate.parse("25-08-2001", formatter)
        );
        User buvanesh = new User(
                idGenerator.newUserUId(),
                "Buvanesh", 23, "CH", LocalDate.parse("05-10-2001", formatter)
        );

        User muthuraja = new User(
                idGenerator.newUserUId(),
                "Muthuraja", 24, "KL", LocalDate.parse("19-11-2001", formatter)
        );

        User nehru = new User(
                idGenerator.newUserUId(),
                "Nehru", 32, "BA", LocalDate.parse("29-10-1991", formatter)
        );

        userMap.put(deeparishi.getId(), deeparishi);
        userMap.put(buvanesh.getId(), buvanesh);
        userMap.put(muthuraja.getId(), muthuraja);
        userMap.put(nehru.getId(), nehru);
    }
}

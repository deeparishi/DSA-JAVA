package com.deeparishi.javaapp.ZohoExam;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        String password1 = "Qw!1";
        String password2 = "Qwertyuiop";
        String password3 = "QwertY123";
        String password4 = "Qwerty@123";

        String strength1 = checkPasswordStrength(password1);
        String strength2 = checkPasswordStrength(password2);
        String strength3 = checkPasswordStrength(password3);
        String strength4 = checkPasswordStrength(password4);

        System.out.println("Strength of Password 1: " + strength1);
        System.out.println("Strength of Password 2: " + strength2);
        System.out.println("Strength of Password 3: " + strength3);
        System.out.println("Strength of Password 4: " + strength4);
    }

    public static String checkPasswordStrength(String password) {
        boolean rule1 = false;
        boolean rule2 = false;
        boolean rule3 = false;
        boolean rule4 = false;

        // Rule 1: At least 8 characters
        if (password.length() >= 8) {
            rule1 = true;
        }

        // Rule 2: Contains both uppercase and lowercase letters
        if (password.matches(".*[a-z].*") && password.matches(".*[A-Z].*")) {
            rule2 = true;
        }

        // Rule 3: Contains at least one digit
        if (password.matches(".*\\d.*")) {
            rule3 = true;
        }

        // Rule 4: Contains at least one special character
        if (password.matches(".*[!@#$%^&*()].*")) {
            rule4 = true;
        }

        // Determine the password strength based on the rules
        if (rule1 && rule2 && rule3 && rule4) {
            return "Strong";
        } else if (rule1 && rule2 && rule3) {
            return "Good";
        } else if (rule1 && rule2) {
            return "Medium";
        } else {
            return "Weak";
        }
    }


}

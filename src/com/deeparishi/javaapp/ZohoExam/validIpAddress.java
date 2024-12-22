package com.deeparishi.javaapp.ZohoExam;

public class validIpAddress {

    public static void main(String[] args) {
        System.out.println(isValid("123.123.123.123"));
        System.out.println(isValid("0.0.0.0."));
        System.out.println(isValid("0.0.0.0"));
        System.out.println(isValid("1234.1230.145.101"));

    }

    public static boolean isValid(String ip) {
        // Split the input string into four parts using the dot as a delimiter
        String[] parts = ip.split("\\.");

        // Check if there are exactly 4 parts
        if (parts.length != 4) {
            return false;
        }

        int count = 0;
        for (int i = 0; i < ip.length(); i++) {

            if (ip.charAt(i) == '.') {
                count++;
            }

        }
        if (count > 3) {
            return false;
        }


        // Iterate through each part and validate it
        for (String part : parts) {
            try {
                // Convert the part to an integer
                int num = Integer.parseInt(part);

                // Check if the integer is within the range [0, 255]
                if (num < 0 || num > 255) {
                    return false;
                }

                // Check for leading zeros
                if (part.length() > 1 && part.charAt(0) == '0') {
                    return false;
                }
            } catch (Exception e) {
                // If parsing as an integer fails, it's not a valid IPv4 address
                return false;
            }
        }

        // If all parts are valid, return 1
        return true;
    }
}



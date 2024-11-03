package com.deeparishi.javaapp.leetcode.string;

import java.util.Arrays;
import java.util.List;

public class VersionUpgradedOrNot {

    public static void main(String[] args) {

        System.out.println(isUpgradedOrDowngraded("4.0.2", "2.8.4"));
    }

    static String isUpgradedOrDowngraded(String version1, String version2){

        StringBuilder conc1 = new StringBuilder();
        StringBuilder conc2 = new StringBuilder();

        List<String> versionParts1 = Arrays.asList(version1.split("\\."));
        List<String> versionParts2 = Arrays.asList(version2.split("\\."));
        versionParts1.forEach(conc1::append);
        versionParts2.forEach(conc2::append);

        if(Integer.parseInt(conc1.toString()) < Integer.parseInt(conc2.toString())){
            return "Updgraded";
        }

        if(Integer.parseInt(conc1.toString()) == Integer.parseInt(conc2.toString())){
            return "Not Upgraded/Downgraded";
        }

        return "Downgraded";

    }
}

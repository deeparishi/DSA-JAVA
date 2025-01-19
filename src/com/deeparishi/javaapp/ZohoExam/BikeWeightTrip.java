package com.deeparishi.javaapp.ZohoExam;

public class BikeWeightTrip {
    public static void main(String[] args) {
        int[] person1 = {70, 80, 90, 100, 110, 160, 180, 100};
        int[] person2 = {70, 80, 90, 100, 110, 160, 180};
        calculateWeightTrip(person1);
        calculateWeightTrip(person2);
    }

    private static void calculateWeightTrip(int[] person) {
        int cond = 2;
        int count = 0;
        int trip = 0;
        if (person.length % 2 != 0) {
            for (int i = 0; i < person.length - 1; i++) {
                count++;
                if (person[i] < 150 && count == cond) {
                    trip++;
                    count = 0;
                }

            }
            if (person[person.length - 1] < 150) {
                trip++;
            }
        }
        System.out.println(trip);
    }
}

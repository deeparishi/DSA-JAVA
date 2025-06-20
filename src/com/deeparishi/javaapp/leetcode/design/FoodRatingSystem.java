package com.deeparishi.javaapp.leetcode.design;

// https://leetcode.com/problems/design-a-food-rating-system

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class FoodRatingSystem {


    public static void main(String[] args) {

        String[] foods1 = {"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"};
        String[] cuisines = {"korean", "japanese", "japanese", "greek", "japanese", "korean"};
        int[] ratings = {9, 12, 8, 15, 14, 7};

        FoodRatingSystem foodRating = new FoodRatingSystem(foods1, cuisines, ratings);

        System.out.println(foodRating.highestRated("korean")); // kimichi
        System.out.println(foodRating.highestRated("japanese")); // ramen
        foodRating.changeRating("sushi", 16);
        System.out.println(foodRating.highestRated("japanese")); // sushi
        foodRating.changeRating("ramen", 16);
        System.out.println(foodRating.highestRated("japanese")); // ramen

    }


    Map<String, FoodRating> foodRatingMap = new HashMap<>();
    Map<String, TreeSet<FoodRating>> cuisineMap = new HashMap<>();

    public FoodRatingSystem(String[] foods, String[] cuisines, int[] ratings) {

        int n = foods.length;
        for (int i = 0; i < n; i++) {

            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];
            FoodRating foodRating = new FoodRating(food, cuisine, rating);

            foodRatingMap.put(food, foodRating);
            cuisineMap.computeIfAbsent(cuisine, _ -> new TreeSet<>()).add(foodRating);
        }
    }

    public void changeRating(String food, int newRating) {

        if (!foodRatingMap.containsKey(food)) return;

        FoodRating foodRating = foodRatingMap.get(food);
        String cuisine = foodRating.cuisine;
        cuisineMap.get(cuisine).remove(foodRating);
        foodRating.rating = newRating;
        cuisineMap.get(cuisine).add(foodRating);

    }

    public String highestRated(String cuisine) {

        TreeSet<FoodRating> foodRatings = cuisineMap.get(cuisine);
        if (foodRatings == null || foodRatings.isEmpty()) return null;
        return foodRatings.first().food;
    }


}

class FoodRating implements Comparable<FoodRating> {

    public FoodRating(String food, String cuisine, int rating) {
        this.food = food;
        this.cuisine = cuisine;
        this.rating = rating;
    }

    String food;
    String cuisine;
    int rating;

    @Override
    public int compareTo(FoodRating other) {
        int ratingComparison = Integer.compare(other.rating, this.rating);
        if (ratingComparison == 0)
            return this.food.compareTo(other.food);
        return ratingComparison;
    }
}
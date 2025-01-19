package com.deeparishi.javaapp.dsaconcepts.greedyalgo.udemy.activity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ActivitySelectionProblem {

    public static void main(String[] args) {

        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("A1", 0, 6));
        activities.add(new Activity("A2", 3, 4));
        activities.add(new Activity("A3", 1, 2));
        activities.add(new Activity("A4", 5, 8));
        activities.add(new Activity("A5", 5, 7));
        activities.add(new Activity("A6", 8, 9));
        activitySelection(activities);
    }

    private static void activitySelection(List<Activity> activities) {

//        Comparator<Activity> activityComparator = Comparator.comparingInt(Activity::getFinishTime);
        Comparator<Activity> activityComparator = (a1, a2) -> a1.getFinishTime() - a2.getFinishTime();

        activities.sort(activityComparator);
        Activity prevActivity = activities.getFirst();
        System.out.println(prevActivity);

        for (int i = 1; i < activities.size(); i++) {
            if (activities.get(i).getStartTime() >= prevActivity.getFinishTime()) {
                System.out.println(activities.get(i));
                prevActivity = activities.get(i);
            }
        }
    }

}

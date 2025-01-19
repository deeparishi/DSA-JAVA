package com.deeparishi.javaapp.dsaconcepts.greedyalgo.udemy.activity;

public class Activity {

    private String activity;

    private int startTime;

    private int finishTime;

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    public Activity(String activity, int startTime, int finishTime) {
        this.activity = activity;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    public String getActivity() {
        return activity;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getFinishTime() {
        return finishTime;
    }


    @Override
    public String toString() {
        return "Activity{" +
                "activity='" + activity + '\'' +
                ", startTime=" + startTime +
                ", finishTime=" + finishTime +
                '}';
    }
}
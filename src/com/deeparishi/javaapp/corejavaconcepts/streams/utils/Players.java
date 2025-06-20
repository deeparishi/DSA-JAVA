package com.deeparishi.javaapp.corejavaconcepts.streams.utils;

import java.util.ArrayList;
import java.util.List;


public class Players {

    public String name;
    public Long score;
    public String teamName;

    public Players(String name, Long score, String teamName) {
        this.name = name;
        this.score = score;
        this.teamName = teamName;
    }

    public Players() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<Players> getPlayers() {
        List<Players> players = new ArrayList<>();
        players.add(new Players("John Brown", 135L, "Team 1"));
        players.add(new Players("Taylor Adams", 129L, "Team 1"));
        players.add(new Players("Casey Green", 121L, "Team 1"));
        players.add(new Players("Pat Clark", 71L, "Team 1"));
        players.add(new Players("Casey Smith", 96L, "Team 1"));
        players.add(new Players("Taylor Adams", 142L, "Team 1"));
        players.add(new Players("Jordan Johnson", 83L, "Team 1"));
        players.add(new Players("Chris Doe", 94L, "Team 1"));
        players.add(new Players("Blake White", 84L, "Team 1"));
        players.add(new Players("Taylor White", 123L, "Team 1"));
        players.add(new Players("Jordan Doe", 76L, "Team 2"));
        players.add(new Players("Casey Green", 149L, "Team 2"));
        players.add(new Players("Taylor Baker", 131L, "Team 2"));
        players.add(new Players("Jordan Adams", 62L, "Team 2"));
        players.add(new Players("Casey Johnson", 116L, "Team 2"));
        players.add(new Players("Blake Smith", 105L, "Team 2"));
        players.add(new Players("Jordan Davis", 81L, "Team 2"));
        players.add(new Players("Chris Doe", 118L, "Team 2"));
        players.add(new Players("Jordan Johnson", 59L, "Team 2"));
        players.add(new Players("Casey Smith", 146L, "Team 2"));
        return players;
    }

}
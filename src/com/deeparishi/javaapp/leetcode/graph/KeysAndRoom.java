package com.deeparishi.javaapp.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/keys-and-rooms/submissions/1460765709/?envType=problem-list-v2&envId=graph

public class KeysAndRoom {

    public static void main(String[] args) {

        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(List.of(1,3));
        rooms.add(List.of(3,0,1));
        rooms.add(List.of(2));
        rooms.add(List.of(0));
        System.out.println(canVisitAllRooms(rooms));
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] visited = new boolean[rooms.size()];

        dfs(0, visited, rooms);

        for (boolean visit : visited) {
            if (!visit)
                return false;
        }

        return true;
    }

    private static void dfs(int room, boolean[] visited, List<List<Integer>> rooms) {
        if(visited[room])
            return;
        visited[room] = true;

        for (int key : rooms.get(room))
            dfs(key, visited, rooms);
    }
}

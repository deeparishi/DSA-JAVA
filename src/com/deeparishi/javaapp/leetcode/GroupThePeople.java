package com.deeparishi.javaapp.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupThePeople {
    public static void main(String[] args) {
        List<List<Integer>> ans = groupThePeople(new int[]{3,3,3,3,3,1,3});
        System.out.println(ans);
    }
    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> groupsMap = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];

            // If a group with the current size doesn't exist, create a new one
            if (!groupsMap.containsKey(size)) {
                groupsMap.put(size, new ArrayList<>());
            }

            // Add the person to the group
            List<Integer> currentGroup = groupsMap.get(size);
            currentGroup.add(i);

            // If the group becomes full, add it to the result and create a new group
            if (currentGroup.size() == size) {
                result.add(currentGroup);
                groupsMap.put(size, new ArrayList<>());
            }
        }

        return result;
    }
}

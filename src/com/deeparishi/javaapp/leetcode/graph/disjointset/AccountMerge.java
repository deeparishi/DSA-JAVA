package com.deeparishi.javaapp.leetcode.graph.disjointset;

import com.deeparishi.javaapp.leetcode.graph.disjointset.utils.DisjointSet;

import java.util.*;

// https://leetcode.com/problems/accounts-merge
public class AccountMerge {

    public static void main(String[] args) {

        List<List<String>> accounts = Arrays.asList(
                Arrays.asList("Alice", "alice@mail.com"),
                Arrays.asList("Bob", "bob@mail.com"),
                Arrays.asList("Alice", "alice@mail.com", "alice.work@mail.com"),
                Arrays.asList("Bob", "bob@mail.com", "bob.work@mail.com")
        );

        List<List<String>> accounts2 = Arrays.asList(
                Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                Arrays.asList("Mary", "mary@mail.com"),
                Arrays.asList("John", "johnnybravo@mail.com")
        );


        System.out.println(new AccountMerge().accountsMerge(accounts2));

    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int size = accounts.size();
        DisjointSet ds = new DisjointSet(size);
        Map<String, Integer> map = new HashMap<>();

        // Step - 1
        for (int i = 0; i < size; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (!map.containsKey(mail))
                    map.put(mail, i);
                else
                    ds.union(i, map.get(mail));
            }
        }

        // Step 2
        ArrayList<String>[] mergedMails = new ArrayList[size];

        for (int i = 0; i < size; i++)
            mergedMails[i] = new ArrayList<>();

        for (Map.Entry<String, Integer> mails : map.entrySet()) {
            String mail = mails.getKey();
            int val = mails.getValue();
            int node = ds.find(val);
            mergedMails[node].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            if(mergedMails[i].isEmpty()) continue;
            Collections.sort(mergedMails[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).getFirst());
            temp.addAll(mergedMails[i]);
            ans.add(temp);
        }

        return ans;
    }
}

package com.deeparishi.javaapp.leetcode.stack;

import java.util.*;

public class DesignTwitter {

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.postTweet(1, 3);
        twitter.postTweet(1, 101);
        twitter.postTweet(1, 13);
        twitter.postTweet(1, 10);
        twitter.postTweet(1, 2);
        twitter.postTweet(1, 94);
        twitter.postTweet(1, 505);
        twitter.postTweet(1, 333);
        twitter.postTweet(1, 22);
        twitter.postTweet(1, 11);
        List<Integer> newsFeed = twitter.getNewsFeed(1);
        System.out.println(newsFeed);
    }


}

class Twitter {

    public int timestamp;

    Map<Integer, Set<Integer>> followingMap;

    Map<Integer, List<Tweet>> tweetMap;

    public Twitter() {
        followingMap = new HashMap<>();
        tweetMap = new HashMap<>();
        timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new Tweet(tweetId, timestamp++));
    }

    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> followedUsers = new HashSet<>(followingMap.getOrDefault(userId, new HashSet<>()));
        followedUsers.add(userId);

        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.timestamp - a.timestamp);
        for (int followedUser : followedUsers) {
            List<Tweet> tweets = tweetMap.get(followedUser);
            if (tweets != null) {
                pq.addAll(tweets);
            }
        }

        List<Integer> newsFeed = new ArrayList<>();
        while (!pq.isEmpty() && newsFeed.size() < 10) {
            newsFeed.add(pq.poll().tweetId);
        }

        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {
        if(followerId != followeeId){
            followingMap.putIfAbsent(followerId, new HashSet<>());
            followingMap.get(followerId).add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> following = followingMap.get(followerId);
        if (following != null) {
            following.remove(followeeId);
        }
    }
}

class Tweet{

    int tweetId;

    int timestamp;

    public Tweet(int tweetId, int timestamp){
        this.tweetId = tweetId;
        this.timestamp = timestamp;
    }

}
package com.deeparishi.javaapp.miscellaneous.videosharingplatform;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class VideoSharingPlatform {

    private int count;

    private final Queue<Integer> countQueue;

    private final Map<Integer, Video> videoMap;

    public VideoSharingPlatform() {
        count = 0;
        countQueue = new LinkedList<>();
        videoMap = new HashMap<>();
    }

    public int upload(String video) {
        Video vid = new Video();
        vid.setVideo(video);
        if (!countQueue.isEmpty()) {
            int polled = countQueue.poll();
            videoMap.put(polled, vid);
            return polled;
        }
        videoMap.put(count, vid);
        count++;
        return count - 1;
    }

    public void remove(int videoId) {
        if (videoMap.containsKey(videoId)) {
            countQueue.add(videoId);
            videoMap.remove(videoId);
        }
    }

    public String watch(int videoId, int startMinute, int endMinute) {
        if (videoMap.containsKey(videoId)) {
            Video video = videoMap.get(videoId);
            video.setViews(video.getViews() + 1);
            int endIndex = Math.min(endMinute + 1, video.getVideo().length());
            return video.getVideo().substring(startMinute, endIndex);
        }
        return "-1";
    }

    public void like(int videoId) {
        Video video = videoMap.get(videoId);
        video.setLike(video.getLike() + 1);
    }

    public void dislike(int videoId) {
        Video video = videoMap.get(videoId);
        video.setDislike(video.getLike() + 1);
    }

    public int[] getLikesAndDislikes(int videoId) {
        if (videoMap.containsKey(videoId)) {
            Video video = videoMap.get(videoId);
            return new int[]{video.getLike(), video.getDislike()};
        }
        return new int[]{-1};
    }

    public int getViews(int videoId) {
        if (videoMap.containsKey(videoId)) {
            Video video = videoMap.get(videoId);
            return video.getViews();
        }
        return -1;
    }

}
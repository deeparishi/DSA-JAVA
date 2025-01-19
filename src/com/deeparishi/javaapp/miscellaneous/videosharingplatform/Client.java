package com.deeparishi.javaapp.miscellaneous.videosharingplatform;

import java.util.Arrays;

// https://leetcode.ca/2022-05-26-2254-Design-Video-Sharing-Platform/

public class Client {

    public static void main(String[] args) {

        VideoSharingPlatform vsp = new VideoSharingPlatform();
        System.out.println(vsp.upload("123"));
        System.out.println(vsp.upload("456"));
        vsp.remove(4);
        vsp.remove(0);
        System.out.println(vsp.upload("789"));
        System.out.println(vsp.watch(1, 0, 5));
        System.out.println(vsp.watch(1, 0, 1));
        vsp.like(1);
        vsp.dislike(1);
        vsp.dislike(1);
        System.out.println(Arrays.toString(vsp.getLikesAndDislikes(1)));
        System.out.println(vsp.getViews(1));

    }
}

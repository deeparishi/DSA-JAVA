package com.deeparishi.javaapp.learning.solid.lsp.sol.serviceimpl;

import com.deeparishi.javaapp.learning.solid.lsp.sol.iservice.PostMediaManager;
import com.deeparishi.javaapp.learning.solid.lsp.sol.iservice.SocialMedia;
import com.deeparishi.javaapp.learning.solid.lsp.sol.iservice.VideoCallManager;

public class Facebook implements PostMediaManager, SocialMedia, VideoCallManager {

    @Override
    public void publishPost(Object post) {

    }

    @Override
    public void chatWithFriend() {

    }

    @Override
    public void sendPhotosAndVideos() {

    }

    @Override
    public void groupVideoCall(String... users) {

    }
}

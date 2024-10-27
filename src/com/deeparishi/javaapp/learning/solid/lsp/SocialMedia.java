package com.deeparishi.javaapp.learning.solid.lsp;

/**
 * L - LISKOV SUBSTITUTION PRINCIPLE

 * Applies to such a way that the derived classes must be completely substitutable for thier base classes.
 * If Class A is subtype of class B then we should be able to replace the class B without interrupting the
   behaviour of the program

 * In below methods some things are not supported by some medium still we are extending,
   it does not over the Liskov's Principle

 **/

public abstract class SocialMedia {

    //@support WhatsApp,Facebook,Instagram
    public abstract  void chatWithFriend();

    //@support Facebook,Instagram
    public abstract void publishPost(Object post);

    //@support WhatsApp,Facebook,Instagram
    public abstract  void sendPhotosAndVideos();

    //@support WhatsApp,Facebook
    public abstract  void groupVideoCall(String... users);

}

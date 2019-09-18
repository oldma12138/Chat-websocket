package com.ccq.pojo;

public class Friend {
    private String friend_1;
    private String friend_2;
    private String currentUser;
    private String friendName;

    public String getFriend_1() {
        return friend_1;
    }

    public void setFriend_1(String friend_1) {
        this.friend_1 = friend_1;
    }

    public String getFriend_2() {
        return friend_2;
    }

    public void setFriend_2(String friend_2) {
        this.friend_2 = friend_2;
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "friend_1='" + friend_1 + '\'' +
                ", friend_2='" + friend_2 + '\'' +
                ", currentUser='" + currentUser + '\'' +
                ", friendName='" + friendName + '\'' +
                '}';
    }
}

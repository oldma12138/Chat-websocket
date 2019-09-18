package com.ccq.pojo;

import java.util.Date;

public class AddFriend {
    public static final String ALLOW="Y";
    public static final String DISALLOW="N";

    private String friend_1;
    private String friend_2;
    private String f1_allow;
    private String f2_allow;
    private String currentUser;
    private String friendName;
    private Date addtime;
    private String time;
    private int id;


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

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

    public String getF1_allow() {
        return f1_allow;
    }

    public void setF1_allow(String f1_allow) {
        this.f1_allow = f1_allow;
    }

    public String getF2_allow() {
        return f2_allow;
    }

    public void setF2_allow(String f2_allow) {
        this.f2_allow = f2_allow;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AddFriend{" +
                "friend_1='" + friend_1 + '\'' +
                ", friend_2='" + friend_2 + '\'' +
                ", f1_allow='" + f1_allow + '\'' +
                ", f2_allow='" + f2_allow + '\'' +
                ", currentUser='" + currentUser + '\'' +
                ", friendName='" + friendName + '\'' +
                ", addtime=" + addtime +
                ", time='" + time + '\'' +
                ", id=" + id +
                '}';
    }
}

package com.ccq.service;

import java.util.List;

public interface FriendService {
   public List<com.ccq.pojo.Friend> findFriendByName(String username);//查询好友
    public void addnewFriend(com.ccq.pojo.Friend friend); //将都为同意的好友添加到好友列表
    public List<com.ccq.pojo.Friend> findFriendByName2(String username);
}

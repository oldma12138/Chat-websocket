package com.ccq.mapper;

import java.util.List;

public interface Friend {
     List<com.ccq.pojo.Friend> findFriendByName(String username);//查询所有包含名字的好友
     List<com.ccq.pojo.Friend> findFriendByName2(String username);//查询好友为friend1的所有
     void addnewFriend(com.ccq.pojo.Friend friend); //将都为同意的好友添加到好友列表
}

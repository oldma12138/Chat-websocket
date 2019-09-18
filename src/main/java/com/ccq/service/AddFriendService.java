package com.ccq.service;

import java.util.List;

public interface AddFriendService {
    public void addFriend(com.ccq.pojo.AddFriend addFriend);//添加好友
    public List<com.ccq.pojo.AddFriend> findFriendRequest(String userName);//查找被添加好友的请求
   public com.ccq.pojo.AddFriend responseMessage(String userName);//查找好友响应，已经有结果
    public com.ccq.pojo.AddFriend delFriendRequest (String userName);//删除已经有结果的添加请求
    public  void friendReqResp(com.ccq.pojo.AddFriend addFriend);//同意 或者 拒绝好友
    com.ccq.pojo.AddFriend findaddfriend(String username,String byaddname);//查找朋友是否已经添加
}

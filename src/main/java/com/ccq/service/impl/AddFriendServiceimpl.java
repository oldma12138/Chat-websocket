package com.ccq.service.impl;

import com.ccq.pojo.AddFriend;
import com.ccq.service.AddFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AddFriendServiceimpl  implements AddFriendService {
    @Autowired
    com.ccq.mapper.AddFriend addFriend1;
    public void addFriend(AddFriend addFriend) {
        addFriend1.addFriend(addFriend);
    }

    public List<com.ccq.pojo.AddFriend>findFriendRequest(String userName) {
        return addFriend1.findFriendRequest(userName);
    }

    public AddFriend responseMessage(String userName) {
        return addFriend1.responseMessage(userName);
    }

    public AddFriend delFriendRequest(String userName) {
        return addFriend1.delFriendRequest(userName);
    }

    public void friendReqResp(AddFriend addFriend) {
        addFriend1.friendReqResp(addFriend);
    }

    public AddFriend findaddfriend(String username, String byaddname) {
        return addFriend1.findaddfriend(username,byaddname);
    }
}

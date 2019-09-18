package com.ccq.service.impl;

import com.ccq.pojo.Friend;
import com.ccq.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FriendServiceImpl  implements FriendService {
    @Autowired
    com.ccq.mapper.Friend friend1;
    public List<com.ccq.pojo.Friend> findFriendByName(String username) {
        return friend1.findFriendByName(username);
    }

    public void addnewFriend(Friend friend) {
        friend1.addnewFriend(friend);
    }

    public List<Friend> findFriendByName2(String username) {
        return friend1.findFriendByName2(username);
    }
}

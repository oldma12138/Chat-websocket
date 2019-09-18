package com.ccq.controller;

import com.ccq.pojo.AddFriend;
import com.ccq.pojo.Friend;
import com.ccq.service.AddFriendService;
import com.ccq.service.FriendService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class addfriend {
    //    void addFriend(com.ccq.pojo.AddFriend addFriend);//添加好友
//    com.ccq.pojo.AddFriend findFriendRequest(String userName);//查找添加好友的响应，还没有结果
//    com.ccq.pojo.AddFriend responseMessage(String userName);//查找好友响应，已经有结果
//    com.ccq.pojo.AddFriend delFriendRequest (String userName);//删除已经有结果的添加请求
//    void friendReqResp(com.ccq.pojo.AddFriend addFriend);//同意 或者 拒绝好友
    @Autowired
    AddFriendService addFriendService;
    @Autowired
    FriendService friendService;


    @RequestMapping("/add")
    @ResponseBody
    public String add(String username, HttpSession session) throws Exception {


            String username1 = (String) session.getAttribute("userid");
            com.ccq.pojo.AddFriend addFriend = new com.ccq.pojo.AddFriend();
            System.out.println(username1+"添加好友"+username);
            com.ccq.pojo.AddFriend addFrien=addFriendService.findaddfriend(username1,username);
            if (addFrien!=null){
                return "2";
            }else {
                try {
            addFriend.setFriend_1(username1);
            addFriend.setFriend_2(username);
            addFriend.setF1_allow("Y");
            addFriend.setAddtime(new Date());
                    System.out.println(new Date());
            addFriendService.addFriend(addFriend);
            return "1";
        } catch (Exception EX) {
            System.out.println(EX);
            return "0";
        }
        }
    }

    //查找被添加的通知
    @RequestMapping(value="/findFriendRequest" ,method= RequestMethod.GET)
    @ResponseBody
    public List<com.ccq.pojo.AddFriend> findFriendRequest(HttpSession session) throws Exception {
        System.out.println("findFriendRequest 执行了 ");
        String username = (String) session.getAttribute("userid");
        ObjectMapper objectMapper = new ObjectMapper();
        //如何不返回时间戳，关闭时间戳功能
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);

        //时间格式化问题
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //3.让mapper 指定时间日期的格式
        objectMapper.setDateFormat(simpleDateFormat);
        //格式化日期

        List<AddFriend> friendRequest = addFriendService.findFriendRequest(username);
        for (AddFriend addFriend : friendRequest) {
            addFriend.setTime(objectMapper.writeValueAsString(addFriend.getAddtime()));
        }
        System.out.println(friendRequest);
        return friendRequest;
    }

    //同意好友
    @RequestMapping("/agree")
    @ResponseBody
    public String agree(HttpSession session ,String addname) {
        try{
            System.out.println(addname);
        com.ccq.pojo.AddFriend addFriend = new com.ccq.pojo.AddFriend();
        com.ccq.pojo.Friend friend=new com.ccq.pojo.Friend();
        com.ccq.pojo.Friend friend1=new com.ccq.pojo.Friend();
        String username = (String) session.getAttribute("userid");
        addFriend.setFriend_2(username);
        friend.setFriend_1(username);
        friend1.setFriend_1(addname);
        addFriend.setFriend_1(addname);
        friend.setFriend_2(addname);
        friend1.setFriend_2(username);
        addFriend.setF2_allow("Y");
        addFriendService.friendReqResp(addFriend);
        friendService.addnewFriend(friend);
        friendService.addnewFriend(friend1);
         return "1";
        } catch (Exception EX){
            System.out.println(EX);
            return "0";
        }


    }

    //拒绝好友
    @RequestMapping("/disagree")
    @ResponseBody
    public String disagree(HttpSession session ,String  addname) {
        com.ccq.pojo.AddFriend addFriend = new com.ccq.pojo.AddFriend();
        String username = (String) session.getAttribute("userid");

        addFriend.setFriend_2(username);
        addFriend.setF2_allow("N");

        return "dissuccess";
    }

    //查询所有朋友
    @RequestMapping("/findFriendbyname")
    @ResponseBody
    public String findFriendbyname(HttpSession session, String username) throws Exception {
        System.out.println("/findFriendbyname");
        System.out.println("查找好友的名字"+username);
       String userid=(String) session.getAttribute("userid");
        System.out.println("本地名字"+userid);//3.本地id

        int count=0;
        List<String> strings;
        List<Friend> username1 = friendService.findFriendByName2(userid);
        for (Friend friend : username1) {
                if(friend.getFriend_2().equals(username)){
                    count++;
                }
        }
        if (count>0){
            String cou=Integer.toString(count);
            return cou;

        }else
            return "0";



    }
}

package com.ccq.test;

import com.ccq.mapper.AddFriend;
import com.ccq.mapper.Friend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class test {
  @Autowired
    Friend friend;
  @Autowired
    AddFriend addFriend;
  @Test
    public void run1(){
      //查找好友
//      com.ccq.pojo.Friend aha = friend.findFriendByName("aha");
//      System.out.println(aha);
      //添加好友
//      com.ccq.pojo.AddFriend addFriend1=new com.ccq.pojo.AddFriend();
//      addFriend1.setF1_allow("Y");
//      addFriend1.setFriend_1("张三");
//      addFriend1.setFriend_2("李四");
//      addFriend.addFriend(addFriend1);

      //查询好友请求 tip:李四的好友请求
//      com.ccq.pojo.AddFriend addFriend2 = addFriend.findFriendRequest("李四");
//      System.out.println(addFriend2);
      //查找好友响应结果
      com.ccq.pojo.AddFriend addFriend3 = this.addFriend.responseMessage("张三");
      System.out.println(addFriend3);
      //删除添加失败结果
//        addFriend.delFriendRequest("张三");
      //拒绝张三的申请
//      com.ccq.pojo.AddFriend addFriend4  = new com.ccq.pojo.AddFriend();
//      addFriend4.setFriend_2("李四");
//      addFriend4.setF2_allow("N");
//        addFriend.friendReqResp(addFriend4);
//      com.ccq.pojo.Friend friend4=new com.ccq.pojo.Friend();
//      friend4.setFriend_1("张三");
//      friend4.setFriend_2("王五");
//      friend.addnewFriend(friend4);
            List<com.ccq.pojo.Friend> friend2= friend.findFriendByName("张三");
      for (com.ccq.pojo.Friend friend1 : friend2) {
          System.out.println(friend1.getFriend_2());
          System.out.println(friend1.getFriend_1());

      }



  }
  @Test
  public void  run2(){
      com.ccq.pojo.AddFriend addFrien=addFriend.findaddfriend("张三","李黑");
      System.out.println(addFrien);



  }
  @Test
    public  void  run3(){
      List<com.ccq.pojo.AddFriend> ad=addFriend.findFriendRequest("张三");
      System.out.println(ad);
  }
    @Test
    public  void run4(){
        com.ccq.pojo.AddFriend addFriend1 = new com.ccq.pojo.AddFriend();
        addFriend1.setFriend_2("子家");
        addFriend1.setFriend_1("振业");
        addFriend1.setF2_allow("Y");
      addFriend.friendReqResp(addFriend1);
    }
    @Test
    public  void  run5(){
      List<com.ccq.pojo.Friend> aha = friend.findFriendByName("aha");
      System.out.println(aha);
    }
}

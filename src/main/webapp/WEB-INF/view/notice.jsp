<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/9/3
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>系统通知</title>
    <jsp:include page="include/commonfile.jsp"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="include/header.jsp"/>
<div class="am-cf admin-main">
    <jsp:include page="include/sidebar.jsp"/>

    <div class="admin-content">
        <div class="am-cf am-padding">
            <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">好友通知</strong> / <small>notice</small></div>
        </div>
    <ul id="myTab" class="nav nav-tabs">
        <li class="active">
            <a href="#home" data-toggle="tab">
                添加好友通知
            </a>
        </li>
        <li><a href="#ios" data-toggle="tab" >被添加通知</a></li>
        <li class="dropdown">
            <a href="#" id="myTabDrop1" class="dropdown-toggle"
               data-toggle="dropdown">Java
                <b class="caret"></b>
            </a>
            <ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop1">
                <li><a href="#jmeter" tabindex="-1" data-toggle="tab">jmeter</a></li>
                <li><a href="#ejb" tabindex="-1" data-toggle="tab">ejb</a></li>
            </ul>
        </li>
    </ul>
    <div id="myTabContent" class="tab-content">
        <div class="tab-pane fade in active" id="home">
            <!-- content start -->

                <div class="am-tabs am-margin">
                    <table class="am-table am-table-striped">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>本地id</th>
                            <th>添加id</th>
                            <th>添加时间</th>
                            <th>详情</th>

                        </tr>
                        </thead>
                        <tbody id="byaddcontext" id="btnnn">

                        </tbody>

                    </table>
                    <div id="page" style="float: right"></div>
                </div>

            <!-- content end -->
        </div>

        <div class="tab-pane fade" id="ios">
            <table class="am-table am-table-striped">
                <thead>
                <tr>
                    <th>#</th>
                    <th>本地id</th>
                    <th>添加id</th>
                    <th>添加时间</th>
                    <th></th>
                    <th></th>

                </tr>
                </thead>
                <tbody id="context">

                </tbody>
            </table>





        </div>
        <div class="tab-pane fade" id="jmeter">
            <p>jMeter 是一款开源的测试软件。它是 100% 纯 Java 应用程序，用于负载和性能测试。</p>
        </div>
        <div class="tab-pane fade" id="ejb">
            <p>Enterprise Java Beans（EJB）是一个创建高度可扩展性和强大企业级应用程序的开发架构，部署在兼容应用程序服务器（比如 JBOSS、Web Logic 等）的 J2EE 上。
            </p>
        </div>
    </div>

    </div>


</div>
<a href="#" class="am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}">
    <span class="am-icon-btn am-icon-th-list"></span>
</a>
<jsp:include page="include/footer.jsp"/>

<script>
   //  //页面加载执行ajax
   // window.onload= function a1() {
   //      $.post("/findFriendRequest",function (data) {
   //          var html=""
   //          for(var i=0;i<data.length;i++){// id f1 f2 data tonyi jujue
   //              html+="<tr>"+
   //                  "<td>"+data[i].id+"</td>"+
   //                  "<td>"+data[i].friend_2+"</td>"+
   //                  "<td>"+data[i].friend_1+"</td>"+
   //                  "<td>"+data[i].data+"</td>"+
   //                  "<td>"+"<button type='button' class='btn btn-success'>"+"</td>"+
   //                  "<td>"+"<button type='button' class='btn btn-danger'>"+"</td>"+
   //                  "</tr>"
   //              $("#btnnn").html(html);
   //
   //          }
   //
   //      })
   //  }
   $(function (){

       $.ajax({
           type:"GET",
           url:"/findFriendRequest",
           dataType:"json",
           async:false,
           success:function(data){
               var html=""
                        for(var i=0;i<data.length;i++){// id f1 f2 data tonyi jujue
                            var userid= data.friend_1;
                            html+="<tr>"+
                                "<td>"+data[i].id+"</td>"+
                                "<td>"+data[i].friend_2+"</td>"+
                                "<td >"+data[i].friend_1+"</td>"+
                                "<td>"+data[i].time+"</td>"+
                                "<td>"+"<button id='sk' type='button' class='btn btn-success' onclick='addfriend1(\""+data[i].friend_1+"\")'>同意</button>"+"</td>"+
                                "<td>"+"<button id='sk2'type='button' class='btn btn-danger' onclick='agfriend1(\""+data[i].friend_1+"\")'>拒绝</button>"+"</td>"+
                                "</tr>"
                            $("#context").html(html);

                        }

           }

       });
   });
function addfriend1(userid) {

    $.post("/agree",{"addname":userid},function (data) {

        if (data=='1'){
                $("#sk").addClass('disabled');
            $("#sk2").addClass('disabled');
            alert("已同意，成功添加为好友")

        }else
            alert("添加失败")

    })




function agfriend1(userid) {
    $.post("disagree",{"addname":userid},function (data) {
        if (data=='1'){
            $("#sk").addClass('disabled');
            $("#sk2").addClass('disabled');
            alert("已经拒绝为添加其为好友")

        }else
            alert("删除失败")
    })
}
}


</script>
</body>
</html>

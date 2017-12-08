<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: song
  Date: 2016/10/28
  Time: 上午9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>

<!--页面头部-->
<section id="login_main">
    <div id="form_content">
        <form action="#" method="post">
        <c:if test="${sessionScope.get('userName')== null}">
            <label for="username">
                <b>用户名:</b>
                <input type="text" name="userName" id="username" placeholder="请输入用户名" onkeydown=KeyDown() >
                <span class="username_warning info_show" style="color: red"></span>
            </label><br>
            <label for="password">
                <b>密码:</b>
                <input type="password" name="passWord" id="password" placeholder="请输入密码" onkeydown=KeyDown() >
                <span class="password_warning info_hide">密码错误</span>
            </label>
            <br>
            <div class="btns">
                <input type="button" id="login_button" value="登录" onclick="ajaxSubmit()">
                <input type="button" id="cancel_button" value="取消">
            </div>
        </c:if>
        <c:if test="${sessionScope.get('userName')!= null}">
            <div>${sessionScope.get("userName")} &nbsp;：您好 &nbsp; &nbsp; &nbsp;<a href="javascript:toIndex('${sessionScope.get("department")}')">去首页</a></div>
            <div class="btns">
                <input type="button" value="登出" id="logout_button">
            </div>
        </c:if>
        </form>
    </div>
</section>
</body>
<script src="/js/jquery-2.2.1.min.js"></script>
<script>

        function KeyDown()
        {
            if (event.keyCode == 13)
            {
                event.returnValue=false;
                event.cancel = true;
                ajaxSubmit();
            }
        }



    function ajaxSubmit() {
        var data = $("form").serializeArray();
        var submitData = {};
        for(var key in data){
            submitData[data[key].name] = data[key].value;
        }
        $.ajax({
            type: "post",
            dataType: 'json',
            contentType : 'application/json',
            url:"/login/submit",
            data:JSON.stringify(submitData),
            success: function(data){
                if(data.status == 1){
                    toIndex(data.data);
                }else{
                    $(".username_warning").html("用户名或者密码错");
                    $(":password").val("");
                }
            },
            error: function(data){
                alert("系统异常");
            }
        });

    }


    $("#logout_button").click(function () {
        window.location = "/logout"
    });
    $("#cancel_button").click(function () {
        $("input[type=text]").val("");
        $("input[type=password]").val("");
    });
    function toIndex(department){
        if(department == "二科")
            window.location = "/d2/task/list"
        else if(department == "三科")
            window.location = "/d3/task/list"
        else if(department == "四科")
            window.location = "/d4/task/list"
        else if(department == "五科")
            window.location = "/d5/task/list"
        else if(department == "一科")
            window.location = "/d1/task/list"
        else if(department == "质量科")
            window.location = "/dq/task/list"
        else if(department == "admin")
            window.location = "/admin/user/list"
        else if(department == "六科")
            window.location = "/d6/task/list"
        else if(department == "七科")
            window.location = "/d7/task/list"
    }

</script>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="/js/jquery-2.2.1.min.js"></script>
<script>
    function hideBtn(){
        var hintMessage=document.getElementById("hintMessage");
        hintMessage.style.display="none";
    }
    function show_dialog(){
        var hintMessage=document.getElementById("hintMessage");
        hintMessage.style.display="block";
    }
    ajax();
     var show_message = setInterval("ajax()",10000);
    function ajax(){
        $.ajax({
            type: "GET",
            dataType: 'json',
            contentType : 'application/json',
            url:"/dq/queryTaskNumber",
            success: function(data){
                $(".num")[0].innerHTML = ''+data.processing;
                $(".num")[1].innerHTML = ''+data.change;
                if(data.processing > 0 || data.change > 0){
                    show_dialog();
                    clearInterval(show_message);
                    return;
                }
            },
            error: function(data){
                alert("与服务器断开连接");
                clearInterval(show_message);
                return;
            }
        });
    }
</script>

<div class="container">
    <!--页面头部-->
    <header id="header">
        <div class="header_main">
            <div class="header_top rt">
		<span class="glyphicon glyphicon-log-out lf">
			欢迎&nbsp;${sessionScope.get('userName')}&nbsp;登录黑龙江省食品药品审核查验中心
		</span>
            </div>
            <img class="lf" src="/images/logo.png" alt=""/>
            <div class="header_content lf">
                <b>
                    黑龙江省食品药品
                </b>
                <br>
        <span>
            审核查验中心
        </span>
            </div>
            <div id="logoff">
                <a href="/logout"><span></span>注销</a>
            </div>
        </div>
    </header>
    <section  id="main">
        <div class="row">
            <div  id="aside" class="col-md-2">
                <div class="aside">
                    <p>专家及检查员选派系统&gt;&gt;</p>
                    <ul class="tree">
                        <%--<c:if test="${sessionScope.get('department')== '一科'}">--%>
                            <%--<li  class="show">--%>
                                <%--<span class="open" onclick="setToggle(this)"> 一科</span>--%>
                                <%--<ul>--%>
                                    <%--<li><a href="/d1/experts/list">专家管理</a></li>--%>
                                    <%--<li><a href="/d1/task/list">任务管理</a></li>--%>
                                    <%--<li><a href="/tasklog/list/d1">变更记录</a></li>--%>
                                <%--</ul>--%>
                            <%--</li>--%>
                        <%--</c:if>--%>
                        <c:if test="${sessionScope.get('department')== '二科'}">
                            <li  class="show">
                                <span class="open" onclick="setToggle(this)"> 二科</span>
                                <ul>
                                    <li><a href="/dq/d2/listE">专家管理</a></li>
                                    <li><a href="/d2/task/list">任务管理</a></li>
                                    <li><a href="/tasklog/list/d2">变更记录</a></li>
                                </ul>
                            </li>
                        </c:if>
                        <c:if test="${sessionScope.get('department')== '三科'}">
                            <li  class="show">
                                <span class="open" onclick="setToggle(this)"> 三科</span>
                                <ul>
                                    <li><a href="/dq/d3/listE">专家管理</a></li>
                                    <li><a href="/d3/task/list">任务管理</a></li>
                                    <li><a href="/tasklog/list/d3">变更记录</a></li>
                                </ul>
                            </li>
                        </c:if>

                        <c:if test="${sessionScope.get('department')== '四科'}">
                            <li  class="show">
                                <span class="open" onclick="setToggle(this)"> 四科</span>
                                <ul>
                                    <li><a href="/dq/d4/listE">专家管理</a></li>
                                    <li><a href="/d4/task/list">任务管理</a></li>
                                    <li><a href="/tasklog/list/d4">变更记录</a></li>
                                </ul>
                            </li>
                        </c:if>

                        <c:if test="${sessionScope.get('department')== '五科'}">
                            <li  class="show">
                                <span class="open" onclick="setToggle(this)"> 五科</span>
                                <ul>
                                    <%--<li><a href="/d5/experts/list">专家管理</a></li>--%>
                                        <li><a href="/dq/d5/listE">专家管理</a></li>
                                        <li><a href="/d5/task/list">任务管理</a></li>
                                    <li><a href="/tasklog/list/d5">变更记录</a></li>
                                </ul>
                            </li>
                        </c:if>
                        <c:if test="${sessionScope.get('department')== '六科'}">
                            <li  class="show">
                                <span class="open" onclick="setToggle(this)"> 六科</span>
                                <ul>
                                    <li><a href="/dq/d6/listE">专家管理</a></li>
                                    <li><a href="/d6/task/list">任务管理</a></li>
                                    <li><a href="/tasklog/list/d6">变更记录</a></li>
                                </ul>
                            </li>
                        </c:if>
                        <c:if test="${sessionScope.get('department')== '七科'}">
                            <li  class="show">
                                <span class="open" onclick="setToggle(this)"> 七科</span>
                                <ul>
                                    <li><a href="/dq/d7/listE">专家管理</a></li>
                                    <li><a href="/d7/task/list">任务管理</a></li>
                                    <li><a href="/tasklog/list/d7">变更记录</a></li>
                                </ul>
                            </li>
                        </c:if>

                        <c:if test="${sessionScope.get('department')== '质量科'}">
                            <li  class="show">
                                <span class="open" onclick="setToggle(this)"> 质量科</span>
                                <ul>
                                    <%--<li><a href="/dq/task/list/department/d1">一科任务管理</a></li>--%>
                                    <li><a href="/dq/task/list/department/d2">二科任务管理</a></li>
                                    <li><a href="/dq/task/list/department/d3">三科任务管理</a></li>
                                    <li><a href="/dq/task/list/department/d4">四科任务管理</a></li>
                                    <li><a href="/dq/task/list/department/d5">五科任务管理</a></li>
                                    <li><a href="/dq/task/list/department/d6">六科任务管理</a></li>
                                    <li><a href="/dq/task/list/department/d7">七科任务管理</a></li>
                                    <%--<li><a href="/d1/task/list">一科专家管理</a></li>--%>
                                    <li><a href="/d2/experts/list">二科专家管理</a></li>
                                    <li><a href="/d3/experts/list">三科专家管理</a></li>
                                    <li><a href="/d4/experts/list">四科专家管理</a></li>
                                    <li><a href="/d5/experts/list">五科专家管理</a></li>
                                    <li><a href="/d6/experts/list">六科专家管理</a></li>
                                    <li><a href="/d7/experts/list">七科专家管理</a></li>
                                    <li><a href="/tasklog/list">变更记录</a></li>
                                    <li><a href="/dq/experts/list">专家列表</a></li>
                                    <li><a href="/dq/task/list">主界面</a></li>
                                </ul>
                                </li>
                            <ul id="hintMessage">
                                <li>
                                    <b onclick="hideBtn();">x</b>
                                </li>
                                <li class="message">
                                    <a href="/dq/task/list">待处理</a>
                                    <span class="num"></span>
                                </li>
                                <li class="message">
                                    <a href="/dq/task/list">变更中</a>
                                    <span class="num"></span>
                                </li>
                            </ul>

                        </c:if>
                        <c:if test="${sessionScope.get('department')== 'admin'}">
                            <li  class="show">
                                <span class="open" onclick="setToggle(this)"> 管理员</span>
                                <ul>
                                    <li><a href="/admin/user/list">用户管理</a></li>
                                    <li><a href="/tasklog/list">质量科变更记录</a></li>
                                    <li><a href="/expertscdlog/list">专家增加删除记录</a></li>
                                    <li><a href="/expertsuplog/list">专家修改记录</a></li>
                                </ul>
                            </li>
                        </c:if>
                    </ul>
                </div>

            </div>
            <div class="col-md-10">
                <div class="sel_main lf">
                    <div id="root">
                    </div>
                    <div id="example">
                    </div>
                </div>
            </div>
        </div>
    </section>

    </section>
    <footer id="foot">
        <div class="copyright">
            Copyright&nbsp;&#169;&nbsp;2004-2016&nbsp;&nbsp;kaiyingtec.com&nbsp;版权所有
        </div>
    </footer>
</div>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <!--页面头部-->
    <header id="header">
        <div class="header_main">
            <div class="header_top rt">
				<span class="glyphicon glyphicon-log-out lf">
					欢迎,xxx 登录黑龙江省食品药品审核查验中心自动化系统
				</span>
            </div>
            <img class="lf" src="/images/logo.png" alt=""/>
            <div class="header_content lf">
                <b>
                    黑龙江省食品药品
                </b>
                <br>
                <span>
                    审核查验中心药品
                </span>
            </div>
            <div id="logoff">
                <a href="#"><span></span>注销</a>
            </div>
        </div>
    </header>
    <section  id="main">
        <div class="aside lf">
            <p>您的办公系统&gt;&gt;</p>
            <ul class="tree">
                <li  class="show">
                    <span class="open" onclick="setToggle(this)"> 二科</span>
                    <ul>
                        <li><a href="">专家管理</a></li>
                        <li><a href="">任务管理</a></li>
                        <li><a href="">变更记录</a></li>
                    </ul>
                </li>
                <li  class="hide">
                    <span class="open" onclick="setToggle(this)"> 三科</span>
                    <ul>
                        <li><a href="">专家管理</a></li>
                        <li><a href="">任务管理</a></li>
                        <li><a href="">变更记录</a></li>
                    </ul>
                </li>
                <li  class="show">
                    <span class="open"  onclick="setToggle(this)"> 质量科</span>
                    <ul>
                        <li><a href="">任务管理</a></li>
                        <li><a href="">变更记录</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="sel_main lf">
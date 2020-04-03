<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2020/3/9
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理员登录</title>
    <%String path = request.getContextPath();%>
    <link rel="stylesheet" href=<%=path+"/layui/css/layui.css" %>>
    <script src="<%=path+"/js/jquery-3.4.1.js"%>"></script>
    <script charset="UTF-8" src="<%=path+"/layui/layui.js"%>"></script>
    <script src="<%=path+"/back/js/UserLogin.js"%>"></script>
</head>
<style>
    .login {
        margin-top: 15%;
        padding: 2% 0;
        width: 28%;
        background-color: #FFF;
    }
    .layui-form{
        margin-top: 5%;
    }
</style>
<body>
<input type="hidden" id="path" value="<%=path%>">
<%--<img src="image/login01.png"style="width: 100%;height: 100%" />--%>
<div class="layui-main login">
    <h2 style="text-align: center">文档分享平台登录</h2>
   <form class="layui-form" action="${pageContext.request.contextPath}/admin/UserLogin" method="post" onsubmit="return false;" ><%-- onsubmit="return false"--%>
        <div class="layui-form-item login-div">
            <label class="layui-form-label username-lable">账号：</label>
            <div class="layui-input-inline">
                <input type="text" name="username" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码：</label>
            <div class="layui-input-inline">
                <input type="password" name="userpwd" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" type="submit" lay-submit lay-filter="subForm">登录</button>

                <button data-method="dialog" class="layui-btn" lay-filter="add">注册</button>
            </div>
        </div>
    </form>
</div>
<script>
</script>
</body>
</html>

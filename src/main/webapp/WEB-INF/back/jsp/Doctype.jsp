<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>文档配置</title>
    <%String path = request.getContextPath();%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
    <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <script src="${pageContext.request.contextPath}/back/js/Doctype.js"></script>
</head>
<body>
<input type="hidden" id="path" value="<%=path%>">
<form class="layui-form" action="" onsubmit="return false;">
    <div class="layui-form-item login-div"id="demotable" style="margin-top: 5%">
        <label class="layui-form-label username-lable">文档格式：</label>
        <div class="layui-input-inline">
            <input type="text" name="typename" placeholder="请输入文档格式" class="layui-input">
        </div>
        <button class="layui-btn" lay-submit lay-filter="subForm">查询</button>
    </div>
</form>
   <table class="layui-table" id="demo" lay-filter="demoTest"></table>
<script type="text/html" id="barDemo">
    <button type="button" class="layui-btn layui-btn-primary layui-btn-xs" lay-event="adds">添加</button>
    <button type="button"  class="layui-btn layui-btn-xs" lay-event="edit">编辑</button>
    <button type="button" class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</button>
</script>
</body>
</html>

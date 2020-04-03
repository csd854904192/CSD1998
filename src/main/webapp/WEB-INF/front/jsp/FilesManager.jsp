<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>动态表格</title>
    <%String path = request.getContextPath();%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
    <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <script src="${pageContext.request.contextPath}/front/js/FileManager.js"></script>
</head>
<body>
<input type="hidden" id="path" value="<%=path%>">
<form class="layui-form" action="" onsubmit="return false;">
    <div class="layui-form-item login-div"id="demotable" style="margin-top: 5%">
        <label class="layui-form-label username-lable">文档名：</label>
        <div class="layui-input-inline">
            <input type="text" name="docname" id="docname" placeholder="请输入文档名" class="layui-input">
        </div>
        <label class="layui-form-label doctime1-lable">文档时间：</label>
        <div class="layui-input-inline">
            <input type="date" name="updoctime1" id="updoctime1" placeholder="请输入起始时间" class="layui-input laydate">
        </div>
        <div class="layui-input-inline">
            <input type="date" name="updoctime2" id="updoctime2" placeholder="请输入最终时间" class="layui-input laydate">
        </div>
        <button class="layui-btn" lay-submit lay-filter="subForm">查询</button>
    </div>
</form>
   <table class="layui-table" id="demo" lay-filter="demoTest"></table>
<script type="text/html" id="barDemo">
    <button type="button" class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</button>
    <button type="button"  class="layui-btn layui-btn-xs" lay-event="edit">编辑</button>
    <button type="button" class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</button>
</script>
</body>
</html>

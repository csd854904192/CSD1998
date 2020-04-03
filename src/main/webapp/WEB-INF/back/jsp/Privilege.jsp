<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>动态表格</title>
    <%String path = request.getContextPath();%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
    <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <script src="${pageContext.request.contextPath}/back/js/Privilege.js"></script>
</head>
<body>
<input type="hidden" id="path" value="<%=path%>">
<table class="layui-table" id="demo" lay-filter="demoTest"></table>
<script type="text/html" id="barDemo">
    <button type="button" data-method="dialog" class="layui-btn layui-btn-xs" lay-event="carte">菜单权限</button>
</script>
</body>
</html>

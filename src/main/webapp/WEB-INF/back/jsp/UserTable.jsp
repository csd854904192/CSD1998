<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2020/3/9
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>静态表格</title>
    <%String path = request.getContextPath();%>
    <link rel="stylesheet" href=<%=path+"/layui/css/layui.css" %>>
    <script src="<%=path+"/js/jquery-3.4.1.js"%>"></script>
    <script charset="UTF-8" src="<%=path+"/layui/layui.js"%>"></script>
</head>
<style>
    table{
        border: 1px solid;
        width: 50%!important;
        margin: 2%!important;
    }

    td,th{
    border: 1px solid!important;
    }
</style>
<body>
<input type="hidden" id="path" value="<%=path%>">
<table class="layui-table" lay-even lay-skin="line" lay-size="lg">
    <colgroup>
        <col width="150">
        <col width="200">
        <col>
    </colgroup>
    <thead>
    <tr>
        <th>ID</th>
        <th>昵称</th>
        <th>密码</th>
    </tr>
    </thead>
    <tbody id="content">
    <tr>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}"></tr>
    </tbody>
</table>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs" data-method="dialog" lay-event="add" id="add">添加</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script src="${pageContext.request.contextPath}/back/js/UserTable.js"></script>
</body>
</html>

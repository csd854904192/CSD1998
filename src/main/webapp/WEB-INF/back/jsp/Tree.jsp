<%--
  Created by IntelliJ IDEA.
  User: junlong
  Date: 2019-11-13
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <title>树组件</title>
    <%String path = request.getContextPath();%>
    <link rel="stylesheet" href=<%=path+"/layui/css/layui.css" %>>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script charset="UTF-8" src="<%=path+"/layui/layui.js"%>"></script>
    <script  src="${pageContext.request.contextPath}/back/js/Tree.js"></script>
</head>
<body>
<input type="hidden" id="path" value="<%=path%>">
<div><input type="hidden" name="roleid" id="roleid"></div>
<button type="button" class="layui-btn layui-btn-normal" id="selectm" onclick="findMenus()">查询</button>
<button type="button" class="layui-btn layui-btn-normal" id="subupdate" onclick="subUpdate()">确认提交</button>
<div id="test1"></div>
</body>
</html>
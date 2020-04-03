<%--
  Created by IntelliJ IDEA.
  User: junlong
  Date: 2019-12-24
  Time: 8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
  <title>layui</title>
  <%String path = request.getContextPath();%>
  <link rel="stylesheet" href=<%=path+"/layui/css/layui.css" %>>
  <script src="<%=path+"/js/jquery-3.4.1.js"%>"></script>
  <script charset="UTF-8" src="<%=path+"/layui/layui.js"%>"></script>
</head>
<body>
<ul>
  <input type="hidden" id="path" value="<%=path%>">
  <li style="text-align: center"><a href="${pageContext.request.contextPath}/admin/path/userLogin">管理员登录</a></li>
  <li style="text-align: center"><a href="${pageContext.request.contextPath}/admin/fPath/userLogin">用户登录</a></li>
<%--  <li><a href="${pageContext.request.contextPath}/WEB-INF/web/back/jsp/DynamicTable.jsp">数据表格</a></li>--%>

<%--  <li><a href="${pageContext.request.contextPath}/admin/path/userLogin">文件上传</a></li>--%>
<%--  <li><a href="${pageContext.request.contextPath}/WEB-INF/web/back/jsp/dialog.jsp">弹出层</a></li>--%>
</ul>
</body>
</html>

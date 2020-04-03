<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2020/3/9
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>菜单</title>
    <%String path = request.getContextPath();%>
    <link rel="stylesheet" href=<%=path+"/layui/css/layui.css" %>>
    <script charset="UTF-8" src="<%=path+"/layui/layui.js"%>"></script>
    <script src="${pageContext.request.contextPath}/front/js/FrontManager.js"></script>

</head>
<body class="layui-layout-body">
<input type="hidden" id="path" value="<%=path%>">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">菜单</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">控制台</a></li>
            <li class="layui-nav-item"><a href="">商品管理</a></li>
            <li class="layui-nav-item"><a href="">用户</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="">邮件管理</a></dd>
                    <dd><a href="">消息管理</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    欢迎您,${sessionScope.user.username} ${sessionScope.user.role.rolename}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/admin/Exit">退了</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <c:if test="${not empty menuMap}">
                    <c:forEach items="${menuMap}" step="1" var="i">
                        <li class="layui-nav-item layui-nav-itemed">
                            <a class="" href="javascript:;">${i.key}</a>
                            <dl class="layui-nav-child">
                                <c:forEach items="${i.value}" step="1" var="j">
                                    <dd>
                                        <a href="javascript:void(0)"
                                           title="${pageContext.request.contextPath}/${j.menuurl}"
                                           onclick="changePath(this)">${j.menuname}
                                        </a>
                                    </dd>
                                </c:forEach>
                            </dl>
                        </li>
                    </c:forEach>
                </c:if>
            </ul>
        </div>
    </div>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <iframe id="iframe_div" style="width: 100%;height: 100%;" name="iframe_div_iframe" src=" " height="100%" width="100%" ></iframe>
    </div>
    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>

</body>
</html>

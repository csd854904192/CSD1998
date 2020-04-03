<%--
  Created by IntelliJ IDEA.
  User: junlong
  Date: 2019-11-16
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>文件上传</title>
    <%String path = request.getContextPath();%>
    <link rel="stylesheet" href=<%=path+"/layui/css/layui.css" %>>
    <script src="<%=path+"/js/jquery-3.4.1.js"%>"></script>
    <script charset="UTF-8" src="<%=path+"/layui/layui.js"%>"></script>
    <script  src="${pageContext.request.contextPath}/front/js/upload.js"></script>
</head>
<body>
<input type="hidden" id="path" value="<%=path%>">
<%--<form class="layui-form" action="${pageContext.request.contextPath}/admin/upload" enctype="multipart/form-data" lay-filter="example">--%>
    <div class="layadmin-user-login-box layadmin-user-login-header">
        <h2>上传文件</h2>
    </div>
    <div class="layui-inline" style="width:500px;">
        <hr>
    </div>
    <div class="layadmin-user-login-box layadmin-user-login-header">
        <div class="layui-form-item">
            <label class="layui-form-label">书名：</label>
            <div class="layui-input-inline">
                <input type="text" name="documentScore" id="hideBookName" lay-verify="title" autocomplete="off"
                       class="layui-input"style="width: 300px" >
            </div>
        </div>
            <div class="layui-form-item">
                <label class="layui-form-label">内容信息：</label>
                <div class="layui-input-inline">
                    <textarea name="intro" id="intro" lay-verify="title" required autocomplete="off"
                           placeholder="请输入绘本信息"
                           class="layui-textarea" style="width: 300px;"></textarea>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">下载积分：</label>
                <div class="layui-input-inline">
                    <input type="text" name="downScore" id="downScore" lay-verify="title" required autocomplete="off"
                           placeholder="请输入积分"
                           class="layui-input" style="width: 300px;">
                </div>
            </div>
        <div style="padding-bottom: 10px;">
            <div class="layui-upload">
                <div class="layui-form-item">
                    <label class="layui-form-label">选择文件：</label>
                    <div class="layui-input-inline">
                        <label type="text" name="downScore" id="fileNames" required  lay-verify="title"  autocomplete="off"
                               class="layui-input"style="width: 200px" ></label>
                    </div>
                <button type="button" class="layui-btn layui-btn-normal" id="test8">选择文件</button>
            </div>
        </div>



<%--        <div class="layui-form-item">--%>
<%--            <label class="layui-form-label">新页数：</label>--%>
<%--            <div class="layui-input-inline">--%>
<%--                <input type="text" name="documentScore" id="pageNum" lay-verify="title" autocomplete="off"--%>

<%--                       class="layui-input"style="width: 300px">--%>
<%--            </div>--%>
<%--        </div>--%>

        <div class="demoTable">
            <div style="padding-bottom: 10px;">
                <div class="layui-upload">
                    <button type="button" class="layui-btn" id="test9"style="margin-left: 5%">上传文件</button>
                </div>
            </div>
        </div>
    </div>
<%--</form>--%>
</body>
</html>


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
    <title>注册用户</title>
    <%String path = request.getContextPath();%>
    <link rel="stylesheet" href=<%=path+"/layui/css/layui.css" %>>
    <script charset="UTF-8" src="<%=path+"/layui/layui.js"%>"></script>
<%--    <script  src="${pageContext.request.contextPath}/front/js/RegUser.js"></script>--%>
</head>
<body>
<input type="hidden" id="path" value="<%=path%>">
<form class="layui-form" action="${pageContext.request.contextPath}/admin/RegUser" lay-filter="test1">
      <div class="layui-form-item">
        <label class="layui-form-label">姓名：</label>
        <div class="layui-input-block">
            <input type="text" name="username" id="username" required  lay-verify="required" placeholder="请输入用户" autocomplete="on" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码框：</label>
        <div class="layui-input-inline">
            <input type="password" name="userpwd" id="userpwd" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">职业：</label>
        <div class="layui-input-block">
            <input type="text" name="occupation" id="occupation" required  lay-verify="required" placeholder="职业" autocomplete="on" class="layui-input">
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">学历：</label>
        <div class="layui-input-block">
            <input type="text" name="degree" id="degree" required  lay-verify="required"  placeholder="学历" autocomplete="on" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">手机号</label>
        <div class="layui-input-block">
            <input type="text" name="userphone" id="userphone" required  lay-verify="phone" autocomplete="on" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">性别 ：</label>
        <div class="layui-input-block">
            <input type="radio" name="usersex" value="男" title="男">
            <input type="radio" name="usersex" value="女" title="女" checked>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">邮箱</label>
        <div class="layui-input-block">
            <input type="text" name="email" id="email" required  lay-verify="required" autocomplete="on" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" type="submit" lay-submit lay-filter="updateForm" style="text-align: center">立即提交</button>
            <button class="layui-btn" lay-submit lay-filter="back" style="text-align: center" onclick="back()">取消</button>
        </div>
    </div>
</form>
</body>
<script>
    function back() {
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);//关闭弹出的子页面窗口 layer.index表示当前层
    }
</script>
</html>
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
    <title>修改文档格式</title>
    <%String path = request.getContextPath();%>
    <link rel="stylesheet" href=<%=path+"/layui/css/layui.css" %>>
    <script charset="UTF-8" src="<%=path+"/layui/layui.js"%>"></script>
</head>
<body>
<input type="hidden" id="path" value="<%=path%>">
<form class="layui-form" action="" lay-filter="test1" onsubmit="return false;">
    <div><input type="hidden" id="typeid" name="typeid"></div>
    <div class="layui-form-item">
        <label class="layui-form-label">文档格式：</label>
        <div class="layui-input-block">
            <input type="text" name="typename" id="typename" required  lay-verify="required" placeholder="请输入用户" autocomplete="on" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">奖励分：</label>
        <div class="layui-input-inline">
            <input type="text" name="bounty" id="bounty" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="updateForm" style="text-align: center">立即提交</button>
            <button class="layui-btn" lay-submit lay-filter="back" style="text-align: center" onclick="back()">取消</button>
        </div>
    </div>
</form>
</body>
<script>
    layui.use(['form','jquery'], function(){
        var $=layui.jquery;
        var form = layui.form;
        form.on('submit(updateForm)', function(data) {
            var typeid = $("#typeid").val();
            var typeInfo = JSON.stringify(data.field)
            var path = $("#path").val();
            $.ajax({
                url:path+'/admin/updateType',
                type:'post',
                data: {"typeid":typeid,"typeInfo":typeInfo},
                success:function(data){
                    if (data=="error"){
                        layer.alert("更新失败");
                    }else if (data=="success") {
                        layer.alert("更新成功",{icon:6},function () {
                            window.parent.location.reload();
                        });
                    }
                }, error: function () {
                    layer.alert("网络繁忙！")
                }
            });
        })
    })
</script>
</html>
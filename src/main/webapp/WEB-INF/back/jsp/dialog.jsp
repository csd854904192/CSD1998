<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>弹出层</title>
    <%String path = request.getContextPath();%>
    <link rel="stylesheet" href=<%=path+"/layui/css/layui.css" %>>
    <script charset="UTF-8" src="<%=path+"/layui/layui.js"%>"></script>
    <script  src="${pageContext.request.contextPath}/back/js/dialog.js"></script>
</head>
<body>
<input type="hidden" id="path" value="<%=path%>">
<button data-method="dialog" class="layui-btn">弹出层简单例子</button>
<script>

</script>

</body>
</html>
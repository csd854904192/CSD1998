<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>动态表格</title>
    <%String path = request.getContextPath();%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
    <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <script src="${pageContext.request.contextPath}/back/js/FileManager.js"></script>
</head>
<body>
<input type="hidden" id="path" value="<%=path%>">
<form class="layui-form" action="" onsubmit="return false;">
    <div class="layui-form-item login-div"id="demotable" style="margin-top: 2%">
        <label class="layui-form-label username-lable">文档名：</label>
        <div class="layui-input-inline">
            <input type="text" name="docname" id="docname" placeholder="请输入文档名" class="layui-input">
        </div>
        <label class="layui-form-label username-lable">上传用户：</label>
        <div class="layui-input-inline">
            <input type="text" name="docname" id="username" placeholder="用户名" class="layui-input">
        </div>
        <label class="layui-form-label doctime1-lable">文档时间：</label>
        <div class="layui-input-inline">
            <input type="date" name="updoctime1" id="doctime1" placeholder="请输入起始时间" class="layui-input">
        </div>
        <div class="layui-input-inline">
            <input type="date" name="updoctime2" id="doctime2" placeholder="请输入最终时间" class="layui-input">
        </div>
        <br/><br/><br/>
        <label class="layui-form-label doctime1-lable">文档类型：</label>
            <div class="layui-input-inline">
                <select name="interest" id="doctype" lay-filter="leixing">
                    <option value="" selected=""></option>
          <c:if test="${not empty dlist}">
            <c:forEach items="${dlist}" var="i" step="1">
           <option value="${i.typeid}"<c:if test="${type==i.typeid}">selected="selected"</c:if>>${i.typename}</option>
            </c:forEach>
          </c:if>
                </select>
            </div>
        <button class="layui-btn" lay-submit lay-filter="subForm">查询</button>
    </div>
</form>
   <table class="layui-table" id="demo" lay-filter="demoTest"></table>
<script type="text/html" id="barDemo">
    <button type="button" class="layui-btn layui-btn-primary layui-btn-xs" lay-event="down">下载</button>
    <button type="button"  class="layui-btn layui-btn-xs" lay-event="through">审核通过</button>
    <button type="button" class="layui-btn layui-btn-danger layui-btn-xs" lay-event="notThrough">审核不通过</button>
</script>
</body>
</html>

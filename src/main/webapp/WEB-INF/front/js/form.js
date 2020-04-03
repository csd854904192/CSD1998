layui.use('form', function(){
    var form = layui.form;
    var $ = layui.$;
    var path = $("#path").val();
    //监听提交
    form.on('submit(userForm)', function (data) {
        $.ajax({
            url: path + "/UserServlet?method=form",
            async: true,
            type: "POST",
            data:  data.field,
            datatype: "text",
            success: function (msg) {
                if (msg == 1111) {
                    alert("添加成功");
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);//关闭弹出的子页面窗口 layer.index表示当前层
                    window.location.reload();//刷新父级界面
                }else {
                    alert("添加失败");
                }
            },
            error: function () {
                alert("网络繁忙！")
            }
        });
        return false;
    });

    form.on('submit(updateForm)',function (data) {
        $.ajax({
            url: path + "/UserServlet?method=updateForm",
            async: true,
            type: "POST",
            data:  data.field,
            datatype: "text",
            success: function (msg) {
                if (msg == 1111) {
                    alert("修改成功");
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);//关闭弹出的子页面窗口 layer.index表示当前层
                    window.parent.location.reload();//刷新父级界面
                }else {
                    alert("修改失败");
                }
            },
            error: function () {
                alert("网络繁忙！")
            }
        });
        return false;
    })
});
function back() {
    var index = parent.layer.getFrameIndex(window.name);
    parent.layer.close(index);//关闭弹出的子页面窗口 layer.index表示当前层
}
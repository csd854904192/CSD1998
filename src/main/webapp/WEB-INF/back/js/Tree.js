function findMenus() {
    var path = $("#path").val();
        var roleid = $("#roleid").val();
        layui.use(['util', 'tree'], function () {
            var tree = layui.tree;
            var obj = [];
            console.log(roleid);
            $.ajax({
                url: path + "/admin/findTree",
                async: true,
                type: 'post',
                data: "roleid=" + roleid,
                datatype: "text",
                success: function (msg) {
                    console.log(msg);
                    for (var i = 0; i < msg["menucid"].length; i++) {
                        obj.push(msg["menucid"][i].id)
                    }
                    loadTree(msg["menufid"], obj)
                }, error: function () {
                    layer.msg("网络繁忙！")
                }
            });
            $("#subupdate").click(function () {
                var path = $("#path").val();
                var checkedData = tree.getChecked('menus');
                var resource = JSON.stringify(checkedData);
                $.ajax({
                    url: path + "/admin/subUpdateMenu",
                    async: true,
                    type: "post",
                    data: {"checkedData":resource,"roleid":roleid},
                    datatype: "text",
                    traditional: true,
                    success: function (msg) {
                       if (msg == "success"){
                           layer.msg("权限已修改")
                           setTimeout('jump()',1000);
                       }else{
                           layer.msg("发生未知错误！修改失败！")
                       }
                    }
                });
            })
            function loadTree(data) {
                //渲染
                var inst1 = tree.render({
                    elem: '#test1'  //绑定元素
                    , showCheckbox: true  //是否显示复选框
                    , data: data
                    , id: "menus"
                    , showLine: false
                });
                tree.setChecked('menus', obj);
            }

        });
    }
function jump(){
    var index = parent.layer.getFrameIndex(window.name);
    parent.layer.close(index);//关闭弹出的子页面窗口 layer.index表示当前层
}
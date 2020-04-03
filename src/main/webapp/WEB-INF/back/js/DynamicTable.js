layui.use(['form','jquery','table'], function(){
    var table = layui.table;
    var form =layui.form;
    $=layui.jquery;
    var path = $("#path").val();
    var tableinf = table.render({
        elem: '#demo'
        ,id:'test'
        ,height: 312
        ,url:path+"/admin/findUserInfo" //数据接口
        ,page: true //开启分页
        ,cols: [[ //表头
            {field: 'userid', title: 'ID', width:80, sort: true, fixed: 'left'}
            ,{field: 'username', title: '用户名', width:80}
            ,{field: 'usersex', title: '性别', width:80, sort: true}
            ,{field:'degree',title:'学历', width:80, sort: true}
            ,{field:'occupation',title:'职业', width:80, sort: true}
            ,{field:'userphone',title:'手机号', width:150, sort: true}
            ,{field:'email',title:'邮箱', width:150, sort: true}
            ,{fixed: 'right',title:'操作', width:178, align:'center', toolbar: '#barDemo'}
        ]]
    });
    table.on('tool(demoTest)',function(obj){
        var data = obj.data;
        if(obj.event === 'edit'){
            layer.open({
                type:2
                ,title:"修改当前用户信息"
                ,area:['400px','350px']
                ,shade:0.3
                ,shadeClose: true //点击遮罩不会关闭
                ,content:path+"/admin/path/updateInfo"
                ,success : function(layero, index) {
                    // layer.iframeAuto(index);
                    //方式一
                    // var div = layero.find('iframe').contents().find("#updateUser");
                    // div.find("#newId").val(data.userId);
                    //方式二
                    var body = layer.getChildFrame('body',index);
                    body.find("#userid").val(data.userid);
                    body.find("#username").val(data.username);
                    body.find("#userpwd").val(data.userpwd);
                    body.find("#occupation").val(data.occupation);
                    body.find("#userphone").val(data.userphone);
                    body.find("#degree").val(data.degree);
                    body.find("#usersex").val(data.usersex);
                    body.find("#email").val(data.email);
                }
            });
            layer.msg('修改');
        }else if(obj.event === 'del'){ //删除
            layer.confirm('真的删除行么', function(index){
                obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                layer.close(index);
                //向服务端发送删除指令
                $.ajax({
                    url: path + "/admin/deleteUser?userid="+data.userid,
                    async: true,
                    type: "POST",
                    success: function (msg) {
                        if (msg == 1111) {
                            layer.msg('删除成功');
                        }else {
                            layer.msg('删除失败');
                        }
                    },
                    error: function () {
                        alert("网络繁忙！")
                    }
                })
            });
        }
    });

    form.on('submit(subForm)',function (data) {
        tableinf.reload({
            url:path+"/admin/findUserInfo",
            page: {
                curr: 1 //重新从第 1 页开始
            },
            where:{
                username:data.field.username,
            }
        });
    });
});
layui.use(['layer','form'], function(){
    var layer = layui.layer, $ = layui.jquery;
    var path = $("#path").val();
    $('.layui-btn').on('click', function(){

        var othis = $(this), //othis当前button对象
            method = othis.data('method');//data-method="dialog"中的值

        if(method == "dialog"){
            layer.open({
                type: 2,
                area: ['500px', '300px'],
                btn: ['添加', '取消'],
                btn1: function(index, layero){
                    //layer.getChildFrame("form", index)获取iframe的表单
                    //serializeArray jquery方法，将表单对象序列化为数组
                    var formData = serializeObject($, layer.getChildFrame("form", index).serializeArray());
                    $.ajax({
                        url:path+"/admin/form",
                        type:'post',
                        data: formData,
                        traditional: true,
                        success:function(data){
                                alert("添加成功");
                                layer.close(index);//关闭弹出的子页面窗口 layer.index表示当前层
                                window.location.reload();//刷新父级界面
                        },
                        error: function () {
                            alert("网络繁忙！")
                        }
                    });
                },
                content: path+'/admin/path/form'
                ,success: function(layero, index){
                    console.log(layero, index);
                }
            });
        }
    });

});

//将表单转为js对象数据
function serializeObject($, array){
    var obj=new Object();
    $.each(array, function(index,param){
        if(!(param.name in obj)){
            obj[param.name]=param.value;
        }
    });
    return obj;
};
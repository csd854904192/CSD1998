layui.use(['form','jquery','table'], function(){
    var table = layui.table;
    var form =layui.form;
    $=layui.jquery;
    var path = $("#path").val();
    var tableinf = table.render({
        elem: '#demo'
        ,id:'test'
        ,height: 312
        ,url:path+"/admin/findDocTypes" //数据接口
        ,page: true //开启分页
        ,cols: [[ //表头
            {field: 'typeid', title: 'ID', width:80, sort: true, fixed: 'left'}
            ,{field: 'typename', title: '文档类型', width:80}
            ,{field: 'bounty', title: '奖励分', width:80, sort: true}
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
                ,content:path+"/admin/path/Updoctype"
                ,success : function(layero, index) {
                    var body = layer.getChildFrame('body',index);
                    body.find("#typeid").val(data.typeid);
                    body.find("#typename").val(data.typename);
                    body.find("#bounty").val(data.bounty);
                }
            });
        }else if(obj.event === 'del'){ //删除
            var typeid = data.typeid;
            console.log(typeid);
            layer.confirm('真的删除行么', function(index){
                obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                layer.close(index);
                //向服务端发送删除指令
                $.ajax({
                    url: path + "/admin/deleteTypes?typeid="+typeid,
                    async: true,
                    type: "POST",
                    success: function (msg) {
                        if (msg == "success") {
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
        }else if(obj.event === 'adds') {
            layer.open({
                type: 2
                , title: "修改当前用户信息"
                , area: ['400px', '350px']
                , shade: 0.3
                , shadeClose: true //点击遮罩不会关闭
                , content: path + "/admin/path/Addtype"
                , success: function (layero, index) {
                    var body = layer.getChildFrame('body', index);
                }
            });
        }
    });

    form.on('submit(subForm)',function (data) {
        tableinf.reload({
            url:path+"/admin/findDocTypes",
            page: {
                curr: 1 //重新从第 1 页开始
            },
            where:{
                typename:data.field.typename,
            }
        });
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
layui.use(['form','jquery','table'], function(){
    var table = layui.table;
    var form =layui.form;
    $=layui.jquery;
    var path = $("#path").val();
    var tableinf = table.render({
        elem: '#demo'
        ,id:'test'
        ,height: 312
        ,url:path+"/admin/findManagerFiles" //数据接口
        ,page: true //开启分页
        ,cols: [[ //表头
             {field: 'docid', title: 'ID', width:80,sort: true, fixed: 'left'}
            ,{field: 'docname', title: '文档名', width:80,sort: true,}
            ,{field:'userid',title:'上传用户', width:150, sort: true}
            ,{field:'updoctime',title:'上传时间', width:150, sort: true}
            ,{field:'docscore',title:'下载积分', width:80, sort: true}
            ,{field:'doctype',title:'文档类型', width:80, sort: true}
            ,{field:'docstatu',title:'状态', width:150, sort: true}
            ,{fixed: 'right',title:'操作', width:250, align:'center', toolbar: '#barDemo'}
        ]]
    });
    table.on('tool(demoTest)',function(obj){
        var data = obj.data;
        if(obj.event === 'through') { //
            layer.confirm('确认审核通过？', function (index) {
                $.ajax({
                    url: path + "/admin/changeDocState",
                    async: true,
                    data:{"docid":data.docid,"docstatu":"已审核"},
                    type: "POST",
                    success: function (msg) {
                        if (msg == "success") {
                            layer.msg('修改成功');
                            window.location.reload();
                        }else {
                            layer.msg('修改失败');
                        }
                    },
                    error: function () {
                        alert("网络繁忙！")
                    }
                })
            })
        }
        else if(obj.event === 'notThrough') { //
            layer.confirm('确认审核不通过？', function (index) {
                $.ajax({
                    url: path + "/admin/changeDocState",
                    async: true,
                    data:{"docid":data.docid,"docstatu":"审核未通过"},
                    type: "POST",
                    success: function (msg) {
                        if (msg == "success") {
                            layer.msg('修改成功');
                            window.location.reload();
                        }else {
                            layer.msg('修改失败');
                        }
                    },
                    error: function () {
                        alert("网络繁忙！")
                    }
                })
            })
        }else if(obj.event === 'down'){
                console.log(data.docid)
                window.location.href = path + '/admin/downFiles?docid=' + data.docid;
        }
    });
    form.on('submit(subForm)',function (data) {
        tableinf.reload({
            url:path+"/admin/findManagerFiles",
            page: {
                curr: 1 //重新从第 1 页开始
            },
            where:{
                docname:$("#docname").val(),
                username:$("#username").val(),
                doctime1:$("#doctime1").val(),
                doctime2:$("#doctime2").val(),
                doctype:$("#doctype").val(),
            }
        });
    });
});

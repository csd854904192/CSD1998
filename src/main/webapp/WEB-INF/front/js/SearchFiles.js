layui.use(['form','jquery','table'], function(){
    var table = layui.table;
    var form =layui.form;
    $=layui.jquery;
    var path = $("#path").val();
    var tableinf = table.render({
        elem: '#demo'
        ,id:'test'
        ,height: 312
        ,page: true //开启分页
        ,cols: [[ //表头
            {field: 'docid', title: 'ID', width:80, sort: true, fixed: 'left'}
            ,{field: 'docname', title: '文档标题', width:80}
            ,{field:'userid',title:'上传用户', width:150, sort: true}
            ,{field:'updoctime',title:'上传日期', width:150, sort: true}
            ,{field:'docscore',title:'下载积分', width:80, sort: true}
            ,{field:'doctype',title:'文档类型', width:80, sort: true}
            ,{fixed: 'right',title:'操作', width:178, align:'center', toolbar: '#barDemo'}
        ]]
    });
    form.on('submit(subForm)',function (data) {
        tableinf.reload({
            url:path+"/admin/findConFiles",
            page: {
                curr: 1 //重新从第 1 页开始
            },
            where:{
                docname:data.field.docname,
            }
        });
    });
});

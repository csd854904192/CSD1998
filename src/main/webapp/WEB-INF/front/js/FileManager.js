layui.use(['form','jquery','table'], function(){
    var table = layui.table;
    var form =layui.form;
    $=layui.jquery;
    var path = $("#path").val();
    var tableinf = table.render({
        elem: '#demo'
        ,id:'test'
        ,height: 312
        ,url:path+"/admin/findFiles" //数据接口
        ,page: true //开启分页
        ,cols: [[ //表头
            {field: 'docid', title: 'ID', width:80, sort: true, fixed: 'left'}
            ,{field: 'docname', title: '文档名', width:80}
            ,{field: 'docdes', title: '文档简介', width:80, sort: true}
            ,{field:'doctype',title:'文档类型', width:80, sort: true}
            ,{field:'docscore',title:'文档积分', width:80, sort: true}
            ,{field:'updoctime',title:'上传时间', width:150, sort: true}
            ,{field:'docstatu',title:'状态', width:150, sort: true}
            ,{field:'dowcount',title:'下载次数', width:150, sort: true}
            ,{field:'userid',title:'上传用户', width:150, sort: true}
            ,{fixed: 'right',title:'操作', width:178, align:'center', toolbar: '#barDemo'}
        ]]
    });
    form.on('submit(subForm)',function (data) {
        tableinf.reload({
            url:path+"/admin/findFiles",
            page: {
                curr: 1 //重新从第 1 页开始
            },
            where:{
                docname:$("#docname").val(),
                doctime1:$("#updoctime1").val(),
                doctime2:$("#updoctime2").val(),

            }
        });
    });
});

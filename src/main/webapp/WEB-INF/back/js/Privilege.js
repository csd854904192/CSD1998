layui.use(['jquery','table'], function(){
    var table = layui.table;
    $=layui.jquery;
    var path = $("#path").val();
    var tableinf = table.render({
        elem: '#demo'
        ,id:'test'
        ,height: 312
        ,url:path+"/admin/findRole" //数据接口
        ,page: true //开启分页
        ,cols: [[ //表头
            {field: 'roleid', title: 'ID', width:80, sort: true, fixed: 'left'}
            ,{field: 'rolename', title: '角色', width:80}
            ,{fixed: 'right',title:'操作', width:178, align:'center', toolbar: '#barDemo'}
        ]]
    });
    table.on('tool(demoTest)',function(obj){
        var data = obj.data;
        if(obj.event === 'carte'){
            layer.open({
                type:2
                ,title:"菜单分配"
                ,area:['400px','350px']
                ,shade:0.3
                ,shadeClose: true //点击遮罩不会关闭
                ,content:path+"/admin/path/Tree"
                ,success : function(layero, index) {
                    var body = layer.getChildFrame('body',index);
                    console.log(data.roleid);
                    body.find("#roleid").val(data.roleid);
                }
            });
        }
    });

});

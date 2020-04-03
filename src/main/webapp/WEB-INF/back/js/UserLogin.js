layui.use(['form','jquery'],function () {
     var form =layui.form;
     $=layui.jquery;
    var path = $("#path").val();
    console.log(path)
     form.on('submit(subForm)',function (data) {
         $.ajax({
             url:path+"/admin/backLogin",
             type:'post',
             data: data.field,
             success:function(msg){
               if(msg == "success"){
                   layer.msg("登录成功");
                   setTimeout('jump()',2000);
               }
             },error:function () {
                alert("网络繁忙！")
             }
         });
         return false;//阻止表单跳转
     });

});
function jump(){
    var path = $("#path").val();
    window.location= path+"/admin/path/BackManager"
}

// layui.use(['layer','form'], function(){
//     var layer = layui.layer, $ = layui.jquery;
//     var path = $("#path").val();
//     $('.layui-btn').on('click', function(){
//      window.location.href= path+'/web/back/jsp/RegUser.jsp';
        // var othis = $(this), //othis当前button对象
        //     method = othis.data('method');//data-method="dialog"中的值
        //
        // if(method == "dialog"){
        //     layer.open({
        //         type: 2,
        //         area: ['500px', '300px'],
        //         content: path+'/web/back/jsp/RegUser.jsp'
        //         ,success: function(layero, index){
        //             console.log(layero, index);
        //         }
        //     });
        // }
//     });
//
// });

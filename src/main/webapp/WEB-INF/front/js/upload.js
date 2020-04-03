layui.use(['upload','jquery'], function(){
    var upload = layui.upload,
        $=layui.jquery;
    var path =$("#path").val()
    //执行实例
    var uploadInst = upload.render({
        elem: '#test8' //绑定元素
        ,url: path+'/admin/upload' //上传接口
        ,auto: false
        ,accept: 'file'
        ,multiple:true
        ,bindAction: '#test9'//配合auto: false来使用，auto: true值一选中文件后就执行上传，关闭后需要根据绑定事件
        ,before: function(obj) {
            this.data = {//要传递的数据
                bookName: $("#hideBookName").val(),
                downScore: $("#downScore").val(),
                fileName: $("#fileNames").val(),
                intro:$("#intro").val(),
            }
        }
        ,choose: function(obj){  //上传前选择回调方法
            obj.preview(function(index, file, result){
                console.log(file);            //file表示文件信息，result表示文件src地址
                $("#fileNames").text(file.name)
            });
        }
        ,done: function(res){
            if(res.code == 0){
                //上传完毕回调
                alert("上传成功！");
            }
            if(res.code == 1){
                //上传完毕回调
                alert("文件类型不匹配！");
            }
            if(res.code == 2){
                //上传完毕回调
                alert("文件或其他信息不能为空！");
            }
        }
        ,error: function(){
            //请求异常回调
            alert("上传失败！");
        }
    });
});
console.log($("#downScore").val());
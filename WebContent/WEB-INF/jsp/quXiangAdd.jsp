<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../plugs/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../plugs/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="../plugs/easyui/demo/demo.css">
    <link rel="stylesheet" type="text/css" href="../plugs/layui/css/layui.css">
    <script type="text/javascript" src="../plugs/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="../plugs/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../plugs/layui/layui.all.js"></script>
<style>
.qxadd{
width:500px;
}
.add-btn{
width:130px;
margin-left:300px;
}
td{
background-color:white;
}
</style>
</head>

<body>
<div class="layui-main  qxadd" style="margin-top:10px;">
<form id="addForm" class="layui-form">
  <table class="layui-table" >
    <colgroup>
    <col width="150">
    <col width="350">
  </colgroup>
   <tbody>
    <tr>
      <td>开始时间</td>
      <td><input type="text" class="layui-input" id="test1" name="test1"></td>
    </tr> 
 
 
    <tr>
      <td>结束时间</td>
      <td><input type="text" class="layui-input" id="test2" name="test2"></td>
    </tr>
    <tr>
      <td>去向</td>
      <td><textarea name="desc" placeholder="请输入内容" name="desc" class="layui-textarea"></textarea></td>
    </tr>
    <tr>
      <td>是否公开</td>
      <td><input type="checkbox" name="yyy" lay-skin="switch" lay-text="ON|OFF" checked></td>
    </tr>
    <tr>
      <td colspan="2"><button class="layui-btn add-btn" lay-submit id="add-submie">提交</button></td>
      
    </tr>
  </tbody>

</table>
</form>
</div>
<!--加载form-->
<script>
layui.use('laydate', function(){
	  var laydate = layui.laydate;
	  
	  //执行一个laydate实例
	  laydate.render({
	    elem: '#test1' //指定元素
	  });
	  laydate.render({
		    elem: '#test2' //指定元素
		  });
	});
    //Demo
    layui.use('form', function(){
        var form = layui.form;
        var $=layui.jquery;
        var layer=layui.layer;
        form.on('submit', function(data){
            layer.msg(JSON.stringify(data.field));
            return true;
          });
        form.render();
    });
</script>
<!--图片上传-->
</body>
</html>
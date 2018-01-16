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
.width{
 width:200px;
}
.layui-btn{
 margin:20px 0px 0px 170px;
}
</style>
</head>
<body>
<div class="layui-main" style="width:500px;height:300px;padding-left:120px;padding-top:6%;">
<form id="pass" class="layui-form" action="">
  <div class="layui-form-item">
    <label class="layui-form-label">旧密码：</label>
    <div class="layui-input-block">
      <input type="text" name="oldpass" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input width">
    </div>
    
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">新密码：</label>
    <div class="layui-input-block">
      <input type="password" id="newpass" name="newpass" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input width">
    </div>
  </div>
  
   <div class="layui-form-item">
    <label class="layui-form-label">确认密码：</label>
    <div class="layui-input-block">
      <input type="password" id="regpass" name="regpass" required  lay-verify="regpass" placeholder="请输入标题" autocomplete="off" class="layui-input width">
    </div>
  </div>
  <div class="layui-form-item">
  <button  class="layui-btn" lay-submit lay-filter="formDemo">确定</button>
  <button type="reset" class="layui-btn">重置</button>
 </div>
</form>
</div>
<!--加载form-->
<script>
//自定义验证规则
layui.use('form',  function() {
	var form = layui.form;
    var $=layui.jquery;
    var layer=layui.layer;
				form.verify({
					regpass: function(value,item) {
					
						//获取密码
						var newpass = $("#newpass").val();
						
						if(!new RegExp(newpass).test(value)) {
		
							return '两次输入的密码不一致';
						}
					}
				});
				form.on('submit', function(data){
		            layer.msg(JSON.stringify(data.field));
		            return false;
		          });
		        form.render();
			});
</script>

</body>
</html>
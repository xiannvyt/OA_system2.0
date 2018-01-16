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
.btn-position{
position:relative;
bottom:59px;
left:490px;
}
.qx-table{
width:1000px;
margin:-100px 0px 0px 50px;
}
body .demo-class .layui-layer-title{background:#019688; color:#fff; border: none;}
</style>
</head>
<body>
<div class="layui-main" style="margin-top:10px;">
<form id="quxiang" class="layui-form" action="" >
  <div class="layui-form-item">
    <label class="layui-form-label">时间：</label>
    <div class="layui-inline"> 
  <input type="text" class="layui-input" name="qx-starttime" id="qx-starttime">
</div>
    <div class="layui-inline"> 
 ~
</div>
    <div class="layui-inline"> 
   <input type="text" class="layui-input" name="qx-endtime" id="qx-endtime">
</div>
  </div>
  
  
  <div class="layui-form-item">
  <button  class="layui-btn btn-position" lay-submit id="qx-lookfor" >确定</button>
 </div>
</form>
<div style="width:200px;position:relative;bottom:112px;left:900px;"><button class="layui-btn" id="qx-add">增加</button><button class="layui-btn" id="qx-delete">删除</button></div>
<div class="qx-table"><table id="demo" lay-filter="test" ></table></div>
</div>
<script src="/static/build/layui.js"></script>
<script>
layui.use('laydate', function(){
  var laydate = layui.laydate;
  
  //执行一个laydate实例
  laydate.render({
    elem: '#qx-starttime' //指定元素
  });
  laydate.render({
	    elem: '#qx-endtime' //指定元素
	  });
});

layui.use('form', function(){
    var form = layui.form;
    var $=layui.jquery;
    var layer=layui.layer;
    form.on('submit', function(data){
        layer.msg(JSON.stringify(data.field));
        return true;
      });
});

layui.use('table', function(){
	  var table = layui.table;
	  
	  //第一个实例
	  table.render({
	    elem: '#demo'
	    ,url: 'to_myqx' //数据接口
	    ,page: true //开启分页
	    ,cols: [[ //表头
	              {checkbox: true}
	      ,{field: 'wheStart', title: '开始时间', width:'20%',align:'center',style:'height:90px;'}
	      ,{field: 'wheEnd', title: '结束时间', width:'20%',align:'center'}
	      ,{field: 'wheAbout', title: '去向', width:'20%',align:'center'}
	      ,{field: 'thur', title: '操作', width:'40%',align:'center'} 
	    
	    ]]
	  });
	  
	});
//添加的点击事件
$("#qx-add").click(function() {
	layer.open({
		type: 2,
		content: "/to_quxiangadd",
		title:'我的去向',
		skin:'demo-class',
		area: ['700px', '92%'],
		scrollbar: false,
	});

});


</script>
</body>
</html>
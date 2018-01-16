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
td{
background-color:white;
}
.laytable-cell-1-wed,.laytable-cell-1-mon,.laytable-cell-1-tues,.laytable-cell-1-thur,.laytable-cell-1-fri,.laytable-cell-1-sat,.laytable-cell-1-sun{
line-height:65px; 
width:120px;
height:65px;

}



</style>
</head>
<body class="layui-layout-body">

  <div class="layui-side" style="width:300px;">
    <div class="layui-side-scroll" style="width:400px;padding:0px 0px 0px 10px;">
    
     <div id="rili" style="padding-top:11px;"></div>
     <form class="layui-form" action="getRiCheng">
     <div class="layui-form-item" >
     <div class="layui-input-none" style="width:100px;">
      <input type="text" id="richengtime" name="richengtime" required   lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
    </div>
  </div>
     </form>
    </div>

  </div>
<div class="layui-body">
    <!-- 内容主体区域 -->
    <div class="layui-main" style="padding:0px 90px;width:860px;">
    <table id="demo" lay-filter="test" ></table>
</div>
  </div>

<script>
//嵌套在指定容器中
layui.use('laydate',function() {
	var laydate = layui.laydate;
	var form = layui.form;
    var $=layui.jquery;
    var layer=layui.layer;
laydate.render({
  elem: '#rili'
  ,position: 'static'
  ,change: function(value, date){ //监听日期被切换
	  lay('#richengtime').val(value);
	  form.submit();
	  form.on('submit(*)', function(data){
		
		});
  }
});
});

layui.use('table', function(){
	  var table = layui.table;
	  
	  //第一个实例
	  table.render({
	    elem: '#demo'
	    ,url: 'test' //数据接口
	    ,cols: [[ //表头
	      {field: 'mon', title: '星期一', width:122,align:'center',style:'height:90px;'}
	      ,{field: 'tues', title: '星期二', width:122,align:'center'}
	      ,{field: 'wed', title: '星期三', width:122,align:'center'}
	      ,{field: 'thur', title: '星期四', width:122,align:'center'} 
	      ,{field: 'fri', title: '星期五', width: 122,align:'center'}
	      ,{field: 'sat', title: '星期六', width: 122,align:'center'}
	      ,{field: 'sun', title: '星期日', width: 120,align:'center'}
	    
	    ]]
	  });
	  
	});
 
</script>
</body>
</html>
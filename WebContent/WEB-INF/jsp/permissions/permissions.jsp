<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link rel="stylesheet" type="text/css" href="../../plugs/layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="//at.alicdn.com/t/font_526922_2mm2tte3pgj2x1or.css" />
		<script type="text/javascript" src="../../plugs/layui/layui.all.js"></script>
<title>Insert title here</title>
</head>
<body>
	<table class="layui-hide" id="LAY_table_permission" lay-filter="permission"></table>
</body>
<script type="text/html" id="bar">
	<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">授权</a>
	<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script>
	layui.use('table',function(){
		var table=layui.table;
		table.render({
			elem:'#LAY_table_permission',
			url:'/to_listRoles.do',
			cols:[[
				{checkbox:true,width: 80,},
				{field:'roleId',title:'ID',sort:true,width: 80,},
				{field:'roleName',title:'角色名称',width: 188,},
				{field:'deptId',title:'所属部门',width: 216,},
				{title:'操作',align:'cent',width:178,toolbar:'#bar'}
			]],
			page:true,
			height:'full'
		});
	})
</script>
</html>
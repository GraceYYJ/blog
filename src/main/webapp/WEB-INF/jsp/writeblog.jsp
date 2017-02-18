<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>写博客</title>
<style type="text/css">
body{
	background-color:#d2b48a;
	margin-left:10%;
	margin-right:10%;
	boder:2px dotted black;
	padding:10px 10px 10px 10px;
	font-family:san-serif
}
</style>
</head>
<h3>写博客</h3>
<body style="text-align: center">
	<div>
		<form action="/blog2/blogger/writeblog">
			<input type="text" name="title"><br>
			<input type="text" name="type"><br>
			<input type="text" width="300px" height="200px" name="inputbox"><br>
			<button type="submit">提交</button>
		</form>
	</div>
</body>
</html>
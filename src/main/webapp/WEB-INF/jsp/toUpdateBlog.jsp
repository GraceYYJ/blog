<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>写博客</title>
<style type="text/css">
body {
	background-color: #d2b48a;
	margin-left: 10%;
	margin-right: 10%;
	boder: 2px dotted black;
	padding: 10px 10px 10px 10px;
	font-family: san-serif
}
</style>

</head>
<h3>写博客</h3>
<body style="text-align: center">
	<div>
		<form action="/blog2/blogger/UpdateBlog">
				   <input type="hidden" name="id" value="${blog.blogid}"><br>
			文章题目：<input type="text" style="width: 300px"  name="title" value="${blog.title}"><br>
			文章类型：<input type="text" style="width: 300px"  name="type" value="${blog.articletype}"><br>
			正文：<br>
				   <input type="text" style="height: 600px; width: 600px"
				name="inputbox" value=${blog.articlebody}><br>
			<button type="submit">提交</button>
		</form>
	</div>
</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>文章详情</title>
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
		<font style="color: #8B2323">作者：楊玉娟&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;尊重博主原创文章，转载请注明文章出于此处。</font>
		<div class="title">${blog.title}</div>
		<div class="type">${blog.articletype}</div>
		<br>
		<div class="blog_content">${blog.articlebody}</div>
	</div>
</body>
</html>
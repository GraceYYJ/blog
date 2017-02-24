<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="myblog.controller.BloggerController"%>
<%@ page import="myblog.model.Blog"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>博客列表</title>
</head>

<body style="text-align: center">
<h2>博客列表</h2>
	<a href="/blog2/blogger/toWrite"><button>添加博客</button></a>	
	<a href="/blog2/blogger/index"><button>返回登陆页面</button></a>		
	<table border=1 width="700px" align="center" style="text-align: center">
		<tr>
			<th>博客编号</th>
			<th>博客题目</th>
			<th>博客类型</th>
			<th>编辑</th>
			<th>删除</th>
		</tr>
		<c:forEach var="item" items="${blogs}">
			<tr>
				<td>${item.blogid}</td>
				
				<td>

				<a name="blogid" href="/blog2/blogger/tolist?blogid=${item.blogid}">${item.title}</a>
				
				</td>
				
				<td>${item.articletype}</td>
				
				<td>
				<form action = "/blog2/blogger/toUpdateBlog">
				<input type="hidden" name="id" value="${item.blogid}">
				<input type ="submit" value = "修改">
				</form>
				</td>
				
				<td>
				<form action = "/blog2/blogger/delBlog">
				<input type="hidden" name="id" value="${item.blogid}">
				<input type = "submit" onclick="return confirm('你确定要删除你的宝贝文文吗？')" value = "删除">
				</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
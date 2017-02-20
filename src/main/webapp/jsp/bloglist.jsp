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

<h2>博客列表</h2>
<body style="text-align: center">
	<table border=1 width="200" align="center" style="text-align: center">
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
				<td>${item.title}</td>
				<td>${item.articletype}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
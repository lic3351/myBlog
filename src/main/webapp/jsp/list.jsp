<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<base href="<%=basePath%>" />
<title>Insert title here</title>
</head>
<body>
	<table width="80%" align="center">
		<tr>
			<td>id</td>
			<td>name</td>
			<td>address</td>
		</tr>
		<c:forEach items="${list }" var="bean">
			<tr>
				<td>${bean.id }</td>
				<td>${bean.name }</td>
				<td>${bean.address}</td>
				<td><a href="delete/${bean.id }.do">删除</a></td>
			</tr>
		</c:forEach>
	</table>
<a href="jsp/user.jsp">添加</a>	
</body>
</html>
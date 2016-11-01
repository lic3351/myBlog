<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<base href="<%=basePath%>" />
<title>login</title>
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/bootstrap-theme.css" rel="stylesheet">
</head>
<body>
<div class="container" style="width:300px; position: absolute;top: 20%; left: 40%;">

      <form  action="login/user.do" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text" name="name" class="form-control" placeholder="用户名" required autofocus>
        <input type="password" name="passwd" class="form-control" placeholder="密码" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
        <button  onclick="register.do">注册</button>
      </form>

    </div> 
    
   <script src="js/jquery.js"></script>
  <script src="js/bootstrap.min.js"></script>
</body>
</html>
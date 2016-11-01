<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<base href="<%=basePath%>" />
<title>main</title>
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/bootstrap-theme.css" rel="stylesheet">
    <script src="js/jquery.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script type="text/javascript">
  var article_id=-1;
	$(function(){
		$("#article_add").click(function(){
			$("#form2").show();
		});
		
		$("#comment button:first").click(function(){
			$("#comment").hide();
		});
		$("#comment button:last").click(function(){
			var con=$("#liuyan").val();
			$.get("article/addcomment.do",{id:article_id,content:con},function(data){
				var temp_id="#liuyan"+article_id;
				var obj = jQuery.parseJSON(data);				
				$(temp_id).append("<li class='list-group-item'>"+obj.user_name+": "+con+"</li>");
				//alert(data);
			});
			$("#comment").hide();
			$("#liuyan").val('');
			//alert(article_id);
		});
	});
	
	var hide=function(){
			$("#form2").hide();
	}
	
//	<!--删除-->
	var a_del_con=function(event){
		var r=confirm("确定要删除吗？");
		if(r==false){
			event.preventDefault();
		}
	}
	
	
	
	//<!--点赞-->
	var a_like=function(id){
		$.get("article/like.do",{id:id},function(data){
			var temp_id='#sp_clike'+id;
			$(temp_id).html(data);
			
		});
	}
//发表评论
	var say=function(id){
		$("#comment").show();
		article_id=id;
	}
	
	
</script>
  
</head>
   <body role="document">
     <div class="page-header">
    <!-- Fixed navbar -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Bootstrap theme</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <span class="caret"></span></a>
              <ul class="dropdown-menu" role="menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li class="divider"></li>
                <li class="dropdown-header">Nav header</li>
                <li><a href="#">Separated link</a></li>
                <li><a href="#">One more separated link</a></li>
              </ul>
            </li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>  
      </div>


 <div class="container theme-showcase" role="main">
 
      <div class="jumbotron">
        <h1>Hello, world!</h1>
        <p>This is a template.</p>
        <p><button id="article_add" onclick="" class="btn btn-primary btn-lg">Say more+ &raquo;</button></p>
      </div>
	
<!--

-->
<c:forEach items="${articles}" var="bean">
<div class="row">

	  <div class="col-md-2">
		  <img data-src="holder.js/200x200" class="img-thumbnail" alt="头像" src="">
		  <p>${bean.user.name}</p>
		  <p>
			<span class="label label-default">Default</span>
			<span class="label label-primary">Primary</span>
		  </p>	 
	  </div>

	  <div class="col-md-7">
			<div class="row">
					<div class="col-md-9">	 
						<div class="alert alert-success" role="alert">
							 <h4>${bean.title}</h4>
							${bean.body }
						</div>
					</div>
					<div class="col-md-1" id="btnctl${bean.id }">
							 <button  class="btn btn-sm btn-info" type="button" onclick="javascript:a_like(${bean.id});">
								like<span id="sp_clike${bean.id}" class="badge">${bean.clike }</span>
							 </button>
							 
									<p><a id="a_del" href="article/delete/${bean.id }.do" onclick="javascript:a_del_con(event);" class="btn btn-sm btn-danger">
							X
							 </a></p>
							  <button  class="btn btn-sm" type="button" onclick="javascript:say(${bean.id })">
								say
							  </button>
					</div>
			 </div>
			 <ul class="list-group" id="liuyan${bean.id }">
				 <c:forEach items="${bean.comments }" var="comment">
				 		<c:if test="${!empty comment.c_time }">
									<!--留言列表-->
									
									  <li class="list-group-item">   
										[<fmt:formatDate value="${comment.c_time }" pattern="yyyy-MM-dd HH:mm"/>] ${comment.content }
									  </li>
									
						</c:if>
				</c:forEach>
			</ul>
	  </div>
</div>
</c:forEach>

<hr>
<div class="page-footer">
  <h1>页尾 <small>Subtext for header</small></h1>
</div>


<!--彈出-->
<form id="form2" action="article/add.do" method="post" style="display: none; position: absolute;top: 10%; left: 50%;">
<div class="panel panel-info" style="width:400px">
  <div class="panel-heading">发布状态
  </div>
  <div class="panel-body">
    Panel content
			<div class="input-group">
			  <span class="input-group-addon">标题</span>
			  <input type="text" name="title" class="form-control" placeholder="Title">
			</div>
			<p></p>
			<div class="input-group">
			  <span class="input-group-addon">内容</span>
			  <input type="text" name="body" class="form-control" placeholder="Content">
			</div>
			<p>
				 <button style="float:right" type="button" onclick="javascript:hide()" class="btn  btn-sm btn-danger">X</button>
				  <button style="float:right" type="submit" class="btn btn-sm  btn-success">O</button>
			</P>
  </div>
</div>
</form>

<div id="comment" class="input-group" style="width:500px;display: none; position: absolute;top: 10%; left: 50%;">
<span class="input-group-addon">@</span>
	<input type="text" id="liuyan" class="form-control">
      <span class="input-group-btn">
        <button class="btn btn-danger" type="button">X</button>
      </span>
        <span class="input-group-btn">
        <button class="btn btn-info" type="button">>></button>
      </span>
</div>


</div>
  </body>
</html>
﻿<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//basePath = "http://localhost:8080/manager_4/"
%>
<html>
<head>
<meta charset="utf-8" />
<title>添加好友</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/bootstrap/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/addFriend.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script>
        $(function(){
		$.ajax({
                url: '${pageContext.request.contextPath}/friend/addFriend.action',
                type: 'POST',
                async: true,
                dataType: 'JSON',
                success: function (data) {
                var json=eval(data);
                $.each(json,function(index,item){
                var userName=json[index].userName;
                var userHeadPortraitPath=json[index].userHeadPortraitPath;
                var age=1;
                var address=2;
					$('#'+"addFriend").append('<li class="user pull-left" id="'+userName+'">'+'</li>');
                    $('#'+"addFriend").find('#'+userName).append('<form id="'+userName+'form" action="${pageContext.request.contextPath}/friend/becomeFriend.action?userName='+userName+'&friendgraphTheoryImagePicPath='+userHeadPortraitPath+'" method="post">'+'</form>');
                    $('#'+"addFriend").find('#'+userName).find("form").append('<a  href="javascript:document.getElementById(\''+userName+'form\').submit();" data-ajax="false" >'+'</a>');
					$('#'+"addFriend").find('#'+userName).find("form").find("a").append('<img src="<%=basePath%>upload/callRing/${userHeadPortraitPath}">'+'</img>');
                    $('#'+"addFriend").find('#'+userName).find("form").find("a").append('<div class="user-name">'+userName+'</div>');
                    $('#'+"addFriend").find('#'+userName).find("form").find("a").append('<div id="'+userName+'info"class="user-msg"">'+'</div>');
                    $('#'+"addFriend").find('#'+userName).find("form").find("a").find('#'+userName+"info").append('<span class=age>'+age+'</span>');
                    $('#'+"addFriend").find('#'+userName).find("form").find("a").find('#'+userName+"info").append('<span class=from>'+address+'</span>');
                    $('#'+"addFriend").find('#'+userName).find("form").find("a").append('<div id="'+userName+'add" class="opera">'+'</div>');
                    $('#'+"addFriend").find('#'+userName).find("form").find("a").find('#'+userName+"add").append('<p class="btn btn-default btn-add" data-ajax="false" >'+"+好友"+'</p>')


                });;
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                console.dir(textStatus);
                console.dir(XMLHttpRequest);
                }
                });
		});
	</script>
</head>
<body class="bg">
<div class="layout" name="layout">
	<div class="header-bar">
		<div class="top clearfix">
			<div class="pull-left"><span class="title"><img src="./img/qq_14x16.png">查找</span></div>
			<div class="pull-right btn-close">x</div>
		</div>
		<div class="tab-bar text-center">
			<ul class="tab-list clearfix" tab-list>
				<li class="text-center pull-left active">找人</li>
				<li class="text-center pull-left">找群</li>
				<li class="text-center pull-left">找主播</li>
				<li class="text-center pull-left">找课程</li>
				<li class="text-center pull-left">找服务</li>
			</ul>
		</div>
	</div>
	<div class="container">
		<div class="search-area">
			<div class="clearfix">
				<div class="pull-left form-wrap">
					<form class="clearfix">
						<div class="pull-left left-form">
							<div class="input-wrap">
								<input type="text" placeholder="请输入QQ号/手机号/邮箱/昵称/关键词"/>
								<i class="arrow"></i>
							</div>
							<div class="sl-wrap clearfix">
								<select class="area mr10">
									<option>所在地：中国</option>
									<option>所在地：福建</option>
									<option>所在地：吉林</option>
								</select>
								<select class="area mr10">
									<option>故乡：中国</option>
									<option>故乡：不限</option>
									<option>故乡：日本</option>
								</select>
								<select class="sl-list mr10">
									<option>不限</option>
									<option>女</option>
									<option>男</option>
								</select>
								<select class="sl-list">
									<option>年龄</option>
									<option>18-22岁</option>
									<option>23-28岁</option>
								</select>
							</div>
						</div>
						<div class="pull-left checkbox">
							<label class="mb15">
								<input type="checkbox" value="在线"/>在线
							</label>
							<label>
								<input type="checkbox" value="摄像头"/>摄像头
							</label>
						</div>
					</form>
				</div>
				<div class="pull-left right-btn">
					<div class="btn btn-default btn-check pull-left">查找</div>
					<div class="txt pull-left">同城交友 同城老乡 附近的人</div>
				</div>
			</div>
		</div>
		<div class="tip-bar clearfix">
			<div class="back pull-left"><i class="arrow"></i>返回</div>
			<div class="tip pull-left">
				<span class="key">搜索:</span>
				<span class="value">121212121212</span>
			</div>
			<div class="sex pull-left"><span>男</span></div>
		</div>
		<div class="search-result clearfix">
			<ul  id="addFriend" class="result-wrap">
				<%--<li class="user pull-left">--%>
					<%--<img src="./img/head_60x60.png" />--%>
					<%--<div class="user-name">张传琨</div>--%>
					<%--<div class="user-msg">--%>
						<%--<span class="age">18岁</span>--%>
						<%--<span class="from">福建 南平</span>--%>
					<%--</div>--%>
					<%--<div class="opera"><a class="btn btn-default btn-add" href="javascript:;">+ 好友</a></div>--%>
				<%--</li>--%>

			</ul>
		</div>
	</div>
</div>
</body>
</html>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.min.css"></script>
<script type="text/javascript">
	(function(){
		$(document).on('click', '[tab-list] li', function(){
			$(this).addClass('active').siblings().removeClass('active');
		});
        //提示层
        $(document).on('click', '.btn-add', function(){
            layer.msg('添加成功！', {
                time:1000
            });
        });
	})()
</script>

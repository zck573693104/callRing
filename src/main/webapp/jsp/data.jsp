<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getServerName() + ":"
            + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>个人资料</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <script src="../jquery/jquery-1.6.2.min.js"></script>

<link rel="stylesheet" href="../css/public.css">
<style>
body{ background:#F7F7F7 !important}
.nav_data{ height:100px;line-height:100px; color:#fff; font-size:35px; position:fixed; width:95%; padding-right:5%; left:0px; top:0px;}
.nav_data{ background:#FD4C5B url(../img/70%20Basic%20Icons-all-24.svg) 26px 30px no-repeat}
.nav_data .left{ float:left; padding-left:85px; cursor:pointer}
.nav_data .right{ float:right; cursor:pointer}

.data_box{ padding-top:100px}
.data_box ul{ background:#fff;}
.data_box li{ height:100px; border-bottom:1px #dfdfdf solid; line-height:100px; padding:0px 5%; font-size:35px}
.data_box h1{ line-height:100px; font-size:35px;}
</style>
    <style type="text/css">
        .file {
            position: relative;
            display: inline-block;
            background: #D0EEFF;
            border: 1px solid #99D3F5;
            border-radius: 4px;
            padding: 4px 12px;
            overflow: hidden;
            color: #1E88C7;
            text-decoration: none;
            text-indent: 0;
            line-height: 20px;
        }
        .file input {
            position: absolute;
            font-size: 100px;
            right: 0;
            top: 0;
            opacity: 0;
        }
        .file:hover {
            background: #AADFFD;
            border-color: #78C3F3;
            color: #004974;
            text-decoration: none;
        }
    </style>
 <script type="text/javascript">

 window.onload = function() {
     var oDiv = document.getElementById('info');
     oDiv.onclick = function() {

         //点击表单“提交”按钮
         var url = "${pageContext.request.contextPath}/user/updateUserInfo.action";
         //更改form的action
         $("#updateUserInformationFormId").attr("action", url);
         //触发submit事件，提交表单
         $("#updateUserInformationFormId").submit();


     };
 };


</script>


<body id="body_bg">
    <div class="nav_data">
        <div class="left" onclick="window.history.go(-1)">个人资料</div>
        <div class="right" id="info" >保存</div>
    </div>
    <div class="data_box">
    	<%--<h1>用户名</h1>--%>
    	<form action=""  method="post" enctype="multipart/form-data" id="updateUserInformationFormId">
            <%--<input type="text" style="width:300px;height:100px;border-radius:10px;box-shadow:none;padding:5px;border:1px solid 颜色;--%>
<%--" value="${userName}" name="userName"/>--%>
    	<%--<ul>--%>
        	<%--<li contentEditable="true" name="userName">${userName}</li>--%>
            <%--<li contentEditable="true" name="password">密码</li>--%>
        <%--</ul>--%>
                <h1>头像</h1>
                <div>
                    <img src="${pageContext.request.contextPath}/upload/callRing/${userHeadPortraitPath}" class="head-img"/>
                    <a href="javascript:;" class="file">
                        <input type="file" name="userHeadPortrait" class="change-img"/>
                        <span class="chang-text">更换头像</span>
                    </a>
                </div>
                <h1>个性签名</h1>
                <textarea type="text" value="${userIntroduce}" name="userIntroduce" style="width:300px;height:100px;border-radius:10px;box-shadow:none;padding:5px;" placeholder="请输入个性签名"></textarea>


        <%--<ul>--%>
        	<%--<li contentEditable="true" style="height:250px; line-height:40px !important; overflow:auto; padding:20px 20px" name="userIntroduce">--%>
            	<%--${userIntroduce}--%>
            <%--</li>--%>
        <%--</ul>--%>
        </form>
    </div>
</body>

</head>
</html>
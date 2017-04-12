<%--
  Created by IntelliJ IDEA.
  User: kcz
  Date: 2016/5/23
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page pageEncoding="utf-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//basePath = "http://localhost:8080/manager_4/"
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>上传结果</title>
</head>
<body>
<img alt="" src="${fileUrl}" />
</body>
</html>
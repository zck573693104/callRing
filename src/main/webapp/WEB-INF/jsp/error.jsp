<%--
  Created by IntelliJ IDEA.
  User: kcz
  Date: 2016/5/20
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//basePath = "http://localhost:8080/manager_4/"
%>
<html>
<head>
    <title></title>
 <link rel="stylesheet" type="text/css"  href="<%=basePath%>css/registerBackground.css"/>
       <style type="text/css">
        .registerBackground{ 
height: 100%; 
width:100%; 
margin:0px auto; 
background-image: -moz-linear-gradient(top,#B22222,#C71585); 
background: -o-linear-gradient(top,#B22222 0%,#C71585 100%);/*Opera*/
background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0,#B22222), color-stop(1,#C71585)); /*Chrome*/
filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#B22222', endColorstr='#C71585', GradientType='0'); /*IE*/
}  
</style>

 <style>
   .Center-Container.is-Inline {   
  text-align: center;  
  overflow: auto;  
}  
  
.Center-Container.is-Inline:after,  
.is-Inline .Center-Block {  
  display: inline-block;  
  vertical-align: middle;  
}  
  
.Center-Container.is-Inline:after {  
  content: '';  
  height: 100%;  
  margin-left: -0.25em; /* To offset spacing. May vary by font */  
}  
  
.is-Inline .Center-Block {  
  max-width: 99%; /* Prevents issues with long content causes the content block to be pushed to the top */  
  /* max-width: calc(100% - 0.25em) /* Only for IE9+ */   
}  
         </style>
         
         <style type="text/css">
input.ys{
border:1 solid #FFCC00;
color: #FFCCFF;
font-size: 9pt;
font-style: normal;
font-variant: normal;
font-weight: normal;
height: 18px;
line-height: normal;
background-color: #D2691E;
}

</style>


</head>
<body class="registerBackground">
 <div class="Center-Container is-Inline">  
  <div class="Center-Block">  
<h1>你操作错了好不好</h1>    
<p>    
<ul>    
    
<h3>错误信息:${message}]显示你手指头按错了好不好</h3>    
<h3>阁下人品不好就跳出了这个页面</h3>   
<h2><a href="<%=basePath%>jsp/user.jsp">请重新登录</a></h2>
</div>  
</div>
</body>
</html>

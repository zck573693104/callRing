<%@page import="javax.print.attribute.Size2DSyntax"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
         <html>
         <head>
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
background-color: #00bfff;
}
</style>
<style type="text/css"> 
.linear{ 
width:100%; 
height:600px; 
FILTER: progid:DXImageTransform.Microsoft.Gradient(gradientType=0,startColorStr=##15A216,endColorStr=#fafafa); /*IE*/ 
background:-moz-linear-gradient(top,#15A216,#fafafa);/*火狐*/ 
background:-webkit-gradient(linear, 0% 0%, 0% 100%,from(#15A216), to(#fafafa));/*谷歌*/ 
background-image: -webkit-gradient(linear,left bottom,left top,color-start(0, #15A216),color-stop(1, #fafafa));/* Safari & Chrome*/ 
filter: progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr='#15A216', endColorstr='#fafafa'); /*IE6 & IE7*/ 
-ms-filter: "progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr='#15A216', endColorstr='#fafafa')"; /* IE8 */ 
} 
</style>
         </head>
         
         <body>
         <div class="linear">
         <div class="Center-Container is-Inline">  
  <div class="Center-Block">  
   <form action="${pageContext.request.contextPath}/introduce/updateOrInsertIntroduce.action" method="post" class="Absolute-Center.is-Responsive">
        <input style="width:300px; height:111px" type="text" name="introduceTittle" value=" <%=request.getParameter("introduceTittle")%> "/></br>
        <input style="width:300px; height:111px" type="text" name="introduceContent"  value="<%=request.getParameter("introduceContent")%>" /></br>
        <input style="width:100px; height:60px;color: blue" type="submit" value="取消" class="ys"/>
         <input  style="width:100px; height:60px" type="submit" value="确定" class="ys"/>
         </form>
  </div>  
</div>  
</div> 
         </body>
         </html>
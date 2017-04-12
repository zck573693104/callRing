<%--
  Created by IntelliJ IDEA.
  User: kcz
  Date: 2016/5/20
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
 <link rel="stylesheet" type="text/css"  href="css/registerBackground.css"/>
       <style type="text/css">
        .registerBackground{ 
height: 100%; 
width:100%; 
margin:0px auto;
filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#D2691E', endColorstr='#DEB887', GradientType=0); /*IE*/
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
border:#FFCC00;
color: #FFCCFF;
font-size: 9pt;
font-style: normal;
font-variant: normal;
font-weight: normal;
height: 18px;
line-height: normal;
background-color: #D2691E;
}
input{
    box-shadow:none;
    border-radius:4px;
    border:none;
    padding:0 15px;
}
body{
    background:url(../img/bj.jpg);
}

</style>

<script>
        function check(form) {
            var p1 = form.userPassword;
            var p2 = form.userPasswordAgain;
            if (p1.value != p2.value) {
                p2.oninvalid();
                return false;
            }
            return true;
        }
        onload = function() {
            var p2 = document.forms["register"].userPasswordAgain;
            p2.oninvalid = function() {
                this.setCustomValidity("密码不一致，请重新输入");
            }
            p2.oninput = function() {
                this.setCustomValidity("");
            }
 
        }
    </script>
</head>
<body class="registerBackground">
 <div class="Center-Container is-Inline">  
  <div class="Center-Block">  
<form id="register" action="${pageContext.request.contextPath}/user/register.action" method="post" onsubmit="return check(this);">
  <input type="text" name="userName" placeholder="userName"style="background:rgb(250, 255, 189);width:300px; height:40px ;box-shadow:none;" required="required" maxlength="16" /></br>
   <input required="true"type="password" id="userPassword" name="userPassword" placeholder="userPassword"style="margin:25px 0;width:300px; height:40px; background:rgb(250, 255, 189);box-shadow:none;" onchange="checkPasswords()" /></br>
<input required="true" type="password" id="userPasswordAgain"name="userPasswordAgain" placeholder="userPasswordAgain"style="margin-bottom:25px;width:300px; height:40px; background:rgb(250, 255, 189); #F0E68C;box-shadow:none;" onchange="checkPasswords()"/></br>
<input type="submit" value="提交" style="background:#ef4300;width:300px; height:44px;color:#fff; font-size:18px;" class="ys"/>
</form>
</div>  
</div>
</body>
</html>

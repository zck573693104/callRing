<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en" class="no-js">

<head>

    <meta charset="utf-8">
    <title>callRing Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- CSS -->
    <!--   <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'> -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login/supersized.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login/style.css">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <script src="js/jquery.js"></script>
    <script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript">

        //点击表单“提交”按钮
        $(function login(){
            $("#loginSelector").bind("click", function () {
                var url = "${pageContext.request.contextPath}/user/checkLogin.action";
                //更改form的action
                $("#lginAndRegist").attr("action", url);
                //触发submit事件，提交表单
                $("#lginAndRegist").submit();
            });
        });


    </script>
    <script type="text/javascript">
        $(function register(){
            $("#registerSelector").bind("click", function () {
                var url = "${pageContext.request.contextPath}/jsp/register.jsp";
                //更改form的action
                $("#lginAndRegist").attr("action", url);
                //触发submit事件，提交表单
                $("#lginAndRegist").submit();
            });
        });

    </script>
</head>

<body>

<div class="page-container">
    <h1>Login</h1>
    <form action="" method="post" id="lginAndRegist" name="lginAndRegist">
        <input type="text" name="userName" class="userName" placeholder="userName">
        <input type="password" name="userPassword" class="userPassword" placeholder="userPassword">
        <button  id="loginSelector" onclick="login()">登录</button>
        <button  id="registerSelector" onclick="register()">注册</button>
        <div class="error"><span>+</span></div>
    </form>
    <div class="connect">
        <p>Or connect with:</p>
        <p>
            <a class="facebook" href=""></a>
            <a class="twitter" href=""></a>
        </p>
    </div>
</div>
<div align="center">Collect from <a href="" target="_blank" title="callRing">callRing</a></div>

<!-- Javascript -->

<!--         <script src="js/login/jquery-1.8.2.min.js"></script> -->
<script src="${pageContext.request.contextPath}/js/login/supersized.3.2.7.min.js"></script>
<script src="${pageContext.request.contextPath}/js/login/supersized-init.js"></script>
<!--  <script src="js/login/scripts.js"></script> -->

</body>

</html>


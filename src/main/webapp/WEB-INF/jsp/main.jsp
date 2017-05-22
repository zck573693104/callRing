<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//basePath = "http://localhost:8080/manager_4/"
%>
<!DOCTYPE HTML>
<html>
<head>
    <title>callRing</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <!--[if lte IE 8]>
    <script src="<%=basePath%>css/ie/html5shiv.js"></script><![endif]-->
    <script src="<%=basePath%>jquery/jquery-1.6.2.min.js"></script>
    <script src="<%=basePath%>js/jquery.poptrox.min.js"></script>
    <script src="<%=basePath%>js/skel.min.js"></script>
    <script src="<%=basePath%>js/init.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/uploadFile.css" />
    <noscript>
        <link rel="stylesheet" href="<%=basePath%>css/skel.css"/>
        <link rel="stylesheet" href="<%=basePath%>css/style.css"/>
        <link rel="stylesheet" href="<%=basePath%>css/style-xlarge.css"/>
        <link rel="stylesheet" href="<%=basePath%>css/style-file.css"/>
</noscript>
    <!--[if lte IE 8]>
    <link rel="stylesheet" href="css/ie/v8.css"/><![endif]-->
    <!-- 异步查询自我介绍 -->
<script type="text/javascript">
        $(function () {
            $.ajax({
                url: '${pageContext.request.contextPath}/user/queryUserInfo.action',
                type: 'POST',
                dataType: 'JSON',
                success: function (data) {
                    var json=eval(data);
                    console.log(json);
                    $.each(json,function(index,item){
                        var introduceTittle=json[index].introduceTittle;
                        var introduceContent=json[index].introduceContent;
                        $('#'+"introduceTittle").text(introduceTittle);
                        

                    });;
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    console.dir(textStatus);
                    console.dir(XMLHttpRequest);
                }
            })
        });
    </script>
    <!-- 异步查询日志 -->
    <script type="text/javascript">
        $(function() {
            $.ajax({
                url: '${pageContext.request.contextPath}/logday/queryLogDay.action',
                type: 'POST',
                dataType: 'JSON',
                success: function (data) {
                    var json=eval(data);
                    console.log(json);
                    $.each(json,function(index,item){
                        var logDayTittle=json[index].logDayTittle;
                        var logDayContext=json[index].logDayContext;
                        $('#'+"logDay").append("<h4>"+logDayTittle+"</h4>");
                        $('#'+"logDay").append("<p>"+logDayContext+"</P>");

                    });;
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    console.dir(textStatus);
                    console.dir(XMLHttpRequest);
                }
            })
        });
    </script>
    <!-- 修改个性签名 -->
    <script>
        function modifyIntroduce(){
            var introduceTittle=$("#introduceTittle").text();
            var introduceContent=$("#introduceContent").text();
            $("#modifyIntroduce").attr("href","${pageContext.request.contextPath}/jsp/updateOrInsertIntroduce.jsp?introduceTittle="+introduceTittle+"&introduceContent="+introduceContent);
        };
    </script>
    <!-- 修改头像 -->
    <script type="text/javascript">
        $(function updatePicPath(){
            $("#updatePicPathSubmit").bind("click", function () {
            	var s=$("#updatePicPath").val();
            	if(s==""){
            		alert("请选择头像");
            	}
            	if(s!=""){
            		var url = "${pageContext.request.contextPath}/user/updatePicPath.action";
                    //更改form的action
                    $("#updatePicPathForm").attr("action", url);
                    //触发submit事件，提交表单
                    $("#updatePicPathForm").submit();
                    
                   }
                });
        });

    </script>
    <!-- 上传图片 -->
    <script type="text/javascript">
        $(function insertPicPath(){
            $("#insertPicPathSubmit").bind("click", function () {
            	var s=$("#insertPicPath").val();
            	if(s==""){
            		alert("请选择图片");
            	}
            	if(s!=""){
            		var url = "${pageContext.request.contextPath}/graphTheory/insertPicPath.action";
                    //更改form的action
                    $("#insertPicPathForm").attr("action", url);
                    //触发submit事件，提交表单
                    $("#insertPicPathForm").submit();
                    
                   }
                });
        });

    </script>
    
</head>
<body id="top">

<!-- Header -->
<header id="header">
    <a href="<%=basePath%>upload/callRing/${userHeadPortraitPath}"  class="image avatar"><img src="<%=basePath%>upload/callRing/${userHeadPortraitPath}" id="head" alt=""/></a>
    <%--<form action="" method="post" enctype="multipart/form-data" id="updatePicPathForm">
          <a   href="javascript: void(0);" class="btn_addPic" ><span><EM>+</EM>修改头像</span>
          <input  class="filePrew"  tabIndex="3" type="file" size="3" name="userHeadPortrait" id="updatePicPath"/>
           </a>
           <input type="button"  id="updatePicPathSubmit" onclick="updatePicPath()" value="提交"/>
          </form>
    --%>
    <h1><strong>${userName}
    </strong>brilliant<br/>
        的设计<br/>
        。</h1>
    </form>
</header>

<!-- Main -->
<div id="main">
    &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp<a href="<%=basePath%>jsp/contact.jsp">进入 your call时代</a>
    &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
    <a href="<%=basePath%>jsp/chat.jsp">常call</a>
    &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
    <a href="">寻找可call</a>
    <!-- One -->
    <section id="one">

        <header class="major">
            <h2 id="introduceTittle"></h2>
        </header>
        <p id="introduceContent"></p>
        <%--<ul class="actions">
            <li><a  id="modifyIntroduce" href="" onclick="modifyIntroduce()"  class="button">me的展示</a></li>
        </ul>

    --%></section>

    <!-- Two -->
    <section id="two"><%--
        <form action="" method="post" enctype="multipart/form-data" id="insertPicPathForm"> 
          
            <a class="btn_addPic" href="javascript:void(0);"><span><EM>+</EM>call图</span>
                <input id="insertPicPath" class="filePrew"  tabIndex="3" type="file" size="3" name="graphTheories" multiple></a>
            </br> <input type="button"  value="提交"  id="insertPicPathSubmit" onclick="insertPicPath()"/>
        </form>
        --%><%--<h2>传达</h2>

        --%><div class="row">
            <c:forEach items="${graphTheoryList}"  varStatus="status">
               <article class="6u 12u$(xsmall) work-item" id="graphTheory">

                   <a   href="<%=basePath%>upload/callRing/${graphTheoryList[status.index].graphTheoryImagePicPath}"  class="image fit thumb"><img id="image1" src="<%=basePath%>upload/callRing/${graphTheoryList[status.index].graphTheoryImagePicPath}" alt=""/></a>

                    <h3 >${graphTheoryList[status.index].graphTheoryContent}</h3>

                    
                </article>
           </c:forEach>

        </div>
        <%--<ul class="actions">
            <li><a href="#" class="button">Full Portfolio</a></li>
        </ul>

    --%></section>

    <!-- Three -->
    <%--<section id="three">
        <h2>根据你的心情来定，想要什么找作者</h2>

        <p>下面是call</p>

        <div class="row">
            <div class="8u 12u$(small)">
                <form method="post" action="${pageContext.request.contextPath}/contactWay/insertContactWay.action">
                    <div class="row uniform 50%">
                      
                        <div class="6u$ 12u$(xsmall)"><input type="email" name="contactWayEmail" id="email" placeholder="Email"/>
                        </div>
                        <div class="12u$"><textarea name="contactWayMessage" id="message" placeholder="Message"
                                                    rows="4"></textarea></div>
                    </div>

                    <ul class="actions">
                        <li><input type="submit" value="Send Message"/></li>
                    </ul>
                </form>
            </div>
            <div class="4u$ 12u$(small)">
                <ul class="labeled-icons">
                    <li>
                        <h3 class="icon fa-home"><span class="label">Address</span></h3>
                        这是我的住址<br/>
                        地球<br/>
                        中国
                    </li>
                    <li>
                        <h3 class="icon fa-mobile"><span class="label">Phone</span></h3>
                        13581777970
                    </li>
                    <li>
                        <h3 class="icon fa-envelope-o"><span class="label">Email</span></h3>
                        <a href="#">zck573693104@gmail.com</a>
                    </li>
                </ul>
            </div>
        </div>
    </section>

    --%><!-- Four -->

    <section id="four">
        <%--<ul class="actions">
           <li><a  id="modifyLogDay" href="" onclick="modifyIntroduce()"  class="button">小说管理</a></li>
        </ul>
        --%>
        <section id="logDay">

        </section>

        <%--<section>
            <h4>Lists</h4>

            <div class="row">
                <div class="6u 12u$(xsmall)">
                    <h5>Unordered</h5>
                    <ul>
                        <li>Dolor pulvinar etiam magna etiam.</li>
                        <li>Sagittis adipiscing lorem eleifend.</li>
                        <li>Felis enim feugiat dolore viverra.</li>
                    </ul>
                    <h5>Alternate</h5>
                    <ul class="alt">
                        <li>Dolor pulvinar etiam magna etiam.</li>
                        <li>Sagittis adipiscing lorem eleifend.</li>
                        <li>Felis enim feugiat dolore viverra.</li>
                    </ul>
                </div>
                <div class="6u$ 12u$(xsmall)">
                    <h5>Ordered</h5>
                    <ol>
                        <li>Dolor pulvinar etiam magna etiam.</li>
                        <li>Etiam vel felis at lorem sed viverra.</li>
                        <li>Felis enim feugiat dolore viverra.</li>
                        <li>Dolor pulvinar etiam magna etiam.</li>
                        <li>Etiam vel felis at lorem sed viverra.</li>
                        <li>Felis enim feugiat dolore viverra.</li>
                    </ol>
                   
                </div>
            </div>
            <h5>Actions</h5>
            <ul class="actions">
                <li><a href="#" class="button special">Default</a></li>
                <li><a href="#" class="button">Default</a></li>
            </ul>
            <ul class="actions small">
                <li><a href="#" class="button special small">Small</a></li>
                <li><a href="#" class="button small">Small</a></li>
            </ul>
            <div class="row">
                <div class="6u 12u$(small)">
                    <ul class="actions vertical">
                        <li><a href="#" class="button special">Default</a></li>
                        <li><a href="#" class="button">Default</a></li>
                    </ul>
                </div>
                <div class="6u$ 12u$(small)">
                    <ul class="actions vertical small">
                        <li><a href="#" class="button special small">Small</a></li>
                        <li><a href="#" class="button small">Small</a></li>
                    </ul>
                </div>
                <div class="6u 12u$(small)">
                    <ul class="actions vertical">
                        <li><a href="#" class="button special fit">Default</a></li>
                        <li><a href="#" class="button fit">Default</a></li>
                    </ul>
                </div>
                <div class="6u$ 12u$(small)">
                    <ul class="actions vertical small">
                        <li><a href="#" class="button special small fit">Small</a></li>
                        <li><a href="#" class="button small fit">Small</a></li>
                    </ul>
                </div>
            </div>
        </section>
			 --%><%--
			 <section>
            <h4>Image</h4>
            <h5>Fit</h5>

            <div class="box alt">
                <div class="row 50% uniform">
                    <div class="12u$"><span class="image fit"><img src="<%=basePath%>img/fulls/05.jpg" alt=""/></span></div>
                    <div class="4u"><span class="image fit"><img src="<%=basePath%>img/thumbs/01.jpg" alt=""/></span></div>
                    <div class="4u"><span class="image fit"><img src="<%=basePath%>img/thumbs/02.jpg" alt=""/></span></div>
                    <div class="4u$"><span class="image fit"><img src="<%=basePath%>img/thumbs/03.jpg" alt=""/></span></div>
                    <div class="4u"><span class="image fit"><img src="<%=basePath%>img/thumbs/04.jpg" alt=""/></span></div>
                    <div class="4u"><span class="image fit"><img src="<%=basePath%>img/thumbs/05.jpg" alt=""/></span></div>
                    <div class="4u$"><span class="image fit"><img src="<%=basePath%>img/thumbs/06.jpg" alt=""/></span></div>
                    <div class="4u"><span class="image fit"><img src="<%=basePath%>img/thumbs/03.jpg" alt=""/></span></div>
                    <div class="4u"><span class="image fit"><img src="<%=basePath%>img/thumbs/02.jpg" alt=""/></span></div>
                    <div class="4u$"><span class="image fit"><img src="<%=basePath%>img/thumbs/01.jpg" alt=""/></span></div>
                </div>
            </div>
           </section>

    --%>
    </section>


</div>

<!-- Footer -->
<footer id="footer">
    <ul class="icons">
        <li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
        <li><a href="#" class="icon fa-github"><span class="label">Github</span></a></li>
        <li><a href="#" class="icon fa-dribbble"><span class="label">Dribbble</span></a></li>
        <li><a href="#" class="icon fa-envelope-o"><span class="label">Email</span></a></li>
    </ul>
    
</footer>




</body>
</html>
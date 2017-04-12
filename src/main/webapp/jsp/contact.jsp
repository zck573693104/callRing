﻿<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//basePath = "http://localhost:8080/manager_4/"
%>
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=750,target-densitydpi=340,user-scalable=no">
<title>主页</title>
<link rel="stylesheet" type="text/css" href="../css/poppup.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/swiper.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/uploadFile.css" />
<link rel="stylesheet" type="text/css" href="../js/layer/skin/default/layer.css"/>
<script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/swiper.js"></script>
<script src="../js/layer/mobile/layer.js"></script>
<style>
    .nav{ background:#fff;height:320px;overflow:auto;}
    .nav li{ height:100px; border-bottom:1px #dfdfdf solid; cursor:pointer}
    #dowebok { background-color: #fff; display:none}
    .block{ display:block !important;}
    #dowebok .nav {list-style-type: none; }
    #dowebok .nav button{ width:80%; height:80px; background:#D2691E; border:none; border-radius:50px; color:#fff; font-size:35px; outline:none}
    #dowebok .nav a { display: block; line-height:100px; padding: 0 20px; text-align:center; color: #333333; font-size:40px; text-decoration: none;}
    /************消息*****************/
    .news{}
    .news ul{}
    .news ul li{ height:100px; border-bottom:1px #dfdfdf solid; padding:0px 20px;}
    .news ul li .lf{ float:left; position:relative;}
    .news ul li .lf img{ display:block;width:60px; height:60px; border-radius:100%; border:4px #fff solid; margin-top:12px; float:left}
    .news ul li .lf h1{ float:left; line-height:100px; font-size:30px; padding-left:30px}
    .news ul li .lf span{ position:absolute; left:47px; top:12px; background:#D2691E; color:#fff; width:25px; height:25px; text-align:center; line-height:25px; border-radius:100%;}
    .news ul li .rt{ float:right; padding-top:40px}
    .news ul li .rt span{ font-size:25px;}


    /************好友*****************/
    .group{}
    .group ul{ display:none}
    .group .group_tit{ height:100px;  padding:0px 20px; line-height:100px; background:url(${pageContext.request.contextPath}/img/70%20Basic%20Icons-all-59.svg) 25px 29px no-repeat }
    .group .group_tit{border-bottom:1px #dfdfdf solid;}
    .group .group_tit h1{font-size:30px; padding-left:60px}
    .cheg ul{ display:block !important}
    .cheg .group_tit{background:url(./img/70%20Basic%20Icons-all-60.svg) 25px 29px no-repeat !important}


    /************空间*****************/
    .space{}
    .space ul{}
    .space li{ background:#fff; border-bottom:none !important; height:auto !important; padding-bottom:50px !important; margin-bottom:30px !important


    }
    .space .lf{}
    .space .rt{}
    .space .say{ padding:0px 10px; color:#2D2D2D; font-size:32px; line-height:38px; text-indent:63px}
    .space .carry{ height:80px; line-height:80px; margin-top:30px; border-bottom:1px #dfdfdf solid;}
    .space .carry .carry_lf{ font-size:30px; color:#8A8A8A; float:left}
    .space .carry .carry_rt{ float:right}
    .space .carry .carry_rt span{ display:inline-block; width:42px; height:40px; margin-right:60px; margin-top:20px}
    .comment{ padding:20px 0px}
    .comment .zan{}
    .comment .zan h1{ color:#3773A7; font-size:30px; background:url(${pageContext.request.contextPath}/img/a7.jpg) 0px 0px no-repeat; padding-left:60px; line-height:38px; font-weight:normal}
    .comment .zan h1 span{}
    .comment h2{ color:#2D2D2D;line-height:50px; font-weight:normal;font-size:30px;}
    .comment h2 span{color:#3773A7;font-weight:normal;font-size:30px;}
    .inpt{ text-align:center}
    .inpt input{ width:80%; padding:0px 5%; height:60px; line-height:50px; font-size:30px; border-radius:10px; border:1px #dfdfdf solid; outline:none;}

    /************写说说*****************/
    .say_say{ padding:40px}
    .say_say h3{ height:120px; line-height:120px; font-size:35px}
    .say_say textarea{ width:90%; padding:5%; border:1px #dfdfdf solid; font-size:30px; border:1px #dfdfdf solid; border-radius:10px; outline:none}

    .btn{ text-align:center;}
    .btn button{ position:relative;padding:0;width:300px; height:100px; background:#FD4C5B; border:none; border-radius:10px; color:#fff; font-size:25px; margin:10px;outline:none; }
.img-up{position:absolute;width:300px;left:0;top:0;bottom:0;opacity:0;}
.default-page{padding-top:120px;width:750px;}
    .default-page img{
        width:200px;
        height:150px;
        margin-left:272px;
        margin-bottom:10px;
    }
    .default-page .txt{
        text-align:center;
        font-size:14px;
    }
    .swiper-slide{
        cursor:pointer;
    }
    .nav_li{height:280px !important;}
    .swiper-wrapper .tab{
        width:20% !important;
    }
    .nav-bar{
        background:url(../img/背景.jpg) no-repeat !important;
        background-size:100% 100%;
    }
    .set{
        background-color:transparent !important;
    }
</style>
</head>
<script>
    $(function () {
        $.ajax({
            url: '${pageContext.request.contextPath}/message/countMessageList.action',
            type: 'POST',
            async: true,
            dataType: 'JSON',
            success: function (data) {
                var json=eval(data);
                $.each(json,function(index,item){
                    var count=json[index].count;
                    var userName=json[index].userName;
                    var sendDaetString=json[index].sendDaetString;
                    var friendgraphTheoryImagePicPath=null;

                    $('#'+"message").append('<li id="'+userName+'">'+'</li>');
                    $('#'+"message").find('#'+userName).append('<div class="lf">'+'</div>');
                    $('#'+"message").find('#'+userName).find("div").append('<a  href="${pageContext.request.contextPath}/jsp/chat.jsp?friendName='+userName+'&friendgraphTheoryImagePicPath='+friendgraphTheoryImagePicPath+'" data-ajax="false">'+'</a>');



                    $('#'+"message").find('#'+userName).find("div").find("a").append('<img src="" class="commentAvatarDiv"/>');
                    $('#'+"message").find('#'+userName).find("div").find("a").find("img").attr("src","<%=basePath%>upload/callRing/"+friendgraphTheoryImagePicPath);
                    $('#'+"message").find('#'+userName).find("div").find("a").append('<h1>'+userName+'</h1>');
                    $('#'+"message").find('#'+userName).find("div").find("a").append('<span>'+count+'</span>');
                    $('#'+"message").find('#'+userName).append('<div class="rt" id="rt">'+'</div>');
                    $('#'+"message").find('#'+userName).find('#'+"rt").append('<span>'+sendDaetString+'</span>');
                });;
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                console.dir(textStatus);
                console.dir(XMLHttpRequest);
            }
        })
    })

</script>

<script>

    $(document).ready(function (){
        $("#data-transition").bind('click', function(){
            window.location="${pageContext.request.contextPath}/jsp/profile.jsp";
        });
    });

    $(function() {
        $.ajax({
            url: '${pageContext.request.contextPath}/friend/queryOftenChatFriend.action',
            type: 'POST',
            dataType: 'JSON',
            success: function (data) {
                var json=eval(data);
                console.log(json);

                $.each(json,function(index,item){
                    var friendName=json[index].friendName;
                    var friendIntroduceTittle=json[index].friendIntroduceTittle;
                    var friendgraphTheoryImagePicPath=json[index].friendgraphTheoryImagePicPath;
                    $('#'+"student").append('<li id="'+friendName+'">'+'</li>');
                    $('#'+"student").find('#'+friendName).append('<div class="lf">'+'</div>');
                    $('#'+"student").find('#'+friendName).find("div").append('<a  target="_blank" href="${pageContext.request.contextPath}/jsp/chat.jsp?friendName='+friendName+'&friendgraphTheoryImagePicPath='+friendgraphTheoryImagePicPath+'" data-ajax="false">'+'</a>');



                    $('#'+"student").find('#'+friendName).find("div").find("a").append('<img src="" class="commentAvatarDiv"/>');
                    $('#'+"student").find('#'+friendName).find("div").find("a").find("img").attr("src","<%=basePath%>upload/callRing/"+friendgraphTheoryImagePicPath);
                    $('#'+"student").find('#'+friendName).find("div").find("a").append('<h1>'+friendName+'</h1>');



                });;
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                console.dir(textStatus);
                console.dir(XMLHttpRequest);
            }
        })
    });
</script>
<script>
    var userName=null;
    $(function addFriend(){
        $("#addFriendId").bind("click", function () {
            <%--$.ajax({--%>
                <%--url: '${pageContext.request.contextPath}/friend/addFriend.action',--%>
                <%--type: 'POST',--%>
                <%--async: true,--%>
                <%--dataType: 'JSON',--%>
                <%--success: function (data) {--%>
                    <%--var json=eval(data);--%>
                    <%--$.each(json,function(index,item){--%>
                        <%--userName=json[index].userName;--%>
                        <%--var userHeadPortraitPath=json[index].userHeadPortraitPath;--%>
                        <%--$('#'+"addFriend").append('<li id="'+userName+'">'+'</li>');--%>
                        <%--$('#'+"addFriend").find('#'+userName).append('<form id="'+userName+'form" action="${pageContext.request.contextPath}/becomeFriend.action?userName='+userName+'&friendgraphTheoryImagePicPath='+userHeadPortraitPath+'" method="post">'+'</form>');--%>
                        <%--$('#'+"addFriend").find('#'+userName).find("form").append('<a  href="javascript:document.getElementById(\''+userName+'form\').submit();" data-ajax="false" >'+'</a>');--%>
                        <%--$('#'+"addFriend").find('#'+userName).find("form").find("a").append('<div class="commentAvatarDiv">'+'</div>');--%>
                        <%--$('#'+"addFriend").find('#'+userName).find("form").find("a").find("div").append('<img  src="'+userName+'+"Img"" class="commentAvatarDiv"  />');--%>
                        <%--$('#'+"addFriend").find('#'+userName).find("form").find("a").find("div").find("img").attr("src","<%=basePath%>upload/callRing/"+userHeadPortraitPath);--%>

                    <%--});;--%>
                <%--},--%>
                <%--error: function (XMLHttpRequest, textStatus, errorThrown) {--%>
                    <%--console.dir(textStatus);--%>
                    <%--console.dir(XMLHttpRequest);--%>
                <%--}--%>
            <%--})--%>
            window.location.href="./addFriend.jsp";
        })

    });
</script>

<!-- 上传图片 -->
<script type="text/javascript">
    $(function insertPicPath(){
        $("#insertPicPathSubmit").bind("click", function () {
            var s=$("#insertPicPath").val();
//            if(s==""){
//                alert("请选择图片");
//            }
//            if(s!=""){
                var url = "${pageContext.request.contextPath}/graphTheory/insertPicPath.action";
                //更改form的action
                $("#insertPicPathForm").attr("action", url);
                //触发submit事件，提交表单
                $("#insertPicPathForm").submit();

            //}
        });
    });

</script>
<script>
    $.ajax({
        url: '${pageContext.request.contextPath}/friend/selectFriendLogDay.action',
        type: 'POST',
        async: true,
        dataType: 'JSON',
        success: function (data) {
                    var json=eval(data);
                    $.each(json,function(index,item){

                       var friendName=json[index].friendName;
                       var logDayContext=json[index].logDayContext;
                       var userHeadPortraitPath=json[index].userHeadPortraitPath;
                       var logDateString=json[index].logDateString;
                        var id=json[index].id;
                        $('#'+"spanl").append('<li id="'+id+'">'+'</li>');
                        $('#'+"spanl").find('#'+id).append('<div class="lf">'+'</div>');
                        $('#'+"spanl").find('#'+id).find("div").append('<img src="<%=basePath%>upload/callRing/"+"'+userHeadPortraitPath+'">'+'</img>');
                        $('#'+"spanl").find('#'+id).find("div").append('<h1>'+friendName+'<h1>');
                        $('#'+"spanl").find('#'+id).append('<div class="rt">'+'</div>');
                        $('#'+"spanl").find('#'+id).append('<span>'+logDateString+'</span>');
                        $('#'+"spanl").find('#'+id).append('<div  style="clear:both">'+'</div>');
                        $('#'+"spanl").find('#'+id).append('<p class="say">'+logDayContext+'</p>');

                    });;
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    console.dir(textStatus);
                    console.dir(XMLHttpRequest);
                }


    });
</script>
<body id="body_bg">
<!-- dialog-->
<div class="chat-dialog undis" id="chat-dialog">
    <div class="drop-wrap">
        <!--自己-->
        <ul class="self">
            <li class="clearfix">
                <img src="./1.jpg" class="head-img pull-right" />
                <div class="chat-text pull-right mr-10 bg-ff">你好</div>

            </li>

            <li class="clearfix">
                <img src="./2.jpg" class="head-img pull-left" />
                <div class="chat-text pull-left ml-10 bg-green">你好</div>
            </li>
            <li class="clearfix">
                <img src="./1.jpg" class="head-img pull-right" />
                <div class="chat-text pull-right mr-10 bg-ff">你好</div>

            </li
        </ul>
        <!--好友-->
        <ul class="other">

        </ul>
    </div>

    <div class="dt-btns">
        <input type="text" id="msg" />
        <a href="javascript:;" class="btn-md btn-gray btn-submit" btn-submit onclick="sendMsg()">发送</a>
        <a href="javascript:;" class="btn-md btn-gray btn-close" btn-close>关闭</a>
    </div>
</div>

<div class="homepage">
    <c:choose>
        <c:when test="${userHeadPortraitPath==null}">
            <div class="set" id="toggle-sidebar" style="width: 136.364px; float:left">
                <img src="${pageContext.request.contextPath}/upload/callRing/default.jpg" />
            </div>
        </c:when>
        <c:when test="${userHeadPortraitPath!=null}">
            <div class="set" id="toggle-sidebar" style="width: 136.364px; float:left">
                <img src="${pageContext.request.contextPath}/upload/callRing/${userHeadPortraitPath}" />
            </div>
        </c:when>
    </c:choose>

    <div class="swiper-container  ws0701_tab_top nav-bar" id="swiper-container2" style="background:#D2691E; position:fixed;top:0px; right:0px; width:100%; z-index:10;">
        <!--------------功能列表-------------->
        <div class="swiper-wrapper" style="float:right; width:80%;">
            <div class="swiper-slide active-nav tab" style="width: 136.364px;">
                <span>消息</span>
            </div>
            <div class="swiper-slide tab" style="width: 136.364px;">
                <span>好友</span>
            </div>
            <div class="swiper-slide tab" style="width: 136.364px;">
                <span>空间</span>
            </div>
            <div class="swiper-slide tab" style="width: 136.364px;">
                <span>写说说</span>
            </div>
            <div class="swiper-slide tab" style="width: 136.364px;">
                <span id="addFriendId">添加好友</span>
            </div>
        </div>
    </div>
    <div class="ws0701_container" style="margin-top:120px;">
        <div class="swiper-container" id="swiper-container3" style="width:100%;">
            <div class="swiper-wrapper" style="height: 488px; transform: translate3d(0px, 0px, 0px); transition-duration: 0ms;">
                <!--------------消息-------------->
                <div class="swiper-slide news" style="width:750px;height:900px; overflow:auto">
                    <div class="default-page">
                        <img src="${pageContext.request.contextPath}/img/nomsg.png" />
                        <p class="txt">暂无内容~</p>
                    </div>
                    <ul id="message">
                        <%--<li>--%>
                            <%--<div class="lf">--%>
                                <%--<img src="${pageContext.request.contextPath}/img/a1.png" />--%>
                                <%--<h1>幽谷草</h1>--%>
                                <%--<span>14</span>--%>
                            <%--</div>--%>
                            <%--<div class="rt">--%>
                                <%--<span>上午10:58</span>--%>
                            <%--</div>--%>
                        <%--</li>--%>

                    </ul>
                </div>
                <!--------------好友-------------->
                <div class="swiper-slide" style="width: 750px;height:900px;overflow:auto">
                    <div class="group news">
                        <div class="group_tit">
                            <h1>同学</h1>
                        </div>
                        <ul id="student">
                            <%--<li>--%>
                            <%--<div class="lf">--%>
                            <%--<a href="chat.jsp"><img src="${pageContext.request.contextPath}/img/a1.png" /></a>--%>
                            <%--<h1>幽谷草</h1>--%>
                            <%--</div>--%>

                            <%--</li>--%>
                            <%--<li>--%>
                            <%--<div class="lf">--%>
                            <%--<img src="${pageContext.request.contextPath}/img/a1.png" />--%>
                            <%--<h1>幽谷草</h1>--%>
                            <%--</div>--%>
                            <%--<div class="rt">--%>
                            <%--<span></span>--%>
                            <%--</div>--%>
                            <%--</li>--%>
                            <%--<li>--%>
                            <%--<div class="lf">--%>
                            <%--<img src="${pageContext.request.contextPath}/img/a1.png" />--%>
                            <%--<h1>幽谷草</h1>--%>
                            <%--</div>--%>
                            <%--<div class="rt">--%>
                            <%--<span></span>--%>
                            <%--</div>--%>
                            <%--</li>--%>
                        </ul>
                    </div>
                    <div class="group news">
                        <div class="group_tit">
                            <h1>同学</h1>
                        </div>
                        <ul>
                            <li chat-both chat-dlog>
                                <div class="lf" >
                                    <img src="${pageContext.request.contextPath}/img/a1.png" />
                                    <h1>幽谷草</h1>
                                </div>
                                <div class="rt">
                                    <span></span>
                                </div>
                            </li>
                            <li chat-both>
                                <div class="lf">
                                    <img src="${pageContext.request.contextPath}/img/a1.png" />
                                    <h1>幽谷草</h1>
                                </div>
                                <div class="rt">
                                    <span></span>
                                </div>
                            </li>
                            <li chat-both>
                                <div class="lf">
                                    <img src="${pageContext.request.contextPath}/img/a1.png" />
                                    <h1>幽谷草</h1>
                                </div>
                                <div class="rt">
                                    <span></span>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="group news">
                        <div class="group_tit">
                            <h1>同学</h1>
                        </div>
                        <ul>
                            <li>
                                <div class="lf">
                                    <img src="${pageContext.request.contextPath}/img/a1.png" />
                                    <h1>幽谷草</h1>
                                </div>
                                <div class="rt">
                                    <span></span>
                                </div>
                            </li>
                            <li>
                                <div class="lf">
                                    <img src="${pageContext.request.contextPath}/img/a1.png" />
                                    <h1>幽谷草</h1>
                                </div>
                                <div class="rt">
                                    <span></span>
                                </div>
                            </li>
                            <li>
                                <div class="lf">
                                    <img src="${pageContext.request.contextPath}/img/a1.png" />
                                    <h1>幽谷草</h1>
                                </div>
                                <div class="rt">
                                    <span></span>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
                <!--------------空间-------------->
                <div class="swiper-slide" style="width: 750px;height:900px;overflow:auto; background:#ECECEC">
                    <div class="space news">
                        <div class="default-page">
                            <img src="${pageContext.request.contextPath}/img/nomsg.png" />
                            <p class="txt">暂无内容~</p>
                        </div>
                        <ul id="spanl">
                            <%--<li>--%>
                                <%--<div class="lf">--%>
                                    <%--<img src="${pageContext.request.contextPath}/img/a1.png" />--%>
                                    <%--<h1>幽谷草</h1>--%>
                                <%--</div>--%>
                                <%--<div class="rt">--%>
                                    <%--<span>上午10:58</span>--%>
                                <%--</div>--%>
                                <%--<div style="clear:both"></div>--%>
                                <%--<p class="say">--%>
                                    <%--东风夜放花千树，更吹落、星如雨。宝马雕车香满路。凤箫声动，玉壶光转，一夜鱼龙舞。--%>
                                    <%--　　蛾儿雪柳黄金缕，笑语盈盈暗香去。众里寻他千百度。蓦然回首，那人却在，灯火阑珊处。--%>
                                <%--</p>--%>
                                <%--<div class="carry">--%>
                                    <%--<div class="carry_lf">--%>
                                        <%--共浏览11次--%>
                                    <%--</div>--%>
                                    <%--<div class="carry_rt">--%>
                                        <%--<span style="background:url(${pageContext.request.contextPath}/img/a5.jpg)"></span>--%>
                                        <%--<span style="background:url(${pageContext.request.contextPath}/img/a6.jpg)"></span>--%>
                                    <%--</div>--%>
                                    <%--<div style="clear:both"></div>--%>
                                <%--</div>--%>
                                <%--<div class="comment">--%>
                                    <%--<div class="zan">--%>
                                        <%--<h1>--%>
                                            <%--<span>吃瓜</span>、--%>
                                            <%--<span>群众</span>--%>
                                        <%--</h1>--%>
                                    <%--</div>--%>
                                    <%--<h2>--%>
                                        <%--<span>吃瓜：</span>--%>
                                        <%--此地无银三百两--%>
                                    <%--</h2>--%>
                                    <%--<h2>--%>
                                        <%--<span>群众：</span>--%>
                                        <%--隔壁王二不曾偷--%>
                                    <%--</h2>--%>
                                <%--</div>--%>
                                <%--<div class="inpt">--%>
                                    <%--<input type="text" />--%>
                                <%--</div>--%>
                            <%--</li>--%>
                            <%--<li>--%>
                                <%--<div class="lf">--%>
                                    <%--<img src="${pageContext.request.contextPath}/img/a1.png" />--%>
                                    <%--<h1>${userName}</h1>--%>
                                <%--</div>--%>
                                <%--<div class="rt">--%>
                                    <%--<span>上午10:58</span>--%>
                                <%--</div>--%>
                                <%--<div style="clear:both"></div>--%>
                                <%--<p class="say">--%>
                                    <%--东风夜放花千树，更吹落、星如雨。宝马雕车香满路。凤箫声动，玉壶光转，一夜鱼龙舞。--%>
                                    <%--　　蛾儿雪柳黄金缕，笑语盈盈暗香去。众里寻他千百度。蓦然回首，那人却在，灯火阑珊处。--%>
                                <%--</p>--%>
                                <%--<div class="carry">--%>
                                    <%--<div class="carry_lf">--%>
                                        <%--共浏览11次--%>
                                    <%--</div>--%>
                                    <%--<div class="carry_rt">--%>
                                        <%--<span style="background:url(${pageContext.request.contextPath}/img/a5.jpg)"></span>--%>
                                        <%--<span style="background:url(${pageContext.request.contextPath}/img/a6.jpg)"></span>--%>
                                    <%--</div>--%>
                                    <%--<div style="clear:both"></div>--%>
                                <%--</div>--%>
                                <%--<div class="comment">--%>
                                    <%--<div class="zan">--%>
                                        <%--<h1>--%>
                                            <%--<span>吃瓜</span>、--%>
                                            <%--<span>群众</span>--%>
                                        <%--</h1>--%>
                                    <%--</div>--%>
                                    <%--<h2>--%>
                                        <%--<span>吃瓜：</span>--%>
                                        <%--此地无银三百两--%>
                                    <%--</h2>--%>
                                    <%--<h2>--%>
                                        <%--<span>群众：</span>--%>
                                        <%--隔壁王二不曾偷--%>
                                    <%--</h2>--%>
                                <%--</div>--%>
                                <%--<div class="inpt">--%>
                                    <%--<input type="text" />--%>
                                <%--</div>--%>
                            <%--</li>--%>
                        </ul>
                    </div>
                </div>
                <!--------------写说说-------------->
                <div class="swiper-slide" style="width: 750px;height:900px;overflow:auto">
                    <form action="" method="post" enctype="multipart/form-data" id="insertPicPathForm">
                    <div class="say_say">
                        <h3>有什么新鲜事想要告诉大家?</h3>
                        <textarea name="graphTheoryContent"
                                value="说点什么吧..."
                                onfocus="if(this.value=='说点什么吧...'){this.value=''}"
                                onblur="if(this.value==''){this.value='说点什么吧...';}"
                        >说点什么吧...</textarea>
                    </div>
                    <div class="btn">

                            <button style="background:#F90">上传图片<input id="insertPicPath"  name="graphTheories"multiple type="file" class="img-up"/></button>
                        <button>发表<input type="submit" class="img-up" id="insertPicPathSubmit" onclick="insertPicPath()"/></button>
                    </div>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<!------------侧边栏导航------------------------>
<div id="dowebok">
    <div class="nav_li" >
        <c:choose>
            <c:when test="${userHeadPortraitPath==null}">
                <img src="${pageContext.request.contextPath}/upload/callRing/default.jpg" style=" display:block;margin:auto" />
            </c:when>
            <c:when test="${userHeadPortraitPath!=null}">
                <img src="${pageContext.request.contextPath}/upload/callRing/${userHeadPortraitPath}"  style=" display:block;margin:auto"/>
            </c:when>
        </c:choose>

        <p class="nickname">${userName}</p>
        <p class="mood">${userIntroduce}</p>
    </div>
    <ul class="nav">
        <li><a href="${pageContext.request.contextPath}/jsp/data.jsp" style="background:url(${pageContext.request.contextPath}/img/70%20Basic%20Icons-all-05.svg) 75px 30px no-repeat;">个人资料</a></li>
        <li><a href="${pageContext.request.contextPath}/jsp/feedback.jsp" style="background:url(${pageContext.request.contextPath}/img/70%20Basic%20Icons-all-63.svg) 75px 30px no-repeat">看</a></li>
        <li><a href="${pageContext.request.contextPath}/jsp/feedback.jsp" style="background:url(${pageContext.request.contextPath}/img/70%20Basic%20Icons-all-63.svg) 75px 30px no-repeat">意见反馈</a></li>
        <li><a href="${pageContext.request.contextPath}/jsp/about_us.jsp" style="background:url(${pageContext.request.contextPath}/img/70%20Basic%20Icons-all-16.svg) 75px 30px no-repeat">关于我们</a></li>
        <li style=" padding-top:10px; height:90px; text-align:center"><button onclick="location.href='${pageContext.request.contextPath}/logoin.jsp';">退出登陆</button></li>
    </ul>
</div>
<script src="${pageContext.request.contextPath}/js/simpler-sidebar.min.js"></script>
<script>
    $(".group_tit").click(function(){
        $(this).parent().toggleClass("cheg");
    })

    $("#toggle-sidebar").click(function(){
        $("#dowebok").addClass("block");
    })
    $(function() {
        $('#dowebok').simplerSidebar({
            opener: '#toggle-sidebar',
            sidebar: {
                align: 'left',
                width: 500,
            }
        });
    });
</script>
<script>
    var mySwiper1 = new Swiper('.swiper1',{
        pagination : '.swiper-pagination',
        paginationType : 'fraction',
    })

    var mySwiper2 = new Swiper('#swiper-container2',{
        watchSlidesProgress : true,
        watchSlidesVisibility : true,
        slidesPerView : 5.5,
        onTap: function(){
            mySwiper3.slideTo( mySwiper2.clickedIndex)
        }
    })

    var mySwiper3 = new Swiper('#swiper-container3',{
        autoHeight: true,
        onSlideChangeStart: function(){
            updateNavPosition()
        }
    })

    function updateNavPosition(){
        $('#swiper-container2 .active-nav').removeClass('active-nav')
        var activeNav = $('#swiper-container2 .swiper-slide').eq(mySwiper3.activeIndex).addClass('active-nav');
        if (!activeNav.hasClass('swiper-slide-visible')) {
            if (activeNav.index()>mySwiper2.activeIndex) {
                var thumbsPerNav = Math.floor(mySwiper2.width/activeNav.width())-1
                mySwiper2.slideTo(activeNav.index()-thumbsPerNav)
            }
            else {
                mySwiper2.slideTo(activeNav.index())
            }
        }
    }
</script>

<script type="text/javascript" src="../js/jquery.dlog.js"></script>
<script type="text/javascript">
    (function(){
        $(document).on('click','[chat-dlog]',function(){
            $('#chat-dialog').dlog({
                title:'小花',
                width:440,
                height:480
            });
            return false;
        });
        $('[btn-close]').on('click',function(){
            $('#chat-dialog')._dlogclose();
            return false;
        });
    })();

    function sendMsg(){
        var v=$("#msg").val();
        if(v==""){
            return;
        }else{
            var data={};
            data["userName"]=userName;
            data["friendName"]=friendName;
            data["text"]=v;
            websocket.send(JSON.stringify(data));

            $("#content").append( "<ul class='self'>"+
                "<li class='clearfix'>"+
                "<img src='./1.jpg' class='head-img pull-right' />"+
                "<div class='chat-text pull-right mr-10 bg-ff'>你好</div>"+"</li>"+" </ul>");
            scrollToBottom();
            $("#msg").val("");
        }
    }
</script>
</body>
</html>

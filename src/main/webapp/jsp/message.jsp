<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//basePath = "http://localhost:8080/manager_4/"
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="<%=basePath%>jquery/jquery.mobile-1.4.3.css">
<link rel="stylesheet" href="<%=basePath%>jquery/jquery.mobile.icons-1.4.3.css">
<link rel="stylesheet" href="<%=basePath%>jquery/jquery.mobile.theme-1.4.3.css">
<link rel="stylesheet" href="<%=basePath%>jquery/jquery.mobile.structure-1.4.3.css">
<link rel="stylesheet" href="<%=basePath%>jquery/jquery.mobile.inline-png-1.4.3.css">
<link rel="stylesheet" href="<%=basePath%>jquery/jquery.mobile.external-png-1.4.3.css">
    <script src="<%=basePath%>jquery/jquery-1.6.2.min.js"></script>
<script src="<%=basePath%>jquery/jquery.mobile-1.4.3.js"></script>
<script src="<%=basePath%>jquery/loading.js"></script>

</head>

<%--<script>  

$(document).ready(function (){
	$("#data-transition").bind('click', function(){
		window.location="./profile.jsp";
	});
});
	  
</script> 

--%>
<body>

  <div data-role="header" data-position="fixed">
    <h1>Blue Contact</h1>
    <form method="post" action="d"> 
    <a href="#" data-transition="fade"></a>
  </div>
 
  <div data-role="content">
    <ul data-role="listview">
      <li>
        <a href="chat.jsp" data-ajax="false">
        <img src="${pageContext.request.contextPath}/jquery/images/country/person1.jpg">
        <h2>${toName}</h2>
        <p></p>
        </a>
      </li>
      <li>
        <a href="chat.html" data-ajax="false">
        <img src="${pageContext.request.contextPath}/jquery/images/country/person2.jpg">
        <h2>Liu Xiao Tao</h2>
        <p>What's up?</p>
        </a>
      </li>
      </ul>
  </div>
  
	<div data-role="footer" data-position="fixed">
		<div data-role="navbar" data-iconpos="left">
			<ul>
				<li><a data-icon="plus" href="#" class="ui-btn-active ui-state-persist" >Message</a></li>
				 <li><a data-icon="plus" href="${pageContext.request.contextPath}/jsp/contact.jsp" data-ajax="false">Contact</a></li>
				<li><a data-icon="plus" href="${pageContext.request.contextPath}/jsp/profile.jsp" data-ajax="false">Profile</a></li>     
                <li><a data-icon="plus" data-rel="popup" href="#popupSure" data-transition="pop">Log Out</a>
<div data-role="popup" id="popupSure">
	<p>Are you sure to log Out from Blue Contact?</p>
	<div>
    <a>
    <button class="ui-btn ui-btn-b" id="btn_login">Sure</button>
	<button class="ui-btn ui-btn-b" id="btn_login">Cancel</button>
    </a>
</div>
</li>
			</ul>
		</div>
		<h4 style="display:none;">Footer</h4>
	</div>
</div>

</body>
</html>

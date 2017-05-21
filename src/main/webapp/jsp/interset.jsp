<%@ page contentType="text/html;charset=UTF-8" language="java" %>
﻿<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
<meta name="description" content="" />
<meta name="author" content="" />
<!--[if IE]>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<![endif]-->
<title>Home</title>
<!-- BOOTSTRAP CORE STYLE CSS -->
<link href="../interset/css/bootstrap.css" rel="stylesheet" />
<!-- FONTAWESOME CSS -->
<link href="../interset/css/font-awesome.css" rel="stylesheet" />
 <!-- STYLE SWITCHER CSS -->
<link href="../interset/css/style-switcher.css" rel="stylesheet" />
  <!-- CUSTOM STYLE CSS -->
<link href="../interset/css/style.css" rel="stylesheet" />
<!-- THEME COLOR STYLE ( DY DEFAULT IT IS HAVING RED COLOR YOUR CAN CHANGE IT BY REPLACEING red.css TO blue.css) -->
<link id="mainCSS" href="../interset/css/themes/red.css" rel="stylesheet" />
</head>
<body>
 <div class="switcher" style="left:-95px;">
	<a id="switch-panel" class="hide-panel" style="text-decoration:none;padding-top:7px;">
		<i >+</i>
	</a>
	<ul class="colors-list">           
		<li><a title="Blue" id="blue" class="blue" ></a></li>
		<li><a title="Red" id="red" class="red" ></a></li>
	</ul>
</div>	
<!-- STYLE SWITCHER DIV END-->
<div class="header-section">
		
		<div class="">
			<h1 class="name-logo"> COMPANY </h1>
		</div>

	</div>
<!--Main Header Section End-->
<div class="container subscribe-sec">
   <div class="row text-center">
	   <div class="col-lg-8 col-md-8 col-sm-8 col-lg-offset-2 col-md-offset-2 col-sm-offset-2 col-xs-12">
	  <h1 >  WE WILL BE LAUNCHING SOON</h1> 
		   <hr />
		   <h4 >SUBSCRIBE US TO KNOW WHEN WE WILL BE LIVE</h4>
		   <div class="">
			   <div class="input-group">
  <input type="text" class="form-control input-set"  />
  <span class="input-group-btn">
	<button class="btn btn-default btn-set" type="button" >SUBSCRIBE</button>
  </span>
</div>
			  
		   </div>
	   </div>
   </div>
</div>
  <!--Subscribe Section End-->
<div class="about-sec" >
	<div class="container" >
   <div class="row text-center">
	   <c:forEach  varStatus="status" items="${sessionScope.hotWordList} ">
	   <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 bdr-b-r pad-o" >
		  <i class="fa fa-ticket fa-5x" ></i>
		   <h3 >${sessionScope.hotWordList}</h3>
		   <p>
			   Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor.
		   </p>
	   </div>
	   </c:forEach>
		<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 bdr-b-r pad-o" >
		  <i class="fa fa-location-arrow fa-5x" ></i>
		   <h3 >LIGHT WEIGHT</h3>
		   <p>
			   Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor.
		   </p>
	   </div>
		<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 bdr-b pad-o" >
		  <i class="fa fa-lightbulb-o fa-5x" ></i>
		   <h3 >HAND CRAFTED</h3>
		   <p>
			   Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor.
		   </p>
	   </div>
   </div>
		<div class="row text-center">
	   <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 bdr-r pad-o" >
		  <i class="fa fa-circle-o-notch fa-5x" ></i>
		   <h3 > RESPONSIVE</h3>
		   <p>
			   Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor.
		   </p>
	   </div>
		<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 bdr-r pad-o" >
		  <i class="fa fa-code fa-5x" ></i>
		   <h3 >EASY CODING</h3>
		   <p>
			   Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor.
		   </p>
	   </div>
		<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 pad-o" >
		  <i class="fa fa-slack fa-5x" ></i>
		   <h3 >UNIQUE DESIGN</h3>
		   <p>
			   Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor.
		   </p>
	   </div>
   </div>
</div>
</div>
  <!--About Section End-->
<div class="container contact-sec">
   <div class="row text-center">
	   <div class="col-lg-6 col-md-6 col-sm-6 col-lg-offset-3 col-md-offset-3 col-sm-offset-3 col-xs-12">
	  <h1 >  DROP US A LINE</h1> 
		   <hr />
		 <h4 >243/789 , New Block, Road Side Template, USA</h4>
		   <br />
		   <div class="form-group">
						<input type="text" class="form-control" required="required" placeholder="Your Name" />
					</div>
					<div class="form-group">
						<input type="text" class="form-control" required="required" placeholder="Your Email" />
					</div>
					<div class="form-group">
						<textarea name="message" id="message" required="required" class="form-control" style="min-height: 80px;" placeholder="Message"></textarea>
					</div>
					<div class="form-group">
						<a href="#" class="btn btn-info btn-lg btn-block btn-send">SEND REQUEST</a>
					</div>
	   </div>
   </div>
</div>
 <!--Contact Section End-->
<div id="footer">Copyright &copy; 2017.Company name All rights reserved.<a target="_blank" href="http://www.aspku.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></div>
<!--Footer Section End-->

<!-- CORE SCRIPTS-->
<script src="../interset/js/jquery-1.11.1.js"></script>
 <!-- STYLE SWITCHER SCRIPTS-->
<script src="../interset/js/style-switcher.js">
	console.log("哈哈" );
</script>
</body>
</html>

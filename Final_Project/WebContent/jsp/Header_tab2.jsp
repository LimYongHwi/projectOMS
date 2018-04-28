<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <link href='http://fonts.googleapis.com/css?family=Noto+Sans' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script
  src="http://code.jquery.com/jquery-2.2.4.js"
  integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
  crossorigin="anonymous"></script>
  <script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
   <script>
   $(document).ready(function(){
	   	var id= "<%= (String)session.getAttribute("id")%>";
	   	if(id=="null"){
	   		  $('#login').html("로그인");
	       	  $('#join').html("회원가입");
	   	}else{
	    var admin="<%=(String)request.getAttribute("admin")%>";
	   		console.log(admin);	
	   		$('#login').html("로그아웃");
	   		if(admin=='Y'){
	   		  $('#join').html("관리페이지");
	   		}else{
	   		 $('#join').html("마이페이지");
	   		}
	   	}
   	
     $('.slider').bxSlider(
   		  {
   			  auto: true,
    		  pager: true,
    		  slideWidth : 1920,
    		  adaptiveHeight:true
   		  });
     $('#login').click(function(){
   	  var id= "<%= (String)session.getAttribute("id")%>";
   	  console.log(id);
   	  console.log(id=="null");
   	  if(id=="null"){
   		  url="loginform.do"
   	    	  window.open(url,"ChildLoginWin","width=500 height=400");
   	  }else{
   		  $('#login').html("로그인");
       	  $('#join').html("회원가입");
       	  location.href="logout.do?id="+id;
   	  }
     });
    
     $('#join').click(function(){
   	 location.href="joinform.do"; 
     });
     
   });

  </script>
<link rel="stylesheet" href="css/Header_tab1.css">
</head>
<body class="headerbody">
<div class="slider">
<div><img src="image/mainslide_1.jpg" id="slide_1"></div>
<div><img src="image/slide_2.jpg" id="slide_2"></div>
<div><img src="image/slide_3.jpg" id="slide_3"></div>
<div><img src="image/slide_4.jpg" id="slide_4"></div>
<div><img src="image/slide_5.jpg" id="slide_5"></div>
</div>
<div class="top">
<div class="logo">
<img src="image/logo.jpg" onclick="location.href='main.do'">
</div>
<div class="buttons">
<ul>
<div id="login_div" style="display:-webkit-inline-box">
<li id="login"></li>|
<li id="join"></li>|
</div>
<li id="login">번역</li>
</ul>
</div>
</div>
<div class="topmenu">
<ul>
<li onclick="location.href='recruit_main.do'">모집/계획</li>|
<li onclick="location.href='review_Main.do'">여행정보/후기</li>|
<li onclick="location.href='service_center_main.do'">고객센터</li>|
<li id="icon"><i class="fas fa-search fa-3x"></i></li>
<li id="icon"><i class="fas fa-align-justify fa-3x"></i></li>
</ul>
</div>
</body>
</html>
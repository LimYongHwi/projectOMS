<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href='http://fonts.googleapis.com/css?family=Noto+Sans'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="http://code.jquery.com/jquery-2.2.4.js"
	integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
	crossorigin="anonymous"></script>
<script defer
	src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<script type="text/javascript" src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
<script type="text/javascript">

   $(document).ready(function(){
   	var id= "<%=(String) session.getAttribute("id")%>";
   	if(id=="null"){
   		  $('#login').html("로그인");
       	  $('#join').html("회원가입");
   	}else{
    var admin="<%=request.getAttribute("admin")%>";
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
   	  var id= "<%=(String) session.getAttribute("id")%>";
   	  console.log(id);
   	  console.log(id=="null");
   	  if(id=="null"){
   		  url="loginform.do"
   	    	  window.open(url,"ChildLoginWin","width=500 height=400 top=200px left=500px");
   	  }else{
   		  $('#login').html("로그인");
       	  $('#join').html("회원가입");
       	  location.href="logout.do?id="+id;
   	  }
     });
    
     $('#join').click(function(){
       	console.log(id);
      	 if(id=="null"){
      		 location.href="joinform.do";
      	 }else{

      		 if(admin=='Y'){
      	        location.href="adminForm.do";
      		 }else
      			location.href="my.do";
      	 }
       });
     
     $(".fullMenu").click(function(){
    	 $("#fullMenu").slideToggle(); 
     })
     
   });
   
   function googleTranslateElementInit() {
     new google.translate.TranslateElement({pageLanguage: 'ko', layout: google.translate.TranslateElement.InlineLayout.SIMPLE}, 'google_translate_element');
     $(".goog-te-gadget-icon").remove();
     console.dir($("#google_translate_element"));
     $(".goog-te-gadget-simple").css("border",0);
     console.dir($(".goog-te-menu-value:nth-child(3)"));
     $(".goog-te-gadget-simple>span").css({"vertical-align": "inherit"})
     $(".goog-te-menu-value>span:nth-child(1)").remove();
     $(".goog-te-menu-value>span:nth-child(2)").remove();
     $(".goog-te-menu-value>span").css({
    	 "color":"black",
    	 "vertical-align": "inherit"
     });
     
     $(".goog-te-menu-value").children('img').remove();
   }
  
  </script>
<link rel="stylesheet" href="css/Header.css">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/fullMenu.css">
</head>
<body class="headerbody">
	<div class="slider">
		<div>
			<img src="image/mainslide_1.jpg" id="slide_1">
		</div>
		<div>
			<img src="image/slide_2.jpg" id="slide_2">
		</div>
		<div>
			<img src="image/slide_3.jpg" id="slide_3">
		</div>
		<div>
			<img src="image/slide_4.jpg" id="slide_4">
		</div>
		<div>
			<img src="image/slide_5.jpg" id="slide_5">
		</div>
	</div>
	<div class="top">
		<div class="logo">
			<img src="image/logo.jpg" onclick="location.href='main.do'">
		</div>
		<div class="buttons">
			<ul>
				<div id="login_div" style="display: -webkit-inline-box">
					<li id="login"></li>|
					<li id="join"></li>|
				<li id="login">번역<div id="google_translate_element"></div>
				</li>
				</div>
			</ul>
		</div>
	</div>
	<div class="topmenu">
		<div class="topmenu_inner">
			<ul>
				<li onclick="location.href='recruit_main.do'">모집/계획</li>|
				<li onclick="location.href='review_Main.do'">여행정보/후기</li>|
				<li onclick="location.href='service_center_main.do'">고객센터</li>|
				<li id="icon"><img src="image/loupe.png" onclick="location.href='SearchForm.do'"></li>
				<li id="icon"><img src="image/menu.png" class="fullMenu"></li>
			</ul>
		</div>
	</div>
	<div id="fullMenu" style="display: none;">
		<div>
			<ul>
				<li onclick="location.href='search.do'">통합검색</li>
				<li onclick="location.href='recruit_main.do'">모집게시판</li>
				<li onclick="location.href='plan_main.do'">계획게시판</li>
			</ul>
		</div>
		<div>
			<ul>
				<li onclick="location.href='info_Main.do'">여행정보게시판</li>
				<li onclick="location.href='review_Main.do'">후기게시판</li>
			</ul>
		</div>
		<div>
			<ul>
				<li onclick="location.href='notice_main.do'">공지사항</li>
				<li onclick="location.href='service_center_main.do'">1:1문의</li>
				<li onclick="location.href='event_main.do'">이벤트</li>
			</ul>
		</div>
		<div>
			<ul>
				<li onclick="location.href='my.do'">마이페이지</li>
				<li><a href="myAlbum.do" target="_blank">사진첩</a></li>
			</ul>
		</div>
	</div>
</body>
</html>
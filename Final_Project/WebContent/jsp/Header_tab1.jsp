<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
<script type="text/javascript"
	src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
<script type="text/javascript">

	function canvasDraw(){
	   this.img=null;
	   this.x=0;
	   this.y=-100;
	   this.vy=-1;//증가값
	   this.canvas=document.getElementById("title_img");
	   this.context;

	   this.setClear=function(){
		   this.context=this.canvas.getContext("2d");
	   }
	   
	   this.setImg=function(){
		   this.img=new Image();
		   this.img.src="image/sub_visual01.jpg";
	   }
	   
	   this.draw=function(){
		       var draws=this;
			   draws.setClear();
			   
			   if(draws.img==null){
	    		   draws.setImg();
	    	   }
			   
		       setInterval(function(){
		    	   
		       draws.y=draws.y-draws.vy;
		       draws.context.drawImage(draws.img, 0, draws.y);
		       
		       if(draws.y>0)//최소값
		    	   draws.vy=draws.vy*-1;
		   	   else if(draws.y<-200)//max값
		    	   draws.vy=draws.vy*-1;
		       },30)
	   }
	}
	
	
	
	
	
	
   $(document).ready(function(){
	   var a = new canvasDraw();
	   a.draw();
   	var id= "<%=(String) session.getAttribute("id")%>";
   	if(id=="null"){
   		  $('#login').html("로그인");
       	  $('#join').html("회원가입");
   	}else{
    var admin="<%=request.getAttribute("admin")%>";
			$('#login').html("로그아웃");
			if (admin == 'Y') {
				$('#join').html("관리페이지");
			} else {
				$('#join').html("마이페이지");
			}
		}

   	
   		$('#login').click(function(){
   			if($("#login").html=="로그인"){
   				
   			}
   			else{
   				
   			}
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
   	
		$('#join').click(function() {
			if (id == "null") {
				location.href = "joinform.do";
			} else {

				if (admin == 'Y') {
					location.href = "adminForm.do";
				} else
					location.href = "my.do";
			}
		});

		$(".fullMenu").click(function() {
			$("#fullMenu").slideToggle();
		})

	});

	function googleTranslateElementInit() {
		new google.translate.TranslateElement({
			pageLanguage : 'ko',
			layout : google.translate.TranslateElement.InlineLayout.SIMPLE
		}, 'google_translate_element');
		$(".goog-te-gadget-icon").remove();
		$(".goog-te-gadget-simple").css("border", 0);
		$(".goog-te-gadget-simple>span").css({
			"vertical-align" : "inherit"
		})
		$(".goog-te-menu-value>span:nth-child(1)").remove();
		$(".goog-te-menu-value>span:nth-child(2)").remove();
		$(".goog-te-menu-value>span").css({
			"color" : "black",
			"vertical-align" : "inherit"
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
			<canvas id="title_img" width="1920" height="320"></canvas>
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
					<li id="login">번역
						<div id="google_translate_element"></div>
					</li>
				</div>
			</ul>
		</div>
	</div>
	<div class="topmenu">
		<div class="topmenu_inner">
			<ul>
				<li onclick="location.href='recruit_main.do'">모집/계획</li>|
				<li onclick="location.href='review_main.do'">여행정보/후기</li>|
				<li onclick="location.href='service_center_main.do'">고객센터</li>|
				<li id="icon"><img src="image/loupe.png"
					onclick="location.href='SearchForm.do'"></li>
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
				<li onclick="location.href='info_main.do'">여행정보게시판</li>
				<li onclick="location.href='review_main.do'">후기게시판</li>
			</ul>
		</div>
		<div>
			<ul>
				<li onclick="location.href='faq_main.do'">FAQ</li>
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
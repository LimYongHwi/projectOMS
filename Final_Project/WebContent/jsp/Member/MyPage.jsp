<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
  src="http://code.jquery.com/jquery-2.2.4.js"
  integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
  crossorigin="anonymous"></script>  
<link href="https://fonts.googleapis.com/css?family=Gloria+Hallelujah" rel="stylesheet">  
 
<style>

@font-face {
  font-family: 'LotteMartDream';
  font-style: normal;
  font-weight: 700;
  src: url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamMedium.woff2') format('woff2'), url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamMedium.woff') format('woff');
}
body{
 font-family: 'LotteMartDream';
	margin:0;
	padding:0;
}

 #MyPwrqpper{ 
 	width:100%; 
 	margin:0 auto; 
 } 

#Myheader{
	background-image: url('image/MyHeader.jpg');
	background-repeat:no-repeat;
	background-size:cover;
	height:370px;
	text-align: center;
}
#Mytitle{
	background-color: #000000; 
	background: rgba(255, 255, 255, 0.5);
    height: 75%;
    vertical-align: middle;
    top:12%;
    position: relative;
	 text-align: center;
}
.p2 {
display: block;
width: 100%;
margin: 0 auto;
word-break: break-all;
padding-top: 4%;
}

h1 {
	display: none;
	margin:auto;
    font-size: 90px;
    color:#424242;
    opacity:0.8;
    font-family: 'Gloria Hallelujah', cursive;
    
}

#MyContainer{
	position:absolute;
	width: 100%;
	height:1100px;
	
}

#menuTitle{
display:inline-block;
	width:100%;
	height:10%;
	text-align: center;
	background-color: #53a9dc7a;
	padding:10px 0px;
}

#menuTitle span{
	font-size: 190%;
	line-height: 85px;
	color: #EFFBFB;
}

#menuList{
	display:inline-block;
	height:90%;
	width:100%;
	background-color: #F2F2F2;
}

#menuList ul{
	list-style-type: none;
	text-align: center;
	margin: 0;
	padding: 0;
}

#menuList li {
	font-size: 20px;
	margin: 25px 0;
}

#menuList li a{
	color: #6E6E6E;
	text-decoration: none;
}

#menuList li a:hover{
	color: #FAFAFA;
	background-color: #848484;
}

#menuSection{
	margin: 0;
	padding:0;
	width: 16%;
	height: 100%;
	float: left;
}

#contentSection {
	width:80%;
	height:100%;
	margin:0;
	padding:0;
	float:left;
	
}



</style>

<script type="text/javascript">
$(document).ready(function(){
	
	function changeText(cont1,cont2,speed){
		var Otext=cont1.text();
		var Ocontent=Otext.split("");
		var i=0;
		function show(){
			if(i<Ocontent.length)
			{		
				cont2.append(Ocontent[i]);
				i=i+1;
			};
		};
			var Otimer=setInterval(show,speed);	
	};
	changeText($("h1"),$(".p2"),150);
	clearInterval(Otimer);
	
});
</script>

</head>
<body>
<div id="MyPwrqpper">
	<div id="Myheader">
		<div id="Mytitle">
		<h1>Oh My Soulmate</h1>
		<h1 class="p2"></h1>
		</div>
	</div>
	
	<div id="MyContainer">
		<div id="menuSection">
		<div id="menuTitle">
			<span>마이 페이지</span>		
		</div>
		<div id="menuList">
		<ul>
			<li><a href="#" id="menu1">정보수정</a></li>
			<li><a href="#" id="menu3">내 사진첩</a></li>
			<li><a href="#" id="menu4">내 활동</a></li>
			<li><a href="#" id="menu5">내가 문의한 글</a></li>
			<li><a href="#" id="menu5">회원 탈퇴</a></li>
		</ul>
		</div>
		</div> <!-- menuSection끝 -->
		<div id="contentSection">
		
		</div>
	</div> <!-- MyContainer끝 -->
</div> <!-- MyPwrapper끝 -->
</body>
</html>
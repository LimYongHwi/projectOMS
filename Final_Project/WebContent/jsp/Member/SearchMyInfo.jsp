<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
<script
  src="http://code.jquery.com/jquery-2.2.4.js"
  integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
  crossorigin="anonymous"></script> 
<title>Insert title here</title>

<style>
@font-face {
  font-family: 'LotteMartDream';
  font-style: normal;
  font-weight: 700;
  src: url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamMedium.woff2') format('woff2'), url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamMedium.woff') format('woff');
}

body {
  background-image: url("image/sInfo.jpg");
   background-repeat: no-repeat; 
   background-size:cover; 
  color: #606468;
  min-height:100%;
  margin:0;
  padding:0;
  font-family: 'LotteMartDream';
}

.sWrapper {
	width:100%;
	height:100%;
	padding: 20% 0 0;
}

.sBox{
	width:40%;
	height:100%;
	margin: 0 auto;
	vertical-align: middle;
    top:50%;
    position: relative;
    padding:10px;
   background-color: #000000; 
	background: rgba(0, 0, 0, 0.40);
    text-align: center;
}

.sInnerBox{
	width:50%;
	height:30%;
	margin:20px auto;
	
}

.sInnerBox p{
	color:white;
	margin:5px;
}

input[type="text"]{
 	padding:0px 10px; 
    display: inline-block;
    margin-bottom: 20px;
    line-height: 27px;
    width:73%;
    font-family: 'LotteMartDream';
    border-radius: 0.3em;   
    border: 1px #E5E5E5;
			outline: 0;
			background: #FFFFFF;
			background: -webkit-gradient(linear, left top, left 25, from(#FFFFFF), color-stop(4%, #EEEEEE), to(#FFFFFF));
			background: -moz-linear-gradient(top, #FFFFFF, #EEEEEE 1px, #FFFFFF 25px);
			box-shadow: rgba(0,0,0, 0.1) 0px 0px 8px;
			-moz-box-shadow: rgba(0,0,0, 0.1) 0px 0px 8px;
			-webkit-box-shadow: rgba(0,0,0, 0.1) 0px 0px 8px;
}

input[type="submit"] {
		width:247px;
		margin-top: 10px ;
		border-radius: 4px;
			-webkit-box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.08);
	-moz-box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.08);
	  box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.08);
		color: #fff;
		font-size: 17px ;
		padding: 5px 0px ;
		text-decoration: none;
		text-shadow: 0 1px 1px rgba(0, 0, 0, 0.075);	
		background-color: rgb( 51, 102, 204 );
		border: 1px solid rgb( 44, 91, 104 );	
		  font-family: 'LotteMartDream';
}

input[type="submit"] : hover{
	cursor: pointer;
	background-color: rgb( 58, 131, 213);
}
	
input[type="submit"] : active {
	background-color: rgb( 42, 91, 191 );	
}

input[name="M_PHONE"]{
	width:18%;
}



.sBox h1{
	color:#E6E6E6;
}

.sBox span{
	margin-right:30px;
	color:#A9F5F2;
	font-size: 20px;
}


</style>

<script type="text/javascript">
	$(document).ready(function(){
		$('#sInnerBox1').hide();
		$('#sInnerBox2').hide();
		
		$("input:radio[name=sID]").click(function() { 
			$('#sInnerBox1').show();
			$('#sInnerBox2').hide();
		}) 	
		$("input:radio[name=sPW]").click(function() { 
			$('#sInnerBox2').show();
			$('#sInnerBox1').hide();
		}) 	
	});

</script>
</head>
<body>
<div class="sWrapper">
	<div class="sBox">
		<h1>아이디/비밀번호 찾기</h1>
			<div class="checks">
			 <input type="radio" name="sID" id="radio1"> <span>아이디 찾기</span> 
			 <input type="radio" name="sPW" id="radio2"> <span>비밀번호 찾기</span> 
			</div>
		<div class="sInnerBox" id="sInnerBox1">
			<form action="sendPw.do">
				<p>아이디 입력</p><input type="text" name="M_ID">
				<p>메일주소 입력</p><input type="text" name="mAddress">
				<input type="submit" value="전송">
			</form>
		</div>
		
		<div class="sInnerBox" id="sInnerBox2">
			<form action="sendPw.do">
				<p>전화번호 입력</p><input type="text" name="M_PHONE"> - <input type="text" name="M_PHONE"> - <input type="text" name="M_PHONE">
				<p>메일주소 입력</p><input type="text" name="mAddress">
				<input type="submit" value="전송">
			</form>
		</div>
</div><!-- sBox끝 -->
</div><!-- sWrapper끝 -->
</body>
</html>
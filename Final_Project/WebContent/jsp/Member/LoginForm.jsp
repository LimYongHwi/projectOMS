<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

[class*="fontawesome-"]:before {
  font-family: 'LotteMartDream';
}


* {
  box-sizing: border-box;
}

html {
  height: 100%;
}

body {
  background-color: #2c3338;
  color: #606468;
  min-height: 100%;
  margin:0;
  padding:0;
  font-family: 'LotteMartDream';

}

a {
  color: #eee;
  outline: 0;
  text-decoration: none;
}
a:focus, a:hover {
  text-decoration: underline;
}

input {
  border: 0;
  color: inherit;
  font: inherit;
  margin: 0;
  outline: 0;
  padding: 0;
  -webkit-transition: background-color .3s;
          transition: background-color .3s;
}

.site__container {
  -webkit-box-flex: 1;
  -webkit-flex: 1;
      -ms-flex: 1;
          flex: 1;
  padding: 3rem 0;
}

.form input[type="password"], .form input[type="text"], .form input[type="submit"] {
  width: 100%;
}
.form--login {
  color: #606468;
}
.form--login label,
.form--login input[type="text"],
.form--login input[type="password"],
.form--login input[type="submit"] {
  border-radius: 0.25rem;
  padding: 1rem;
}
.form--login label {
  background-color: #363b41;
  border-bottom-right-radius: 0;
  border-top-right-radius: 0;
  padding-left: 1.25rem;
  padding-right: 1.25rem;
}
.form--login input[type="text"], .form--login input[type="password"] {
  background-color: #3b4148;
  border-bottom-left-radius: 0;
  border-top-left-radius: 0;
}
.form--login input[type="text"]:focus, .form--login input[type="text"]:hover, .form--login input[type="password"]:focus, .form--login input[type="password"]:hover {
  background-color: #434A52;
}
.form--login input[type="submit"] {
  background-color:#6fe0eb;
  color: #f5f6f9;
  font-weight: bold;
  text-transform: uppercase;
}
.form--login input[type="submit"]:focus, .form--login input[type="submit"]:hover {
  background-color:#63cdd7;
  color:#f5f6f9;
}
.form__field {
  display: -webkit-box;
  display: -webkit-flex;
  display: -ms-flexbox;
  display: flex;
  margin-bottom: 1rem;
}
.form__input {
  -webkit-box-flex: 1;
  -webkit-flex: 1;
      -ms-flex: 1;
          flex: 1;
}

.align {
  -webkit-box-align: center;
  -webkit-align-items: center;
      -ms-flex-align: center;
          align-items: center;
  display: -webkit-box;
  display: -webkit-flex;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-orient: horizontal;
  -webkit-box-direction: normal;
  -webkit-flex-direction: row;
      -ms-flex-direction: row;
          flex-direction: row;
}

.hidden {
  border: 0;
  clip: rect(0 0 0 0);
  height: 1px;
  margin: -1px;
  overflow: hidden;
  padding: 0;
  position: absolute;
  width: 1px;
}

.text--center {
  text-align: center;
}

.grid__container {
  margin: 0 auto;
  max-width: 20rem;
  width: 90%;
}

</style>


  
  <script type="text/javascript">
 $(document).ready(function(){
	  var timer=setInterval(function(){
		  var id= "<%= (String)session.getAttribute("id")%>";
		  if(id != "null"){
			  clearInterval(timer);
			  opener.parent.location.href="main.do?id="+id;
  			  window.close();
		}
	  },10);
	 
	 $('#goJoin').click(function(){
		 window.opener.location.href="joinform.do";
		 self.close(); 
	 });
	 
	$('lgnFrm').submit(function(){
		var id= "<%= session.getAttribute("id")%>";
		console.log(id);
			if($('#loginFlag').val()==""){
				alert('아이디와 비번을 모두 입력하세요.');
				return false;
			}else if($('#loginFlag').val()=="2"||$('#loginFlag').val()=="3"){
				return false;
			}else{
				return true;		
			}
			});
	
	 $('#SearchInfo').click(function(){
		 window.opener.location.href="searchMyInfo.do";
		 self.close();
	 });
  });
 

  </script>
</head>
<body class="align">
  <div class="site__container">

    <div class="grid__container">

      <form action="login.do" method="post" class="form form--login">

        <div class="form__field">
          <label for="login__username"><i class="fas fa-user"></i><span class="hidden">Username</span></label>
          <input id="login__username" name ="m_id" type="text" class="form__input" placeholder="아이디" required>
        </div>

        <div class="form__field">
          <label for="login__password"><i class="fas fa-lock"></i><span class="hidden">Password</span></label>
          <input id="login__password" name="m_password" type="password" class="form__input" placeholder="비밀번호" required>
        </div>

        <div class="form__field">
          <input type="submit" id="loginbtn" value="Log In">
        </div>

      </form>

      <p class="text--center">회원이 아니신가요? <a id="goJoin">회원가입</a> <span class="fontawesome-arrow-right"></span></p>
      <p class="text--center"><a href="#" id="SearchInfo">아이디/비밀번호 찾기</a> <span class="fontawesome-arrow-right"></span></p>
      <p class="text--center" id="resultMsg">${msg}</p>
      <p class="text--center" id="loginFlag">${loginFlag}</p>

    </div>

  </div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(".fullMenu").click(function(){
	 $("#fullMenu").slideToggle(); 
})
</script>
<link rel="stylesheet" href="css/fullMenu.css">
</head>
<body>
<div id="fullMenu" style="display: none;">
		<div>
			<ul>
				<li>통합검색</li>
				<li>모집게시판</li>
				<li>계획게시판</li>
			</ul>
		</div>
		<div>
			<ul>
				<li>여행정보게시판</li>
				<li>후기게시판</li>
			</ul>
		</div>
		<div>
			<ul>
				<li>공지사항</li>
				<li>1:1문의</li>
				<li>이벤트</li>
			</ul>
		</div>
		<div>
			<ul>
				<li>마이페이지</li>
				<li>사진첩</li>
			</ul>
		</div>
	</div>
	
</body>
</html>
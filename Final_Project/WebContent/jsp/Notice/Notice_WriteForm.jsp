<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-2.2.4.js"
  integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
  crossorigin="anonymous"></script>
<script type="text/javascript">
$(document).ready(function(){
	
$(".title").text("공지게시판");
})


</script>
<link rel="stylesheet" href="jsp/Plan/css/writeForm.css">
</head>

<body>
<jsp:include page="../Header_tab1.jsp"></jsp:include>
<div class="body">
<jsp:include page="../sidevar_3.jsp"/>

<div class="section">
<p id="title">공지사항</p>
<p id="title_sub">공지하실 내용을 작성해주세요!</p>

<hr>
<div>
<form action="notice_write.do" enctype="multipart/form-data" method="post">

<dl>
<dt>제목</dt><dd><input type="text" name="NOTICE_TITLE"></dd>
<dt>내용</dt><dd><input type="text" name="NOTICE_CONTENT"></dd>
<dt>첨부파일</dt><dd><input type="file" name="ufile"></dd>
</dl>
<input type="button" class="button" value="뒤로가기" onclick="javascript:history.back()" style="margin-left:50px">
<input type="submit" value="작성하기" style="margin-left:200px"> 
</form>
</div>
</div>
</div>

</body>
</html>
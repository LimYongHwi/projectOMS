<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<link rel="stylesheet" href="jsp/Plan/css/update.css">
<body>
<jsp:include page="../Header_tab1.jsp"></jsp:include>
<div class="body">

<jsp:include page="../sidevar_3.jsp"/>

<div class="section"> 
<p id="title">공지합니다</p>
<p id="title_sub">공지에 대한 자세한 내용을 수정해주세요!</p>
<hr>
<form action="notice_update.do" enctype="multipart/form-data" method="post">
<dl>
<dt>글번호</dt><dd><input type="text" name="NOTICE_NO" value="${notice.NOTICE_NO}" readonly="readonly"></dd>
<dt>제목</dt><dd><input type="text" name="NOTICE_TITLE" value="${notice.NOTICE_TITLE}"></dd>
<dt>내용</dt><dd><input type="text" name="NOTICE_CONTENT" value="${notice.NOTICE_CONTENT}"></dd>
<dt>첨부파일</dt><dd><input type="file" name="ufile" value="${notice.NOTICE_FILE}"></dd>
</dl>
<input type="button" class="button" value="뒤로가기" onclick="javascript:history.back()" style="margin-left:50px">
<input type="submit" value="작성하기">
</form>
</div>
</div>

</body>
</html>
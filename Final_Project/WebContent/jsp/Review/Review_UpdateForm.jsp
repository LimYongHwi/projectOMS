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
	
$(".title").text("후기게시판");
})


</script>
<link rel="stylesheet" href="jsp/Plan/css/update.css">
<body>
<jsp:include page="../Header_tab1.jsp"></jsp:include>
<div class="body">

<jsp:include page="../sidevar_2.jsp"/>

<div class="section"> 
<p id="title">후기게시물수정</p>
<p id="title_sub">후기에 대한 자세한 내용으로 수정해주세요!</p>
<hr>


<form action="review_Update.do" enctype="multipart/form-data" method="post">
<input type="hidden" name="REV_NO" value="${REV.REV_NO}">
<dl>
<dt>제목</dt><dd><input type="text" name="REV_TITLE" value="${REV.REV_TITLE}"></dd>
<dt>내용</dt><dd><input type="text" name="REV_CONTENT" value="${REV.REV_CONTENT }"></dd>
<dt>작성자</dt><dd><input type="text" name="M_ID" readonly="readonly" value="${REV.m_ID}"></dd>
<dt>첨부파일</dt><dd><input type="file" name="ufile"></dd>
<dt>장소</dt><dd><input type="text" name="REV_DESTINATION" value="${REV.REV_DESTINATION}"></dd> 
<dt>시작일</dt><dd><input type="date" name="REV_START"></dd>
<dt>종료일</dt><dd><input type="date" name="REV_END"></dd>
</dl>
<input type="button" class="button" value="뒤로가기" onclick="javascript:history.back()" style="margin-left:50px">
<input type="submit" value="작성하기" style="margin-left:200px"> 
</form>
</div>
</div>

</body>
</html>
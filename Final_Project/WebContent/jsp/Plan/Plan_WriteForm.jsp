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
	
$(".title").text("계획게시판");
})


</script>
<link rel="stylesheet" href="jsp/Plan/css/writeForm.css">
</head>

<body>
<jsp:include page="../Header_tab1.jsp"></jsp:include>
<div class="body">
<jsp:include page="../sidevar_1.jsp"/>

<div class="section">
<p id="title">계획하기</p>
<p id="title_sub">함께 여행할 계획을 자세히 작성해주세요!</p>

<hr>
<div>
<form action="plan_write.do" enctype="multipart/form-data" method="post">

<dl>
<dt>제목</dt><dd><input type="text" name="PLAN_TITLE"></dd>
<dt>내용</dt><dd><input type="text" name="PLAN_CONTENT"></dd>
<dt>첨부파일</dt><dd><input type="file" name="ufile"></dd>
<dt>작성자</dt><dd><input type="text" name="M_ID" readonly="readonly" value="${member.m_ID}"></dd>
<dt>장소</dt><dd><input type="text" name="PLAN_DESTINATION"></dd>
<dt>인원수</dt><dd><input type="number" name="PLAN_MEMBER_COUNT"></dd>

<dt>원하는 성별</dt><dd><input type="radio" name="PLAN_GENDER" value="M">남자만 
<input type="radio" name="PLAN_GENDER" value="W">여자만 
<input type="radio" name="PLAN_GENDER" value="F">무관</dd>

<dt>시작일</dt><dd><input type="date" name="PLAN_START"></dd>
<dt>종료일</dt><dd><input type="date" name="PLAN_END"></dd>
</dl>
<input type="button" class="button" value="뒤로가기" onclick="javascript:history.back()" style="margin-left:50px">
<input type="submit" value="작성하기" style="margin-left:200px"> 
</form>
</div>
</div>
</div>

</body>
</html>
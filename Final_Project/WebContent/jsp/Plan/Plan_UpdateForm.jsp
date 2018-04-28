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
	
$(".title").text("계획게시판");
})


</script>
<link rel="stylesheet" href="jsp/Plan/css/update.css">
<body>
<jsp:include page="../Header_tab1.jsp"></jsp:include>
<div class="body">

<jsp:include page="../sidevar_1.jsp"/>

<div class="section"> 
<p id="title">계획합니다</p>
<p id="title_sub">여행 계획에 대한 자세한 내용을 설명해주세요!</p>
<hr>
<form action="plan_update.do" enctype="multipart/form-data" method="post">
<dl>
<dt>글번호</dt><dd><input type="text" name="PLAN_NO" value="${plan.PLAN_NO}" readonly="readonly"></dd>
<dt>제목</dt><dd><input type="text" name="PLAN_TITLE" value="${plan.PLAN_TITLE}"></dd>
<dt>내용</dt><dd><input type="text" name="PLAN_CONTENT" value="${plan.PLAN_CONTENT}"></dd>
<dt>첨부파일</dt><dd><input type="file" name="ufile"></dd>
<dt>작성자</dt><dd><input type="text" name="M_ID" value="${plan.m_ID}" readonly="readonly"></dd>
<dt>장소</dt><dd><input type="text" name="PLAN_DESTINATION" value="${plan.PLAN_DESTINATION}"></dd>
<dt>인원수</dt><dd><input type="number" name="PLAN_MEMBER_COUNT" value="${plan.PLAN_MEMBER_COUNT}"></dd>
<dt>원하는 성별</dt><dd><input type="radio" name="PLAN_GENDER" value="M" value="${plan.PLAN_GENDER }">남자만 <input type="radio" name="PLAN_GENDER" value="W" value="${plan.PLAN_GENDER }">여자만 <input type="radio" name="PLAN_GENDER" value="F"value="${plan.PLAN_GENDER }">무관</dd>
<dt>시작일</dt><dd><input type="date" name="PLAN_START" value="${plan.PLAN_START}"></dd>
<dt>종료일</dt><dd><input type="date" name="PLAN_END" value="${plan.PLAN_END}"></dd>
</dl>
<input type="button" class="button" value="뒤로가기" onclick="javascript:history.back()" style="margin-left:50px">
<input type="submit" value="작성하기">
</form>
</div>
</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
  src="https://code.jquery.com/jquery-2.2.4.js"
  integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
  crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	readlist(1);
	minecheck();
$(".title").text("공지게시판");
});
function sysout(V){
	var tost="";
	for(var a in V){
		tost+=a;
	}
	return 
}
</script>
<link rel="stylesheet" href="jsp/Plan/css/view.css">
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../Header_tab1.jsp"></jsp:include>
<%boolean admin= (char)request.getAttribute("admin")=='Y'?true:false; %>
<div class="body">
<jsp:include page="../sidevar_3.jsp"/>
<div class="section"> 

<p id="title">공지 뷰</p>
<p id="title_sub">공지사항을 꼭 읽어주세요</p>
<hr>
<input type="text" style="display: none;" value="${page}" id="page" readonly="readonly">
<dl>
<dt>번호</dt>
<dd>${notice.NOTICE_NO}</dd>
<dt>제목</dt>
<dd>${notice.NOTICE_TITLE}</dd>
<dt>작성날짜</dt>
<dd><fmt:formatDate value="${notice.NOTICE_CREATE_DATE}" pattern="yyyy-MM-dd"/></dd>
<dt>파일다운로드</dt>
<dd>
<c:choose>
<c:when test="${notice.NOTICE_FILE!=null}">
<a href="noticedownload.do?num=${notice.NOTICE_NO}">
${notice.NOTICE_FILE}
</a>
</c:when>
<c:otherwise>
파일없음
</c:otherwise>
</c:choose>
</dd>
<dt>내용</dt>
<dd><img alt="이미지없음" src="noticedownload.do?num=${notice.NOTICE_NO}">${notice.NOTICE_CONTENT}</dd>
</dl>


<input type="button" class="button" value="뒤로가기" onclick="javascript:history.back()" style="margin-left:50px">
<%if(admin){ %>
<input type="button" value="수정" onclick="location.href='notice_updateForm.do?NOTICE_NO=${notice.NOTICE_NO}'">
<input type="button" value="삭제" onclick="location.href='notice_delete.do?NOTICE_NO=${notice.NOTICE_NO}'">
<%} %>
<input type="button" value="전체목록" onclick="location.href='notice_main.do'"> 
</div>
</div>
</body>
</html>
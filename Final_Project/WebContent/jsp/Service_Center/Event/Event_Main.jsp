<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="jsp/Service_Center/css/main.css">
<script src="https://code.jquery.com/jquery-2.2.4.js"
	integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
	crossorigin="anonymous"></script>
	
<script type="text/javascript">
$(document).ready(function(){
	$('.content').hide();
	$('#title li').click(function(){
		$('.content').not(this).hide();
		$('.content', this).fadeToggle();
	});
});
</script>

</head>
<body>
<jsp:include page="../../Header_tab1.jsp"></jsp:include>
	<div class="body">
	<jsp:include page="../../sidevar_3.jsp"></jsp:include>

	<div class="sc_board">
	<p id="subject">이벤트게시판</p>
	<p id="subject_sub">오마쏘에 이벤트에 함께 해보세요!</p>
	<hr>
	<table>
	<tr>
	<th>글번호</th>
	<th>제목</th>
	<th>작성일</th>
	</tr>
		<c:forEach items="${eventList}" var="eList">
		<tr>
				<td>${eList.RN}</td>
			<td><a href="event_view.do?EVT_NO=${eList.EVT_NO}">${eList.EVT_TITLE}</a></td>
				<td>${eList.EVT_CREATE_DATE}</td>
		</tr>		
		</c:forEach>
	</table>
		<c:if test="${START!=1}">
			<a href="event_main.do?page=1&type=${type}&keyword=${keyword}">[처음]</a>
			<a href="event_main.do?page=${PAGE-1}&type=${type}&keyword=${keyword}">[이전]</a>
		</c:if>
		<c:forEach begin="${START}" end="${END<LAST? END:LAST}" var="i">
			<c:choose>
				<c:when test="${i==current}"> <b>[${i}]</b> </c:when>
				<c:otherwise>
					<a href="event_main.do?page=${i }&type=${type}&keyword=${keyword}">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${END<LAST}">
			<a href="event_main.do?page=${END+1}&type=${type}&keyword=${keyword}">[다음]</a>
			<a href="event_main.do?page=${LAST}&type=${type}&keyword=${keyword}">[마지막]</a>
		</c:if>


				<input align="right" type="button" value="글쓰기"
				onclick="location.href='event_writeForm.do'">

	</div>
	</div>
</body>
</html>
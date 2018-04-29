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
<jsp:include page="../Header_tab1.jsp"></jsp:include>
<div class="body">
<jsp:include page="../sidevar_3.jsp"/>

	<div class="sc_board">
	<center>
	<p id="subject">1:1문의하기</p>
	<p id="subject_sub">오마쏘에 궁금한신 사항을 문의 해주세요.</p>
	<hr>
	
	<table>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		
		<c:forEach items="${sevList}" var="sList">
			<tr>
				<td align="center">${sList.m_SVC_NO}</td>
				<td align="center">
				<ul id="title">
				<li>${sList.m_SVC_TITLE }
				<ul class="content">
				<li>${sList.m_SVC_CONTENT }</li>
				</ul>
				</li>
				</ul>
				</td>
				<td align="center">${sList.m_ID }</td>
				<td align="center"><fmt:formatDate value="${sList.m_SVC_CREATE_DATE}" pattern="yyyy-MM-dd"/></td>
			</tr>
		</c:forEach>
	</table>

	<c:if test="${start != 1}">
		<a href="service_center_main.do?page=1">처음</a>
		<a href="service_center_main.do?page=${current-1 }">이전</a>
	</c:if>
	<c:forEach begin="${start}" end="${end<last? end:last}" var="i">
					<c:choose>
						<c:when test="${i==current}">
							<b>[${i }]</b>
						</c:when>
						<c:otherwise>
							<a href="service_center_main.do?page=${i }">${i }</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${end<last}">
					<a href="service_center_main.do?page=${end+1 }">다음</a>
					<a href="service_center_main.do?page=${last }">마지막</a>
				</c:if>
				<input align="right" type="button" value="글쓰기"
				onclick="location.href='service_writeForm.do'">
	</center>
	</div>
	</div>
</body>
</html>
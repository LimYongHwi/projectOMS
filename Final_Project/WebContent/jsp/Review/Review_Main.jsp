<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
$(".search_").css("display","none");

})
function toggleT(element,id) 
{ 
if ($("input:checkbox[name='"+id+"']").is(":checked")){
   $("#"+element).css("display",'block');
}
else {
$("#"+element).css("display",'none');
}
} 


</script>

<link rel="stylesheet" href="jsp/Plan/css/main.css">

</head>
<body>
<jsp:include page="../Header_tab1.jsp"></jsp:include>
<div class="body">
<jsp:include page="../sidevar_2.jsp"/>
<div class="board">
<p id="title">후기게시판</p>
<p id="title_sub">좋았던 여행을 친구들에게 자랑해보세요! </p>
	<hr>
	<table>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>조회수</th>
			<th>추천수</th>
			<th>비추천수</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<c:forEach var="r" items="${reviewList}">
			<tr>
				<td>${r.REV_NO}</td>
				<td><a href="review_view.do?num=${r.REV_NO}">${r.REV_TITLE }</a></td>
				<td>${r.REV_VIEWS}</td>
				<td>${r.REV_REM_COUNT}</td>
				<td>${r.REV_UNREM_COUNT}</td>
				<td>${r.m_ID }</td>
				<td><fmt:formatDate value="${r.REV_CREATE_DATE}"
						pattern="yyyy-MM-dd" /></td>
			</tr>
		</c:forEach>
		</table>
		<c:if test="${START>1}">
			<a href="review_Main.do?page=1&type=${type}&keyword=${keyword}">[처음]</a>
			<a href="review_Main.do?page=${PAGE-1}&type=${type}&keyword=${keyword}">[이전]</a>
		</c:if>
		<c:forEach begin="${START}" end="${END<LAST? END:LAST}" var="i">
			<c:choose>
				<c:when test="${i==current}"> <b>[${i}]</b> </c:when>
				<c:otherwise>
					<a href="review_Main.do?page=${i }&type=${type}&keyword=${keyword}">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${END<LAST}">
			<a href="review_Main.do?page=${END+1}&type=${type}&keyword=${keyword}">[다음]</a>
			<a href="review_Main.do?page=${LAST}&type=${type}&keyword=${keyword}">[마지막]</a>
		</c:if>
		
		<form action="review_Main.do">
		
		
		


		<div id="searchChk">
		기간<input type="checkbox" name="datesearch" onclick="toggleT('datesearch','datesearch')">
		장소<input type="checkbox" name="destination" onclick="toggleT('REV_DESTINATION','destination')">
		</div>



		<div id="searchForm">
		<div id="datesearch" class="search_">
		<input type="date" name="startdate">
		<input type="date" name="enddate"><br>
		</div>
		
		<div id="REV_DESTINATION" class="search_">
		<input type="text" name="PLAN_DESTINATION" placeholder="장소를 입력하세요">
		</div>

		</div>
		
		<div id="search_keyword">
		<select name="type">
		<option value="1">제목</option>
		<option value="2">내용</option>
		<option value="3">제목+내용</option>
		<option value="4">작성자</option>
		</select>
		<input type="text" name="keyword" value="${keyword}"><br>
		</div>
		
		<input type="submit" value="검색">
		</form>
		<button onclick="location.href='review_WriteForm.do'">글쓰기</button>
</div>
</div>
</body>
</html>
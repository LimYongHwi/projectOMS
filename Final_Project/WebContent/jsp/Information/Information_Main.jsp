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
	
$(".title").text("여행정보게시판");
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
<p id="title">여행정보게시판</p>
<p id="title_sub">알고있는 좋은 정보를 친구들에게 공유해보세요! </p>
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
		<c:forEach var="i" items="${infoList}">
			<tr>
				<td>${i.INFO_NO}</td>
				<td><a href="info_view.do?num=${i.INFO_NO}">${i.INFO_TITLE }</a></td>
				<td>${i.INFO_VIEWS}</td>
				<td>${i.INFO_RCM}</td>
				<td>${i.INFO_UNRCM}</td>
				<td>${i.m_ID }</td>
				<td><fmt:formatDate value="${i.INFO_CREATE_DATE}"
						pattern="yyyy-MM-dd" /></td>
			</tr>
		</c:forEach>
		</table>
		<c:if test="${START>1}">
			<a href="info_Main.do?page=1&type=${type}&keyword=${keyword}">[처음]</a>
			<a href="info_Main.do?page=${PAGE-1}&type=${type}&keyword=${keyword}">[이전]</a>
		</c:if>
		<c:forEach begin="${START}" end="${END<LAST? END:LAST}" var="i">
			<c:choose>
				<c:when test="${i==current}"> <b>[${i}]</b> </c:when>
				<c:otherwise>
					<a href="info_Main.do?page=${i }&type=${type}&keyword=${keyword}">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${END<LAST}">
			<a href="info_Main.do?page=${END+1}&type=${type}&keyword=${keyword}">[다음]</a>
			<a href="info_Main.do?page=${LAST}&type=${type}&keyword=${keyword}">[마지막]</a>
		</c:if>
		
		<form action="info_Main.do">
		
		
		


		<div id="searchChk">
		기간<input type="checkbox" name="datesearch" onclick="toggleT('datesearch','datesearch')">
		장소<input type="checkbox" name="destination" onclick="toggleT('REV_DESTINATION','destination')">
		</div>



		<div id="searchForm">
		<div id="datesearch" class="search_">
		<input type="date" name="startdate">
		<input type="date" name="enddate"><br>
		</div>
		
		<div id="INFO_DESTINATION" class="search_">
		<input type="text" name="INFO_DESTINATION" placeholder="장소를 입력하세요">
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
		<button onclick="location.href='info_WriteForm.do'">글쓰기</button>
</div>
</div>
</body>
</html>
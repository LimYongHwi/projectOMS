<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/SearchForm.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
  src="https://code.jquery.com/jquery-2.2.4.js"
  integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
  crossorigin="anonymous"></script>
<script type="text/javascript">
function checkAll(checkbox){
	if(	checkbox.prop("checked"))
		$(".selOne").prop("checked",true);
	else{
		$(".selOne").prop("checked",false);
	}
}
function checkOne(checkbox){
	var count =0;
	if(	checkbox.prop("checked")){
		$(".selOne").each(function(index){
			if($(this).prop("checked")){
				count++;
			}
			if(count==4){
				$(".selAll").prop("checked",true);
			}
		})
		
	}else{
		$(".selAll").prop("checked",false);
	}
}
$(document).ready(function(){
	
$('.sliding').click(function(){
	$(".searchForm").slideToggle('slow');
});

})


function valuecheck(){
	var count = 0;
	var checkedval=[];
	if(!$(".selAll").prop("checked")){
		$(".selOne").each(function(index){
			if($(this).prop("checked")){
				console.log(index+"체크댐")
				checkedval.push($(this).val())
			}
		})
		$("input[name=selected]").val(checkedval);
		console.log(checkedval)
		console.log($("input[name=selected]").val())
	}
	
	return true;
}
</script>


<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<div class="section">
<hr>
<div class="title"><h2>통합검색</h2></div>
<hr>
<div class="searchForm">
<form action="search.do" method="post">
<dl>
<dt>제목</dt>
<dd><input type="text" name="TITLE"></dd>
<dt>내용</dt>
<dd><input type="text" name="CONTENT"></dd>
<dt>작성자</dt>
<dd><input type="text" name="M_ID"></dd>
<dt>선택</dt>
<dd><input type="checkbox" name="selectAll" class="selAll" onclick="checkAll($(this))">전체
<input type="checkbox" name="select" value="1" class="selOne" onclick="checkOne($(this))">모집게시판
<input type="checkbox" name="select" value="2" class="selOne" onclick="checkOne($(this))">계획게시판
<input type="checkbox" name="select" value="3" class="selOne" onclick="checkOne($(this))">후기게시판
<input type="checkbox" name="select" value="4" class="selOne" onclick="checkOne($(this))">여행정보게시판
<input type="hidden" name="selected">
</dd>
<dt></dt>
<dd></dd>
</dl> 
<input type="submit" value="검색하기">
</form>
</div>
<hr>
<div class="sliding"><b>^</b></div>

<div class="result">


	<div class="recruit">
	<hr>
	<h3>모집게시판</h3>
	<table class="recruit_tab">
	<tr>
	</tr>
	<tr>
	<th width="70px">글번호</th>
	<th width="500px">제목</th>
	<th width="200px">작성자</th>
	<th width="200px">작성일</th>
	</tr>
	<c:choose>
	<c:when test="${fn:length(recruit.Recruit)<1}">
	<tr><td colspan="5">검색결과가 없습니다.</td></tr>
	</c:when>
<c:otherwise>
	<c:forEach var="r" items="${recruit.Recruit }">
	<tr>
	<td>${r.REC_NO}</td>
	<td style="text-align:left">${r.REC_TITLE}</td>
	<td>${r.m_ID }</td>
	<td><fmt:formatDate value="${r.REC_CREATE_DATE }" pattern="yyyy-MM-dd"/></td>
	</tr>
	</c:forEach>
		</c:otherwise></c:choose>
	</table>
	<hr>
	</div>
	
	
	
	<div class="plan">
		<h3>계획게시판</h3>
	<table class="plan_tab">
	<tr>
	</tr>
	<tr>
	<th width="70px">글번호</th>
	<th width="500px">제목</th>
	<th width="200px">작성자</th>
	<th width="200px">작성일</th>
	</tr>
	<c:choose>
	<c:when test="${fn:length(plan.plan)<1}">
	<tr><td colspan="5">검색결과가 없습니다.</td></tr>
	</c:when>
	<c:otherwise>
	<c:forEach var="p" items="${plan.plan}">
	<tr>
	<td>${p.PLAN_NO}</td>
	<td style="text-align:left">${p.PLAN_TITLE}</td>	
	<td>${p.m_ID }</td>
	<td><fmt:formatDate value="${p.PLAN_CREATE_DATE }" pattern="yyyy-MM-dd"/></td>
	</tr>
	</c:forEach>
	</c:otherwise></c:choose>
	</table>
	<hr>
	</div>	
	
	
	<div class="review">
	<h3>리뷰게시판</h3>
	<table class="review_tab">
	<tr>
	</tr>
	<tr>
		<th width="70px">글번호</th>
	<th width="500px">제목</th>
	<th width="200px">작성자</th>
	<th width="200px">작성일</th>
	</tr>
	<c:choose>
	<c:when test="${fn:length(review.reviewList)<1}">
	<tr><td colspan="5">검색결과가 없습니다.</td></tr>
	</c:when>
	<c:otherwise>
	<c:forEach var="r" items="${review.reviewList}">
	<tr>
	<td>${r.REV_NO}</td>
	<td style="text-align:left">${r.REV_TITLE}</td>	
	<td>${r.m_ID }</td>
	<td><fmt:formatDate value="${r.REV_CREATE_DATE }" pattern="yyyy-MM-dd"/></td>
	</tr>
	</c:forEach>
	</c:otherwise></c:choose>
	</table>
	<hr>
	</div>
	
	
		
	<div class="info">
	<h3>여행정보게시판</h3>
	<table class="info_tab">
	<tr>
	</tr>
	<tr>
		<th width="70px">글번호</th>
	<th width="500px">제목</th>
	<th width="200px">작성자</th>
	<th width="200px">작성일</th>
	</tr>
	<c:choose>
	<c:when test="${fn:length(info.infoList)<1}">
	<tr><td colspan="5">검색결과가 없습니다.</td></tr>
	</c:when>
	<c:otherwise>
	<c:forEach var="i" items="${info.infoList}">
	<tr>
	<td>${i.INFO_NO}</td>
	<td style="text-align:left">${i.INFO_TITLE}</td>
	<td>${i.m_ID }</td>
	<td><fmt:formatDate value="${i.INFO_CREATE_DATE }" pattern="yyyy-MM-dd"/></td>
	</tr>
	</c:forEach>
	</c:otherwise></c:choose>
	</table>
	<hr>
	</div>
</div>


</div>



</body>
</html>
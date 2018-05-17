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
$(document).ready(function(){
	checkOne();
})
function checkAll(checkbox){
	if(	checkbox.prop("checked"))
		$(".selOne").prop("checked",true);
	else{
		$(".selOne").prop("checked",false);
	}
}
function checkOne(checkbox){
	var count =0;
	
	if(checkbox==undefined){
		$(".selOne").each(function(index){
			if($(this).prop("checked")){
				count++;
			}
			if(count==4){
				$(".selAll").prop("checked",true);
			}
		})
	}else{
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
				checkedval.push($(this).val())
			}
		})
		$("input[name=selected]").val(checkedval);
		console.log($("input[name=selected]").val())
	}
	
	return true;
}

function createPage(elementId,current,start,end,last){
	console.log("createPage"+elementId+"   current"+current+"   start"+start+"   end"+end+"   last"+last);
	var div=$("#"+elementId);
	var CURRENT=parseInt(current);
	var START=parseInt(start);
	var END=parseInt(end);
	var LAST=parseInt(last);
	var pre=START-10;
	var next=START+10;
	
	div.empty();
	if(CURRENT!=1){
		div.append("<b onclick='movePage(\""+elementId+"\",1)'>[처음]</b>");
		if(pre>=1)
		div.append("<b onclick='movePage(\""+elementId+"\","+pre+")'>[이전]</b>");
	}
	var rLAST=END<LAST?END:LAST;
	for(var i=START; i<=rLAST;i++){
		if(i==CURRENT){
			div.append("<b class='current'> "+i+" </b>");
		}else
		div.append("<b onclick='movePage(\""+elementId+"\","+i+")'> "+i+" </b>");
	}
	if(CURRENT<LAST){
		if(next<=LAST)
		div.append("<b onclick='movePage(\""+elementId+"\","+next+")'>[다음]</b>");
		div.append("<b onclick='movePage(\""+elementId+"\","+LAST+")'>[마지막]</b>");
	}
}

function movePage(inputElement,pageNum){
	console.log(inputElement)
	console.log(pageNum)
	$("input[name="+inputElement+"]").val(pageNum);
	$("#searchForm").submit();
}
</script>


<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<div class="section">
</script>
<hr>
<div class="title"><h2>통합검색</h2></div>
<hr>
<div class="searchForm">
<form action="search.do" method="post" id="searchForm">
<dl>
<dt>
<select name="type">
<option value="1" <c:if test="${type==1}">selected</c:if>>제목</option>
<option value="2" <c:if test="${type==2}">selected</c:if>>내용</option>
<option value="3" <c:if test="${type==3}">selected</c:if>>제목+내용</option>
</select></dt>
<dd>
<input type="text" name="keyword" value="${keyword}"></dd>
<dt>작성자</dt>
<dd><input type="text" name="M_ID" value="${M_ID}"></dd>
<dt>선택</dt>
<dd><input type="checkbox" name="selectAll" class="selAll" onclick="checkAll($(this))">전체
<input type="checkbox" name="select" value="1" class="selOne" onclick="checkOne($(this))" ${rec_check }>모집게시판
<input type="checkbox" name="select" value="2" class="selOne" onclick="checkOne($(this))" ${plan_check }>계획게시판
<input type="checkbox" name="select" value="3" class="selOne" onclick="checkOne($(this))" ${rev_check }>후기게시판
<input type="checkbox" name="select" value="4" class="selOne" onclick="checkOne($(this))" ${info_check }>여행정보게시판
<input type="hidden" name="selected">
</dd>
<dt></dt>
<dd></dd>
</dl> 
<input type="submit" value="검색하기">
</form>
</div>
<hr>
<div class="sliding"><img src="image/slidebutton.png" alt="^" style="margin-top: 5px;"></div>

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
	<input type="hidden" value="${recruit.current}" name="recPage" form="searchForm">
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
	<div id="recPage" class="paging">
	<script type="text/javascript">
	createPage("recPage",${recruit.current},${recruit.START},${recruit.END},${recruit.LAST});
	</script>
	</div>
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
	<input type="hidden" value="${plan.current}" name="planPage" form="searchForm">
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
	<div id="planPage" class="paging">
	<script type="text/javascript">
	createPage("planPage",${plan.current},${plan.START},${plan.END},${plan.LAST});
	</script>
	</div>
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
	<input type="hidden" value="${review.current}" name="revPage" form="searchForm">
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
	<div id="revPage" class="paging">
	<script type="text/javascript">
	createPage("revPage",${review.current},${review.START},${review.END},${review.LAST});
	</script>
	</div>
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
	<input type="hidden" value="${info.current}" name="infoPage" form="searchForm">
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
	<div id="infoPage" class="paging">
	<script type="text/javascript">
	createPage("infoPage",${info.current},${info.START},${info.END},${info.LAST});
	</script>
	</div>
	<hr>
	</div>
</div>


</div>



</body>
</html>
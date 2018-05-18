<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="jsp/FAQ/css/FAQ.css" rel="stylesheet">
<script
  src="https://code.jquery.com/jquery-2.2.4.js"
  integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
  crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$('.content').hide();
		$('#title li').click(function() {
			$('.content').not(this).hide();
			$('.content', this).fadeToggle();

		});
		faq_tab(1,0);
	});
	
	function faq_tab(page, tab_no){
		$.ajax({
			type: 'post',
			url: 'getFAQList.do',
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			dataType: 'json',
			async : true,
			data:{
			"page":page,
			"tab_no":tab_no},
			
			success:function(data){
				console.dir(data)
				var datas= data;
				var tabname = ["-","모집/계획관련", "이벤트관련", "회원관련"];
				
				console.log(datas);
				console.log(datas.result[0])
				console.log(datas.result[0].List);
				var list = datas.result[0].List;
				console.log(list.length);
			   	$("#table_").empty();
			   	if(list.length==0){
			   		$("#table_").append("<tr>");
			   		$("#table_").append("<td>검색결과가 없습니다.</td>");
			   		$("#table_").append("</tr>");
			   	}else{
			   		
				for(var i =0; i<list.length;i++){
					$("#table_").append("<tr>");
					$("#table_").append("<td>"+tabname[list[i].FAQ_TAB]+"</td>");
					$("#table_").append("<td>"+list[i].FAQ_TITLE+"</td>");
					$("#table_").append("</tr>");
				}
			   		
			   	}
				

				
			}
		});
		
	}
</script>

</head>
<body>
<jsp:include page="../Header_tab1.jsp"></jsp:include>
	<div class="body">
		<jsp:include page="../sidevar_3.jsp"></jsp:include>

		<div id="container">

			<p id="subject">FAQ</p>
			<p id="subject_sub">오마쏘에 자주 묻는 질문을 확인해보세요.</p>
			<hr>
			<div class="section">
				<ul class="tabs">
					<li class="active" rel="tab1" onclick="faq_tab(1, 0)">전체</li>
					<li rel="tab2" onclick="faq_tab(1, 1)">모집/계획 관련</li>
					<li rel="tab3" onclick="faq_tab(1, 2)">이벤트 관련</li>
					<li rel="tab4" onclick="faq_tab(1, 3)">회원 관련</li>
				</ul>

				<div class="tab_container">
					<div id="tab1" class="tab_content">
						<table id="table_"></table>
						
						<c:if test="${START!=1}">
			<a href="service_center_main.do?page=1&type=${type}&keyword=${keyword}">[처음]</a>
			<a href="service_center_main?page=${PAGE-1}&type=${type}&keyword=${keyword}">[이전]</a>
		</c:if>
		<c:forEach begin="${START}" end="${END<LAST? END:LAST}" var="i">
			<c:choose>
				<c:when test="${i==current}"> <b>[${i}]</b> </c:when>
				<c:otherwise>
					<a href="rservice_center_main.do?page=${i }&type=${type}&keyword=${keyword}">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${END<LAST}">
			<a href="service_center_main.do?page=${END+1}&type=${type}&keyword=${keyword}">[다음]</a>
			<a href="service_center_main.do?page=${LAST}&type=${type}&keyword=${keyword}">[마지막]</a>
		</c:if>
						<input type="button" id="write" value="글쓰기"
							onclick="location.href='faq_writeForm.do'">
					</div>

					<div id="tab2" class="tab_content">
						
					</div>
					<!-- #tab2 -->
					<div id="tab3" class="tab_content">
						
					</div>
					<!-- #tab3 -->
					<div id="tab4" class="tab_content">
					<!-- #tab4 -->
				</div>
			</div>
		</div>
	</div>
	
</div>
</body>
</html>
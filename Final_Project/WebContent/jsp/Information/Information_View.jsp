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
	minecheck();
$(".title").text("여행정보게시판");
});
function sysout(V){
	var tost="";
	for(var a in V){
		tost+=a;
	}
	return 
}

function minecheck(){
	var sessionId = "<%= (String)session.getAttribute("id")%>";
	var writer =$("#writer").text();
	if(sessionId==writer){
		$(".mine").css({"visibility":"visible","display":"block"});
		console.log('보여');;
	}else{
		$(".mine").css({"visibility":"hidden","display":"none"});
		console.log('사라져');;
	}
}


//추천 버튼눌렀을떄 발생할놈 ?
function doRCM(isRCM,INFO_NO){
	var uri="infoRCM.do";
	$.ajax({
		type:'get',
		url:uri,
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		dataType:'text',
		data:"INFO_NO="+INFO_NO+"&isRCM="+isRCM,
		success:function(data){
			var datas= JSON.parse(data);
			console.log(datas.result[0]);
			updateRCM(datas.result[0].RCMCNT,datas.result[0].UNRCMCNT);
		}
		
	})
	
	
	
	
}


//추천, 비추천수 변경해줄놈
updateRCM= function(rcm,rec){
	console.log(rcm+"//"+rec);
	$("#RCM_COUNT").text(rcm);
	$("#UNRCM_COUNT").html(rec);
}






</script>
<link rel="stylesheet" href="jsp/Review/css/view.css">
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../Header_tab1.jsp"></jsp:include>
<%boolean mine=(boolean)request.getAttribute("ismine"); %>
<div class="body">
<jsp:include page="../sidevar_2.jsp"/>
<div class="section"> 

<p id="title">여행정보게시물</p>
<p id="title_sub">친구들의 여행후기에 평가를 남겨주세요!</p>
<hr>
<input type="text" style="display: none;" value="${INFO.INFO_NO}" id="INFO_NO">

<dl>
<dt>번호</dt>
<dd>${INFO.INFO_NO}</dd>
<dt>제목</dt>
<dd>${INFO.INFO_TITLE}</dd>
<dt>작성날짜</dt>
<dd><fmt:formatDate value="${INFO.INFO_CREATE_DATE}" pattern="yyyy-MM-dd"/></dd>
<dt>작성자</dt>
<dd id="writer">${INFO.m_ID}</dd>
<dt>추천수</dt>
<dd id="RCM_COUNT">${INFO.INFO_RCM}</dd>
<dt>비추천수</dt>
<dd id="UNRCM_COUNT">${INFO.INFO_UNRCM}</dd>
<dt>조회수</dt>
<dd>${INFO.INFO_VIEWS}</dd>

<dt>파일다운로드</dt>
<dd>
<c:choose>
<c:when test="${INFO.INFO_FILE!=null}">
<a href="infodownload.do?num=${INFO.INFO_NO}">
${INFO.INFO_NO}
</a>
</c:when>
<c:otherwise>
파일없음
</c:otherwise>
</c:choose>
</dd>
<dt>내용</dt>
<dd><img alt="이미지없음" src="infodownload.do?num=${INFO.INFO_NO}">${INFO.INFO_CONTENT}</dd>
</dl>


<input type="button" class="button" value="뒤로가기" onclick="javascript:history.back()" style="margin-left:50px">
<%if(mine){%>
<span id="list1"></span>
<%}else{ %>
<input type="button" id="RCM"  value="추천하기" onclick="doRCM(0,${INFO.INFO_NO})">
<input type="button" id="UNRCM"value="비추천하기" onclick="doRCM(1,${INFO.INFO_NO})">
<%} %>
<%if(mine){ %>
<input type="button" value="수정" onclick="location.href='info_updateForm.do?INFO_NO=${INFO.INFO_NO}'">
<input type="button" value="삭제" onclick="location.href='info_delete.do?INFO_NO=${INFO.INFO_NO}'">
<%} %>
<input type="button" value="전체목록" onclick="location.href='info_Main.do'"> 
</div>
</div>
</body>
</html>
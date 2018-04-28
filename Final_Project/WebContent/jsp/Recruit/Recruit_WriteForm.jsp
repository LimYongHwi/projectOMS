<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="jsp/Recruit/css/writeForm.css">
</head>

<body>
<jsp:include page="../Header_tab1.jsp"></jsp:include>
<div class="body">
<jsp:include page="../sidevar_1.jsp"/>

<div class="section">
<p id="title">모집하기</p>
<p id="title_sub">함께 여행할 계획에 친구들을 모집해보세요!</p>

<hr>
<div>
<form action="recruit_write.do" enctype="multipart/form-data" method="post">
<dl>
<dt>내용</dt><dd><input type="text" name="REC_CONTENT"></dd>
<dt>첨부파일</dt><dd><input type="file" name="ufile"></dd>
<dt>작성자</dt><dd><input type="text" name="M_ID" value="${M_ID}"></dd>
<dt>장소</dt><dd><input type="text" name="REC_DESTINATION"></dd>
<dt>인원수</dt><dd><input type="number" name="REC_MEMBER_COUNT"></dd>
<dt>원하는 성별</dt><dd><input type="radio" name="REC_GENDER" value="M">남자만 <input type="radio" name="REC_GENDER" value="W">여자만 <input type="radio" name="REC_GENDER" value="F">무관</dd>
<dt>시작일</dt><dd><input type="date" name="REC_START"></dd>
<dt>종료일</dt><dd><input type="date" name="REC_END"></dd>
</dl>
<input type="button" class="button" value="뒤로가기" onclick="javascript:history.back()" style="margin-left:50px">
<input type="submit" value="작성하기" style="margin-left:200px"> 
</form>
</div>
</div>
</div>

</body>
</html>
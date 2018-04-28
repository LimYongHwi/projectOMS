<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/Join.css">
<script
  src="http://code.jquery.com/jquery-2.2.4.js"
  integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
  crossorigin="anonymous"></script>
 <style type="text/css">
 .prof_section .imagePreview {
  	content:url("");
 	width:183px;
 	height:183px;
 	display: block;
 	margin:0 auto;
 	border: 0; border-radius: 7.5em;
}
 </style>
 <script>
 $(document).ready(function(){
	
    $('#gender').hide();
    $('#nation').hide();
    
	var gender = $('#gender').val();
	var nation = $('#nation').val();
	var phone = $("select[name=M_PHONE]").val();
	var private = $("input[name=M_PRIVATE]").val();
	alert(private);
	
	alert(gender);
    if(gender=="1")
    	$(".select option:eq(1)").attr("selected", "selected");
    else if(gender=="2")
    	$(".select option:eq(2)").attr("selected", "selected");
    else if(gender=="3")
    	$(".select option:eq(3)").attr("selected", "selected");
    
    if(nation=="대한민국")
    	$(".birthday_box option:eq(1)").attr("selected", "selected");
    else if(nation=="일본")
    	$(".birthday_box option:eq(2)").attr("selected", "selected");
    else if(nation=="미국")
    	$(".birthday_box option:eq(3)").attr("selected", "selected");
    

    if(phone=="010")
    	$(".phn-select option:eq(0)").attr("selected", "selected");
    else if(phone=="011")
    	$(".phn-select option:eq(1)").attr("selected", "selected");
    else if(phone=="019")
    	$(".phn-select option:eq(2)").attr("selected", "selected");	
     
    if(private=="Y"){
    	$('#m_private').prop('checked',true);
    	$('#m_private').val('Y');
    }else{
    	$('#m_private').prop('checked',false);
    	$('#m_private').val('N');

    }
    
    $('#eOption').on('change',function(){
    	$('#eAddress').val( $('#eOption').val());
    });
    
    
 });
 </script>
</head>
<body>
<jsp:include page="MyPage.jsp"></jsp:include>
<div id="MyPwrqpper">
	<div id="MyContainer">
		<div id="menuSection">
		<div id="menuTitle">
			<span>마이 페이지</span>		
		</div>
		<div id="menuList">
		<ul>
			<li><a href="updateForm.do" id="menu1">정보수정</a></li>
			<li><a href="myAlbum.do?m_id=좆같네" id="menu2">내 사진첩</a></li>
			<li><a href="myActivity.do" id="menu3">내 활동</a></li>
			<li><a href="myQuestion.do" id="menu4">내가 문의한 글</a></li>
			<li><a href="withdraw.do">회원 탈퇴</a></li>
		</ul>
		</div>
		</div> <!-- menuSection끝 -->
		<div id="contentSection">
<form action="update.do" method="post" enctype="multipart/form-data" id="form" name="frm">
<div class="whole"> <!-- 전체 감싸고 있는 -->
<div class="title"><h2>정보 수정</h2></div> <!-- 타이틀 -->
<div class="join_form">
<div class="prof_section">
<a><img class="imagePreview"  src="profileDownload.do?M_ID=${mv.m_ID}"></a>
 <label class="imgLabel"> 이미지 등록
<input type="file"  name="ufile" value="이미지수정" id="uploadFile"></label>
</div> <!-- 이미지 섹션 끝 -->

<div class="stylized"> <!-- 아이디 입력폼 -->
<label>*아이디</label>
<label class="alert" id="valid_id"></label>
<div class="input_line">
<input type="text" name="M_ID" id="idval" value="${mv.m_ID}" placeholder="중복검사 클릭" readonly>
<button id="chkForm">중복 검사</button>
</div>
</div>

<div class="stylized" > <!-- 이름,성별 입력폼 -->
<label>*이름</label>
<span id="gen">*성별</span>
<input type="text" value="${mv.m_GENDER}" id="gender">
<select class="select" name="M_GENDER" value="${mv.m_GENDER}">
<option value="" selected disabled>선택하세요</option>
<option value="1">여자</option>
<option value="2">남자</option>
<option value="3">기타</option>
</select>
<div class="input_line">
<input type="text" name="M_NAME" placeholder="이름을 입력하세요" value="${mv.m_NAME}">
</div>
</div>

<div class="stylized" > <!-- 비밀번호 입력폼 -->
<label>*비밀번호</label>
<span class="alert" id="pwResult">영어 소문자+숫자1자이상 또는 특수문자 1자 이상. 8자리~16자리</span>
<div class="input_line">
<input type="password" placeholder="비밀번호를 입력하세요" id="pw" name="M_PASSWORD" value="${mv.m_PASSWORD}">
</div>
</div>

<div class="stylized" > <!-- 비밀번호 확인 -->
<label>*비밀번호 확인</label>
<span class="alert" id="po_check">일치 여부</span>
<div class="input_line">
<input type="password" placeholder="비밀번호를 입력하세요" id="pw_chk">
</div>
</div>

<div id="extra"> <!-- 생년월일 -->
<div class="stylized">
<label>*생년월일</label>
<span class="alert">숫자만 입력하세요.</span>
<div class="input_line">
<input type="text" name="M_AGE" id="age" value="${mv.m_AGE}">
</div>
</div>

<div id="extra"> <!-- 전화번호 -->
<label>*전화번호</label>
<span id=bi><input type="checkbox" name="M_PRIVATE" id="m_private" value="${mv.m_PRIVATE}">비공개</span>
<div class="stylized">
<select class="phn-select" name="M_PHONE" value="${phone1}">
<option value="010">010</option>
<option value="011">011</option>
<option value="019">019</option>
</select>
<span id="bar">-</span>
<input type="text" name="M_PHONE" value="${phone2}">
<span id="bar">-</span>
<input type="text" name="M_PHONE" value="${phone3}">
</div>
</div>

<div id="extra" > <!-- 거주 국가  -->
<label>*거주국가</label>
<input type="text" value="${mv.m_NATION}" id="nation">
<select class="birthday_box" name="M_NATION" value="${mv.m_NATION}">
<option value="" selected disabled>선택하세요</option>
<option value="대한민국">대한민국(South Korea)</option>
<option value="일본">일본(Japan)</option>
<option value="미국">미국(Unite States)</option>
</select>
</div>


<div class="stylized"> <!-- 주소 -->
<label>*주소</label>
<span class="alert" >상세주소 제외 동까지만 입력하세요.</span>
<div class="input_line" id="">
<input type="text" placeholder="입력하세요" name="M_ADDRESS" value="${mv.m_ADDRESS}">
</div>
</div>

<div id="extra" > <!-- 이메일 -->
<label>*이메일 주소</label>
<div class="birthday_box">
<input type="text" name="M_EMAIL" value="${email1}">
<span id="bar">@</span>
<input type="text" name="M_EMAIL" id="eAddress" value="${email2}">
<span id="bar"> </span>
<select class="phn-select" id="eOption">
<option value="" selected>직접 입력</option>
<option value="gmail.com">gmail.com</option>
<option value="naver.com">naver.com</option>
</select>
</div>
</div>

<div class="btn_box">
<input type="submit" value="수정" id="sub_btn">
<button id="reset">다시 작성</button>
<button id="back">뒤로</button>
</div>
</div>
</div>
</div>
</form>
</div>
</div>
</div>


</body>
</html>
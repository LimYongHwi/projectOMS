<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  
  
  <script type="text/javascript">
  
	 function jusoCallBack(roadFullAddr){
  		var address = roadFullAddr; 
  		$('#addr').val(address);
		self.close();
	}
 
  $(document).ready(function(){
	  var link=null;
	  
	  function pwValidate(pw){
		  var pwPattern = /^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{8,16}$/;
		  if(pwPattern.test(pw)==false)
			  return false;
		  else return true;
	  }
	  
	  function pwChkValidate(){
		  if($('#pw').val() != $('#pw_chk').val()){
				 $('#po_check').text('');
				 $('#po_check').html('비밀번호가 틀렸습니다. 다시 입력해 주세요.');
				 return false;
			 }
			 else {
				 $('#po_check').text('');
				 $('#po_check').css('color','green');
				 $('#po_check').html('비밀번호가 일치합니다.');
				 return true;
			 }
	  }
	  
	
	  
	  $('#pw').on('keyup',function(){
		  var pw = $('#pw').val();
		  if(!pwValidate(pw)){
			  $('#pwResult').text('형식이 올바르지 않습니다.영소문자+숫자1 또는 특수문자 조합 8자리~16자리');
			  $('#pwResult').css('color','red');
		  }else{
			  $('#pwResult').text('');
			  $('#pwResult').text('정상입력');
			  $('#pwResult').css('color','green');
		  }
	  })
	  
	  
	 $('#pw_chk').keyup(function(){
		 pwChkValidate();
	 });
	  
	 
	 $('#age').keyup(function(){
		 $(this).val($(this).val().replace(/[^0-9]/g,""));
	 });
	 
	 $('input[name=M_PHONE]').keyup(function(){
		 $(this).val($(this).val().replace(/[^0-9]/g,""));
	 });
	 
	
	 $('form').on('submit', function() {
		if($('#idval').val()==null || $('#idval').val()==""){
			alert('아이디를 입력하세요');
			return false;
		}else if(!pwValidate($('#pw').val())){
			alert('비밀번호 양식을 맞추세요');
			return false;
		}else if(!pwChkValidate()){
			alert('비밀번호가 틀립니다.확인하세요.');
			return false;
		}
		
	 });
	 
	 $('#back').click(function(){
		 window.history.back();
	 });
	 
	 $('#reset').click(function(){
		 location.reload();
	 });
	
	 
	 $('#chkForm').click(function(){
		 var url = "idChkForm.do"
		window.open(url,"ckeck","width=500 height=400 status=no")
	 });
	 
	 $('#eOption').change(function(){
		 $('#eAddress').val($('#eOption option:selected').val());
	 });
		
	 $(function() {

		    $("#uploadFile").on("change", function(){

		        var files = !!this.files ? this.files : [];

		        if (!files.length || !window.FileReader) return; 

		        if (/^image/.test( files[0].type)){ 

		            var reader = new FileReader(); 

		            reader.readAsDataURL(files[0]); 		 

		            reader.onloadend = function(){ 

		             $('.imagePreview').css("content", "url("+this.result+")"); 

		            };

		        }

		    });

		});
	 
	 
	 $('#srchAddr').click(function(){
		 var pop = window.open("jusoPopup.do","pop","width=590,height=420, scrollbars=yes, resizable=yes");
		 
		});
	
	 
	  



	 
	 

  }); //스크립트 끝

  </script>
  
</head>
<body>		
<form action="join.do" method="post" enctype="multipart/form-data" id="form" name="frm">
<div class="whole"> <!-- 전체 감싸고 있는 -->
<div class="title"><h1>회원가입</h1></div> <!-- 타이틀 -->
<div class="join_form">
<div class="prof_section">
<img class="imagePreview">
 <label class="imgLabel"> 이미지 등록
<input type="file" name="ufile" value="이미지등록" id="uploadFile"></label>
</div> <!-- 이미지 섹션 끝 -->

<div class="stylized"> <!-- 아이디 입력폼 -->
<label>*아이디</label>
<label class="alert" id="valid_id">아이디 중복검사는 필수사항입니다.</label>
<div class="input_line">
<input type="text" name="M_ID" id="idval" value="${m_id}" placeholder="중복검사 클릭" readonly>
<button id="chkForm">중복 검사</button>
</div>
</div>

<div class="stylized" > <!-- 이름,성별 입력폼 -->
<label>*이름</label>
<span id="gen">*성별</span>
<select class="select" name="M_GENDER">
<option value="" selected disabled>선택하세요</option>
<option value="1">여자</option>
<option value="2">남자</option>
<option value="3">기타</option>
</select>
<div class="input_line">
<input type="text" name="M_NAME" placeholder="이름을 입력하세요">
</div>
</div>

<div class="stylized" > <!-- 비밀번호 입력폼 -->
<label>*비밀번호</label>
<span class="alert" id="pwResult">영어 소문자+숫자1자이상 또는 특수문자 1자 이상. 8자리~16자리</span>
<div class="input_line">
<input type="password" placeholder="비밀번호를 입력하세요" id="pw" name="M_PASSWORD">
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
<input type="text" name="M_AGE" id="age">
</div>
</div>

<div id="extra"> <!-- 전화번호 -->
<label>*전화번호</label>
<span id=bi><input type="checkbox" name="M_PRIVATE" id="m_private" value="Y">비공개</span>
<div class="stylized">
<select class="phn-select" name="M_PHONE">
<option value="010">010</option>
<option value="011">011</option>
<option value="019">019</option>
</select>
<span id="bar">-</span>
<input type="text" name="M_PHONE">
<span id="bar">-</span>
<input type="text" name="M_PHONE">
</div>
</div>

<div id="extra" > <!-- 거주 국가  -->
<label>*거주국가</label>
<select class="birthday_box" name="M_NATION">
<option value="" selected disabled>선택하세요</option>
<option value="대한민국">대한민국(South Korea)</option>
<option value="일본">일본(Japan)</option>
<option value="미국">미국(Unite States)</option>
</select>
</div>


<div class="stylized"> <!-- 주소 -->
<label>*주소</label>
<span class="alert"><button id="srchAddr" type="button">주소검색</button></span>

<div class="input_line" id="">
<input type="text" name="M_ADDRESS" id="addr">
</div>
</div>

<div id="extra" > <!-- 이메일 -->
<label>*이메일</label>
<div class="birthday_box">
<input type="text" name="M_EMAIL">
<span id="bar">@</span>
<input type="text" name="M_EMAIL" id="eAddress">
<span id="bar"> </span>
<select class="phn-select" id="eOption">
<option value="" selected disabled>직접 입력</option>
<option value="gmail.com">gmail.com</option>
<option value="naver.com">naver.com</option>
</select>
</div>
</div>

<div class="btn_box">
<input type="submit" value="가입" id="sub_btn">
<input type="reset" value="다시 작성">
<input type="button" value="뒤로">
<!-- <button id="reset">다시 작성</button> -->
<!-- <button id="back">뒤로</button> -->
</div>
</div>
</div>
</div>
</form>

</body>
</html>


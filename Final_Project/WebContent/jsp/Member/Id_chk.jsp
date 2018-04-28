<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
  src="http://code.jquery.com/jquery-2.2.4.js"
  integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
  crossorigin="anonymous"></script> 
  <link rel="stylesheet" href="//fonts.googleapis.com/earlyaccess/hanna.css" />
<link rel="stylesheet" href="css/IdCheck.css">
<script>
$(document).ready(function(){
	$('#alertMsg').hide();
 	$('#flag').hide();
	
	$('#dBtn').on('click', function() {       
        if($('#search').val()==""){
        	alert('아이디를 입력하세요!');
        	console.log('실패');
            return false;
        }else{
        	$('#alertMsg').hide().text('');
        	 var m_id=$('#search').val();
        	$.ajax({
        		url:'duplChk.do',
        		type:'get',
        		cache : false,
        		data: "m_id="+m_id,
        		dataType:'text',
                contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        		success: function(result){
        			var data= JSON.parse(result);
        			console.log(data.msg[0]);
        			$('#msg').text(data.msg[0]);
        			$('#flag').val(data.flag);
        		},
        		error : function(request,status,error){
        			alert("code:"+request.status+"error:"+error);
        		}
        		
        	});
        	return false;
        }
    });
	
	$('#useId').click(function() {       
		if($('#flag').val()=="false"||$('#flag').val()==""){
			alert('아이디 사용여부를 확인하세요.');
		}else{
			$("#idval", parent.opener.document).val($('#search').val());
			console.log($('#search').val());
 			self.close();
		}
	});
	
	$('#closeWin').click(function(){
		window.close();
	});
	
});

</script>
</head>
<body>
<div class="srch_box">
<div class="srch_title">
<h1>중복검사</h1>
</div>
<div class="box">
  <div class="container-4">
  	<form action="duplChk.do" name="duform">
    <input type="search" id="search" name="m_id" placeholder="아이디를 입력하세요." required />
    <button class="icon" type="button" id="dBtn"><i class="fa fa-search"></i></button>
    </form>
  </div>
</div>
	<p id="alertMsg" class="resultBox"></p>
	<p id="msg" class="resultBox">${msg}</p>
 	<input id="flag" class="resultBox">
 	
 	
 	<div class="btn_Box" id="">
 	<button id="useId">사용하기</button>	
 	<button id="closeWin">취소</button>
 	</div>
 	
</div>

</body>
</html>
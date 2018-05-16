<%@page import="javax.mail.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
  src="http://code.jquery.com/jquery-2.2.4.js"
  integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
  crossorigin="anonymous"></script>  
<link href="https://fonts.googleapis.com/css?family=Gloria+Hallelujah" rel="stylesheet">  
<link rel="stylesheet" href="css/MyPage.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/PlugIn/jquery-ui.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/Js/MyPage.js"></script> 

<style type="text/css">
#Myheader{
	background-image: url('image/MyHeader.jpg');
	background-repeat:no-repeat;
	background-size:cover;
	height:370px;
	text-align: center;
}
</style>

<script type="text/javascript">
function init(){
	var id= "<%= (String)session.getAttribute("id")%>";
	 $.ajax({
			url:'updateForm.do',
			type:"POST",
			cache : false,
			data: "id="+id,
			dataType:'text',
	  contentType: "application/x-www-form-urlencoded; charset=UTF-8",
	     success: function(result){
				var data= JSON.parse(result);
				console.log(data.name);
				
				$('#name').val(data.name);
				$('#idval').val(data.id);
				$('#pw').val(data.pwd);

				if(data.profile=="")
					$('.imagePreview').css("content", "url(image/sample.png)");	
				
				var gender =data.gender;
				if(gender=='1')
			    	$(".select option:eq(1)").attr("selected", "selected");
			    else if(gender=='2')
			    	$(".select option:eq(2)").attr("selected", "selected");
			    else if(gender=='3')
			    	$(".select option:eq(3)").attr("selected", "selected");
				
				$('#age').val(data.age);
				
				var phone=$('#phone1').val(data.phone1);
				if(phone=="010")
			    	$(".phn-select option:eq(0)").attr("selected", "selected");
			    else if(phone=="011")
			    	$(".phn-select option:eq(1)").attr("selected", "selected");
			    else if(phone=="019")
			    	$(".phn-select option:eq(2)").attr("selected", "selected");	
				
				$('#phone2').val(data.phone2);
				$('#phone3').val(data.phone3);
				
				var private = data.private;
				if(private=="Y"){
			    	$('#private').prop('checked',true);
			    	$('#private').val('Y');
			    }else{
			    	$('#private').prop('checked',false);
			    	$('#private').val('N');
			    }
				
				var nation=data.nation;
				if(nation=="대한민국")
			    	$(".birthday_box option:eq(1)").attr("selected", "selected");
			    else if(nation=="일본")
			    	$(".birthday_box option:eq(2)").attr("selected", "selected");
			    else if(nation=="미국")
			    	$(".birthday_box option:eq(3)").attr("selected", "selected");
				
				$('#address').val(data.address);
				$('#eId').val(data.eId);
				$('#eAddress').val(data.eAddress);
			
				
				
			},
			error : function(request,status,error){
				alert("code:"+request.status+"error:"+error);
			}
	});
	 
	 
}
	
	
$(document).ready(function(){
	var id= "<%= (String)session.getAttribute("id")%>";
	
	$('#menu1').click(function(){
		$('#contentSection').load("jsp/Member/MemberUpdateForm2.jsp");
		init();
	});
	
	$('#menu2').click(function(){
		 url="myAlbum.do?id="+id+"&s_id="+id;
  	     window.open(url,"ChildAlbumWin","width=1200 height=700 top=30px left=180px");
	});
});
</script>

</head>
<body>
<div id="MyPwrqpper">
	<div id="Myheader">
		<div id="Mytitle">
		<h1>Oh My Soulmate</h1>
		<h1 class="p2"></h1>
		</div>
	</div>
	<div class="">
	
	</div>
	
	<div id="MyContainer">
		<div id="MenuSection">
		<div class="MyMenuBox" id="MyMenuBox">
		<div id="menuTitle">
			<span>마이 페이지</span>	
		</div>
		<div id="menuList">
		<ul>
			<li id="menu1">정보수정</li>
			<li id="menu2">내 사진첩</li>
			<li><a href="#" id="menu4">내 활동</a></li>
			<li><a href="#" id="menu5">내가 문의한 글</a></li>
			<li><a href="#" id="menu5">회원 탈퇴</a></li>
		</ul>
		</div>
		</div> <!-- MymenuBox끝 -->
		</div>
		<div id="contentSection">
		
		</div>
	</div> <!-- MyContainer끝 -->
</div> <!-- MyPwrapper끝 -->
</body>
</html>
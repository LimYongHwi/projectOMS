<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/Album.css">
	<script type="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
<script src='http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js'></script>
		<script
		  src="http://code.jquery.com/jquery-2.2.4.js"
		  integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
		  crossorigin="anonymous"></script>
<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
<style type="text/css">
 a:link { color: red; text-decoration: none; color:black;}
 a:visited { color: black; text-decoration: none; color:black;}
 a:hover { color: blue; text-decoration: underline; cursor: pointer; color:black;}
</style>


<script type="text/javascript">
	$(document).ready( function() {
		var id= "<%= (String)session.getAttribute("id")%>";
		
		var uldFlag = 'off';
		$('#uldSection').hide();
		
		$('#uploadMypht').click(function(){
			if(uldFlag=='off'){
				$('#uldSection').slideDown();
				$('#photo_section').fadeOut();
				uldFlag = 'on';
			}else{
				$('#uldSection').slideUp();
				$('#photo_section').fadeIn();
				uldFlag = 'off';
			}
		});
		
		$('pFrm').submit(function(){
			
			var formData = new FormData();
			formData.append("PHOTO_CONTENT",$("input[name=PHOTO_CONTENT]").val());
                for (var index = 0; index < Object.keys(files).length; index++) {                	 
					formData.append("ufile",$("input[name=ufile]")[0].files[index]);
                }

			$.ajax({
				url:'uldMyPhoto.do',
				processData:false,
				contentType:false,
				async: true,
				cache: false,
				data:formData,
				enctype:"multipart/form-data",
				type:'POST',
				success:function(){
					location.reload();
				},
				error: function(request,status,error){
        			alert("code:"+request.status+"error:"+error);
				}
			});
		});
		
		
		
		$('#uploadBtn').change(function(){
			addPreview($(this));
		});
		function addPreview(input) {
	        if (input[0].files) {
	            for (var i = 0 ; i < input[0].files.length ; i++) {
	                var file = input[0].files[i];
	                var reader = new FileReader();
	 
	                reader.onload = function (img) {
	                    $("#preview").append(
	                        "<img src=\"" + img.target.result + "\"\/>"
	                    );
	                };
	                
	                reader.readAsDataURL(file);
	            }
	        } 
	    }
	
	});	 
	
</script>
</head>
<body>
<div class="boxContainer">
<div class="box1">
<div id="album_title"><h2>Photo Album</h2></div>
<div class="img_section">
<div class="al_pr_img"><img src="profileDownload.do?M_ID=${m_id}"></div></div>

<div class="info_section">
<h3>${m_id}</h3>
<h3>${rank}</h3>
<div id="ment">
<p>Jobs fill your pocket,</p>
<p>adventure fill your soul.</p>
</div>
</div>
</div>

<div class="box2">
<div class="prof_section">
<div class="section3">
<button id="uploadMypht">이미지 등록</button>
	<form action="uldMyPhoto.do" id="phtForm" name="pFrm" method="post" enctype="multipart/form-data">
	<div id="uldSection"><!-- 이미지 업로드 div -->
		<div class="phtTitleSec1">
			<ul>
				<li>제목</li>
				<li>이미지 첨부</li>
			</ul>
		</div>
		<div class="phtTitleSec2">
			<ul>
				<li><input type="text" name="PHOTO_TITLE"></li>
				<li> <label class="phtLabel"> 추가하기<input type="file" name="ufile" id="uploadBtn" multiple="multiple"></label></li>
			</ul>
		</div>
		
		<div id="preview">
		
		</div>
		
		<div class="uldContentSec">
			<div class="textWin">
			<textarea rows="10" cols="95" name="PHOTO_CONTENT"></textarea>
			</div>
		<div id="btnSec">
			<button type="submit" id="uld">완료</button>
			<button>취소</button>
		</div>
		</div>
	</div><!-- 이미지 업로드 끝 -->
	</form>
</div>


<div class="photo_section" id="photo_section">
	
	<div class="albWrapper"><!-- 데이터영역 -->
	<c:forEach items="${PhotoList}" var="p">
		<div class="phtContent">
		<a href="inDetail.do?photo_no=${p.PHOTO_NO}"><img src="photodownload.do?PHOTO_NO=${p.PHOTO_NO}"></a>
		<div>
		<a href="inDetail.do?photo_no=${p.PHOTO_NO}"><span id="3">${p.PHOTO_TITLE}</span></a>
		</div>
		</div>
		</c:forEach>
	</div>
	<div class="pageNum">		
		<c:if test="${start>1}">
			<a href="myAlbum.do?page=1" class="a page">처음</a>
			<a class="a page" href="myAlbum.do?page=${page-1}">이전</a>
		</c:if>
		

		<c:forEach begin="${start}" end="${end<last? end : last}" var="i">
			<c:choose>
				<c:when test="${i==current}">
					<b class="a page">${i}</b>
				</c:when>
				<c:otherwise>
					<a href="myAlbum.do?page=${i}">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		<c:if test="${end<last}">
		    <a class="a page" href="myAlbum.do?page=${end+1}">다음</a>
			<a class="a page" href="myAlbum.do?page=${last}">마지막</a>
		</c:if>
	</div>
	
	
</div>
</div>
</div> <!-- 사진영역 끝 -->
</div><!-- 컨테이너 끝 -->
</body>
</html>
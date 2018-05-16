<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
<script src='http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js'></script>
<script src="http://code.jquery.com/jquery-2.2.4.js"
	integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
	crossorigin="anonymous"></script>
<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
<script src="${pageContext.request.contextPath}/PlugIn/jquery.timeago.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/PlugIn/jquery.timeago.ko.js" type="text/javascript"></script> 
<script src="PlugIn/jquery.timeago.js" type="text/javascript"></script>
<script src="PlugIn/jquery.timeago.ko.js" type="text/javascript"></script> 
<link rel="stylesheet" href="css/Album.css">


<style type="text/css">
@font-face {
	font-family: 'LotteMartDream';
	font-style: normal;
	font-weight: 700;
	src:
		url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamMedium.woff2')
		format('woff2'),
		url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamMedium.woff')
		format('woff');
}

* { 
	font-family: 'LotteMartDream';
}

body {
	margin: 0;
	padding: 0;
}

.accBtns{
	display: inline-block;
}


	

</style>

<script>

	function checkWriter(id){
		var s_id = '${p.m_ID}';
			if(id==s_id){
			
		}
	}
	
	function checkFL(){
		var pNo = '${p.PHOTO_NO}';
		var first = '${fl.FNO}';
		var last = '${fl.LNO}';
		
		if(pNo == first){
			$('#goPrev').attr('disabled',true).css(
				{'background':'#919198',
				 'cursor' : 'cursr',
				 'color' : '#6e6e6e'
				});
		}
		
		if(pNo == last){
			$('#goNextView').attr('disabled',true).css(
					{'background':'#424242',
					 'cursor' : 'cursr',
					 'color' : '#6e6e6e'
			});
		}
	}
	
	function init(){
	
		 $(".tg").each(function(id){
	    	   var timeago_t = jQuery.timeago( $(this).data("date"));
	           $(this).text(timeago_t);
      });
		 
		 $('.id').each(function(){
			 var id= "<%= (String)session.getAttribute("id")%>";

			   var addParentId='#btn'+$(this).attr('id');
			   console.log(addParentId)
	           var w_id = $(this).data("id");
	           console.log('id는 :  ' +id);
	           console.log('w_id는 :  ' +w_id);
	           if(id!=w_id){
	        	   console.log(id==w_id);
	        	   $(addParentId).css('display','none');
	        	   }else{ 
	        	$(addParentId).css('display','inline-block');
	           }
		 });
		 
	}
	
	


	$(document).ready(function(){
		var likeFlag=0;
		
		var id= "<%= (String)session.getAttribute("id")%>";
		
		checkWriter(id); //작석자 본인 확인
		checkFL(); //처음 게시물이냐 마지막 게시물이냐 판별해서 버튼 클릭 막음
		init();
		
		$('#goPhtMain').hover(function(){
			$(this).attr('cursor','pointer').attr('opicity',0.5);
		});
		
		$('#goPhtMain').click(function(){
			window.location.href="myAlbum.do?"+id;
		});
		
		$('#goPrev').click(function(){
			var prePage = Number('${p.PHOTO_NO}')+1;
			window.location.href="inDetail.do?photo_no="+prePage;
		});
		
		$('#goNextView').click(function(){
			var nextPage = Number('${p.PHOTO_NO}')-1;
			window.location.href="inDetail.do?photo_no="+nextPage
		});
		
		$('#logo').hover(function(){
			$(this).css('top',+2);},
			function(){
				$(this).css('top',-2);
		});
		
		$('#likeThis').click(function(){
			if(likeFlag==0){
				$(this).attr('src',"image/like2.png");
				//여기에서 컨트롤러에서 넘어온 좋아요수가 3개 이상이냐 체크해서 이름으로 텍스트 쓸지 갯수로 보여줄지 결정.
				$('#likeCnt').text(id+'님');
				likeFlag=1;
			}else{
				$(this).attr('src',"image/like.png");
				likeFlag=0;
			}
			
		});
	 	
		$('#clickMe').hover(function(){
			$(this).text('Click Me!!');
		});
		$('#clickMe').mouseleave(function(){
			$(this).text('댓글 보기 (${commentTotalCnt}개)');
		});
		
		
		$('#writeComt').on('click',function(){
			
			var COMMT_CONTENT =$('input[name="COMMT_CONTENT"]').val();
			var PHOTO_NO = ${p.PHOTO_NO};
			var COMMT_PARENT =$('input[name="COMMT_PARENT"]').val(); 
		
			$.ajax({
				url:'commt_write.do',
				data:{
					COMMT_CONTENT,id,PHOTO_NO,COMMT_PARENT},
				type:'POST',
				cache:false,
				dataType:'text',
				contentType: "application/x-www-form-urlencoded; charset=UTF-8",
				success:function(data){
					var result = JSON.parse(data);
					
					$('#pv_cmt_view').prepend(
									
									'<ul><li><div class="addParent">'+ '<img src='+'"profileDownload.do?M_ID='+result.id+'">'+
									'<span>'+result.id+'</span>'+'<span>'+result.content+'</span>'+
									'<span class="tg" data-date="'+result.date+'"></span>'+
									'<button id="update_commt">수정</button>'+
									'<button id="delete_commt">삭제</button></div></li></ul>'
							);
					
					init();
					$('#inputCommt').val('');
							
						
					
					
// 							if(result.parent!=null){
// 								$('#pv_cmt_view').appendTo(
// 								'<span id="relpyMark"> └ </span>'+
// 								'<span id="replyMarkParent">'+ result.parent +'</span>'
// 								);
// 							}
							
// 							$('#pv_cmt_view').appendTo(
							
// 							);		
					
					
				
					
// 					if(result.id!=id){
// 						$('#update_commt').hide();
// 						$('#delete_commt').hide();
// 						$('#date').append('')
// 					}
				
				},
				error: function(request,status,error){
        			alert("code:"+request.status+"error:"+error);
				}
				
			});
			
		});
				
				init()
		      
		
	});
</script>
</head>
<body>
<div class="pv_container">
		<div class="pv_header">
			<div id="btnBx1">
				<button id="goPrev">이전 사진</button>
			</div>
			
			<div id="logoBx">
				<img src="image/logo2.jpg" id="logo">
			</div>
			
			<div id="btnBx3">
				<img id="goPhtMain" src="image/gallery.png">
			</div>
			
			<div id="btnBx2">
				<button id="goNextView">다음 사진</button>
			</div>
			
			
		</div>

		<div class="pv_body">
			
				<div class="content_head">
					<div id="pht_title_deco">
					<div id="pht_title">
					<h2>${p.PHOTO_TITLE}</h2>
					</div>
					</div>
					<div id="pht_no">
					<span>No :  </span><span>${p.PHOTO_NO}</span>
					</div>
				</div>
				
				<div class="content_img">
					<img src="photodownload.do?PHOTO_NO=${p.PHOTO_NO}">
				</div>
				<div class="content_pre">
					<div class="content_pre_inner"></div>
				</div>

			<div id="content_id_wrap">
				<div id="content_id">
					<span id="p.m_ID">${p.m_ID}</span> <img src="image/like.png"
						id="likeThis"> <span id="likeCnt"></span>
					<!-- 좋아요 눌렀을 때 부터 3개까지는 누른사람 표시 그 이후부터는 개수표시 -->
 					<button id="goUpdate" class="goUpdate">수정</button>
    

					<c:choose>
						<c:when test="${empty p.PHOTO_UPDATE_DATE}">
							<p><fmt:formatDate value="${p.PHOTO_CREATE_DATE}" pattern="yyyy년 MM월 dd일" /></p>
						</c:when>
						<c:otherwise>
							<p><fmt:formatDate value="${p.PHOTO_UPDATE_DATE}" pattern="yyyy년 MM월 dd일" /></p>
						</c:otherwise>
					</c:choose>
					<div class="content_text">${p.PHOTO_CONTENT}
						<div id="content_text_inner">내용입니다.</div>
					</div>
				</div>
			</div>
			<!-- 도저히 이해를 할 수 없는 부분 대문자와 소문자의 차이는 뭐고 왜 얘만 이럴까 -->
			
			<div id="openComt">
				<button id="clickMe">댓글보기 (${commentTotalCnt}개)</button>
			</div>
		</div>
		
		

		<div class="pv_comment_wrap">
			<div class="pv_comment">
			<div id="pv_cmt_view">
			<ul>
			<c:forEach items="${CommentList}" var="i">
			
				<li><div class="addParent">
				<c:choose>
						<c:when test="${0 ne i.COMMT_PARENT}">
							<span id="relpyMark"> └ </span>
							<span id="replyMarkParent">${i.PARENT_ID}</span>
						</c:when>
					</c:choose>
				<img src="profileDownload.do?M_ID=${i.m_ID}"><span class="id" data-id="${i.m_ID}" id="${i.COMMT_NO}">${i.m_ID}</span>
					<span>${i.COMMT_CONTENT}</span>
					<c:choose>
						<c:when test="${empty i.PHT_COMMT_UPDATE_DATE}">
<%-- 							<input type="hidden" value="${i.PHT_COMMT_CREATE_DATE}" name="date"> --%>
								<span class="tg" data-date="${i.PHT_COMMT_CREATE_DATE}"></span>
						</c:when>
						<c:otherwise>
							<input type="hidden" value="${i.PHT_COMMT_UPDATE_DATE}" name="date">
						</c:otherwise>
					</c:choose>
					<span id="tg"></span>
						<div class="accBtns" id="btn${i.COMMT_NO}">
							<input type="button" name="update_commt" value="수정">
							<input type="button" name="delete_commt" value="삭제">
						</div>
					</div></li>
				
			</c:forEach>
			</ul>
			</div>
			
			
			<div class="pv_cmt_write">
				<img src="profileDownload.do?M_ID=${id}"> <span>${id}</span>
				<input type="text" name="COMMT_CONTENT" id="inputCommt"></input>
				<input type="hidden" value=0 name="COMMT_PARENT">
				<input type="hidden" value="${p.PHOTO_NO}" name="PHOTO_NO">
				<button id="writeComt">등록</button>
			</div>
			</div>
			</div>
		
			
			</div>
		

</body>
</html>
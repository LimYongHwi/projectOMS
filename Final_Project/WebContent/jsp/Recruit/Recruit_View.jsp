<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-2.2.4.js"
	integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	readlist(1);
	minecheck();
	readReply(1);
});





function minecheck(){
	var sessionId = "<%=(String) session.getAttribute("id")%>";
	var writer =$("#writer").text();
	if(sessionId==writer){
		$(".mine").css({"visibility":"visible","display":"block"});
	}else{
		$(".mine").css({"visibility":"hidden","display":"none"});
	}
}

function dorefrence(id,REC_APPLY_NO,page){
	var rec_no = $('#rec_no').val();
	$.ajax({
		type:'get',
		url:'doRefrence.do',
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		dataType:'text',
		data:page="REC_APPLY_NO="+REC_APPLY_NO+"&REC_NO="+rec_no+"&M_ID="+id+"&page="+page,
		success:function(data){
			var datas= JSON.parse(data);
			readlist(datas.page[0]);
		}
	
	
});
}


function readlist(page){
	var rec_no = $('#rec_no').val();

	$.ajax({
		type:'get',
		url:'getRefrenceList.do',
		dataType:'text',
		data:page="page="+page+"&REC_NO="+rec_no,
		
		success:function(data){
			var datas= JSON.parse(data);
			var result = datas.result[0];
			var refrenceList=datas.result[0]["RefrenceList"];
			
		   	$("#list").empty();
		   	$("#pages").empty();
		   	
			if(refrenceList.length== 0){
	       		$("#list").append("<td colspan=4 style='padding:30px;'>데이터가 없습니다.</td>");
			}else{ 
				$("#list").append("<tr><th>번호</th><th>이름</th><th>확정여부</th></tr>");
				
	          for(var i =0; i<refrenceList.length; i++){
	        		  msg='확정취소';
	        	  	  confirm="대기중";
	        	  if(refrenceList[i].REC_APPLY_CONFIRM=='Y'){
	        	  var msg='확정';
	        	  var confirm="확정";
	        	  }
	        	  $("#list").append("<tr>"
	        			  +"<td>"+refrenceList[i].RN+"</td>"
	        			  +"<td>"+refrenceList[i].M_ID+"</td>"
	        			  +"<td>"+confirm+"</td>"
	        			  +"<td><button class='mine' onclick=\"dorefrence('"+refrenceList[i].M_ID+"',"+refrenceList[i].REC_APPLY_NO+","+result.page+")\">"+msg+"</button>"+"</td>"
	        			  +"</tr>");       	  
	          }
	        $('#page').val(result.page);
	          	var begin=result.START;
	          	var current= result.current;
				if(result.END<result.END)
					var end=result.END;
				else
					var end=result.LAST;
				var str='';
				for(var i=begin;i<=end;i++){
					if(i==current){
						str=">"+i;
					}else
						str="  onclick='readlist("+i+")'>"+i;
					$('#pages').append("<td"+str+"</td>");
				}
				
	          
	      };
				minecheck();
		}
		
	});
}

function readReply(page){
	var rec_no = $('#rec_no').val();
	console.log(rec_no);
	$.ajax({
		type:'get',
		url:'getREC_REP.do',
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		dataType:'text',
		data:'REC_NO='+rec_no+'&page='+page,
		success:function(data){
			var datas = JSON.parse(data).result[0];
			var replyList=datas.replyList;
			console.log(JSON.parse(data));
			console.log(datas);
			console.log(replyList);
			
			$('#reply').empty();
			$('#replyPage').empty();
			$("#reply").append('<tr>'+
					'<th width="50">댓글 번호</th>'+
					'<th width="200">내용</th>'+
					'<th width="50">닉네임</th>'+
					'<th width="50">작성일</th>'+
					'<th width="50">댓글달기</th>'+
					'<th width="50">수정</th>'+
					'<th width="50">삭제</th>'+
					'</tr>');
			$('#reply').append('<tr>'+
					'<td colspan="7" width="1400" bgcolor="brown"></td></tr>');
			
			if(replyList.length==0){
				
				$('#reply').append(
						'<tr></tr>'+
						'<tr><td colspan="7">댓글이 없어요 ! 한마디 남겨주세요!</td></tr>'+
						'<tr></tr>'+
				'<tr><td></td><td colspan="4" align="center"><textarea id="comcontent" style="resize:none; width:100%;" placeholder="욕설이나 심한 험담은 제제가 될 수 있습니다. "></textarea> </td>'+
				'<td align="center"><input type="button" value="등록" onclick="writeReply(0,'+datas.current+')"></td></tr>');

			}else{
				for(var i=0 ; i<replyList.length;i++){
					var msg="";
										if(replyList[i].PARENT_REC_REPLY_NO!=0){
												for(var j=1; j<replyList[i].LEVEL; j++){												
												msg+="　";
												}
												 msg+='└>';
											}
					var date= new Date(replyList[i].RECRUIT_REPLY_CREATE_DATE);
					var time=(date.getMonth()+1)+"."+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
					
					$('#reply').append('<tr id='+replyList[i].RECRUIT_REPLY_NO+' align="center">'+
											'<td>'+replyList[i].RN+'</td>'+
											'<td align="left">'+msg+replyList[i].RECRUIT_REPLY_CONTENT+'</td>'+
											'<td>'+replyList[i].M_ID+'</td>'+
											'<td>'+time+'</td>'+
											'<td><input type="button" value="댓글달기" onclick="textareaView(\'#rep_write'+replyList[i].RECRUIT_REPLY_NO+'\')"></td>'+
											'<td><input type="button" value="댓글수정" onclick="textareaView(\'#rep_update'+replyList[i].RECRUIT_REPLY_NO+'\')"</td>'+
											'<td><input type="button" value="댓글삭제" onclick="levelChkComm('+replyList[i].RECRUIT_REPLY_NO+','+datas.current+')"</td>'+									
											'<tr id="rep_write'+replyList[i].RECRUIT_REPLY_NO+'" class="showinput">'+
													'<td colspan="4" align="center">'+
													'<textarea id="comcontent'+replyList[i].RECRUIT_REPLY_NO+'" style="resize:none; width:100%;" placeholder="이 글에 답변을 해보세요"></textarea></td>'+
													'<td align="center">'+
													'<input type="button" value="등록" onclick="writeReply('+replyList[i].RECRUIT_REPLY_NO+','+datas.current+')">'+
													'</td></tr>'+                
											'</tr>');
					//커맨트 업데이트 추가
					$('#reply').append('<tr id="rep_update'+replyList[i].RECRUIT_REPLY_NO+'" class="showinput">'+
											'<td colspan="4" align="center">'+
											'<textarea id="commentupdate'+replyList[i].RECRUIT_REPLY_NO+'" style="resize:none; width:100%;" placeholder="기존내용 : '+replyList[i].RECRUIT_REPLY_CONTENT+'"></textarea></td>'+
											'<td align="center">'+
											'<input type="button" value="수정등록" onclick="updateComm('+replyList[i].RECRUIT_REPLY_NO+','+datas.current+')">'+
											'</td></tr>');
				}
				//댓글 인풋 가리기
				$(".showinput").css("display","none");
				//댓글 수정 가리기
			var Last = datas.END;
			if(Last>datas.LAST){
				Last=datas.LAST;
			}
			var tags='<tr>'; 
			for(var i=datas.START;i<=Last;i++){
				if(i!=datas.current)
				tags+='<td onclick="readReply('+i+')">'+i+'</td>';
				else{
					tags+='<td>'+i+'</td>';
				}
			}
			tags+='</tr>';
				$('#replyPage').append(tags);
				$('#reply').append('<tr>'+
						'<td></td><td colspan="4" align="center">'+
						'<textarea id="comcontent" style="resize:none; width:100%;" placeholder="욕설이나 심한 험담은 제제가 될 수 있습니다."></textarea></td>'+
						'<td align="center">'+
						'<input type="button" value="등록" onclick="writeReply(0,'+datas.current+')">'+
						'</td></tr>');
			}
		}
	})
	}
	
	
	

function textareaView(id){
	var obj = $(id);
	$(".showinput").css("display","none");
	if($(id).css("display")=="none"){
		$(id).css("display","table-row");
	}else{
		$(id).css("display","none");
	}
}

function writeReply(PARENT,com_page){
	var rec_no=$('#rec_no').val();
	var content=null;
	content=$('#comcontent').val();
// 	content값이 비어있다면(댓글의 내용이 없다면) return false 로직을 세워라
	if(PARENT!=0){//가지댓글 쓸때
		content=$('#comcontent'+PARENT).val();
	}else{//루트댓글 쓸때
		content=$('#comcontent').val();
	}
	if(content==null||content=="undefined"||content==""){
		alert('내용을 입력하세요');
	}else{
		$.ajax({
			type:'get',
			url:'writeREC_REP.do',
			contentType:"application/x-www-form-urlencoded; charset=UTF-8",
			dataType:'text',
			data:'REC_NO='+rec_no+'&PARENT_REC_REPLY_NO='+PARENT+'&RECRUIT_REPLY_CONTENT='+content,
			success:function(data){
				if(data==1){
			readReply(com_page);
				}else{
					("로그인을 하셔야 글을 작성할 수 있습니다.");
				}
			}
		})
	}	
}

function updateComm(comment_num,com_page){
	var comm_update=null;
	comm_update=$('#commentupdate'+comment_num).val();
	if(comm_update==null){
		alert("수정할 내용을 작성해주세요");
		return false;
	}else {
		$.ajax({
			type:'get',
			url:'updateREC_REP.do',
			contentType:"application/x-www-form-urlencoded; charset=UTF-8",
			dataType:'text',
			data:'RECRUIT_REPLY_NO='+comment_num+'&RECRUIT_REPLY_CONTENT='+comm_update,
			success:function(data){
				if(data==1){
			$('#commentupdate'+comment_num).val(null);
			readReply(com_page);
				}else{
					alert('본인이 작성한 글만 수정가능 합니다.')
				}
			}
		})
	}
	}

function deleteComm(comment_num,com_page){
		$.ajax({
			type:'post',
			url:'deleteREC_REP.do',
			contentType:"application/x-www-form-urlencoded; charset=UTF-8",
			dataType:'text',
			data:'RECRUIT_REPLY_NO='+comment_num,
			success:function(data){
				if(data==1){
					readReply(com_page);
						}else{
							alert('본인이 작성한 글만 삭제할 수 있습니다.')
					}
			
			}
		})
	}
	
//대댓글 여부 체크
function levelChkComm(comment_num,com_page){
	var boardnum=$('#boardnum').val();
		$.ajax({
			type:'post',
			url:'levelChkComm.do',
			contentType:"application/x-www-form-urlencoded; charset=UTF-8",
			dataType:'text',
			data:'RECRUIT_REPLY_NO='+comment_num,
			success:function(data){
						if(data==1){
							deleteComm(comment_num,com_page);
						}else{
							alert("해당 글에 댓글이 달려있어서 삭제할 수 없습니다.");
							return false;
						}
					}

		})
	}


</script>
<link rel="stylesheet" href="jsp/Recruit/css/view.css">
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../Header_tab1.jsp"></jsp:include>
	<%
		boolean mine = (boolean) request.getAttribute("ismine");
	%>
	<div class="body">
		<jsp:include page="../sidevar_1.jsp" />
		<div class="section">

			<p id="title">모집합니다</p>
			<p id="title_sub">모집하는 여행에 동참해보세요!</p>
			<hr>
			<input type="text" style="display: none;" value="${page}" id="page"
				readonly="readonly"> <input type="text"
				style="display: none;" value="${rec.REC_NO}" id="rec_no">
			<dl>
				<dt>제목</dt>
				<dd>${rec.REC_TITLE}</dd>
				<dt>작성날짜</dt>
				<dd>
					<fmt:formatDate value="${rec.REC_CREATE_DATE}" pattern="yyyy-MM-dd" />
				</dd>
				<dt>작성자</dt>
				<dd id="writer">${rec.m_ID}</dd>
				<dt>인원수</dt>
				<dd>${rec.REC_MEMBER_COUNT}</dd>
				<dt>조회수</dt>
				<dd>${rec.REC_VIEWS}</dd>
				<dt>원하는 성별</dt>
				<dd>${rec.REC_GENDER}</dd>
				<dt>파일다운로드</dt>
				<dd>
					<c:choose>
						<c:when test="${rec.REC_FILE!=null}">
							<a href="recruitdownload.do?num=${rec.REC_NO}">
								${rec.REC_FILE} </a>
						</c:when>
						<c:otherwise>
파일없음
</c:otherwise>
					</c:choose>
				</dd>
				<dt>내용</dt>
				<dd>
					<img alt="이미지없음" src="recruitdownload.do?num=${rec.REC_NO}">${rec.REC_CONTENT}</dd>
				<dt>신청자 목록</dt>
				<dd>
					<table>
						<tr id="list">
						</tr>
						<td colspan="4">

							<table style="margin: 0 auto">
								<tr id="pages"></tr>
							</table>

						</td>
					</table>
				</dd>
			</dl>
			<div id="replydiv">
				<table id="reply"></table>
				<table id="replyPage" style="margin: 0 auto;"></table>
			</div>

			<input type="button" class="button" value="뒤로가기"
				onclick="javascript:history.back()" style="margin-left: 50px">
			<%
				if (mine) {
			%>
			<span id="list1"></span>
			<%
				} else {
			%>
			<span id="list1"></span> <input type="button" value="신청하기"
				onclick="location.href='recruit_refrence.do?REC_NO=${rec.REC_NO}'">
			<%
				}
			%>
			<%
				if (mine) {
			%>
			<input type="button" value="수정"
				onclick="location.href='recruit_updateForm.do?num=${rec.REC_NO}'">
			<input type="button" value="삭제"
				onclick="location.href='recruit_delete.do?REC_NO=${rec.REC_NO}'">
			<%
				}
			%>
			<input type="button" value="전체목록"
				onclick="location.href='recruit_main.do'">
		</div>
	</div>
</body>
</html>
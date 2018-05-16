<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
  src="http://code.jquery.com/jquery-2.2.4.js"
  integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
  crossorigin="anonymous"></script>
  <link href='http://fonts.googleapis.com/css?family=Noto+Sans' rel='stylesheet' type='text/css'>
  <script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
   <script>
    $(document).ready(function(){
    	getBestReview();
      $('.eventSlider').bxSlider(
    		  {
    		  auto: true,
    		  pager: true,
    		  slideWidth : 300,
      		  adaptiveHeight:true,
      		  autoHover:true
    		  });
      $('.reviewSlider').bxSlider(
    		  {
    		  auto: true,
    		  pager: true,
      		  adaptiveHeight:true,
      		  slideWidth : 200,
      		  autoHover:true
    		  });
      $('.infoSlider').bxSlider(
    		  {
    		  auto: true,
    		  pager: true,
      		  adaptiveHeight:true,
      		  autoHover:true
    		  });
      $(function (){
          $(".tab_content").hide();
          $(".tab_content:first").show();

          $("ul.tabs li").click(function () {
              $("ul.tabs li").removeClass("active").css("color", "#333");
              //$(this).addClass("active").css({"color": "darkred","font-weight": "bolder"});
              $(this).addClass("active").css("color", "darkred");
              $(".tab_content").hide()
              var activeTab = $(this).attr("rel");
              $("#" + activeTab).fadeIn()
          });
      });
      
     
    });
   function getBestReview(){
	   $.ajax({
			type:'get',
			url:'getBestReview.do',
			dataType:'text',			 
			success:function(data){
				var datas= JSON.parse(data);
				var review = datas.result[0].bestReview;
				var prereview = datas.result[0].PreBestReview;
				console.log("prereview"+prereview);
				var rev_no=review.REV_NO;
			
				
				$('.bestreview').attr('onclick',"location.href='review_view.do?num="+rev_no+"'");
				$('.bestreviewimg').attr('src','reviewdownload.do?REV_NO='+rev_no);
				$('#BRV_CREATER').text('by '+review.m_ID);
				$('#BRV_TITLE').text(review.REV_TITLE);
				var plus= '...';
				if(review.REV_CONTENT.length<20)
					plus='';
				$('#BRV_CONTENT').text(review.REV_CONTENT.substring(0,20)+plus);
				if(prereview!=null){
				var prereviewNo = prereview.REV_NO;
				$('.prebestreview').attr('onclick',"location.href='review_view.do?num="+prereviewNo+"\'");
				$('.prebestreviewimg').attr('src','reviewdownload.do?REV_NO='+prereviewNo);
				$('#PREBRV_CREATER').text('by '+prereview.m_ID);
				$('#PREBRV_TITLE').text(prereview.REV_TITLE);
				var plus= '...';
				if(prereview.REV_CONTENT.length<20)
					plus='';
				$('#PREBRV_CONTENT').text(prereview.REV_CONTENT.substring(0,20)+plus);
				}
			}
		});
	   
	   
	  
   }   
   
   
  </script>
<link rel="stylesheet" href="css/Main.css">
</head>

<jsp:include page="Header.jsp"></jsp:include>
<body>
<div class="body">
<div class="saction1">
<div class="bestreview">
<img src="image/bestreview.jpg" width="300px" height="250px" class="bestreviewimg">
<p id="BRV_CREATER">...<br>
이번달의 베스트 리뷰</p>
<p id="BRV_TITLE"></p>
<p id="BRV_CONTENT">
리뷰를 찾을 수 없어요 ㅠㅠ
</p>
</div>
<div class="eventSlider">
<c:if test="${event.eventList==null}">
<div><img src="" alt="현재진행중인 이벤트가 없습니다." id="eventSlide_1"></div>
</c:if>
<c:forEach items="${event.eventList}" var='e'>
<div onclick="location.href='event_view.do?EVT_NO=${e.EVT_NO}'"><img src="eventdownload.do?num=${e.EVT_NO}" id="eventSlide_${e.RN}"></div>
</c:forEach>
</div>
<div class="prebestreview">
<img src="image/bestreview.jpg" width="300px" height="250px" class="prebestreviewimg">
<p  id="PREBRV_CREATER">...<br>
저번달의 베스트 </p>
<p id="PREBRV_TITLE"></p>
<p id="PREBRV_CONTENT">
리뷰는 없네요 ㅠㅠ
</p>
</div>
</div>


<div class="saction2">
<div id="container">
    <ul class="tabs">
        <li class="active" rel="tab1">공지사항</li>
        <li rel="tab2">모집게시판</li>
        <li rel="tab3">계획게시판</li>
    </ul>
    <div class="tab_container">
        <div id="tab1" class="tab_content">
        		<ul>
           		<c:forEach begin="0" end="4" items="${notice}" var="n">
                <li>
                <a href="notice_view.do?NOTICE_NO=${n.NOTICE_NO}">
                <span>${n.NOTICE_TITLE}</span>
                <span id="date"><fmt:formatDate value="${n.NOTICE_CREATE_DATE}" pattern="yyyy-MM-dd"/></span>
                </a>
                </li>
                </c:forEach>
                </ul>
        </div>
        <!-- #tab1 -->
        <div id="tab2" class="tab_content">
              <ul>
			<c:forEach begin="0" end="4" items="${recruit.Recruit}" var="r">
                <li>
                <a href="recruit_view.do?num=${r.REC_NO}">
                <span>${r.REC_TITLE}</span>
                <span id="date"><fmt:formatDate value="${r.REC_CREATE_DATE}" pattern="yyyy-MM-dd"/></span>
                </a>
                </li>
                </c:forEach>
            </ul>
         </div>
        <!-- #tab2 -->
        <div id="tab3" class="tab_content">
                   <ul>
                <c:forEach begin="0" end="4" items="${plan.plan}" var="p">
                <li>
                <a href="plan_view.do?num=${p.PLAN_NO}">
                <span>${p.PLAN_TITLE}</span>
                <span id="date"><fmt:formatDate value="${p.PLAN_CREATE_DATE}" pattern="yyyy-MM-dd"/></span>
                </a>
                </li>
                </c:forEach>
            </ul>
           </div>
        <!-- #tab3 -->
    </div>
    <!-- .tab_container -->
</div>
<!-- #container -->

<div class="reviewSlider">
<div><img src="image/event1.jpg" id="reviewSlide_1"></div>
<div><img src="image/event2.jpg" id="reviewSlide_2"></div>
<div><img src="image/event3.jpg" id="reviewSlide_3"></div>
<div><img src="image/event4.jpg" id="reviewSlide_4"></div>
<div><img src="image/event5.jpg" id="reviewSlide_5"></div>
</div>
</div>


<div class="saction3">
<div class="infoSlider">
<div><img src="image/info_1.jpg" id="infoSlide_1"></div>
<div><img src="image/info_1.jpg" id="infoSlide_2"></div>
<div><img src="image/info_1.jpg" id="infoSlide_3"></div>
<div><img src="image/info_1.jpg" id="infoSlide_4"></div>
</div>
</div>
</div>



</body>
</html>
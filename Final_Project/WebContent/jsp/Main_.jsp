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
  <link href='http://fonts.googleapis.com/css?family=Noto+Sans' rel='stylesheet' type='text/css'>
  <link href='css/Main.css' rel='stylesheet' type='text/css'>
  <script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
   <script>
    $(document).ready(function(){
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
    
   
  </script>
</head>

<jsp:include page="Header.jsp"></jsp:include>
<body>
<div class="body">
<div class="saction1">
<div class="bestreview">
<img src="image/bestreview.jpg" width="300px" height="250px">
<p>by작성자<br>
환상적인 이탈리아 여행이였어요!</p>
<p>
9박 10일간의 유럽여행,,, 이탈리아는 정말 정렬적....
</p>
</div>
<div class="eventSlider">
<div><img src="css/image/event1.jpg" id="slide_1"></div>
<div><img src="css/image/event2.jpg" id="slide_2"></div>
<div><img src="css/image/event3.jpg" id="slide_3"></div>
<div><img src="css/image/event4.jpg" id="slide_4"></div>
<div><img src="css/image/event5.jpg" id="slide_5"></div>
</div>

<div class="bestreview1">
<img src="css/image/bestreview.jpg" width="300px" height="250px">
<p>by작성자<br>
환상적인 이탈리아 여행이였어요!</p>
<p>
9박 10일간의 유럽여행,,, 이탈리아는 정말 정렬적....
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
                <li><a href="#"><span>오마이소울메이트 고객님들께 말씀전해드립니다.</span><span id="date">2018-02-21</span></a>
                </li>
                <li><a href="#"><span>오마이소울메이트 고객님들께 말씀전해드립니다.</span><span id="date">2018-02-21</span></a>
                </li>
                <li><a href="#"><span>오마이소울메이트 고객님들께 말씀전해드립니다.</span><span id="date">2018-02-21</span></a>
                </li>
                <li><a href="#"><span>오마이소울메이트 고객님들께 말씀전해드립니다.</span><span id="date">2018-02-21</span></a>
                </li>
                <li><a href="#"><span>오마이소울메이트 고객님들께 말씀전해드립니다.</span><span id="date">2018-02-21</span></a>
                </li>
            </ul>
        </div>
        <!-- #tab1 -->
        <div id="tab2" class="tab_content">
                  <ul>
                <li><a href="#"><span>오마이소울메이트 고객님들께 말씀전해드립니다.</span><span id="date">2018-02-21</span></a>
                </li>
                <li><a href="#"><span>오마이소울메이트 고객님들께 말씀전해드립니다.</span><span id="date">2018-02-21</span></a>
                </li>
                <li><a href="#"><span>오마이소울메이트 고객님들께 말씀전해드립니다.</span><span id="date">2018-02-21</span></a>
                </li>
                <li><a href="#"><span>오마이소울메이트 고객님들께 말씀전해드립니다.</span><span id="date">2018-02-21</span></a>
                </li>
                <li><a href="#"><span>오마이소울메이트 고객님들께 말씀전해드립니다.</span><span id="date">2018-02-21</span></a>
                </li>
            </ul>
         </div>
        <!-- #tab2 -->
        <div id="tab3" class="tab_content">
                   <ul>
                <li><a href="#"><span>오마이소울메이트 고객님들께 말씀전해드립니다.</span><span id="date">2018-02-21</span></a>
                </li>
                <li><a href="#"><span>오마이소울메이트 고객님들께 말씀전해드립니다.</span><span id="date">2018-02-21</span></a>
                </li>
                <li><a href="#"><span>오마이소울메이트 고객님들께 말씀전해드립니다.</span><span id="date">2018-02-21</span></a>
                </li>
                <li><a href="#"><span>오마이소울메이트 고객님들께 말씀전해드립니다.</span><span id="date">2018-02-21</span></a>
                </li>
                <li><a href="#"><span>오마이소울메이트 고객님들께 말씀전해드립니다.</span><span id="date">2018-02-21</span></a>
                </li>
            </ul>
           </div>
        <!-- #tab3 -->
    </div>
    <!-- .tab_container -->
</div>
<!-- #container -->

<div class="reviewSlider">
<div><img src="css/image/event1.jpg" id="reviewSlide_1"></div>
<div><img src="css/image/event2.jpg" id="reviewSlide_2"></div>
<div><img src="css/image/event3.jpg" id="reviewSlide_3"></div>
<div><img src="css/image/event4.jpg" id="reviewSlide_4"></div>
<div><img src="css/image/event5.jpg" id="reviewSlide_5"></div>
</div>
</div>


<div class="saction3">
<div class="infoSlider">
<div><img src="css/image/info_1.jpg" id="infoSlide_1"></div>
<div><img src="css/image/info_1.jpg" id="infoSlide_2"></div>
<div><img src="css/image/info_1.jpg" id="infoSlide_3"></div>
<div><img src="css/image/info_1.jpg" id="infoSlide_4"></div>
</div>
</div>
</div>



</body>
</html>
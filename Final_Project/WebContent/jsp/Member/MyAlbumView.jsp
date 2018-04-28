<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="smoothgallery/smoothgallery.css">
	<script type="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
<script src='http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js'></script>
		<script
		  src="http://code.jquery.com/jquery-2.2.4.js"
		  integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
		  crossorigin="anonymous"></script>
		  <script type='text/javascript' src="smoothgallery/smoothgallery.min.js"></script>
		  <script type="text/javascript" src="smoothgallery/jquery-ui.js"></script>
<script type="text/javascript">
$(document).ready( function() {
    // use default options
    $(document).smoothGallery({
        animSpeed:300, 
        delaySpeed:50,
        visibleRows: 2,
        animEasing: 'easeOutQuart'
    });
});
</script>


<link rel="stylesheet" href="css/sibal.css">
<style type="text/css">
.photo_section {
    float: left;
    width: 80%;
    height: 100%;
    background-color: #fcfbf5;
    margin: 0;
    padding-top: 10%;
}
#contentSection {
	width:84%;
	height:100%;
	margin:0;
	padding:0;
	float:left;
	padding-top:10%;
}

#MyContainer{
	position:absolute;
	width: 100%;
	height:800px;
}


</style>
</head>
<body>
<div id="Container">
<div class="a">
<div class="prof_section">
<div id="album_title"><h2>Photo Album</h2></div>
<div class="img_section">
<div class="al_pr_img"></div></div>

<div class="info_section">
<h3>yeoneebee</h3>
<h3>Bronze member</h3>
<div id="ment">
<p>Jobs fill your pocket,</p>
<p>adventure fill your soul.</p>
</div>
</div>

</div>
<div class="photo_section">
<div class="sg" style="width:800px;margin:50px auto; display:block; height:300px; padding:10px; ">
  <div class="sg-item"><img src="sample.jpg"> <br>
    PHOTO TITLE </div>
  <div class="sg-item"> <a href="sample.jpg"><img src="smoothgallery/images/2_thumb.jpg"></a> <br>
    PHOTO TITLE </div>
  <div class="sg-item"> <a href="sample.jpg"><img src="smoothgallery/images/3_thumb.jpg"></a> <br>
    PHOTO TITLE </div>
  <div class="sg-item"> <a href="smoothgallery/images/4.jpg"><img src="smoothgallery/images/4_thumb.jpg"></a> <br>
    PHOTO TITLE </div>
  <div class="sg-item"> <a href="smoothgallery/images/5.jpg" title="Another Caption"><img src="smoothgallery/images/5_thumb.jpg"></a> <br>
    PHOTO TITLE </div>
  <div class="sg-item"> <a href="smoothgallery/images/6.jpg"><img src="smoothgallery/images/6_thumb.jpg"></a> <br>
    PHOTO TITLE </div>
  <div class="sg-item"> <a href="smoothgallery/images/1.jpg"><img src="smoothgallery/images/1_thumb.jpg"></a> <br>
    PHOTO TITLE </div>
  <div class="sg-item"> <a href="smoothgallery/images/2.jpg"><img src="smoothgallery/images/2_thumb.jpg"></a> <br>
    PHOTO TITLE </div>
  <div class="sg-item"> <a href="smoothgallery/images/3.jpg"><img src="smoothgallery/images/3_thumb.jpg"></a> <br>
    PHOTO TITLE </div>
  <div class="sg-item"> <a href="smoothgallery/images/4.jpg"><img src="smoothgallery/images/4_thumb.jpg"></a> <br>
    PHOTO TITLE </div>
  <div class="sg-item"> <a href="smoothgallery/images/5.jpg"><img src="smoothgallery/images/5_thumb.jpg"></a> <br>
    PHOTO TITLE </div>
  <div class="sg-item"> <a href="smoothgallery/images/6.jpg"><img src="smoothgallery/images/6_thumb.jpg"></a> <br>
    PHOTO TITLE </div>
  <div class="sg-item"> <a href="smoothgallery/images/1.jpg"><img src="smoothgallery/images/1_thumb.jpg"></a> <br>
    PHOTO TITLE </div>
  <div class="sg-item"> <a href="smoothgallery/images/2.jpg"><img src="smoothgallery/images/2_thumb.jpg"></a> <br>
    PHOTO TITLE </div>
  <div class="sg-item"> <a href="smoothgallery/images/3.jpg"><img src="smoothgallery/images/3_thumb.jpg"></a> <br>
    PHOTO TITLE </div>
  <div class="sg-item"> <a href="smoothgallery/images/4.jpg"><img src="smoothgallery/images/4_thumb.jpg"></a> <br>
    PHOTO TITLE </div>
  <div class="sg-item"> <a href="smoothgallery/images/5.jpg"><img src="smoothgallery/images/5_thumb.jpg"></a> <br>
    PHOTO TITLE </div>
  <div class="sg-item"> <a href="smoothgallery/images/6.jpg"><img src="smoothgallery/images/6_thumb.jpg"></a> <br>
    PHOTO TITLE </div>
</div>
<br>
<div class="sg-paginate"> <a href="#" class="sg-up">▲</a><a href="#" class="sg-down">▼</a> </div>
</div>
</div>
</div>
</body>
</html>
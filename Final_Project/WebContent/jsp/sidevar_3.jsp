<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<style>
.sidevar{
text-align:center;
width:20%;
margin : 0;
    background: #f1f1f1;
    height: 800px;
}
.sidevar .title_tb{
    background: #97d8ff;
    width: 100%;
    text-align: center;
    padding-top: 40px;
    height: 100px;

}
.sidevar .title_tb p{
margin:0;
padding : 0;
}
.sidevar ul{
text-align: -webkit-left;
list-style: none;
    margin: 0px 0px 0px 25px;
padding : 0;
}
.sidevar li{
margin-top : 10px;
}
.sidevar li a{
text-decoration: none;
    color: black;
}
 #selected{
 background:gray;
 }
    
</style>

<body>
<div class="sidevar">
<div class="title_tb">
<p style="font-size: 13px; color:white">OH MY SOULMATE</p>

<p class="title" style="font-size: 30px; color:white">고객센터</p>
</div>
<ul>
<li class="sub_faq"><a href="faq_main.do">FAQ</a></li>
<li class="sub_notice"><a href="notice_main.do">공지사항</a></li>
<li class="sub_review">
<a href='service_center_main.do'> 1:1 문의하기 </a>
</li>
<li class="sub_event"><a href='event_main.do'>이벤트</a></li>
</ul>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<form action="faq_write.do" method="post">
<input type="hidden" value="운영자" readonly="readonly"/>
<tr>
<td><select name="FAQ_TAB">
<option value="1">모집/계획 관련</option>
<option value="2">이벤트 관련</option>
<option value="3">회원 관련</option>
</select>
<tr>
<td>제목 : <input type="text" name="FAQ_TITLE" /></td>
</tr>
<tr>

<td>내용 : <input type="text" name="FAQ_CONTENT"></td>
</tr>
<tr>
<td><input type="submit" value="작성완료" /></td>
</tr>
</form>
</table>

</body>
</html>
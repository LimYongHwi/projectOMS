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
<form action="service_write.do" method="post" enctype="multipart/form-data">
<tr>
<td>제목 : <input type="text" name="M_SVC_TITLE" /></td>
</tr>
<tr>
<td>작성자 : <input type="text" name="M_ID" value="${M_ID }" readonly="readonly"/></td>
</tr>
<tr>
<td>내용 : <input type="text" name="M_SVC_CONTENT"></td>
</tr>
<tr>
<td><input type="file" name="ufile"></td>
</tr>
<tr>
<td><input type="submit" value="작성완료" /></td>
</tr>
</table>
</form>

</body>
</html>
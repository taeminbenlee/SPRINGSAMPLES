<%@page import="bit.com.a.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
MemberDto mem = (MemberDto)request.getSession().getAttribute("login");
request.setCharacterEncoding("utf-8");
%>
</head>
<body>
<div align="center" style="height: 1000px; font-size: 12pt;">
<form action="writeAf.do" method="post">
	<table class="table table-dark table-hover">
	
<colgroup>
<col width="200"><col width="400">
</colgroup>

<tr>
	<th>아이디</th>
	<td>
		<%-- <input type="text" name="id" size="50px" value="<%=mem.getId() %>"> --%>
		<input type="text" name="id" size="50px" value=${login.id } readonly="readonly">
	</td>
</tr>

<tr>
	<th>제목</th>
	<td>
		<input type="text" name="title" size="50px">
	</td>
</tr>

<tr>
	<th>내용</th>
	<td>
		<textarea rows="20" cols="50px" name="content"></textarea>
	</td>
</tr>
<tr>
	<td>
		<input type="submit" class="btn btn-warning" value="글쓰기">
	</td>
	
	<td><a href="bbspagingsearchlist.do" style="color: white;"><b>목록보기</b></a></td>
	
</tr>
</table>
</form>
</div>
</body>
</html>
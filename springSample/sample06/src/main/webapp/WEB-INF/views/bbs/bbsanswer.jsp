<%@page import="bit.com.a.dto.BbsDto"%>
<%@page import="bit.com.a.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.parent{
	padding-left: 200px;
	padding-top: 300px;
	float: left;
}
.child{
	padding-top: 250px;
	padding-right: 150px;
	float: right;
}
</style>
</head>
<%
request.setCharacterEncoding("utf-8");
MemberDto mem = (MemberDto)request.getSession().getAttribute("login");

%>
<%
BbsDto dto  = (BbsDto)request.getAttribute("detail");
int seq = dto.getSeq();

%>
<body>
<div style="font-size: 11pt;">
	<div class="parent">
	<table class="table table-dark table-hover">
	<caption><h1 style="color: white">부모글</h1></caption>
<colgroup>
	<col style="width: 250">
	<col style="width: 600">
</colgroup>

<tr>
	<th>작성자</th>
	<td><%=dto.getId() %></td>
</tr>

<tr>
	<th>제목</th>
	<td><%=dto.getTitle() %></td>
</tr>

<tr>
	<th>작성일</th>
	<td><%=dto.getWdate() %></td>
</tr>

<tr>
	<th>조회수</th>
	<td><%=dto.getReadcount() %></td>
</tr>

<tr>
	<th>내용</th>
	<td align="center">
	<textarea rows="10" cols="90" readonly="readonly"><%=dto.getContent() %></textarea>
	</td>
</tr>
</table>
	</div>
	<br><br>
	
	
	<div class="child">
	<form action="answerAf.do" method="post">
	<input type="hidden" name="seq" value="<%=dto.getSeq() %>">
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


</div>
</body>
</html>
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
	.view{
		font-size: 14pt;
		padding-top: 300px;
		
	}
	</style>
</head>
<body>
<%
MemberDto mem = (MemberDto)request.getSession().getAttribute("login");

BbsDto dto  = (BbsDto)request.getAttribute("detail");
%>
<div class="view">
<form action="updateAf.do" method="post">
<input type="hidden" name="seq" value="<%=dto.getSeq() %>">
<div align="center">
	<table class="table table-dark table-hover" style="text-align: center; width: 1200px;">
	<caption><h1>BBS UPDATE</h1></caption>
<colgroup>
	<col style="width: 30%">
	<col style="width: 70%">
</colgroup>
<tbody>
<tr>
	<th>작성자</th>
	<td>
		<input type="text" name="id" readonly="readonly" size="60" 
			value="<%=mem.getId() %>"> 		
	</td>	
</tr>

<tr>
	<th>제목</th>
	<td>
		<input type="text" name="title" size="60" value="<%=dto.getTitle() %>">		
	</td>
</tr>
<tr>
	<th>내용</th>
	<td>
		<textarea rows="10" cols="60" name="content"><%=dto.getContent() %></textarea>		
	</td>
</tr>
</tbody>
<tfoot>

<tr>
	
	<td><input type="submit" class="btn btn-warning" value="완료"></td>
	<td><button type="button" class="btn btn-warning" OnClick="javascript:history.back(-1)">취소</button></td>
	
</tr>
</tfoot>
</table>
<div class="utill4">

</div>
<div class="utill4">

</div>
</div>
</form>

</div>
</body>
</html>
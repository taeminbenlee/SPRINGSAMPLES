<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="bit.com.a.dto.BbsDto"%>
<%@page import="bit.com.a.dto.MemberDto"%>




<h1>글 수정</h1>
<br>

<%
Object ologin = session.getAttribute("login");
MemberDto mem = null;
mem = (MemberDto)ologin;
%>

<%
BbsDto bbs = (BbsDto)request.getAttribute("bbs");
%>

<div align="center">

<form action="bbsupdateAf.do" method="post">
<input type="hidden" name="seq" value="<%=bbs.getSeq() %>">
			
<table class="list_table" style="width: 85%">
<col width="200"><col width="500"> 

<tr>
	<th>아이디</th>
	<td>
		<input type="text" name="id" readonly="readonly" size="60" 
			value="<%=mem.getId() %>"> 		
	</td>	
</tr>
<tr>
	<th>제목</th>
	<td>
		<input type="text" name="title" size="60" value="<%=bbs.getTitle() %>">		
	</td>
</tr>
<tr>
	<th>내용</th>
	<td>
		<textarea rows="10" cols="60" name="content"><%=bbs.getContent() %></textarea>		
	</td>
</tr>
<tr>
	<td colspan="2">
		<input type="submit" value="글수정">
	</td>
</tr>

</table>

</form>

</div>
<br><br>
<a href="bbslist.do">글목록</a>
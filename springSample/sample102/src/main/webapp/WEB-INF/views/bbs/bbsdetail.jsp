<%@page import="bit.com.a.dto.MemberDto"%>
<%@page import="bit.com.a.dto.BbsDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
MemberDto mem = (MemberDto)request.getSession().getAttribute("login");
%>

<%
BbsDto bbs = (BbsDto)request.getAttribute("bbs");
%>
<div align="center">

<table class="list_table" style="width: 85%">
<tr>
	<th>작성자</th>
	<td><%=bbs.getId() %></td>
</tr>

<tr>
	<th>제목</th>
	<td><%=bbs.getTitle() %></td>
</tr>

<tr>
	<th>작성일</th>
	<td><%=bbs.getWdate() %></td>
</tr>

<tr>
	<th>조회수</th>
	<td><%=bbs.getReadcount() %></td>
</tr>

<tr>
	<th>정보</th>
	<td><%=bbs.getRef() %>-<%=bbs.getStep() %>-<%=bbs.getDepth() %></td>
</tr>

<tr>
	<th>내용</th>
	<td align="center">
	<textarea rows="15" cols="100" readonly="readonly"><%=bbs.getContent() %></textarea>
	</td>
</tr>
</table>

<br>
<button type="button" onclick="answerbbs(<%=bbs.getSeq() %>)">답글</button>

<button type="button" onclick="location.href='bbslist.do'">글목록</button>
<%
if(bbs.getId().equals(mem.getId())){
	%>	
	<button type="button" onclick="updateBbs(<%=bbs.getSeq() %>)">수정</button>
	<button type="button" onclick="deleteBbs(<%=bbs.getSeq() %>)">삭제</button>
	<%
}
%>
</div>

<script type="text/javascript">
function updateBbs(seq) {
	location.href = "bbsupdate.do?seq=" + seq;
}

function deleteBbs(seq) {
	location.href = "bbsdelete.do?seq=" + seq;
}

function answerbbs(seq) {
	location.href = "bbsanswer.do?seq=" + seq;	
}



</script>
</body>
</html>
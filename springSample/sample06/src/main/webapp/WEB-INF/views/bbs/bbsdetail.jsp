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
request.setCharacterEncoding("utf-8");
MemberDto mem = (MemberDto)request.getSession().getAttribute("login");

%>
<%
BbsDto dto  = (BbsDto)request.getAttribute("detail");
int seq = dto.getSeq();

%>




<div class="view">
	<div align="center">
	<table class="table table-dark table-hover" style="text-align: center; width: 1200px;">
	<thead>
	</thead>
	<tbody>
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
	<th>정보</th>
	<td><%=dto.getRef() %>-<%=dto.getStep() %>-<%=dto.getDepth() %></td>
</tr>

<tr>
	<th>내용</th>
	<td align="center">
	<textarea rows="10" cols="90" readonly="readonly"><%=dto.getContent() %></textarea>
	</td>
</tr>
</tbody>

<tfoot>
<colgroup>
<col style="width: 200"><col style="width: 200"><col style="width: 200"><col style="width: 200">
</colgroup>
<% 
if(dto.getId().equals(mem.getId())){
%>
<tr>
<td><button type="button" class="btn btn-warning" onclick="answerBbs(<%=dto.getSeq() %>)">답글</button></td>
<td><button type="button" class="btn btn-warning" onclick="updateBbs(<%=dto.getSeq() %>)">수정</button></td>
<td><button type="button" class="btn btn-warning" onclick="deleteBbs(<%=dto.getSeq() %>)">삭제</button><td>
<td><a href="bbspagingsearchlist.do" style="color: white;"><b>목록보기</b></a></td>
</tr>
<%
}
%>
</tfoot>

</table>




</div>
</div>

<script type="text/javascript">
function updateBbs( seq ) {
	
	location.href = "bbsupdate.do?seq=" + seq;
	
	
	
}
function deleteBbs( seq ) {
	location.href = "bbsdelete.do?seq=" + seq;
}
function answerBbs( seq ) {
	location.href = "toAnswer.do?seq=" + seq;

}
</script>


</body>
</html>
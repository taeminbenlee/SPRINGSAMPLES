<%@page import="bit.com.a.dto.BbsDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 부모글 -->
<%
BbsDto bbs = (BbsDto)request.getAttribute("bbs");
%>
<table class="list_table" style="width: 85%" id="_list_table">
<colgroup>
	<col style="width:30%">
	<col style="width:70%">
</colgroup>
<tr>
	<th>아이디</th>
	<td>
		<input type="text" name="id" id="_userid" size="30" readonly="readonly" value=${login.name }>
	</td>
</tr>
<tr>
	<th>제목</th>
	<td style="padding-left: 5px">
		<input type="text" size="30" readonly="readonly" value=${bbs.title }>
	</td>
</tr>
<tr>
	<th>내용</th>
	<td style="padding-left: 5px">
		<textarea rows="20" cols="50px" readonly="readonly" >${bbs.content }</textarea>
	</td>
</tr>
</table>

<br><br><br>
<!-- 답글부분.. -->
<form action="" method="post" id="_ansForm" name="ansForm">
<input type="hidden" name="seq" value=${bbs.seq }>
<table class="list_table" style="width: 85%" id="_list_table">
<colgroup>
	<col style="width:30%">
	<col style="width:70%">
</colgroup>
<tr>
	<th>아이디</th>
	<td>
		<input type="text" name="id" id="_userid" size="30" readonly="readonly" value=${login.name }>
	</td>
</tr>
<tr>
	<th>제목</th>
	<td style="padding-left: 5px">
		<input type="text" size="30" id="_title" name="title">
	</td>
</tr>
<tr>
	<th>내용</th>
	<td style="padding-left: 5px">
		<textarea rows="20" cols="50px" name="content"></textarea>
	</td>
</tr>
<tr>
	<td style="padding-left: 5px">
		<span class="button blue">
			<button type="button" id="btnCancel" onclick="location.href='bbslist.do'">취소</button>
		</span>
	</td>
	<td style="padding-left: 5px">
		<span class="button blue">
			<button type="button" id="btnAnswer" >작성완료</button>	
		</span>
	</td>
</tr>
</table>
</form>

<script type="text/javascript">
$(document).ready(function () {
	$("#btnAnswer").click(function () {
		if($("#_title").val() == ""){
		    alert("제목을 입력하세요");
		}else{
			$("#_ansForm").attr("action", "bbsanswerAf.do").submit();
	
		}
	});
});

</script>

</body>
</html>
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


<form action="" method="post" id="_wrtForm" name="wrtForm">
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
			<button type="button" id="btnWrite" >작성완료</button>	
		</span>
	</td>
</tr>
</table>
</form>

<script type="text/javascript">
$(document).ready(function () {
	$("#btnWrite").click(function () {
		if($("#_title").val() == ""){
		    alert("제목을 입력하세요");
		}else{
			$("#_wrtForm").attr("action", "bbswriteAf.do").submit();
	
		}
	});
});
</script>
</body>
</html>
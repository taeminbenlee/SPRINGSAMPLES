<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  


<form name="frmForm" id="_frmForm" action="pdsupdateAf.do" method="post" enctype="multipart/form-data">
<input type="hidden" name="seq" value="${pdsdetail.seq }">
<input type="hidden" name="oldfilename" value="${pdsdetail.filename }">
<input type="hidden" name="oldnewfilename" value="${pdsdetail.newfilename }">
<table class="list_table" style="width: 85%">

<colgroup>

</colgroup>
<tbody>
<thead>
<tr>
	<th>작성자</th>
	<td>${pdsdetail.id }</td>
	
	<th>작성일</th>
	<td>${pdsdetail.regdate }</td>
	<th>조회수</th>
	<td>${pdsdetail.readcount }</td>
	
</tr>
</thead>

<tr>
	<th>제목</th>
	<td><input type="text" id="title" name="title" size="50" value="${pdsdetail.title }"></td>
	<th>다운로드</th>
	<td>
		${pdsdetail.filename }&nbsp;<input type="button" name="btnDown" value="다운로드" onclick="filedown('${pdsdetail.newfilename }', ${pdsdetail.seq })"> 
		<br>새로운 자료 업로드<input type="file" name="fileload">
	</td>
	<th>다운수</th>
	<td>${pdsdetail.downcount }</td>
	
</tr>

<tr>
	<th>내용</th>
	<td colspan="5">
	<textarea cols="120" rows="10" name="content">${pdsdetail.content }</textarea>
	</td>
</tr>


</tbody>
</table>
</form>

<div id="btns" align="center">
<button type="button" onclick="location.href='pdsSearch.do'">글목록</button>

<button type="button" id="btnPds">수정</button>

</div>

<script>
$("#btnPds").click(function () {
	if($("#title").val() == ""){
	    alert("제목을 입력하세요");
	}else{
		var title = $('#title').val();
		
		$("#_frmForm").submit();
	}
	
});


</script>







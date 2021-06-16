<%@page import="bit.com.a.dto.PdsDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

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
	<td>${pdsdetail.title }</td>
	
	<th>다운로드</th>
	<td>
		${pdsdetail.filename }&nbsp;<input type="button" name="btnDown" value="다운로드" onclick="filedown('${pdsdetail.newfilename }', ${pdsdetail.seq })"> 
	</td>
	<th>다운수</th>
	<td>${pdsdetail.downcount }</td>
	
</tr>


<tr>
	
</tr>

<tr>
	<th>내용</th>
	<td colspan="5">
	<textarea cols="120" rows="10" name="content" readonly="readonly">${pdsdetail.content }</textarea>
	</td>
</tr>


</tbody>
</table>
<div id="btns" align="center">
<button type="button" onclick="location.href='pdsSearch.do'">글목록</button>
<c:if test="${login.id==pdsdetail.id}">
<button type="button" onclick="updatePds(${pdsdetail.seq})">수정</button>
<button type="button" onclick="deletePds(${pdsdetail.seq})">삭제</button>
</c:if>
</div>
<!-- 다운버튼클릭시 -->
<form name="file_Down" action="fileDownload.do" method="post">
	<input type="hidden" name="newfilename">
	<input type="hidden" name="seq" >
</form>
<script>
function filedown(newfilename, seq) {
	let doc = document.file_Down;
	doc.newfilename.value = newfilename;
	doc.seq.value = seq;
	doc.submit();
}
function updatePds(seq) {
	location.href = "pdsUpdate.do?seq="+seq;
}
function deletePds(seq) {
	location.href = "pdsDelete.do?seq="+seq;
}
</script>

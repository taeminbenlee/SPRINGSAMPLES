<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>    
<div class="box_border" style="margin-top: 5px; margin-bottom: 10px">
<form action="" id="_frmFormSearch" method="get">
<input type="hidden" name="page" value="0">
<table style="margin-left: auto; margin-right: auto; margin-top: 3px; margin-bottom: 3px">
<tr>
	<td>검색</td>
	<td style="padding-left: 5px">
		<select id="_choice" name="choice">
			<option value="" selected="selected">선택</option>
			<option value="title">제목</option>
			<option value="content">내용</option>
			<option value="writer">작성자</option>
		</select>
	</td>
	<td style="padding-left: 5px">
		<input type="text" id="_searchWord" name="search" value=${search }>
	</td>
	<td style="padding-left: 5px">
		<span class="button blue">
			<button type="button" id="btnSearch" >검색</button>
		</span>
	</td>
</tr>
</table>
</form>
</div>
<table class="list_table" style="width: 85%;">
<colgroup>
	<col width="50"><col width="100"><col width="300"><col width="80">
	<col width="50"><col width="50"><col width="100">
</colgroup>


<tr>
	<th>번호</th><th>작성자</th><th>제목</th><th>다운로드</th>
	<th>조회수</th><th>다운수</th><th>작성일</th>
</tr>



<c:forEach var="pds" items="${pdslist }" varStatus="i">

<tr>
	<th>${i.count }</th>
	<td>${pds.id }</td>
	<td style="text-align: left;">
		<a href="pdsdetail.do?seq=${pds.seq }">${pds.title }</a>
	</td>
	<td>
		<input type="button" name="btnDown" value="다운로드" onclick="filedown('${pds.newfilename }', ${pds.seq })">
	</td>
	<td>${pds.readcount }</td>
	<td>${pds.downcount }</td>
	<td><font size="1">${pds.regdate }</font></td>
	
</tr>

</c:forEach>


</table>


<!-- 자료추가버튼 -->
<div id="button.wrap">
	<span class="button blue">
		<button type="button" id="_btnAdd">자료추가</button>
	</span>
</div>

<!-- 다운버튼클릭시 -->
<form name="file_Down" action="fileDownload.do" method="post">
	<input type="hidden" name="newfilename">
	<input type="hidden" name="seq" >
</form>
<br><br>

<!-- 페이징    [1] 2 [3] -->
<%
int len = (int)request.getAttribute("pNumber");
int pdsPage = len / 10;
if((len % 10)>0){
	pdsPage = pdsPage +1;
}
int pageNumber = (Integer)request.getAttribute("pageNumber");

for(int i = 0;i < pdsPage; i++){
   if(pageNumber == i){   // 현재 페이지      [1] 2 [3] 
      %>
      <span style="font-size: 15pt; color: black; font-weight: bold;">
         <%=i + 1 %>
      </span>&nbsp;
      <%
   }
   else{
      %>      
      <a href="#none" title="<%=i+1 %>페이지" onclick="goPage(<%=i %>)"
         style="font-size: 15pt; color: gray; font-weight: bold; text-decoration: none">
         [<%=i + 1 %>]
      </a>&nbsp;   
      <%
   }   
   
} 
%>

<br><br>


<script type="text/javascript">



$("#btnSearch").click(function () {
	
		$("#_frmFormSearch").attr("action", "pdsSearch.do").submit();
	
});

$("#_btnAdd").click(function () {
	location.href = "pdswrite.do";
});

function filedown(newfilename, seq) {
	let doc = document.file_Down;
	doc.newfilename.value = newfilename;
	doc.seq.value = seq;
	doc.submit();
}

function goPage( page ) {
	
	let choice = document.getElementById("_choice").value;
	let search = document.getElementById("_searchWord").value;
	
	location.href = "pdsSearch.do?choice=" + choice + "&search=" + search + "&page=" + page;	
}

</script>

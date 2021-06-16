<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<form name="frmForm" id="_frmForm" action="pdsupload.do" method="post" enctype="multipart/form-data">

<table class="list_table">

<tr>
	<th>아이디</th>
	<td style="text-align: left;">
		<input type="text" name="id" readonly="readonly" value="${login.id }" size="50">
	</td>
</tr>

<tr>
	<th>제목</th>
	<td style="text-align: left;">
		<input type="text" id="title"name="title" size="50">
	</td>
</tr>

<tr>
	<th>파일 업로드</th>
	<td style="text-align: left;">
		<input type="file" id="fileup"name="fileload" style="width: 400px;">
	</td>
</tr>

<tr>
	<th>내용</th>
	<td style="text-align: left;">
		<textarea cols="50" rows="10" name="content"></textarea>
	</td>
</tr>

<tr>
	<td colspan="2" style="height: 50px; text-align: center;">
		<a href="#none" id="btnPds" title="자료올리기">
			<img alt="" src="image/bwrite.png">
		</a>
	</td>
</tr>

</table>

</form>

<script>
$("#btnPds").click(function () {
	if($("#title").val() == ""){
	    alert("제목을 입력하세요");
	    
	}if
	 ($("#fileup").val() == "")	{
		alert("파일을 업로드해 주세요")
	}else{
		$("#_frmForm").submit();
	}
	
});


</script>







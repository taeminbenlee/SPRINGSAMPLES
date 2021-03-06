<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!-- 검색 -->
<div class="box_border" style="margin-top: 5px; margin-bottom: 10px;">
<form action="" id="_frmFormSearch" method="get">
<table style="margin-left: auto;margin-right: auto;margin-top: 3px;margin-bottom: 3px;">
<tr>
	<td>검색</td>
	<td style="padding-left: 5px;">
		<select id="_choice" name="choice">
			<option value="" selected="selected">선택</option>
			<option value="title" >제목</option>
			<option value="content" >내용</option>
			<option value="writer" >작성자</option>
		</select>
	
	</td>
	<td style="padding-left: 5px">
		<input type="text" id="_searchWord" name="searchWord">
	</td>
	<td style="padding-left: 5px;">
		<span class="button blue">
			<button type="button" id="btnSearch" onclick="getSearch()">검색</button>
		</span>
	</td>
</tr>
</table>

</form>

</div>


<table class="list_table" style="width: 85%" id="_list_table">
<colgroup>
<col style="width:70px">
<col style="width:auto">
<col style="width:100px">
</colgroup>

<tr>
	<th>번호</th><th>제목</th><th>작성자</th>
</tr>

<%-- <c:if test="${empty bbslist }">
<tr>
	<td colspan="3">오류난게 아니라면 작성글없다</td>
</tr>
</c:if>

<c:forEach items="${bbslist }" var="bbs" varStatus="vs">
	<tr>
		<td>${vs.count }</td>
		<td style="text-align: left;"><a href="bbsdetail.do?seq="${bbs.seq }>${bbs.title }</a></td>
		<td>${bbs.id }</td>
	</tr>
</c:forEach> --%>

</table>
<div class="container">
   <nav aria-label="Page navigation">
      <ul class="pagination" id="pagination" style="justify-content:center;"></ul>
   </nav>
</div>


<script>

bbslistPage();
getBbsListCount();
//bbslist을 취득
function bbslistPage( pageNumber, choice, search ) {
	$.ajax({
		url:"./bbslistData.do",
		type:"get",
		data:{page: pageNumber, choice:$("#_choice").val(), search:$("#_searchWord").val()  },
		success:function( list ){
			//alert('success');
			//alert(list);
			
			$(".list_col").remove();
			$.each(list,function(i, val){
				let app = "<tr class='list_col'>"
							+ "<td>" + (i+1) + "</td>"
							+ "<td style='text-align:left'>"
							//+ 답글이미지
							+ "<a href='bbsdetail.do?seq="+val.seq + "'>" +val.title + "</a>"
							+ "</td>"
							+ "<td>" + val.id + "</td>"
							+ "</tr>";
				$("#_list_table").append(app);
			});
		},
		error:function(){
			alert('error');
		}
	});
}



//글의 총수를 취득.......................
function getBbsListCount( choice, search) {
	
	$.ajax({
		url:"./bbslistCount.do",
		type:"get",
		data:{page: 0, choice:$("#_choice").val(), search:$("#_searchWord").val()  },
		success:function(count){
			alert('gggg');
			loadPage(count);
		},
		error:function(){
			alert('ㅅ;ㅣ발 실패좆같은년');
		}
	});
}
//페이징처리.....................
function loadPage(totalCount) {
	
	let pageSize = 10;
	let nowPage = 1;
	
	let _totalPages = totalCount / pageSize;   // 전체 페이지의 수
	if(totalCount % pageSize > 0){
	   _totalPages++;
	}
	   
	   /* « 처음, 끝 기호 » */
	$("#pagination").twbsPagination({
	  // startPage: 1,
	   totalPages: _totalPages,
	   visiblePages: 10,
	   first:'<span aria-hidden="true">«</span>',
	   prev:"prev",
	   next:"next",
	   last:'<span aria-hidden="true">»</span>',
	   initiateStartPageClick: false,
	   onPageClick:function(event, page){
	      nowPage = page;
	      //alert('nowPage: ' + page);
	      bbslistPage();
	   }
	});
}

function getSearch() {


	if($("#_searchWord").val() == ""){
	    alert("검색 입력해 주십시오");
	}else{
		$("#_frmFormSearch").attr("action", "searchAf.do").submit();
	}
}

</script>


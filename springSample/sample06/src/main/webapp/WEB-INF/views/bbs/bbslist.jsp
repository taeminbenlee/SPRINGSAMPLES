
<%@page import="bit.com.a.dto.BbsDto"%>
<%@page import="bit.com.a.dto.MemberDto"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bbslist(Bulletin Board System) = 전자 게시판</title>
  
	<style type="text/css">
	.view{
		font-size: 14pt;
		padding-top: 300px;
		
	}
	</style>
</head>
<%
request.setCharacterEncoding("utf-8");
Object ologin = request.getSession().getAttribute("login");
MemberDto mem = null;

if(ologin == null){
	
	response.sendRedirect("login.jsp");
}
mem = (MemberDto)ologin;
%>

<%!
// 댓글의 depth와 image를 추가하는 함수
// depth = 1	'	'->
// depth = 2	'	'	->
public String arrow(int depth){
	String rs = "<img src='./image/arrow.png' width='20px' height='20px'/>";
	String nbsp =  "&nbsp;&nbsp;&nbsp;&nbsp;";
	
	String ts = "";
	for(int i =0; i<depth; i++){
		ts += nbsp;
	}
	return depth==0 ? "":ts + rs;
}

%>   
<%
String choice = request.getParameter("choice");
String search = request.getParameter("search");
if(choice == null){
	choice = "";
}
if(search == null){
	search = "";
}
%>
<%
//Conroller부터 list
List<BbsDto> list = (List<BbsDto>)request.getAttribute("list");

//총 페이지 수
int len = (Integer)request.getAttribute("bbsPage");
int bbsPage = len / 10;		// 23 -> 2
if((len % 10) > 0){
	bbsPage = bbsPage + 1;
}

//현재 페이지
int pageNumber = (Integer)request.getAttribute("pageNumber");
System.out.println("pageNumber:" + pageNumber);
%>


<script type="text/javascript">
$(document).ready(function() {
	// 검색어 있는 경우
	let search = "<%=search %>";
	if(search == "") return;
	
	// select
	let obj = document.getElementById("choice");
	obj.value = "<%=choice %>";
	obj.setAttribute("selected", "selected");
});
</script>
<body>

<div class="view">
	<div align="center">
	<table class="table table-dark table-hover" style="text-align: center; width: 1200px;">
	<col width="70"><col width="600"><col width="150">
    <thead>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
      </tr>
    </thead>
    <tbody>
    

      <%
if(list == null || list.size() == 0){
	%>
	<tr>
		<td colspan="3">작성된 글이 없습니다</td>
	</tr>
	<%
} else{
	for(int i = 0;i < list.size(); i++){
		BbsDto bbs = list.get(i);
		%>
		<tr>
			<th><%=i + 1+ pageNumber * 10 %></th>
			<td>
				<%
				if(bbs.getDel() == 0){
					%>
					<%=arrow( bbs.getDepth() ) %>			
					<a href="bbsdetail.do?seq=<%=bbs.getSeq() %>">
						<%=bbs.getTitle() %>
					</a>	
					<%
				}else{
					%>		
					<font color="#ff0000">*** 이 글은 작성자에 의해서 삭제되었습니다</font> 
					<%
				}
				%>
			</td>
			<td align="center"><%=bbs.getId() %></td>
		</tr>
		<%
	}
}
%>
    </tbody>
    <tfoot>
    <tr>
    	<td><select id="choice" class="form-control"> 
			<option value="title">제목</option>
			<option value="content">내용</option>
			<option value="writer">작성자</option>
		</select></td>
    	<td><input type="text" id="search" class="form-control" value="<%=search %>"></td>
    	<td><button type="button" class="btn btn-warning" onclick="searchBbs()"><p class="text-info">Search</p></button></td>
    </tr>
    <tr>
    	<td><a href="bbswrite.do" style="color: white;"><b>글쓰기</b></a></td>
    	<td>
    	<%
		for(int i = 0;i < bbsPage; i++){
			if(pageNumber == i){	// 현재 페이지		[1] 2 [3] 
				%>
				<span style="font-size: 15pt; color: white; font-weight: bold;">
					<%=i+1 %>
				</span>
				<%
			}
			else{
				%>		
				<a href="#none" title="<%=i+1 %>페이지" onclick="goPage(<%=i %>)"
					style="font-size: 15pt; color: aqua; font-weight: bold;">
					[<%=i + 1 %>]
				</a>	
				<%
			}	
		}
		%>
    	</td>
    	<td><a href="bbspagingsearchlist.do" style="color: white;"><b>목록보기</b></a></td>
    </tr>
    </tfoot>
  </table>
	</div>
	
	


<script type="text/javascript">
function searchBbs() {
	let choice = document.getElementById("choice").value;
	let search = document.getElementById("search").value;
//	alert(choice);
//	alert(search);
	
	location.href = "bbspagingsearchlist.do?choice=" + choice + "&search=" + search;
}

function goPage( pageNumber ) {
	let choice = document.getElementById("choice").value;
	let search = document.getElementById("search").value;
	
	location.href = "bbspagingsearchlist.do?choice=" + choice + "&search=" + search + "&pageNumber=" + pageNumber;	
}

</script>

</div>
</body>
</html>
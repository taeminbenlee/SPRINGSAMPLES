<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<form action="polling.do" method="post">
<table class="list_table" style="width: 95%">
<colgroup>
	<col width="200px"><col width="500px">
</colgroup>

<tr>
	<th>투표번호</th>
	<td style="text-align: left;">
		<input type="text" name="pollid" value="${poll.pollid }" size="50" readonly="readonly">
	</td>
</tr>

<tr>
	<th>아이디</th>
	<td style="text-align: left;">
		<input type="text" name="id" value="${login.id }" size="50" readonly="readonly">
	</td>
</tr>

<tr>
	<th>투표기한</th>
	<td style="text-align: left;">
		${poll.sdate }~${poll.edate }
	</td>
</tr>

<tr>
	<th>투표내용</th>
	<td style="text-align: left;">
		<textarea rows="10" cols="50" name="question">${poll.question }</textarea>
	</td>
</tr>

<tr>
	<th>투표 보기수</th>
	<td style="text-align: left;">
		${poll.itemcount }
	</td>
</tr>

<tr>
	<th>투표 보기들</th>
	<td style="text-align: left;">
		<c:forEach items="${pollsublist }" var="psub" varStatus="i">
		${i.count}번
		<input type="radio" name="pollsubid" ${i.count==1?"checked='checked'":"" } 
		value="${psub.pollsubid }">
		<input type="text" name="answer" size="60" value="${psub.answer }" readonly="readonly"><br>
		
		</c:forEach>
	</td>
</tr>

<tr align="center">
	<td colspan="2"><input type="submit" value="투표하기"></td>
</tr>
</table>
</form>
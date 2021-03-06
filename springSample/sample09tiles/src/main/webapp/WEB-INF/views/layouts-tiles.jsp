<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<!-- 기본레이아웃 -->
<table style="width: 100%; height: 100%; border-color: orange">
<thead>
<!-- 헤더 -->
<tr align="center" style="background-color: black; color: white;">
	<td height="10%" colspan="3">
		<tiles:insertAttribute name="header"/>
	</td>
</tr>
<!-- 메뉴 -->

</thead>
<tbody>
<!-- 메인 -->
<tr>
	<td width="20%" align="left" valign="top" style="background-color: rgb(204, 204, 204)">
		<tiles:insertAttribute name="menu"/>
	</td>
	<td>
		<tiles:insertAttribute name="content"/>
	</td>
	<td width="15%" align="center">
		<tiles:insertAttribute name="empty"/>
	</td>
</tr>
</tbody>
<tfoot>
<!-- 풋터 -->
<tr align="center" style="background-color: black; color: white;">
	<td height="10%" colspan="3">
		<tiles:insertAttribute name="footer"/>
	</td>
</tr>
</tfoot>
</table>


</body>
</html>
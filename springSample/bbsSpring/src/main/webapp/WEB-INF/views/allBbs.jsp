<%@page import="bit.com.a.dto.BbsDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<BbsDto> list = (List<BbsDto>)request.getAttribute("bbslist");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	for(int i = 0; i < list.size(); i++){
		out.println(list.get(i).toString()+"<br>");
	}
%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.center{
	margin: auto;
	width: 60%;
	border: 3px solid #0000ff;
	padding: 10px;
}
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body>

<h2>회원가입</h2>
<p>환영합니다. 홍길동 홈페이지입니다</p>

<div class="center">

<form action="regiAf.do" method="post">

<table border="1">
<tr>
	<td>아이디</td>
	<td>
		<input type="text" name="id" id="_id" size="20"><br>		
		<!-- id확인(ajax) p, button-->		
		<p id="idcheck" style="font-size: 8px"></p>
		<input type="button" id="btn" value="id확인">		
	</td>
</tr>
<tr>
	<td>패스워드</td>
	<td>
		<input type="text" name="pwd" id="_pwd" size="20">
	</td>
</tr>
<tr>
	<td>이름</td>
	<td>
		<input type="text" name="name" size="20">
	</td>
</tr>
<tr>
	<td>이메일</td>
	<td>
		<input type="text" name="email" size="20">
	</td>
</tr>
<tr>
	<td colspan="2">
		<input type="submit" value="회원가입">
	</td>
</tr>

</table>


</form>

</div>

<script type="text/javascript">
$(function () {
	
	$("#btn").click(function () {		
		$.ajax({
			type:"post",
			url:"./idcheck.do",		
			data:{ id:$("#_id").val() },
			success:function( data ){	
				alert('success');			
				if(data == "YES"){
					$("#idcheck").css("color", "#0000ff");
					$("#idcheck").html('사용할 수 있는 id입니다');
				}else{
					$("#idcheck").css("color", "#ff0000");
					$("#idcheck").html('사용 중인 id입니다');
					$("#id").val("");
				}			
			},
			error:function(){
				alert("error");
			}			
		});		
	});	
});
</script>

</body>
</html>







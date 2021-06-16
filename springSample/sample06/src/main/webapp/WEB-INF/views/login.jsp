<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

.home {
	
    width: 100%;
    height: 100vh;
    background-image: url(https://images.unsplash.com/photo-1498550744921-75f79806b8a7?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=b0f6908fa5e81286213c7211276e6b3d&auto=format&fit=crop&w=1500&q=80);
    background-position: center top;
	background-size:cover;
}
.center{
	color: orange;
}
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="http://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript" ></script>

</head>
<body>
<section class="home">
<h2>login page</h2>

<div class="center" align="center">

<form action="loginAf.do" method="post">
	<input type="hidden" name="param" value="loginAf">
<table border="1">
<tr>
	<th>아이디</th>
	<td>
		<input type="text" id="_id" name="id" size="20"><br>
		<input type="checkbox" id="chk_save_id">save id
	</td>
</tr>
<tr>
	<th>패스워드</th>
	<td>
		<input type="password" name="pwd" size="20">
	</td>
</tr>
<tr>
	<td colspan="2">
		<input type="submit" value="로그인">		
		<button type="button" onclick="account()">회원가입</button>
	</td>
</tr>

</table>
</form>

</div>

<script type="text/javascript">
function account() {	
	location.href = "regi.do";
}

/*
	session	: Java -> Server Object
	cookie : Java Script -> Client String 
 */

let user_id = $.cookie("user_id");
if(user_id != null){	// 저장된 id가 있음
//	alert("쿠키 있음");
	$("#_id").val( user_id );
	$("#chk_save_id").attr("checked", "checked");
//	$("#chk_save_id").prop("checked", true);
}

$("#chk_save_id").click(function() {
	
	if( $("#chk_save_id").is(":checked") ){
	//	alert('첵크됨');
		if( $("#_id").val().trim() == "" ){
			alert('id를 입력해 주십시오');
			$("#chk_save_id").prop("checked", false);			
		}else{
			// 쿠키를 저장
			$.cookie("user_id", $("#_id").val().trim(), { expires:7, path:'./'});
		}
	}
	else{
		$.removeCookie("user_id", { path:'./' });
	}
	
}); 

</script>
 
    </section>
</body>
</html>










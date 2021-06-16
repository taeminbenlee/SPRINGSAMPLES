<%@page import="bit.com.a.dto.human"%>
<%@page import="java.util.List"%>
<%@page import="org.springframework.ui.Model"%>
<%@page import="bit.com.a.dto.MyClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>hello~</h1>
<h1>J!!!!!</h1>
<h1>S!!!!!!!!!!!</h1>
<h1> P!!!!!!!!!!!!!!</h1>
<!-- 1 컨트롤러에서 값을 가져올때~-->

<%
MyClass cls = (MyClass)request.getAttribute("mycls");


%>
번호:<%=cls.getNumber() %>
<br>
이름:<%=cls.getName() %>
<br>
<br>
number:${mycls.number }<br>
name:${mycls.name }<br>
<br>


<!-- 2 -->

<form action="move.do" method="post">
이름:<input type="text" name="name">
<br>
번호:<input type="text" name="number">
<br>
<input type="submit" value="submit">
</form>
<br><br>

<!-- 3 -->
id:<input type="text" id="checkid"><br>
<br>
<button type="button" onclick="idcheck()">id check</button>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
function idcheck() {
	
	$.ajax({
		url:"idcheck.do",
		type:"get",
	//	data:"id="+$("#checkid").val(),
		data:{id:$("#checkid").val()},
		success:function( data ){
			alert('success');
			alert(data);
		},
		error:function(){
			alert('error');
		}
	});
	
}

</script>

<br><br>

<!-- 4 -->

<!-- Json을 통해서 웹에서 데이터를 날려주면 콘트롤러에서는 오브젝트를 받아주는것이고..
자바에서 Map을 통해 받아서 다시 날려주면 Json으로 받는당
Json(web) - > Object(Controller)
Map(Controller) - > json(web) -->

name:<input type="text" id="name" value="john"><br>
phone:<input type="text" id="phone" value="2242346844"><br>
email:<input type="text" id="email" value="johns@gmail.com"><br>
date of birth:<input type="text" id="birth" value="2002/06/08"><br>
<button type="button" id="account">create account</button> 

<script type="text/javascript">
$("#account").click(function () {
	alert('clicked');
	let human = {
			name:$("#name").val(),
			phone:$("#phone").val(),
			email:$("#email").val(),
			birth:$("#birth").val()
	};
	$.ajax({
		url:"account.do",
		type:'post',
		dataType:'json',
		data:human,
		async:true, 
		success:function(data){
			alert('success');
			
			alert(JSON.stringify(data));
		},
		error:function(){
			alert('error');
		}
	
	});
	
	
});


</script>

<!-- 5 -->
<div id="datas">

</div>

<button type="button" onclick="read()">data read</button>

<script type="text/javascript">
function read() {
	/* list 확인 web */
	
	
	$.ajax({
		url:"dataread.do",
		type:"get",
		success:function(data){
			alert('success');
			alert(JSON.stringify(data));
			
			
			let str='';
			$.each(data, function (i, item) {
				str += i + "  ";
				str += item.name + " ";
				str += item.phone + " ";
				str += item.email + " ";
				str += item.birth + "<br>";
			});
			
			$("#datas").html(str);
			
		},
		error:function(){
			alert('error');
		}
	
	});
	
	
	
	
}
</script>













</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">
  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
 
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style type="text/css">

.home {
	
    width: 100%;
    height: 100vh;
    background-image: url(https://images.unsplash.com/photo-1498550744921-75f79806b8a7?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=b0f6908fa5e81286213c7211276e6b3d&auto=format&fit=crop&w=1500&q=80);
    background-position: center top;
	background-size:cover;
}
.form-group{
width: 300px;
}
body{background: black;}
h2{font-family: 'Rock Salt', cursive; color: white;}
.form-check-label{font-family: 'Rock Salt', cursive; color: white;}
.form-group{font-family: 'Rock Salt', cursive;}
</style>
</head>


<body>
<section class="home">
<div id=leftScr align="center">

<p>Welcome</p>
<form action="regiAf.do" method="post">
	<div class="form-group" style="padding-top: 100px">
		<h2 style="color: white; text-align: center;"><br>Sign Up PAGE<br><br></h2>
		<br>
		<label for="usr" style="color: aqua;">ID:</label>
		<input type="text" class="form-control" id="checkid" name="id" size="20">
		<!-- id 확인 (ajax) p, button-->
		<button type="button" class="btn btn-warning" onclick="idcheck()">ID Check</button>
	</div>
	<div class="form-group">
		<label for="pwd" style="color: aqua;">PASSWORD:</label>
		<input type="password" class="form-control" name="pwd" id="pwd" size="20">
	</div>
	<div class="form-group">
		<label for="name" style="color: aqua;">NAME:</label>
		<input type="text" class="form-control" name="name" size="20">
	</div>	
	<div class="form-group">
		<label for="email" style="color: aqua;">EMAIL:</label>
		<input type="text" class="form-control" name="email" size="20">
	</div>
<br><br>

	<input type="submit" class="btn btn-warning" value="SIGN UP">
				
</form>


</div>
</section>

<script type="text/javascript">
function idcheck() {
	
	alert($("#checkid").val());
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



</body>
</html>

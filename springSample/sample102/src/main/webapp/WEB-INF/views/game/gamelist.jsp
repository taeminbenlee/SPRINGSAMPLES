<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <table class="list_table" style="width: 85%;">
    <tr>
    <th>테트리스</th>
    <td><span class="button blue">
			<button type="button" id="btnTetris" >실행</button>
		</span></td>
    </tr>
    <tr>
    <th>벽부수기</th>
    <td><span class="button blue">
			<button type="button" id="btnBreak" >실행</button>
		</span></td>
    </tr>
      <tr>
    <th>비행조류</th>
    <td><span class="button blue">
			<button type="button" id="btnBird" >실행</button>
		</span></td>
    </tr>
    <tr>
    <th>스페이스바 온오프</th>
    <td><span class="button blue">
			<button type="button" id="btnOnoff" >실행</button>
		</span></td>
    </tr>
 
    </table>
    
    <script>
    $("#btnTetris").click(function () {
		location.href = "tetris.do";
	});
    $("#btnBreak").click(function () {
		location.href = "break.do";
	});
    $("#btnBird").click(function () {
		location.href = "bird.do";
	});
    $("#btnCar").click(function () {
		location.href = "car.do";
	});
    $("#btnOnoff").click(function () {
		location.href = "http://192.168.0.230:8092/sample10/onoff/index.html";
	});
    </script>
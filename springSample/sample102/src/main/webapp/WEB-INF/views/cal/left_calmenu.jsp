<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="menu_table">
	<ul style="width: 100%">
		<li class="title">일정관리 게시판</li>
		<li class="subtitle">일정관리</li>
		<li class="menu_item">
			<a href="showSchedule.do" title="글목록">일정목록</a>
		</li>
		<li class="menu_item">
			<a href="#none" data-toggle="modal" data-target="#myModal1" title="일정추가">일정추가</a>
		</li>
		<li class="menu_item">
			<a href="#none" data-toggle="modal" data-target="#myModal2" title="일정검색">일정검색</a>
		</li>
	</ul>

</div>   

<div class="modal" id="myModal1">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">이벤트 추가</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
        <form action="" method="post" id="_evtForm" name="evtForm">
        <input type="hidden" name="id" value=${login.id }>
         <table class="list_table" style="width: 85%" id="_list_table">
         <tr>
          <th>제목</th><td><input type='text' size="20" id="_title" name="title"></td>
          </tr>
          <tr>
          <th>내용</th>
          <td><textarea rows="20" cols="50px" id="_content" name="content"></textarea></td>
          </tr>
          <tr>
          <th>시작일</th>
          <td><input type="datetime-local" id="_startdate" name="startdate" value=""></td>
          </tr>
          <tr>
          <th>종료</th>
          <td><input type="datetime-local" id="_enddate" name="enddate" value=""></td>
          </tr>
          </table>
         </form>
        </div>
      
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" id="btnInsert">추가 완료</button>        
          <button type="button" class="btn btn-secondary" data-dismiss="modal">추가 취소</button>
        </div>
        
      </div>
    </div>
  </div>
  
  
  
 
 <script>

	
	 $(document).ready(function () {
		 	
			$("#btnInsert").click(function () {
			
			
				if($("#_title").val() == ""){
				    alert("제목을 입력하세요");
				}else{
					$("#_evtForm").attr("action", "calwriteAf.do").submit();
			
				}
			});
		});
 
 
 </script> 
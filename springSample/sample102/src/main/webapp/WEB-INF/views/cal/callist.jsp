<%@page import="bit.com.a.dto.calParam"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bit.com.a.dto.CalendarDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
List<CalendarDto> list = (ArrayList<CalendarDto>)request.getAttribute("list");

%>
<style>

  #calendar {
    max-width: 1100px;
    margin: 0 auto;
  }

</style>

<div id='calendar' style="position : relative;">
</div>


<div class="modal fade" id="calendarModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h1 class="modal-title">이벤트 디테일</h1>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
        <form action="" method="post" id="_updateForm">
        <input type="hidden" name="seq" id="_seq" value="">
        <table class="list_table" style="width: 85%" id="_list_table">
        <tr>
        <th>제목</th>
        <td>
          <input type='text' size="20" id="title" name="title">
          </td>
          </tr>
          <tr>
          <th>내용</th><td><textarea rows="5" cols="20px" id="content" name="content" ></textarea></td>
         </tr>
         <tr>
          <th>
   			시작</th><td><input type="datetime-local" id="_startdate" name="startdate"></td>
   			</tr>
   			<tr>
          	<th>종료</th><td><input type="datetime-local" id="_enddate" name="enddate"></td>
          	</tr>
          	</table>
         </form>
        </div>
      
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" id="btnDelete" onclick="deleteAf()">삭제</button> 
          <button type="button" class="btn btn-secondary" id="btnUpdate" onclick="updateAf()">수정</button>        
          <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
        </div>
        
      </div>
    </div>
  </div>

 <div class="modal" id="myModal2">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">일정 검색</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
        <form action="" method="post" id="searchForm" name="searchForm">
        <input type="hidden" name="id" value=${login.id }>
        <table class="list_table" style="width: 85%" id="_list_table">
        <tr>
        <th>검색옵션</th>
        <td>
        <select id="_choice" name="choice">
			<option value="" selected="selected">&nbsp;&nbsp;&nbsp;선택&nbsp;&nbsp;&nbsp;</option>
			<option value="title">제목</option>
			<option value="content">내용</option>
		</select>
		</td>
		</tr>
		<tr>
		<th>검색어</th>
		<td><input type="text" id="_searchWord" name="searchWord"></td>
		</table>
         </form>
        </div>
      
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" id="btnSearch">검색</button>        
          <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
        </div>
        
      </div>
    </div>
  </div>


	 <div class="modal" id="listModal">
    <div class="modal-dialog-scrollable" role="document">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">일정검색결과</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
        <table class="list_table" style="width: 85%" id="list_table2">

			<tr>
				<th>제목</th><th>내용</th><th>시작일</th><th>종료일</th>
			</tr>
			
    	  </table>
        </div>
      
        <!-- Modal footer -->
        <div class="modal-footer">
       
          <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
        </div>
        
      </div>
    </div>
  </div>
<script>

  document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {
      headerToolbar: {
        left: 'prev,next today',
        center: 'title',
        right: 'dayGridMonth,timeGridWeek,timeGridDay,listMonth'
      },
    
      locale: "ko",
      //initialDate: '2020-09-12',
      navLinks: true, // can click day/week names to navigate views
      businessHours: true, // display business hours
      editable: true,
      selectable: true,
      
      events: [
    	  <% 
    	  		for(int i=0; i < list.size(); i++){
    	  			CalendarDto dto = list.get(i);
    	  		
    	  %>
    	  {
    		title: "<%=dto.getTitle() %>",
    		extendedProps: { 
    							description: "<%=dto.getContent()%>",
    							seq: "<%=dto.getSeq()%>"
    	  					},
    		start: "<%=dto.getStartdate() %>",
    		end: "<%=dto.getEnddate() %>"
    		
    	  },
    	  
    	  <%
    	  		}
    	  %>
    
      ],
      
      eventColor: 'red',
	    eventClick: function(info) {
			//alert(info.event.start);
 	        
 	  		var x = convertDate(info.event.start);
 	  		//alert(x);
    		var y = convertDate(info.event.end);
    		
 	        $('#calendarModal #title').val(info.event.title);
 	        $('#calendarModal #_startdate').val(x);
 	        $('#calendarModal #_enddate').val(y);
 	        $('#calendarModal #content').val(info.event.extendedProps.description);
 	        $('#calendarModal #_seq').val(info.event.extendedProps.seq);
 	        $('#calendarModal').modal('show');
 	
 	    }
   		
    });

    calendar.render();
    
  });
  

function convertDate(date) {
	  var yyyy = date.getFullYear().toString();
	  var mm = (date.getMonth()+1).toString();
	  var dd  = date.getDate().toString();
	  var hh = date.getHours().toString();
	  var min = date.getMinutes().toString();
	  var mmChars = mm.split('');
	  var ddChars = dd.split('');
	  var hhChars = hh.split('');
	  var minChars = min.split('');
	  
	  return yyyy + '-' + (mmChars[1]?mm:"0"+mmChars[0]) + '-' + (ddChars[1]?dd:"0"+ddChars[0]) + 'T'
	  			+ (hhChars[1]?hh:"0"+hhChars[0]) + ':' + (minChars[1]?min:"0"+minChars[0]);
	}

function updateAf() {
	if($("#title").val() == ""){
	    alert("제목을 입력하세요");
	}else{
		$("#_updateForm").attr("action", "calUpdate.do").submit();

	}
}
function deleteAf() {
	$("#_updateForm").attr("action", "calDelete.do").submit();
}

$("#btnSearch").click(function () {
	if($("#_searchWord").val() == ""){
	    alert("검색어를 입력해 주십시오");
	}else{
		$.ajax({
			url:"./calSearch.do",
			type:"post",
			data:{  choice:$("#_choice").val(), search:$("#_searchWord").val() },
			success:function( lista ){
			//	alert('success');
				
				$('#myModal2').modal('hide');
				$('#listModal').modal('show');
				
				$.each(lista, function (i, val) {
					let app = "<tr class='list_col'>"
						 + "<td class='_hover_tr' style='text-align:left'>" + val.title + "</td>"
						 + "<td>" + val.content + "</td>"
						 + "<td>" + val.startdate + "</td>"
						 + "<td>" + val.enddate + "</td>"
						 + "</tr>";
							
					$("#list_table2").append(app);	
				});	 
				
				
			},
			error:function(){
				alert('error');
			}
		});
}
});
</script>


  

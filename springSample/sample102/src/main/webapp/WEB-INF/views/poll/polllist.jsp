<%@page import="bit.com.a.util.PollUtil"%>
<%@page import="bit.com.a.dto.MemberDto"%>
<%@page import="bit.com.a.poll.PollDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>
<%
   List<PollDto> plists = (List<PollDto>)request.getAttribute("plists");
   
   MemberDto mem = (MemberDto)session.getAttribute("login");
%>

<!-- 관리자 - 투표x 만들기만 가능 -->
<%
if(mem.getAuth() == 1){
%>   
   <table class="list_table" style="width: 95%">
      <col width="50"><col width="50"><col width="300">
      <col width="100"><col width="100"><col width="50">
      <col width="50"><col width="100">
      
         <tr>
            <th>번호</th><th>아이디</th><th>투표제목</th>
            <th>시작일</th><th>종료일</th><th>항목수</th>
            <th>투표수</th><th>등록일</th>
         </tr>
      <%
         for(int i = 0 ; i < plists.size(); i++){
            PollDto poll = plists.get(i);
            %>
            <tr bgcolor="#aabbcc">
               <td><%=i + 1 %></td>
               <td><%=poll.getId() %></td>
               <td><%=poll.getQuestion() %></td>
               <td><%=poll.getSdate() %></td>
               <td><%=poll.getEdate() %></td>
               <td><%=poll.getItemcount() %></td>
               <td><%=poll.getPolltotal() %></td>
               <td><%=poll.getregdate() %></td>
            </tr>
            <%      
         }
       %>
   </table>
   
<%
} else if(mem.getAuth() == 3){   // 이건 해도되고 안해도댐 -if
%>
<!-- 사용자 - 투표O 만들기는 못함 -->
   <table class="list_table" style="width: 95%">
      <col width="50"><col width="50"><col width="300"><col width="100">
      <col width="100"><col width="100"><col width="50">
      <col width="50"><col width="100">
      
         <tr>
            <th>번호</th><th>아이디</th><th>투표제목</th><th>결과</th>   <!-- 결과에선 진행중?/종료? 표기 -->
            <th>시작일</th><th>종료일</th><th>항목수</th>
            <th>투표수</th><th>등록일</th>
         </tr>
   
      
      <%
         for(int i = 0; i < plists.size(); i++){
            PollDto poll = plists.get(i);
            %>
            <tr bgcolor="#aabbcc">
               <td><%=i + 1 %></td>
               <td><%=poll.getId() %></td>
               <%   // 투표 주제
               boolean isS = poll.isVote();
               
               // 투표함            but, 기간 만료
               if(isS == true || PollUtil.isEnd(poll.getEdate()) == true){
                  %>
                  <td>[마감]<%=poll.getQuestion() %></td>
                  <%
               } else {   // 투표를 안했으며, 기간이 아직 만료되지 않은상태
                  %>
                  <td>
                     <a href="polldetail.do?pollid=<%=poll.getPollid() %>">결과
                        <%=poll.getQuestion() %>
                     </a>
                    
                  </td>
                  <%
               }   
                  
               // 투표안함
               
               %>
               
               <td>
               <%
               if(isS == true || PollUtil.isEnd(poll.getEdate()) == true){
               %>
               <a href = "pollresult.do?pollid=<%=poll.getPollid() %>">결과</a>
               <input type="button" id="resultbtn" value="결과확인">
               <input type="hidden" id="_pollid" name="pollid" value="<%=poll.getPollid() %>">
               <%
               
               } else {
               %>
               <img alt="" src="image/pen.gif">
               <%
               }
               %>
               </td>
               <td><%=poll.getSdate() %></td>
               <td><%=poll.getEdate() %></td>
               <td><%=poll.getItemcount() %></td>
               <td><%=poll.getPolltotal() %></td>
               <td><%=poll.getregdate() %></td>
            
            </tr>   
            
            
            
            <%
         }
      %>
      
    
   
   
   </table>

<%
}
%>
<br><br>
<%
if(mem.getAuth()==1){
	%>
	<a href = "pollmake.do">투표만들기</a>
	<%
}
%>



<div class="modal fade" id="pollModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h1 class="modal-title" id="rqtitle"></h1>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
		<figure class="highcharts-figure">
	  	<div id="container"></div>
	  <input type="text" id="hiddenjson" size="40px"> 
		</figure>
        </div>
    
 	</div>
 </div>
</div>

<div id="highcharts-modal" class="modal">
  <div class="modal-content">
    <div id="container2" style="width: 300px; height: 500px;"></div>
  </div>
</div>


<script>




$(document).ready(function () {
 	
	$("#resultbtn").click(function () {
		//$('#pollModal').modal('show');
		$.ajax({
			url:"./preresult.do",
			type:"post",
			data:{  pollid:$("#_pollid").val() },
			success:function( list ){
				//변수
				let jsonData;
				let titleQ;
				
				alert('success');
				jsonData = "[";
				
				$.each(list, function (i, val) {
					titleQ = val.rquestion;
					
					jsonData += "{name:'" + val.ranswer + "', y:" + val.racount + "},";
					
				
				});
				
				jsonData = jsonData.substring(0, jsonData.lastIndexOf(","));
				jsonData += "]";
				
				//alert(jsonData);
				//alert(titleQ);
				
				mamam(titleQ, jsonData);
				
				
				$('#hiddenjson').val(jsonData);
				$('#container').highcharts().redraw();
				$('#pollModal').modal('show');
				$('#container').highcharts().redraw();
				
			
				
			},
			error:function(){
				alert('error');
			}			
		});	
	});
	
	
	
	
});




function mamam(titleQ, jsonData) {
	alert(jsonData);
	alert(titleQ);
	
	var j2data = document.getElementById("hiddenjson").value;
	alert(j2data);
	
	Highcharts.chart('container', {
		  chart: {
		    plotBackgroundColor: null,
		    plotBorderWidth: null,
		    plotShadow: false,
		    type: 'pie'
		  },
		  title: {
		    text: titleQ
		  },
		  tooltip: {
		    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
		  },
		  accessibility: {
		    point: {
		      valueSuffix: '%'
		    }
		  },
		  plotOptions: {
		    pie: {
		      allowPointSelect: true,
		      cursor: 'pointer',
		      dataLabels: {
		        enabled: true,
		        format: '<b>{point.name}</b>: {point.percentage:.1f} %'
		      }
		    }
		  },
		  series: [{
		    name: '득표수',
		    colorByPoint: true,
		    data: j2data
		  }]
		});
}

	
	
</script>


















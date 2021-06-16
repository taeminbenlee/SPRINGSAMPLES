<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String str = (String)request.getAttribute("yulist");

if(str==null || str.equals("")){
   str = "";
}
%>

<script type="text/javascript">
$(function () {
   let str = '<%=str%>';
   //alert(str);
   
   json = JSON.parse(str);
   //alert(json);
   
   let obj = json.contents.twoColumnSearchResultsRenderer.primaryContents.sectionListRenderer.contents[0].itemSectionRenderer.contents[1].shelfRenderer.content.verticalListRenderer.items;
   
   $.each(obj, function (i, item) {
   //   alert(item.videoRenderer.videoId);
   //   alert(item.videoRenderer.title.runs[0].text);
   
      let s = "<tr>"
               + "<td>" + (i + 1) + "</td>"
               + "<td style='text-align: left; cursor: pointer;'><div class='c_vname' vname='" + item.videoRenderer.videoId + "'>" + item.videoRenderer.title.runs[0].text +"</div></td>"
               + "<td>" + item.videoRenderer.videoId + "</td>"
               + "<td style='cursor: pointer;'><img src='image/save.png' class='ck_seq' id='" + item.videoRenderer.videoId +"' loginIn='${login.id}' title='" + item.videoRenderer.title.runs[0].text +"'></td>"
            +"</tr>";
      $("#tbody").append(s);
      
   });
   
   obj = json.contents.twoColumnSearchResultsRenderer.primaryContents.sectionListRenderer.contents[0].itemSectionRenderer.contents;
      $.each(obj, function (i, item) {
         if(item.videoRenderer != undefined){
            let s = "<tr>"
               + "<td>" + (i + 1) + "</td>"
               + "<td style='text-align: left; cursor: pointer;'><div class='c_vname' vname='" + item.videoRenderer.videoId + "'>" + item.videoRenderer.title.runs[0].text + "</div></td>"
               + "<td>" + item.videoRenderer.videoId + "</td>"
               + "<td style='cursor: pointer;'><img src='image/save.png' class='ck_seq' id='" + item.videoRenderer.videoId + "'   loginIn='${login.id}' title='" + item.videoRenderer.title.runs[0].text + "'></td>"
                   + "</tr>";
         
            $("#tbody").append(s);
         }
      });
      
     
   
   
});
</script>



<div class="box_border" style="margin-top: 5px; margin-bottom: 10px">

<form id="frmForm" method="post">

<table style="margin-left: auto; margin-right: auto; margin-top: 3px; margin-bottom: 3px">
<tr>
   <td>검색</td>
   <td style="padding-left: 5px">
       <input type="text" id="_s_keyword" name="s_keyword" value="${empty s_keyword?'':s_keyword }">
   </td>
   <td style="padding-left: 5px">
      <span class="button blue">
         <button type="button" id="btnSearch" >검색</button>
    </span>    
   </td>

</tr>
</table>
</form>
</div>

<div id="_youtube_">
   <iframe id="_youtube" width="820" height="360" src="http://www.youtube.com/embed/"
    frameborder="0" allowfullscreen>   
   </iframe>      
</div>

<table class="list_table" style="width: 85%">
<colgroup>
   <col style="width: 70px"><col style="width: auto;">
   <col style="width: 100px"><col style="width: 40px">
</colgroup>

<thead>
   <tr>
      <th>번호</th><th>제목</th><th>유투브 고유번호</th><th>저장</th>
   </tr>
</thead>

<tbody id="tbody">
   
</tbody>

</table>




<script>
$("#btnSearch").click(function() {
//   alert("click");

   $("#frmForm").attr("action", "youtube.do").submit();
   
});

$(document).on("click", ".c_vname", function() {
   $("#_youtube").attr("src", "http://www.youtube.com/embed/" + $(this).attr("vname"));
});

// 저장버튼 눌렀을 때 
$(document).on("click",".ck_seq", function() {
   //alert("btnClick");
   
   let id = $(this).attr("loginIn");
   let title = $(this).attr("title");
//   alert(title);
   let url = $(this).attr("id");
   
   $.ajax({
      url:'youtubesave.do',
      type:'post',
      async:true,
      data:{ "id":id, "title":title, "url":url},
      success:function(msg){
         alert(msg);
      },
      error:function(){
         alert('error');
      }
      
   });
   
   
});



</script>




















<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<!-- pagination -->
<!-- https://github.com/josecebe/twbs-pagination -->
<script type="text/javascript" src="./jquery/jquery.twbsPagination.min.js"></script>

</head>
<body>

<br><br><br>
<div class="container">
   <nav aria-label = "Page navigation">
      <ul class="pagination" id="pagination">
      
      </ul>
   </nav>
</div>


<script type="text/javascript">
let totalCount = 51;   // 글의 총 갯수
let pageSize = 10;      // 페이지의 크기 글이 1~10
let nowPage = 1;      // 현재 페이지

let _totalPages = totalCount / pageSize;   // 전체 페이지의 수
if(totalCount % pageSize > 0){
   _totalPages++;
}
   
   /* « 처음, 끝 기호 » */
$("#pagination").twbsPagination({
   startPage: 1,
   totalPages: _totalPages,
   visiblePages: 10,
   first:'<span aria-hidden="true">«</span>',
   prev:"이전",
   next:"다음",
   last:'<span aria-hidden="true">»</span>',
   onPageClick:function(event, page){
      nowPage = page;
      alert('nowPage: ' + page);
   }
});
</script>

</body>
</html>
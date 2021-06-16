/**
 * 
 */

let loginid;

getWeatherData();

getBbsListData(0);

getBbsListCount();
//seq받아오기
let urlParams = location.search.split(/[?&]/).slice(1).map(function(paramPair) {
    return paramPair.split(/=(.+)?/).slice(0, 2);
}).reduce(function(obj, pairArray) {
    obj[pairArray[0]] = pairArray[1];
    return obj;
}, {});

//로그인 정보 다시 받아오기
$(document).ready(function(){


});
//날씨정보 취득
function getWeatherData() {
	alert('날씨정보 가져오기');
	
	$.ajax({
		url:"http://localhost:3000/weather",
		type:"get",
		success:function( list ){
			alert('success');
			
			alert(list);
			let atab = "";
			$.each(list, function (i,	 val) {
				atab += "<li class='wli'><div class='wslider-container'>"
						+ "<p>"+ "오늘의 날씨정보:    "  
						+ val.cities + "시    " + val.temperature + "도    "
						+ val.winfo +"</p>"
						+ "</div></li>";
					
			});
			
			$("div#wslider ul.wul").append(atab);
		},
		error:function(){
			alert('error');
		}
			
		});
}



// bbslist을 취득
function getBbsListData( pNumber ) {
	
	$.ajax({
		url:"http://localhost:3000/bbslistData",
		type:"get",
		data:{ page:pNumber, choice:$("#_choice").val(), search:$("#_searchWord").val() },
		success:function( list ){
			//alert('success');
			//alert(list);
			
			
			$(".list_col").remove();
		
			$.each(list, function (i, val) {
				let app = "<tr class='list_col'>"
							+ "<td>" + (i + 1) + "</td>"
							+ "<td class='_hover_tr' style='text-align:left'>"
							+ getArrow( val.depth );	// 댓글이미지
					if(val.del == 0){	// 삭제되지 않은 글	
						app += "<a href='javascript:;' class='_seq' value='"+val.seq+"' style=' color: aqua;'>&nbsp;" 
						+ val.title + "</a>";
					}else{				// 삭제된 글
						app += "<font color='#ff0000'>* 이 글은 작성자에 의해서 삭제되었습니다 *</font>";
					}
					app += "</td>";
					app += "<td>" + val.readcount + "</td>";
					app += "<td>" + val.id + "</td>";
					//app += "<td>" + val.seq + "</td>";
					app += "</tr>";
						
				$("#_list_table").append(app);	
			});	
			
			
		},
		error:function(){
			alert('error');
		}
	});
}


// 글의 총수를 취득
function getBbsListCount() {
	
	$.ajax({
		url:"http://localhost:3000/bbslistCount",
		type:"get",
		data:{ page:0, choice:$("#_choice").val(), search:$("#_searchWord").val() },
		success:function( count ){
			//alert('success');
			loadPage(count);
		},
		error:function(){
			alert('error');
		}		
	});
}

//댓글 이미지 처리
function getArrow( depth ) {			
	let rs = "<img src='./image/arrow.png' width='15px' height='15px'/>";
	let nbsp = "&nbsp;&nbsp;&nbsp;&nbsp;";
	
	let ts = "";
	for(i = 0;i < depth; i++) {
		ts += nbsp;
	}
	
	return depth==0?"":ts + rs;
}

// paging 처리
function loadPage( totalCount ) {

	let pageSize = 10;
	let nowPage = 1;
	
	let _totalPages = totalCount / pageSize;
	if(totalCount % pageSize > 0){
		_totalPages++;
	}
	$("#pagination").twbsPagination('destroy'); //페이지 갱신: 초기화
	
	$("#pagination").twbsPagination({
	//	startPage: 1,
		totalPages: _totalPages,
		visiblePages: 10,
		first:'<span sria-hidden="true">«</span>',
		prev:"이전",
		next:"다음",
		last:'<span sria-hidden="true">»</span>',
		initiateStartPageClick:false,		// onPageClick 자동 실행되지 않도록 한다
		onPageClick:function(event, page){
			nowPage = page;
		//	alert('nowPage:' + page);
			getBbsListData( page - 1 );
		}
	});	
}

function updatemo() {
	
}



$(document).ready(function () {

	let login = sessionStorage.getItem("login");
	let json = JSON.parse(login); // String -> json
	//alert(json.id);
	let loginid = json.id;
	$("#_wid").val(json.id);	
	
	
	
$("#btnSearch").click(function () {
	if($("#_searchWord").val() == ""){
	    alert("검색어를 입력해 주십시오");
	}else{
	
	getBbsListData(0);
	getBbsListCount();
	}
});

$("#writeAf").click(function () {
	if($("#_title").val() == ""){
	    alert("제목을 입력해 주십시오");
	} else {
		$.ajax({
			url:"http://localhost:3000/bbswriteAf",
			type:"get",
			data:{ id:$('#_wid').val(), title: $('#_wtitle').val(), content: $('#_wcontent').val() },
			success:function( data ){
				//alert('success');
				//alert(data);
				$("#writeModal").modal('hide');
				getBbsListData(0);
				getBbsListCount();
			},
			error:function(){
				alert('error');
			}		
		});
	}
});

$(document).on("click", "._seq",function () { 
	var tseq=$(this).attr('value');
	//alert('click');
	//alert(tseq);
	//let seq = urlParams.seq;
	//alert("seq: " + seq);
	$.ajax({
		url:"http://localhost:3000/bbsdetail",
		type:"get",
		data:{seq:tseq },
		success:function( bbs ){
			//alert('success');
			$("#_did").val(bbs.id);
			$("#_dtitle").val(bbs.title);
			$("#_dreadcount").val(bbs.readcount);
			$("#_dcontent").val(bbs.content);
			$("#_dwdate").val(bbs.wdate);
			$("#_dinformation").val(bbs.ref + "-" + bbs.step + "-" + bbs.depth);
			$("#_dseq").val(bbs.seq);
			$("#detailModal").modal('show');
		},
		error:function(){
			alert('error');
		}		
		
		});
	
	});

$(document).on("click", "#updatebtn", function () {
	//alert(loginid);
	//alert($("#_dseq").val());
	if($('#_did').val() == loginid){
		alert('수정가능');
		//e.preventDefault();
		
		$("#_dtitle").removeAttr("readonly");
		$("#_dcontent").removeAttr("readonly");
		$(".modal-footer").append("<button type=\"button\" class=\"btn btn-secondary\" id=\"updateAf\">수정완료</button>");
		
	}else{
		alert('수정권한이 없습니다.');
	}
});

$(document).on("click", "#updateAf", function () {
	//alert('click');
	//alert($('#_dseq').val());
	$(this).remove();
	//$('#detailModal').modal('hide');
	$.ajax({
		url:"http://localhost:3000/updateAf",
		type:"get",
		data:{seq:$('#_dseq').val(), title:$('#_dtitle').val(), content:$('#_dcontent').val() },
		success:function( data ){
			//alert('success');
			
			$("#detailModal").modal('hide');
			alert(data);
			
			location.href = "bbslist.html";

			
		},
		error:function(){
			alert('error');
			}
	});
});

$(document).on("click", '#answerbtn', function(){
	//alert('click');
	//alert(json.id);
	
	let atab = "<table class=\"list_table\" style=\"width: 85%\" id=\"_list_table\">"
				+ "<input type=\"hidden\" size=\"20\" id=\"_aid\" name=\"id\" readonly=\"readonly\">"
				+	"<tr><th>제목</th>"
				+ "<td><input type=\"text\" size=\"20\" id=\"_atitle\" name=\"title\"></td>"
				+ "</tr>"
				+ "<tr><th>내용</th>"
				+ "<td><textarea rows=\"10\" cols=\"30\" id=\"_acontent\" name=\"content\"></textarea></td>"
				+ "</tr></table>";
	
	
	$(".modal-body").append(atab);
	
	$(".modal-footer").append("<button type=\"button\" class=\"btn btn-secondary\" id=\"answerAf\">답글완료</button>");
	//$(".modal-footer").append("<button type=\"button\" class=\"btn btn-secondary\" id=\"check\">확인용</button>");
	
	
});

$(document).on("click", '#answerAf', function(){
	//alert('click');
	
	//alert(json.id);
	$("#_aid").val(json.id);
	//alert($("#_aid").val());
	$(this).remove();
	$.ajax({
		url:"http://localhost:3000/answerAf",
		type:"get",
		data:{seq:$('#_dseq').val(), title:$('#detailModal #_atitle').val(), content:$('#detailModal #_acontent').val(), id:$("#_aid").val() },
		success:function( data ){
			//alert('success');
			
			$("#detailModal").modal('hide');
			alert(data);
			//getBbsListData(0);
			//getBbsListCount();
			location.href = "bbslist.html";
			
		},
		error:function(){
			alert('error');
			}
	});
	
	
});
$(document).on("click", '#check', function(){
	$("#_aid").val(json.id);
	alert($("#_aid").val());
	alert($("#detailModal #_atitle").val());
	alert($("#detailModal #_acontent").val());
});


$('#closebtn').click(function () {
	$('#detailModal').modal('hide');
	location.href = "bbslist.html";
});

});
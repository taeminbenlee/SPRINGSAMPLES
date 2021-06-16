
<%@page import="movie.MovieChart"%>
<%@page import="dto.MovieVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<MovieVo>list = MovieChart.getCGVData();
for(MovieVo v : list){
	System.out.println(v.toString());
}

String jsonData = "[";
for(MovieVo v : list){
	jsonData += "{ name:'" + v.getTitle() + "', y:" + v.getPercent() + "},";
}

jsonData = jsonData.substring(0, jsonData.lastIndexOf(","));

jsonData += "]";

System.out.println(jsonData);

request.setAttribute("jsonData", jsonData);




%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>
<style type="text/css">
.highcharts-figure, .highcharts-data-table table {
  min-width: 320px; 
  max-width: 800px;
  margin: 1em auto;
}

.highcharts-data-table table {
	font-family: Verdana, sans-serif;
	border-collapse: collapse;
	border: 1px solid #EBEBEB;
	margin: 10px auto;
	text-align: center;
	width: 100%;
	max-width: 500px;
}
.highcharts-data-table caption {
  padding: 1em 0;
  font-size: 1.2em;
  color: #555;
}
.highcharts-data-table th {
	font-weight: 600;
  padding: 0.5em;
}
.highcharts-data-table td, .highcharts-data-table th, .highcharts-data-table caption {
  padding: 0.5em;
}
.highcharts-data-table thead tr, .highcharts-data-table tr:nth-child(even) {
  background: #f8f8f8;
}
.highcharts-data-table tr:hover {
  background: #f1f7ff;
}


input[type="number"] {
	min-width: 50px;
}
</style>
</head>
<body>


<!-- 
crawling
웹이나  xml, json 을 통해서 데이터를 수집할 수 있는 기능

java -> 데이터 수집 <- 파이썬에서도함
		정형화 -> 2차원배열
		
		분석 -> 트레이딩
		
		결과 값 -> app, web
		
		

 -->

<figure class="highcharts-figure">
  <div id="container"></div>
  
</figure>


<script type="text/javascript">
Highcharts.chart('container', {
	  chart: {
	    plotBackgroundColor: null,
	    plotBorderWidth: null,
	    plotShadow: false,
	    type: 'pie'
	  },
	  title: {
	    text: '영화 예매율'
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
	    name: '예매율',
	    colorByPoint: true,
	    data: <%=request.getAttribute("jsonData")%>
	  }]
	});
</script>
</body>
</html>
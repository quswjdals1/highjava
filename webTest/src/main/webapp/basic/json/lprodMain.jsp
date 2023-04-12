<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table{
	margin: auto;
	border-collapse: collapse;
}
td{
	width: 100px;
	height: 50px;
}
#box, #result{
	text-align: center;
}
</style>
<script src="../../js/jquery-3.6.4.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(()=>{
	$("#lprodBtn").on("click",function(){
		
		$.ajax({
			url : "<%=request.getContextPath()%>/lprodList.do",
			type: "get",
			dataType: "json",
			success : function(res){
				table = "<table border='1'>"
				table +="<tr><td>id</td><td>gu</td><td>nm</td></tr>"
				
				$.each(res,function(i,v){
					table+=`<tr><td>\${v["lprod_id"]}</td><td>\${v["lprod_gu"]}</td><td>\${v["lprod_nm"]}</td></tr>`
				})
				table+="</table>"
				$("#result").html(table);
			},
			error : function(xhr){
				alert("상태: "+xhr.status)
			}
		})
	})
	
})
</script>

</head>
<body>

<!--  
	아래의 lprod자료 가져오기 버튼을 클릭하면 db의 lprod테이블의 전체 데이터를 가져와
	id 가 'result'인 <div> 태그에 table태그로 출력하시오.
	(ajax,mvc패턴 사용, 서블릿url패턴: /lprodList.do)
-->

<div id="box">
	<form>
		<input type="button" id ="lprodBtn" value="Lprod자료 가져오기">
		<h3>Lprod 자료목록</h3>
		<div id="result"></div>
	</form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath() %>/js/jquery-3.6.4.min.js" type="text/javascript"></script>

<script type="text/javascript">
$(()=>{
	path = "<%=request.getContextPath()%>";
	$.ajax({
		url : "<%=request.getContextPath()%>/memberList.do",
		type : "get",
		dataType : "json",
		success : function(res){
			table = "<table border='1'>"
			table += "<tr><td colspan='5'><input type='button' id='addbtn' value='회원추가'></td></tr>"
			table += "<tr><td>아이디</td><td>비밀번호</td><td>이름</td><td>전화번호</td><td>주소</td></tr>"
			$.each(res,function(i,v){
				table +=`<tr><td><a href='\${path}/memberInfo.do?mem_id=\${v["mem_id"]}'>\${v["mem_id"]}<a></td><td>\${v["mem_pass"]}</td><td>\${v["mem_name"]}</td><td>\${v["mem_tel"]}</td><td>\${v["mem_addr"]}</td></tr>`
			})
			table +="</table>"
			$("#result").html(table);
		},
		error : function(xhr){
			alert("상태: "+xhr.status)
		}
	})
	
	
	$(document).on("click","#addbtn",function(){
		location.href="<%=request.getContextPath()%>/member/memberAdd.jsp"
	})
})
</script>
</head>
<body>
<div id="result"></div>
</body>
</html>
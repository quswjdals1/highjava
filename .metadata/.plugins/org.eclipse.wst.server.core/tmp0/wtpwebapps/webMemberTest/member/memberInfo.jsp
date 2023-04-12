<%@page import="member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath() %>/js/jquery-3.6.4.min.js" type="text/javascript"></script>
<style type="text/css">
img{
	width: 500px;
	height: 500px;
}
</style>
<% 
	MemberVO memberVO=(MemberVO)request.getAttribute("memberVo");
%>
<script type="text/javascript">

$(()=>{
	$("#back").on("click",function(){
		location.href="<%=request.getContextPath()%>/member/memberList.jsp"
	})
	
	$("#remove").on("click",function(){
		location.href="<%=request.getContextPath()%>/memberDelete.do?id="+$("#id").text();
	})
	
	$("#modify").on("click",function(){
		location.href="<%=request.getContextPath()%>/modifyForm.do?id="+$("#id").text();
	})
})
	
</script>

</head>

<body>
	<table border="1">
		<tr>
			<td colspan="2"><img alt="" src="<%=request.getContextPath()%>/memberInfo/image.do?id=<%=memberVO.getMem_id()%>"></td>
		</tr>
		<tr>
			<td>회원id</td>
			<td id="id"><%=memberVO.getMem_id() %></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><%=memberVO.getMem_pass() %></td>
		</tr>
		<tr>
			<td>회원이름</td>
			<td><%=memberVO.getMem_name() %></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><%=memberVO.getMem_tel() %></td>
		</tr>
		<tr>
			<td>회원주소</td>
			<td><%=memberVO.getMem_addr() %></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" id="modify" value="수정">
				<input type="button" id="remove" value="삭제">
				<input type="button" id="back" value="회원목록">
			</td>
		</tr>
	</table>
</body>
</html>
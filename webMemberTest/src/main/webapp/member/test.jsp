<%@page import="member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	MemberVO memberVO = new MemberVO();
	memberVO.setMem_id("test");
	memberVO.setMem_addr("test");
	memberVO.setMem_name("test");
	memberVO.setMem_pass("test");
	memberVO.setMem_tel("test");
	
%>
<body>
<form id="form" action="<%=request.getContextPath()%>/memberModify.do" method="post"
		enctype="multipart/form-data">
		
	<table border="1">
		<tr>
			<td>회원id</td>
			<td id="id"><%=memberVO.getMem_id() %></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="pw" value="<%=memberVO.getMem_pass() %>" ></td>
		</tr>
		<tr>
			<td>회원이름</td>
			<td><input type="text" name="name" value="<%=memberVO.getMem_name() %>" ></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type= "text" name="tel" value="<%=memberVO.getMem_tel() %>" ></td>
		</tr>
		<tr>
			<td>회원주소</td>
			<td><input type="text" name="add" value="<%=memberVO.getMem_addr() %>"  ></td>
		</tr>
		<tr>
			<td>파일업로드</td>
			<td><input type = "file"  name="file" ></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="저장">
				<input type="button" id="cancle" value="취소">
				<input type="button" id="back" value="회원목록">
			</td>
		</tr>
	</table>
</form>
</body>
</html>
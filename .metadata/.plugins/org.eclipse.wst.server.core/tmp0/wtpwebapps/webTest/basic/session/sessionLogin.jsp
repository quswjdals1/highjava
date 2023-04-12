<%@page import="kr.or.ddit.basic.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 
	// session정보를 가져온다. --> jsp문서에서 httpsession객체는 'session'이라는 이름으로 저장되어 있음
	MemberVO memberVO=(MemberVO)session.getAttribute("member");
	String loginID=null;
	if(memberVO!=null){
		 loginID = memberVO.getMem_id();
	}
%>

<% 
	if(loginID==null){
%>		


<form action="<%=request.getContextPath()%>/sessionLoginDB.do" method="post">
	<table border="1">
		<tr>
			<td>id</td>
			<td><input type="text" name="id" val=""></td>
		</tr>
		<tr>
			<td>pass</td>
			<td><input type="text" name="pass" val=""></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="Login">
			</td>
		</tr>
	</table>
</form>
<%
	}else{
%>
	<h3><%=loginID %>님 반갑습니다.</h3>
	<a href="<%=request.getContextPath()%>/sessionLogout.do">로그아웃</a>
<%
}
%>
</body>
</html>
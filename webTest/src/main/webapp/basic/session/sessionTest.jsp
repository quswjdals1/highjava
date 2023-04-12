<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session 연습</title>
</head>
<body>

<%
//jsp 문서에서 session정보가 session이라는 이름으로 자동으로 저장되어 있다.
//그래서 그냥 사용하면된다.

%>

<%=session.getAttribute("userName")%>
<a href="<%=request.getContextPath()%>/sessionAdd.do">Session 정보 저장하기</a>
<a href="<%=request.getContextPath()%>/sessionRead.do">Session 정보 확인하기</a>
<a href="<%=request.getContextPath()%>/sessionDel.do">Session 정보 삭제하기</a>
</body>
</html>
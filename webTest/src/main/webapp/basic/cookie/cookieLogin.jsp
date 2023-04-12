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
		String id="";
		Cookie c[]=request.getCookies();
		for(Cookie cookie: c){
			if(cookie.getName().equals("cid")){
				id=cookie.getValue().trim(); 
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
%>
<form action="<%=request.getContextPath()%>/cookieLoginServlet.do">
	id: <input type="text" name="id" value="<%if(!id.equals("")){out.print(id);}%>"> <br>
	pass: <input type="text" name="pass"> <br>
	<input type="checkbox" name="idcookie" value="true">id 기억하기 <br>
	<input type="submit" value="login">
</form>

</body>
</html>
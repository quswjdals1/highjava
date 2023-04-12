<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2> File Upload 연습</h2>
<!-- 
	파일업로드용 form테그는 반드시 method는 post, enctype은 multipart/form-data라고 지정해
	주어야 한다.
 -->
<form action="<%=request.getContextPath()%>/fileUpload.do" method="post"
		enctype="multipart/form-data">
	작성자 이름 : <input type="text" name="username"><br><br>
	한 개의 파일 선택: <input type="file" name="upFile1"><br><br>
	여러개의 파일 선택: <input type="file" name="upFile2" multiple><br><br>
	
	<input type="submit" value="전 송">
</form>
<br><hr><br>

<a href="<%=request.getContextPath()%>/fileList.do"> 전체 파일목록 보기</a>

</body>
</html>
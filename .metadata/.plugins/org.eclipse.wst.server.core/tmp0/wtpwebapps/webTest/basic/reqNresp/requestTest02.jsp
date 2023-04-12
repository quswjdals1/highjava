<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>request 연습</h3>
<hr>
<!-- 
	아래의 form 태그에서 구성한 데이터를 이용하여 계산된 결과를 출력하는 웹프로그램을 작성하시오
	(처리할 서블릿 url패턴: /requestTest02.do)
숫자 입력은 정수형으로 입력한다.
 -->
<form action="/webTest/requestTest02.do">
<table border='1'>
	<tr>
		<td>
			<input type="text" size="10" name="fv">
		</td>
		<td>
			<select name="opr">
				<option value="+">+</option>
				<option value="-">-</option>
				<option value="*">*</option>
				<option value="/">/</option>
				<option value="%">%</option>
			</select>
		</td>
		<td>
			<input type="text" size="10" name="sv">
		</td>
		<td>
			<input type="submit" value="계산하기" >
		</td>
	</tr>
</table>
</form>
</body>
</html>
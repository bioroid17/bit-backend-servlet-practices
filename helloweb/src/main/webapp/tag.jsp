<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello World</h1>
	<h2>Hello World</h2>
	<h3>Hello World</h3>
	<h4>Hello World</h4>
	<h5>Hello World</h5>
	<h6>Hello World</h6>
	
	<table border="1">
		<tr>
			<td>글번호</td>
			<td>글제목</td>
			<td>작성자</td>
		</tr>
		<tr>
			<td>1</td>
			<td>안녕</td>
			<td>둘리</td>
		</tr>
		<tr>
			<td>2</td>
			<td>안녕</td>
			<td>마이콜</td>
		</tr>
	</table>
	
	<%-- /는 최상위 경로 = webapp --%>
	<img src="/helloweb/assets/images/mmzero_wallpaper.jpg" style="width:400px;">
	<p>
		문장입니다.<br>
		문장입니다.<br>
		문장입니다.<br>
	</p>
	
	<%-- link는 GET 방식만 가능 --%>
	<a href="/helloweb/hello?no=10&age=20">hello으로 가기</a>
	<%-- POST 방식은 form을 써야 한다. --%>
	<a href="/helloweb/form.jsp">form으로 가기</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String s = "Hello World";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><%="Hello World" %></h1>
<h1><%=s %></h1>
<h1><%=s.toUpperCase() %></h1>
<h1><%="Hello" + " " + "World" %></h1>
</body>
</html>
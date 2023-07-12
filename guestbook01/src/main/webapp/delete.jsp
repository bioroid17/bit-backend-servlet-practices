<%@page import="com.bitacademy.guestbook.dao.GuestbookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String no = request.getParameter("no");
	String password = request.getParameter("password");
	
	GuestbookDao dao = new GuestbookDao();
	boolean equal = dao.checkPassword(no, password);
	
	if (equal){
		dao.delete(no);
		response.sendRedirect("/guestbook01");
	} else {
%>
<h6>비밀번호가 일치하지 않습니다.</h6>
<a href="/guestbook01">메인으로 돌아가기</a>
<%
	}
%>

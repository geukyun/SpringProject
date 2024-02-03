<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%

	// 로그아웃을 요청한 브라우저와 매핑된 세션 객체를 획득한다.
	// 획득한 세션을 강제종료하고 메인 페이지로 이동한다.
	session.invalidate();

	response.sendRedirect("login.jsp");

%>
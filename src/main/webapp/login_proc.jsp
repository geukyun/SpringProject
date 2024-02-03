<%@page import="com.ssamz.biz.user.UserVO"%>
<%@page import="com.ssamz.biz.user.impl.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	// 1. 사용자 입력정보 추출
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	
	// 2. DB 연동 처리
	UserVO vo = new UserVO();
	vo.setId(id);
	vo.setPassword(password);
	
	UserDAO userDAO = new UserDAO();
	UserVO user = userDAO.getUser(vo);
	
	// 3. 화면 네비게이션
	if(user!=null){
		// 로그인 성공한 경우
		response.sendRedirect("getBoardList.jsp");
	}else{
		// 로그인 실패한 경우
		response.sendRedirect("login.jsp");
	}
%>
<%@page import="com.ssamz.biz.user.UserVO"%>
<%@page import="com.ssamz.biz.user.impl.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	// 1. ����� �Է����� ����
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	
	// 2. DB ���� ó��
	UserVO vo = new UserVO();
	vo.setId(id);
	vo.setPassword(password);
	
	UserDAO userDAO = new UserDAO();
	UserVO user = userDAO.getUser(vo);
	
	// 3. ȭ�� �׺���̼�
	if(user!=null){
		// �α��� ������ ���
		response.sendRedirect("getBoardList.jsp");
	}else{
		// �α��� ������ ���
		response.sendRedirect("login.jsp");
	}
%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%

	// �α׾ƿ��� ��û�� �������� ���ε� ���� ��ü�� ȹ���Ѵ�.
	// ȹ���� ������ ���������ϰ� ���� �������� �̵��Ѵ�.
	session.invalidate();

	response.sendRedirect("login.jsp");

%>
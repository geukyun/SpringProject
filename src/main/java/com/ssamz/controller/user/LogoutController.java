package com.ssamz.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssamz.controller.Controller;

public class LogoutController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�α׾ƿ� ó��");
		
		// �α׾ƿ��� ��û�� �������� ���ε� ���� ��ü�� ȹ���Ѵ�.
		HttpSession session = request.getSession();
		
		// ȹ���� ������ ���������ϰ� ���� �������� �̵��Ѵ�.
		session.invalidate();

		return "login.jsp";
	}

}

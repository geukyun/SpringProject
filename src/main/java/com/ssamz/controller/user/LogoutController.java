package com.ssamz.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LogoutController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�α׾ƿ� ó��");

		// �α׾ƿ��� ��û�� �������� ���ε� ���� ��ü�� ȹ���Ѵ�.
		HttpSession session = request.getSession();

		// ȹ���� ������ ���������ϰ� ���� �������� �̵��Ѵ�.
		session.invalidate();

		// 3. ȭ�� �׺���̼�(�̵��� ȭ�� ������ ModelAndView�� ����Ͽ� �����Ѵ�.)
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:login.do");
		return mav;
	}

}

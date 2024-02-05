package com.ssamz.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssamz.controller.Controller;

public class LogoutController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그아웃 처리");
		
		// 로그아웃을 요청한 브라우저와 매핑된 세션 객체를 획득한다.
		HttpSession session = request.getSession();
		
		// 획득한 세션을 강제종료하고 메인 페이지로 이동한다.
		session.invalidate();

		return "login.jsp";
	}

}

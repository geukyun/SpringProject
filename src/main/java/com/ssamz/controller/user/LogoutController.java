package com.ssamz.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController{

	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println("로그아웃 처리");
		// 획득한 세션을 강제종료하고 메인 페이지로 이동한다.
		session.invalidate();
		return "redirect:login.jsp";
	}

}

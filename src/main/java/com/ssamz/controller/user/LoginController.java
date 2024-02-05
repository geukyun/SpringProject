package com.ssamz.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssamz.biz.user.UserVO;
import com.ssamz.biz.user.impl.UserDAO;
import com.ssamz.controller.Controller;

public class LoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그인 인증 처리");

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
		if (user != null) {
			// 로그인 성공한 경우
//			HttpSession session = request.getSession();
//			session.setAttribute("user", user);
			return "getBoardList.do";
		} else {
			// 로그인 실패한 경우
			return "login.jsp";
		}
	}

}

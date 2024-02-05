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
		System.out.println("�α��� ���� ó��");

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
		if (user != null) {
			// �α��� ������ ���
//			HttpSession session = request.getSession();
//			session.setAttribute("user", user);
			return "getBoardList.do";
		} else {
			// �α��� ������ ���
			return "login.jsp";
		}
	}

}

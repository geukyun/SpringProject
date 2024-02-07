package com.ssamz.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ssamz.biz.board.BoardVO;
import com.ssamz.biz.board.impl.BoardDAO;

public class InsertBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�۵�� ó��");

		// 1. ����� �Է����� ����
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");

		// 2. DB ���� ó��
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);

		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(vo);

		// 3. ȭ�� �׺���̼�(�̵��� ȭ�� ������ ModelAndView�� ����Ͽ� �����Ѵ�.)
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getBoardList.do");
		return mav;
	}

}

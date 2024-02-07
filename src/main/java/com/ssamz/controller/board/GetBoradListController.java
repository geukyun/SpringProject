package com.ssamz.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ssamz.biz.board.BoardVO;
import com.ssamz.biz.board.impl.BoardDAO;

public class GetBoradListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�۸�� ����Ʈ ó��");

		// 1. DB ���� ó��
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);

		// 2. Model(DAO)�� �̿��ؼ� �˻��� �����͸� View(JSP) ȭ�鿡�� ����� �� �ֵ��� ���ǿ� ����Ѵ�.
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);

		// 3. ȭ�� �׺���̼�(�̵��� ȭ�� ������ ModelAndView�� ����Ͽ� �����Ѵ�.)
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getBoardList.jsp");
		return mav;
	}

}

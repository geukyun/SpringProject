package com.ssamz.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssamz.biz.board.BoardVO;
import com.ssamz.biz.board.impl.BoardDAO;

@Controller
public class BoardController {

	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�۵�� ó��");
		boardDAO.insertBoard(vo);
		return "forward:getBoardList.do";
	}

	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�۵�� ó��");
		boardDAO.updateBoard(vo);
		return "forward:getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�۵�� ó��");
		boardDAO.deleteBoard(vo);
		return "forward:getBoardList.do";
	}
	
	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("�۸�� ó��");
		mav.addObject("board", boardDAO.getBoard(vo));
		mav.setViewName("getBoard");
		return mav;
	}
	
	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("�۸�� ����Ʈ ó��");
		// ModelAndView ��ü�� �˻� ����� View �̸��� �����Ѵ�.
		// ModelAndView�� ����� �˻� ����� �ڵ����� request�� ��ϵȴ�.
		mav.addObject("boardList", boardDAO.getBoardList(vo));
		mav.setViewName("getBoardList");
		return mav;
	}
	
	
}
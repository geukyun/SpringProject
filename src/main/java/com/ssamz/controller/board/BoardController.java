package com.ssamz.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ssamz.biz.board.BoardVO;
import com.ssamz.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
	
	@RequestMapping(value="/insertBoard.do", method = RequestMethod.GET)
	public String insertBoard() {
		System.out.println("�۵�� ó��_1");
		return "insertBoard";
	}
	
	@RequestMapping(value="/insertBoard.do", method = RequestMethod.POST)
	public ModelAndView insertBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("�۵�� ó��_2");
		boardDAO.insertBoard(vo);
		mav.setViewName("forward:getBoardList.do");
		return mav;
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
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("�۸�� ó��");
		model.addAttribute("board", boardDAO.getBoard(vo));
		return "getBoard";
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("�۸�� ����Ʈ ó��");
		// ModelAndView ��ü�� �˻� ����� View �̸��� �����Ѵ�.
		// ModelAndView�� ����� �˻� ����� �ڵ����� request�� ��ϵȴ�.
		// Model�� ����� �˻� ����� �ڵ����� request�� ��ϵȴ�.
		model.addAttribute("boardList", boardDAO.getBoardList(vo));
		return "getBoardList";
	}
	
	
}

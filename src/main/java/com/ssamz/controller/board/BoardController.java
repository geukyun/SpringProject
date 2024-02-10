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
		System.out.println("글등록 처리_1");
		return "insertBoard";
	}
	
	@RequestMapping(value="/insertBoard.do", method = RequestMethod.POST)
	public ModelAndView insertBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("글등록 처리_2");
		boardDAO.insertBoard(vo);
		mav.setViewName("forward:getBoardList.do");
		return mav;
	}

	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글등록 처리");
		boardDAO.updateBoard(vo);
		return "forward:getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글등록 처리");
		boardDAO.deleteBoard(vo);
		return "forward:getBoardList.do";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("글목록 처리");
		model.addAttribute("board", boardDAO.getBoard(vo));
		return "getBoard";
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("글목록 리스트 처리");
		// ModelAndView 객체에 검색 결과와 View 이름을 저장한다.
		// ModelAndView에 저장된 검색 결과는 자동으로 request에 등록된다.
		// Model에 저장된 검색 결과는 자동으로 request에 등록된다.
		model.addAttribute("boardList", boardDAO.getBoardList(vo));
		return "getBoardList";
	}
	
	
}

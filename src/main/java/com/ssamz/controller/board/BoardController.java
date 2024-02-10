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
		System.out.println("글등록 처리");
		boardDAO.insertBoard(vo);
		return "forward:getBoardList.do";
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
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("글목록 처리");
		mav.addObject("board", boardDAO.getBoard(vo));
		mav.setViewName("getBoard");
		return mav;
	}
	
	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("글목록 리스트 처리");
		// ModelAndView 객체에 검색 결과와 View 이름을 저장한다.
		// ModelAndView에 저장된 검색 결과는 자동으로 request에 등록된다.
		mav.addObject("boardList", boardDAO.getBoardList(vo));
		mav.setViewName("getBoardList");
		return mav;
	}
	
	
}

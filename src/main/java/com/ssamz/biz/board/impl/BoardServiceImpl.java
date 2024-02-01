package com.ssamz.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssamz.biz.board.BoardService;
import com.ssamz.biz.board.BoardVO;
 
// Service 구현 클래스
@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired	// Type Injection
	private BoardDAO boardDAO;
	
	public void insertBoard(BoardVO vo) {
		if(vo.getSeq()==0) {
			throw new IllegalArgumentException();
		}
		
		boardDAO.insertBoard(vo);
	}

	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}

}

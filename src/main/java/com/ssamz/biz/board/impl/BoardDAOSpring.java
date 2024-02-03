package com.ssamz.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ssamz.biz.board.BoardVO;

// DAO(Data Access Object)
@Repository
public class BoardDAOSpring {
	
	@Autowired
	private JdbcTemplate spring;
	
	// SQL 명령어들
	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values ((select nvl(max(seq), 0)+1 from board),?,?,?)";
	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete from board where seq=?";
	private final String BOARD_GET	  = "select * from board where seq=?";
	private final String BOARD_LIST	  = "select * from board order by seq desc";
	
	// CRUD 기능의 메소드 구현
	// 글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===> SPRING로 insertBoard() 기능 처리");
		spring.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	
	// 글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> SPRING로 updateBoard() 기능 처리");
		spring.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
		
	}
	
	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> SPRING로 deleteBoard() 기능 처리");
		spring.update(BOARD_DELETE, vo.getSeq());
		
	}
	
	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> SPRING로 getBoard() 기능 처리");
		Object[] params = {vo.getSeq()};
		return spring.queryForObject(BOARD_GET, params, new BoardRowMapper());
	}
	
	// 글 상세 조회
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> SPRING로 getBoardList() 기능 처리");
		return spring.query(BOARD_LIST, new BoardRowMapper());
	}
}

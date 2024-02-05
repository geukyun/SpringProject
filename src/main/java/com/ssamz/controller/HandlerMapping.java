package com.ssamz.controller;

import java.util.HashMap;
import java.util.Map;

import com.ssamz.controller.board.DeleteBoardController;
import com.ssamz.controller.board.GetBoardController;
import com.ssamz.controller.board.GetBoradListController;
import com.ssamz.controller.board.InsertBoardController;
import com.ssamz.controller.board.UpdateBoardController;
import com.ssamz.controller.user.LoginController;
import com.ssamz.controller.user.LogoutController;

public class HandlerMapping {

	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		// 온갖 Controller 객체를 HashMap에 등록한다.
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", 		 new LoginController());
		mappings.put("/logout.do", 		 new LogoutController());
		mappings.put("/insertBoard.do",  new InsertBoardController());
		mappings.put("/updateBoard.do",  new UpdateBoardController());
		mappings.put("/deleteBoard.do",  new DeleteBoardController());
		mappings.put("/getBoard.do", 	 new GetBoardController());
		mappings.put("/getBoardList.do", new GetBoradListController());
	}
	
	public Controller getContrller(String path) {
		// 요청 path Controller 객체를 검색하여 리턴한다.
		return mappings.get(path);
	}

}

package com.DDinside.action;

import com.DDinside.IdolBoard.*;




// 객체를 생성해서 클래스르 따로 설계해서 작업하는 것을 팩토리 패턴이라고 한다.
// 요청이 들어오면 이에 해당하는 액션 객체를 생성해주는 클래스이다.

public class IdolActionFactory {
	private IdolActionFactory() {}
	private static IdolActionFactory instance = new IdolActionFactory();
	public static IdolActionFactory getInstance() {return instance;}

	public Action getAction(String command) {
		Action action = null;
		String board_id ="Idol";

		if (command.equals(board_id+"_BoardList")) {
			action = new Idol_BoardListAction(board_id);
		} else if (command.equals(board_id+"_BoardWrite")) {
			action = new Idol_BoardWriteAction(board_id);
		} else if (command.equals(board_id+"_BoardView")) {
			action = new Idol_BoardViewAction(board_id);
		} else if (command.equals(board_id+"_PostEdit")) {
			action = new Idol_BoardEditAction(board_id);
		} else if (command.equals(board_id+"_BoardReWrite")) {
			action = new Idol_BoardReWriteAction(board_id);
		} else if (command.equals(board_id+"_BoardDelete")) {
			action = new Idol_BoardDeleteAction(board_id);
		} else if (command.equals(board_id+"_BoardComment")) {
			action = new Idol_BoardCommentAction(board_id);
		} else if (command.equals(board_id+"_PostUp")) {
			action = new Idol_PostUpAction(board_id);
		} else if (command.equals(board_id+"_PostDown")) {
			action = new Idol_PostDownAction(board_id);
		} else if (command.equals(board_id+"_PostAho")) {
			action = new Idol_PostAhoAction(board_id);
		} else if (command.equals(board_id+"_Search")) {
			action = new Idol_SearchAction(board_id);
		} else if (command.equals(board_id+"_CommentEdit")) {
			action = new Idol_CommentEditAction(board_id);
		} else if (command.equals(board_id+"_CommentDelete")) {
			action = new Idol_CommentDeleteAction(board_id);
		} else if (command.equals(board_id+"_BoardCommentReWrite")) {
			action = new Idol_BoardCommentReWriteAction(board_id);
		} else if(command.equals(board_id+"_Page")) { 
			action = new Idol_BoardListAction(board_id);
		} else if(command.equals(board_id+"_PostReport")) {
			action = new Idol_PostReportAction(board_id);
		} 
		return action;
	}

}

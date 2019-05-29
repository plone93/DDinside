package com.DDinside.action;

import com.DDinside.Board.*;





// 객체를 생성해서 클래스르 따로 설계해서 작업하는 것을 팩토리 패턴이라고 한다.
// 요청이 들어오면 이에 해당하는 액션 객체를 생성해주는 클래스이다.

public class BoardActionFactory {
	private BoardActionFactory() {}
	private static BoardActionFactory instance = new BoardActionFactory();
	public static BoardActionFactory getInstance() {return instance;}

	public Action getAction(String command, String board_id) {
		
		Action action = null;

		if (command.equals("BoardList")) {
			action = new BoardListAction(board_id);
		} else if (command.equals("BoardWrite")) {
			action = new BoardWriteAction(board_id);
		} else if (command.equals("BoardView")) {
			action = new BoardViewAction(board_id);
		} else if (command.equals("PostEdit")) {
			action = new BoardEditAction(board_id);
		} else if (command.equals("BoardReWrite")) {
			action = new BoardReWriteAction(board_id);
		} else if (command.equals("BoardDelete")) {
			action = new BoardDeleteAction(board_id);
		} else if (command.equals("BoardComment")) {
			action = new BoardCommentAction(board_id);
		} else if (command.equals("PostUp")) {
			action = new PostUpAction(board_id);
		} else if (command.equals("PostDown")) {
			action = new PostDownAction(board_id);
		} else if (command.equals("PostAho")) {
			action = new PostAhoAction(board_id);
		} else if (command.equals("Search")) {
			action = new SearchAction(board_id);
		} else if (command.equals("CommentEdit")) {
			action = new CommentEditAction(board_id);
		} else if (command.equals("CommentDelete")) {
			action = new CommentDeleteAction(board_id);
		} else if (command.equals("BoardCommentReWrite")) {
			action = new BoardCommentReWriteAction(board_id);
		} else if(command.equals("Page")) { 
			action = new BoardListAction(board_id);
		} else if(command.equals("PostReport")) {
			action = new PostReportAction(board_id);
		} else if(command.equals("Main")) {
			action = new MainAction();
		} 
		return action;
	}

}

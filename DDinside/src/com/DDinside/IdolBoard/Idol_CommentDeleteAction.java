package com.DDinside.IdolBoard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DDinside.action.Action;
import com.DDinside.dao.DDinsideDAO;

public class Idol_CommentDeleteAction implements Action{
	String board_id;
	public Idol_CommentDeleteAction(String board_id) {
		this.board_id = board_id;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String board_num = request.getParameter("board_num");
		String comment_num = request.getParameter("num");
		String url = "controller?command="+board_id+"_BoardView&num="+board_num;

		DDinsideDAO boardDAO = DDinsideDAO.getInstance();
		boardDAO.commentDelete(comment_num, board_id);
		
		response.sendRedirect(url);
	}

}

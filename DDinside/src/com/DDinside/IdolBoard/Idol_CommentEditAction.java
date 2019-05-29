package com.DDinside.IdolBoard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DDinside.action.Action;
import com.DDinside.dao.DDinsideDAO;
import com.DDinside.dto.CommentVO;

public class Idol_CommentEditAction implements Action{
	String board_id;
	public Idol_CommentEditAction(String board_id) {
		this.board_id = board_id;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String url = board_id+"_Board/"+board_id+"_BoardCommentEdit.jsp";
		String num = request.getParameter("num");
		String board_num = request.getParameter("board_num");
		
		
		DDinsideDAO boardDAO = DDinsideDAO.getInstance();
		CommentVO commentVO = boardDAO.commentView(num, board_id);
		request.setAttribute("commentEditView", commentVO);
		request.setAttribute("board_num", board_num);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}

package com.DDinside.Board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DDinside.action.Action;
import com.DDinside.dao.DDinsideDAO;
import com.DDinside.dao.Suv_DDinsideDAO;
import com.DDinside.dto.CommentVO;

public class CommentEditAction implements Action{
	String board_id;
	public CommentEditAction(String board_id) {
		this.board_id = board_id;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String url = "Board/BoardCommentEdit.jsp";
		String num = request.getParameter("num");
		String board_num = request.getParameter("board_num");
		CommentVO commentVO = new CommentVO();
		
		DDinsideDAO boardDAO = DDinsideDAO.getInstance();
		Suv_DDinsideDAO suv_boardDAO = Suv_DDinsideDAO.getInstance();

		if(board_id.equals("高評価") || board_id.equals("低評価") || board_id.equals("アホ") || board_id.equals("統合")) {
			commentVO = suv_boardDAO.commentView(num, board_id);
		} else {
			commentVO = boardDAO.commentView(num, board_id);
		}
		
		request.setAttribute("commentEditView", commentVO);
		request.setAttribute("board_num", board_num);
		
		request.setAttribute("board_id", board_id);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}

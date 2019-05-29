package com.DDinside.Board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DDinside.action.Action;
import com.DDinside.dao.Suv_DDinsideDAO;
import com.DDinside.dao.DDinsideDAO;
import com.DDinside.dto.CommentVO;

public class BoardCommentAction implements Action {
	String board_id;
	public BoardCommentAction(String board_id) {
		this.board_id = board_id;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String num = request.getParameter("num");
		String url = "controller?command=BoardView&num="+num+"&board_id="+board_id;

		CommentVO commentVO = new CommentVO();
		commentVO.setBoard_num(Integer.parseInt(request.getParameter("num")));
		commentVO.setWriter_id(request.getParameter("id"));
		commentVO.setWriter_name(request.getParameter("name"));
		commentVO.setBoard_title(request.getParameter("title"));
		commentVO.setContent(request.getParameter("content"));
		
		/*
		 * String content = request.getParameter("content"); content =
		 * content.replace("\r\n","<br>"); commentVO.setContent(content);
		 */
		
		DDinsideDAO boardDAO = DDinsideDAO.getInstance();
		Suv_DDinsideDAO suv_boardDAO = Suv_DDinsideDAO.getInstance();

		if(board_id.equals("高評価") || board_id.equals("低評価") || board_id.equals("アホ") || board_id.equals("統合")) {
			suv_boardDAO.insertComment(commentVO, board_id);
		} else {
			boardDAO.insertComment(commentVO, board_id);
		}
		request.setAttribute("board_id", board_id);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		

		
	}

}

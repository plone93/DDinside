package com.DDinside.IdolBoard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DDinside.action.Action;
import com.DDinside.dao.DDinsideDAO;
import com.DDinside.dto.CommentVO;

public class Idol_BoardCommentReWriteAction implements Action{
	String board_id;
	public Idol_BoardCommentReWriteAction(String board_id) {
		this.board_id = board_id;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String board_num = request.getParameter("board_num");
		String url = "controller?command="+board_id+"_BoardView&num="+board_num;
		
		CommentVO commentVO = new CommentVO();
		commentVO.setNum(Integer.parseInt(request.getParameter("comment_num")));
		commentVO.setContent(request.getParameter("content"));
		
		DDinsideDAO boardDAO = DDinsideDAO.getInstance();
		boardDAO.updateComment(commentVO, board_id); // 콘텐트만 들어있음
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
	}

}

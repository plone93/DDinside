package com.DDinside.IdolBoard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DDinside.action.Action;
import com.DDinside.dao.DDinsideDAO;
import com.DDinside.dto.CommentVO;

public class Idol_BoardCommentAction implements Action {
	String board_id;
	public Idol_BoardCommentAction(String board_id) {
		this.board_id = board_id;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String num = request.getParameter("num");
		String url = "controller?command="+board_id+"_BoardView&num="+num;
		
		CommentVO commentVO = new CommentVO();
		commentVO.setBoard_num(Integer.parseInt(request.getParameter("num")));
		commentVO.setWriter_id(request.getParameter("id"));
		commentVO.setWriter_name(request.getParameter("name"));
		commentVO.setBoard_title(request.getParameter("title"));
		
		String content = request.getParameter("content");
		content = content.replace("\r\n","<br>");
		commentVO.setContent(content);
		
		DDinsideDAO boardDAO = DDinsideDAO.getInstance();
		boardDAO.insertComment(commentVO, board_id);
		
		response.sendRedirect(url);
		

		
	}

}

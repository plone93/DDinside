package com.DDinside.IdolBoard;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DDinside.action.Action;
import com.DDinside.dao.DDinsideDAO;
import com.DDinside.dto.BoardVO;
import com.DDinside.dto.CommentVO;
import com.DDinside.dto.CountVO;


public class Idol_BoardViewAction implements Action{
	String board_id;
	public Idol_BoardViewAction(String board_id) {
		this.board_id = board_id;
	}

	//게시글과 댓글을 둘다 처리
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = board_id+"_Board/"+board_id+"_BoardView.jsp";
		String num = request.getParameter("num");
		
		DDinsideDAO boardDAO = DDinsideDAO.getInstance();
		
		boardDAO.updateReadCount(num, board_id);
		int readcount = boardDAO.getReadCount(num, board_id);
		request.setAttribute("readcount", readcount);
		
		BoardVO boardVO = boardDAO.BoardView(num, board_id);
		CountVO countVO = boardDAO.getPostCount(num, board_id);
		
		String writer = boardDAO.selectUserId(num, board_id);
		request.setAttribute("writer", writer);
		
		List<CommentVO> commentList = boardDAO.selectComment(num, board_id);
		request.setAttribute("comment", commentList);
		
		int count = boardDAO.tableCount(board_id);
		request.setAttribute("listCount", count);	
		
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		List<BoardVO> list = boardDAO.selectAllBoard(page, board_id);
		request.setAttribute("boardList", list);
		
		request.setAttribute("boardView", boardVO);
		request.setAttribute("PostCount", countVO);
		
		List<BoardVO> noticeList = boardDAO.selectNotice();
		request.setAttribute("NoticeList", noticeList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
						
	}

}

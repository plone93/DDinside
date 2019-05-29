package com.DDinside.Board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DDinside.action.Action;
import com.DDinside.dao.Suv_DDinsideDAO;
import com.DDinside.dao.DDinsideDAO;
import com.DDinside.dto.BoardVO;
import com.DDinside.dto.CommentVO;
import com.DDinside.dto.CountVO;


public class BoardViewAction implements Action{
	String board_id;
	public BoardViewAction(String board_id) {
		this.board_id = board_id;
	}

	//게시글과 댓글을 둘다 처리
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String url = "Board/BoardView.jsp";
		String num = request.getParameter("num");
		
		DDinsideDAO boardDAO = DDinsideDAO.getInstance();
		Suv_DDinsideDAO suv_boardDAO = Suv_DDinsideDAO.getInstance();

		
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		if(board_id.equals("高評価") || board_id.equals("低評価") || board_id.equals("アホ") || board_id.equals("統合") || board_id.equals("申告管理")) {
			List<CommentVO> commentList = suv_boardDAO.selectComment(num, board_id);
			int readcount = suv_boardDAO.getReadCount(num, board_id);
			suv_boardDAO.updateReadCount(num, board_id);
			BoardVO boardVO = suv_boardDAO.BoardView(num, board_id);
			CountVO countVO = suv_boardDAO.getPostCount(num, board_id);
			String writer = suv_boardDAO.selectUserId(num, board_id);
			int count = suv_boardDAO.tableCountView(board_id);
			
			request.setAttribute("comment", commentList);
			request.setAttribute("readcount", readcount);
			request.setAttribute("writer", writer);
			request.setAttribute("listCount", count);
			request.setAttribute("boardView", boardVO);
			request.setAttribute("PostCount", countVO);
			
			List<BoardVO> list = suv_boardDAO.selectAllBoard(page, board_id);
			request.setAttribute("boardList", list);
			
		} else {
			List<CommentVO> commentList = boardDAO.selectComment(num, board_id);
			int readcount = boardDAO.getReadCount(num, board_id);
			boardDAO.updateReadCount(num, board_id);
			BoardVO boardVO = boardDAO.BoardView(num, board_id);
			CountVO countVO = boardDAO.getPostCount(num, board_id);
			String writer = boardDAO.selectUserId(num, board_id);
			int count = boardDAO.tableCount(board_id);
			
			request.setAttribute("comment", commentList);
			request.setAttribute("readcount", readcount);
			request.setAttribute("writer", writer);
			request.setAttribute("listCount", count);
			request.setAttribute("boardView", boardVO);
			request.setAttribute("PostCount", countVO);
			
			List<BoardVO> list = boardDAO.selectAllBoard(page, board_id);
			request.setAttribute("boardList", list);
		}
		
		
		String noticeBoard_id = "お知らせ";
		List<BoardVO> noticeList = boardDAO.selectNotice(noticeBoard_id);
		request.setAttribute("NoticeList", noticeList);
		request.setAttribute("board_id", board_id);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
						
	}

}

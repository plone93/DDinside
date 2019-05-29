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
import com.DDinside.dto.PageVO;

public class Idol_BoardListAction implements Action {
	String board_id;
	public Idol_BoardListAction(String board_id) {
		this.board_id = board_id;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = board_id+"_Board/"+board_id+"_BoardList.jsp";
		
		/*
		 * String uri = request.getRequestURI(); String conPath =
		 * request.getContextPath(); String com = uri.substring(conPath.length());//
		 * 어느시점에서 뒤에 값을 구함
		 */		
		
		int page = 1;	
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		PageVO pageVO = new PageVO();
		pageVO.setPage(page);
		
		DDinsideDAO boardDAO = DDinsideDAO.getInstance();
		List<BoardVO> list = boardDAO.selectAllBoard(page, board_id);
		request.setAttribute("boardList", list);
		
		pageVO.setTotalCount(boardDAO.tableCount(board_id));// DAO에서 총 테이블 갯수를 검색해야함
		request.setAttribute("page", pageVO);
		
		List<BoardVO> noticeList = boardDAO.selectNotice();
		request.setAttribute("NoticeList", noticeList);
		
		int count = boardDAO.tableCount(board_id);
		request.setAttribute("listCount", count);
		
		//String url ="controller?command=FreeBoardList&page="+page;
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);


	}

}

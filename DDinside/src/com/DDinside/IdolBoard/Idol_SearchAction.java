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
import com.DDinside.dto.SearchVO;

public class Idol_SearchAction implements Action{
	String board_id;
	public Idol_SearchAction(String board_id) {
		this.board_id = board_id;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = board_id+"_Board/"+board_id+"_BoardSearchList.jsp";
		
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		DDinsideDAO boardDAO = DDinsideDAO.getInstance();
		PageVO pageVO = new PageVO();
		pageVO.setPage(page);
		
		SearchVO searchVO = new SearchVO();
		searchVO.setKeyWord(request.getParameter("keyword"));
				
		List<BoardVO> list = boardDAO.search(searchVO, board_id);
		request.setAttribute("searchList", list);
		
		pageVO.setTotalCount(boardDAO.searchTableCount(searchVO, board_id));
		request.setAttribute("page", pageVO);
		
		List<BoardVO> noticeList = boardDAO.selectNotice();
		request.setAttribute("NoticeList", noticeList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}

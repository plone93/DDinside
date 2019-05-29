package com.DDinside.Board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DDinside.action.Action;
import com.DDinside.dao.DDinsideDAO;
import com.DDinside.dao.Suv_DDinsideDAO;
import com.DDinside.dto.BoardVO;
import com.DDinside.dto.PageVO;
import com.DDinside.dto.SearchVO;

public class SearchAction implements Action{
	String board_id;
	public SearchAction(String board_id) {
		this.board_id = board_id;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String url = "Board/BoardSearchList.jsp";
		
		List<BoardVO> list = new ArrayList<BoardVO>();		
		SearchVO searchVO = new SearchVO();
		searchVO.setKeyWord(request.getParameter("keyword"));
		
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		PageVO pageVO = new PageVO();
		pageVO.setPage(page);
		
		DDinsideDAO boardDAO = DDinsideDAO.getInstance();
		Suv_DDinsideDAO suv_boardDAO = Suv_DDinsideDAO.getInstance();
		
		int count = 0;
		String hotcount = "5";
		if(board_id.equals("高評価")) {
			String word = "up";
			list = suv_boardDAO.search(page, searchVO, board_id, word, hotcount);
			pageVO.setTotalCount(suv_boardDAO.searchTableCount(searchVO, board_id, word, hotcount));
			count = suv_boardDAO.searchTableCountReport(searchVO, board_id, word, hotcount);
			//count = boardDAO.searchTableCountSuv(searchVO, word, hotcount);
		} else if(board_id.equals("低評価")) {
			String word = "down";
			list = suv_boardDAO.search(page, searchVO, board_id, word, hotcount);
			pageVO.setTotalCount(suv_boardDAO.searchTableCount(searchVO, board_id, word, hotcount));
			count = suv_boardDAO.searchTableCountReport(searchVO, board_id, word, hotcount);
			//count = boardDAO.searchTableCountSuv(searchVO, word, hotcount);
		} else if(board_id.equals("アホ")) {
			String word = "aho";
			list = suv_boardDAO.search(page, searchVO, board_id, word, hotcount);
			pageVO.setTotalCount(suv_boardDAO.searchTableCount(searchVO, board_id, word, hotcount));
			count = suv_boardDAO.searchTableCountReport(searchVO, board_id, word, hotcount);
			//count = boardDAO.searchTableCountSuv(searchVO, word, hotcount);
		} else if(board_id.equals("統合")) {
			list = suv_boardDAO.searchTotal(page, searchVO, board_id);
			pageVO.setTotalCount(suv_boardDAO.searchTableCountTotal(searchVO, board_id));
			count = suv_boardDAO.searchTableCountTotal(searchVO, board_id);
			//count = boardDAO.searchTableCountTotal(searchVO);
		} else if(board_id.equals("申告管理")) {
			String word = "report";
			list = suv_boardDAO.searchReport(page, searchVO, board_id, word, hotcount);
			pageVO.setTotalCount(suv_boardDAO.searchTableCountReport(searchVO, board_id, word, hotcount));
			count = suv_boardDAO.searchTableCountReport(searchVO, board_id, word, hotcount);
			//count = boardDAO.searchTableCountSuv(searchVO, word, hotcount);
		} else if(board_id.equals("アカウント管理")) {
			list = suv_boardDAO.searchAccount(searchVO);
			pageVO.setTotalCount(suv_boardDAO.searchMemberCount(searchVO));
			count = suv_boardDAO.searchMemberCount(searchVO);
			url = "Board/MemberList.jsp";
			
		} else {
			list = boardDAO.search(page, searchVO, board_id);
			pageVO.setTotalCount(boardDAO.searchTableCount(searchVO, board_id));
			count = boardDAO.searchTableCount(searchVO, board_id);
		}
		
		
		
		
		request.setAttribute("searchList", list);
		request.setAttribute("page", pageVO);
		request.setAttribute("board_id", board_id);
		request.setAttribute("searchCount", count);
		
		String noticeBoard_id = "お知らせ";
		List<BoardVO> noticeList = boardDAO.selectNotice(noticeBoard_id);
		request.setAttribute("NoticeList", noticeList);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}

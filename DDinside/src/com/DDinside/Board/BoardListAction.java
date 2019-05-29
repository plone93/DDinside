package com.DDinside.Board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DDinside.action.Action;
import com.DDinside.dao.Suv_DDinsideDAO;
import com.DDinside.dao.*;
import com.DDinside.dto.BoardVO;
import com.DDinside.dto.MemberVO;
import com.DDinside.dto.PageVO;

public class BoardListAction implements Action {
	String board_id;
	public BoardListAction(String board_id) {
		this.board_id = board_id;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String url = "Board/BoardList.jsp";
		
		/*
		 * String uri = request.getRequestURI(); String conPath =
		 * request.getContextPath(); String com = uri.substring(conPath.length());//
		 * 어느시점에서 뒤에 값을 구함
		 */		
		List<BoardVO> list = new ArrayList<BoardVO>();
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		int page = 1;
		int count = 0;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		PageVO pageVO = new PageVO();
		pageVO.setPage(page);
		
		DDinsideDAO boardDAO = DDinsideDAO.getInstance();
		Suv_DDinsideDAO suv_boardDAO = Suv_DDinsideDAO.getInstance();
		
		String hotcount = "5";
		if(board_id.equals("高評価")) {
			String word = "up";
			list = suv_boardDAO.selectAllBoard_suv(page, board_id, word, hotcount);
			pageVO.setTotalCount(suv_boardDAO.tableCount(board_id, hotcount));// DAO에서 총 테이블 갯수를 검색해야함
			count = suv_boardDAO.tableCount(board_id, hotcount); 
		} else if(board_id.equals("低評価")) {
			String word = "down";
			list = suv_boardDAO.selectAllBoard_suv(page, board_id, word, hotcount);
			pageVO.setTotalCount(suv_boardDAO.tableCount(board_id, hotcount));// DAO에서 총 테이블 갯수를 검색해야함
			count = suv_boardDAO.tableCount(board_id, hotcount); 
		} else if(board_id.equals("アホ")) {
			String word = "aho";
			list = suv_boardDAO.selectAllBoard_suv(page, board_id, word, hotcount);
			pageVO.setTotalCount(suv_boardDAO.tableCount(board_id, hotcount));// DAO에서 총 테이블 갯수를 검색해야함
			count = suv_boardDAO.tableCount(board_id, hotcount); 
		} else if(board_id.equals("統合")) {
			list = suv_boardDAO.selectAllBoardTotal(page, board_id);
			pageVO.setTotalCount(suv_boardDAO.tableCountTotal(board_id));// DAO에서 총 테이블 갯수를 검색해야함
			count = suv_boardDAO.tableCountTotal(board_id);
		} else if(board_id.equals("申告管理")) {
			String word = "report";
			list = suv_boardDAO.selectAllBoardReport(page, board_id, word);
			pageVO.setTotalCount(suv_boardDAO.tableCountReport(board_id, word));// DAO에서 총 테이블 갯수를 검색해야함
			count = suv_boardDAO.tableCountReport(board_id, word); 
		} else if(board_id.equals("アカウント管理")) {
			memberList = suv_boardDAO.selectAllAccount(page);
			pageVO.setTotalCount(suv_boardDAO.memberCountTotal());// DAO에서 총 테이블 갯수를 검색해야함
			count = suv_boardDAO.memberCountTotal();
			request.setAttribute("memberList", memberList);
			request.setAttribute("listCount", count);
			url = "Board/MemberList.jsp";
		} else {
			list = boardDAO.selectAllBoard(page, board_id);
			pageVO.setTotalCount(boardDAO.tableCount(board_id));// DAO에서 총 테이블 갯수를 검색해야함
			count = boardDAO.tableCount(board_id);
		}
		request.setAttribute("boardList", list);
		request.setAttribute("listCount", count);
		request.setAttribute("page", pageVO);
		
		String noticeBoard_id = "お知らせ";
		List<BoardVO> noticeList = boardDAO.selectNotice(noticeBoard_id);
		request.setAttribute("NoticeList", noticeList);
		request.setAttribute("board_id", board_id);
		
		
		//String url ="controller?command=FreeBoardList&page="+page;
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);


	}

}

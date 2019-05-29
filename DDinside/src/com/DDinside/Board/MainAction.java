package com.DDinside.Board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DDinside.action.Action;
import com.DDinside.dao.DDinsideDAO;
import com.DDinside.dto.BoardVO;

public class MainAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String url = "index.jsp";
		DDinsideDAO boardDAO = DDinsideDAO.getInstance();
		List<BoardVO> BestList = boardDAO.mainNoticeBest();
		List<BoardVO> WorstList = boardDAO.mainNoticeWorst();
		List<BoardVO> AhoList = boardDAO.mainNoticeAho();
		
		request.setAttribute("Best", BestList);
		request.setAttribute("Worst", WorstList);
		request.setAttribute("Aho", AhoList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}

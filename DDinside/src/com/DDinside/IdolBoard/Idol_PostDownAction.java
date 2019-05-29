package com.DDinside.IdolBoard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DDinside.action.Action;
import com.DDinside.dao.DDinsideDAO;
import com.DDinside.dto.CountVO;

public class Idol_PostDownAction implements Action {
	String board_id;
	public Idol_PostDownAction(String board_id) {
		this.board_id = board_id;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		String url ="controller?command="+board_id+"_BoardView&num="+num;
		
		DDinsideDAO boardDAO = DDinsideDAO.getInstance();
		boardDAO.postDownCount(num, board_id); 
		
		CountVO countVO = boardDAO.getPostCount(num, board_id);
		request.setAttribute("PostCount", countVO);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}

package com.DDinside.IdolBoard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DDinside.action.Action;
import com.DDinside.dao.DDinsideDAO;

public class Idol_PostReportAction implements Action{
	String board_id;
	public Idol_PostReportAction(String board_id) {
		this.board_id = board_id;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String num = request.getParameter("num");
		String url ="controller?command="+board_id+"_BoardView&num="+num;
		
		DDinsideDAO boardDAO = DDinsideDAO.getInstance();
		boardDAO.postReport(num, board_id);
			
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}

package com.DDinside.IdolBoard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DDinside.action.Action;
import com.DDinside.dao.DDinsideDAO;

public class Idol_BoardDeleteAction implements Action {
	String board_id;
	public Idol_BoardDeleteAction(String board_id) {
		this.board_id = board_id;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "controller?command="+board_id+"_BoardList";
		String num = request.getParameter("num");
		
		DDinsideDAO boardDAO = DDinsideDAO.getInstance();
		boardDAO.boardDelete(num, board_id);
		
		response.sendRedirect(url);
		
		
	}

}

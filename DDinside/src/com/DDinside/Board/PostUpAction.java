package com.DDinside.Board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DDinside.action.Action;
import com.DDinside.dao.DDinsideDAO;
import com.DDinside.dao.Suv_DDinsideDAO;
import com.DDinside.dto.CountVO;

public class PostUpAction implements Action{
	String board_id;
	public PostUpAction(String board_id) {
		this.board_id = board_id;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("utf-8");
		String num = request.getParameter("num");
		String url ="controller?command=BoardView&num="+num+"&board_id="+board_id;
		CountVO countVO = new CountVO();
		
		DDinsideDAO boardDAO = DDinsideDAO.getInstance();
		Suv_DDinsideDAO suv_boardDAO = Suv_DDinsideDAO.getInstance();

		if(board_id.equals("高評価") || board_id.equals("低評価") || board_id.equals("アホ") || board_id.equals("統合")) {
			suv_boardDAO.postUpCount(num, board_id); 
			countVO = suv_boardDAO.getPostCount(num, board_id);
		} else {
			boardDAO.postUpCount(num, board_id); 
			countVO = boardDAO.getPostCount(num, board_id);
		}
		
		int Up = countVO.getUp();
		request.setAttribute("Up", Up);
		request.setAttribute("PostCount", countVO);
		request.setAttribute("board_id", board_id);
			
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}

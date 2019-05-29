package com.DDinside.IdolBoard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DDinside.action.Action;
import com.DDinside.dao.DDinsideDAO;
import com.DDinside.dto.BoardVO;

public class Idol_BoardEditAction implements Action{
	String board_id;
	public Idol_BoardEditAction(String board_id) {
		this.board_id = board_id;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String url = board_id+"_Board/"+board_id+"_BoardEdit.jsp";
		String num = request.getParameter("num");

		
		DDinsideDAO boardDAO = DDinsideDAO.getInstance();
		BoardVO boardVO = boardDAO.BoardView(num, board_id);
		request.setAttribute("BoardEditView", boardVO);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
		
		/*
		 * ServletContext context = request.getSession().getServletContext(); String
		 * path = context.getRealPath("upload"); String encType="utf-8"; int sizeLimit =
		 * 20 * 1024 * 1024; //1kb = 1024 MultipartRequest multi = new MultipartRequest(
		 * request, path, sizeLimit, encType, new DefaultFileRenamePolicy() );
		 */
		
		
	}

}

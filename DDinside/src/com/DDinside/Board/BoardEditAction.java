package com.DDinside.Board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DDinside.action.Action;
import com.DDinside.dao.DDinsideDAO;
import com.DDinside.dao.Suv_DDinsideDAO;
import com.DDinside.dto.BoardVO;

public class BoardEditAction implements Action{
	String board_id;
	public BoardEditAction(String board_id) {
		this.board_id = board_id;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String url = "Board/BoardEdit.jsp";
		String num = request.getParameter("num");
		BoardVO boardVO = new BoardVO();

		
		DDinsideDAO boardDAO = DDinsideDAO.getInstance();
		Suv_DDinsideDAO suv_boardDAO = Suv_DDinsideDAO.getInstance();

		if(board_id.equals("高評価") || board_id.equals("低評価") || board_id.equals("アホ") || board_id.equals("統合")) {
			boardVO = suv_boardDAO.BoardView(num, board_id);
		} else {
			boardVO = boardDAO.BoardView(num, board_id);
		}

		request.setAttribute("BoardEditView", boardVO);
		request.setAttribute("board_id", board_id);
		
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

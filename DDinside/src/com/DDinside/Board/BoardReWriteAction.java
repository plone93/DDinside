package com.DDinside.Board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DDinside.action.Action;
import com.DDinside.dao.DDinsideDAO;
import com.DDinside.dao.Suv_DDinsideDAO;
import com.DDinside.dto.BoardVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardReWriteAction implements Action {
	String board_id;
	public BoardReWriteAction(String board_id) {
		this.board_id = board_id;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("upload");
		String encType="utf-8";
		int sizeLimit = 20 * 1024 * 1024; //1kb = 1024
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		
		String num = multi.getParameter("num");
		String url = "controller?command=BoardView&num="+num+"&board_id="+board_id;
		
		BoardVO boardVO = new BoardVO();
		
		String content = multi.getParameter("content");
		content = content.replace("\r\n","<br>");
		
		boardVO.setContent(content);
		boardVO.setTitle(multi.getParameter("title"));
		boardVO.setPass(multi.getParameter("pass"));
		boardVO.setItem(multi.getFilesystemName("item"));
		boardVO.setNum(Integer.parseInt(num));
		
		DDinsideDAO boardDAO = DDinsideDAO.getInstance();
		Suv_DDinsideDAO suv_boardDAO = Suv_DDinsideDAO.getInstance();

		if(board_id.equals("高評価") || board_id.equals("低評価") || board_id.equals("アホ") || board_id.equals("統合")) {
			suv_boardDAO.updateBoard(boardVO, board_id);
		} else {
			boardDAO.updateBoard(boardVO, board_id);
		}

		request.setAttribute("board_id", board_id);
		request.setAttribute("message", "スレッドを更新しました。");
		response.setCharacterEncoding("UTF-8");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}

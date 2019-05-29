package com.DDinside.IdolBoard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DDinside.action.Action;
import com.DDinside.dao.DDinsideDAO;
import com.DDinside.dto.BoardVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class Idol_BoardWriteAction implements Action {
	String board_id;

	public Idol_BoardWriteAction(String board_id) {
		this.board_id = board_id;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String url = "controller?command="+board_id+"_BoardList";
		
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("upload");
		String encType="utf-8";
		int sizeLimit = 20 * 1024 * 1024; //1kb = 1024
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		
		BoardVO boardVO = new BoardVO();
		boardVO.setUserid(multi.getParameter("userid"));
		boardVO.setTitle(multi.getParameter("title"));
		boardVO.setPass(multi.getParameter("pass"));
		boardVO.setItem(multi.getFilesystemName("item"));
		
		String content = multi.getParameter("content");
		content = content.replace("\r\n","<br>");
		boardVO.setContent(content);
		boardVO.setName(multi.getParameter("name"));
		
		DDinsideDAO boardDAO = DDinsideDAO.getInstance();
		boardDAO.insertBoard(boardVO, board_id);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}

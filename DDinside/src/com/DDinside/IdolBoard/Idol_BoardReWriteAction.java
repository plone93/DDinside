package com.DDinside.IdolBoard;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DDinside.action.Action;
import com.DDinside.dao.DDinsideDAO;
import com.DDinside.dto.BoardVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class Idol_BoardReWriteAction implements Action {
	String board_id;
	public Idol_BoardReWriteAction(String board_id) {
		this.board_id = board_id;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("upload");
		String encType="utf-8";
		int sizeLimit = 20 * 1024 * 1024; //1kb = 1024
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		
		String num = multi.getParameter("num");
		String url = "controller?command="+board_id+"_BoardView&num="+num;
		

		BoardVO boardVO = new BoardVO();
		
		String content = multi.getParameter("content");
		content = content.replace("\r\n","<br>");
		
		boardVO.setContent(content);
		boardVO.setTitle(multi.getParameter("title"));
		boardVO.setPass(multi.getParameter("pass"));
		boardVO.setItem(multi.getFilesystemName("item"));
		boardVO.setNum(Integer.parseInt(num));

		DDinsideDAO boardDAO = DDinsideDAO.getInstance();
		boardDAO.updateBoard(boardVO, board_id);
		response.sendRedirect(url);

	}

}

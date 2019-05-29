package com.DDinside.Member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DDinside.action.Action;
import com.DDinside.dao.MemberDAO;

public class MemberDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String board_id = request.getParameter("board_id");
		String num = request.getParameter("num");
		String url = "controller?command=BoardList&board_id="+board_id;
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.memberDelete(num);
		
		request.setAttribute("message", "アカウントを削除しました。");
		response.setCharacterEncoding("UTF-8");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}

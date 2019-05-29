package com.DDinside.Member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DDinside.action.Action;
import com.DDinside.dao.MemberDAO;

public class AccountCloseCompleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String url = "controller?command=Main";
		String num = request.getParameter("num");
		String pass = request.getParameter("pass");
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		String pass2 = memberDAO.getMemberPass(num);
		
		if(pass == pass2) {
			memberDAO.memberDelete(num);
			request.setAttribute("Message", "アカウント削除に完了しました。");
		} else {
			request.setAttribute("Message", "パスワードを確認してください。");
		}
		
		response.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}

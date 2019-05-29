package com.DDinside.Member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DDinside.action.Action;
import com.DDinside.dao.LoginDAO;
import com.DDinside.dto.MemberVO;

public class LoginAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "index.jsp";
		String login_id = request.getParameter("login_id");
		String login_pass = request.getParameter("login_pass");
		
		LoginDAO loginDAO = LoginDAO.getInstane();
		int result = loginDAO.MemberLogin(login_id, login_pass);
		
		if(result == 1) { //로그인에 성공 했을 경우
			MemberVO memberVO = loginDAO.getMember(login_id);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", memberVO);
			request.setAttribute("message", "ログインしました。");
			
		} else if(result == 0) { // 비밀번호가 틀렸을 경우
			request.setAttribute("message", "パスワードを確認してください。");
		} else if(result == -1) { // 존재 하지 않을 경우
			request.setAttribute("message", "登録されていません。");
		}
		
		response.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}

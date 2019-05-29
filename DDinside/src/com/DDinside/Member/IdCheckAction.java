package com.DDinside.Member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.DDinside.action.Action;
import com.DDinside.dao.MemberDAO;

public class IdCheckAction implements Action{

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		int result = memberDAO.idCheck(id); // 1이면 중복 아이디 존재, -1이면 중복아이디 존재 x 사용가능
		
		JSONObject obj = new JSONObject();
		if(result == 1) {
			obj.put("message", "既に使用されているIDです。");
			obj.put("result", result);
		} else {
			obj.put("message", "使用可能なIDです。");
			obj.put("result", result);
		}

		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/x-json, charset=utf-8");
		response.getWriter().print(obj);
	}

}

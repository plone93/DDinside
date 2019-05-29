package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DDinside.action.*;




@WebServlet("/controller")
public class ProntController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ProntController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
		String board_id = request.getParameter("board_id");
		System.out.println(board_id);
		Action action = null;
		
		if(action == null) {
			MemberActionFactory member = MemberActionFactory.getInstance();
			action = member.getAction(command);
			if(action != null) {
				action.execute(request, response); 
			} else {
				BoardActionFactory board = BoardActionFactory.getInstance();
				action = board.getAction(command, board_id);
				if(action != null) {
					action.execute(request, response);
						}  
						
					}
				}
			}
		
	

			
		
		
		


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}

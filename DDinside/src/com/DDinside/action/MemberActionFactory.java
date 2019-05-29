package com.DDinside.action;


import com.DDinside.Member.*;


// 객체를 생성해서 클래스르 따로 설계해서 작업하는 것을 팩토리 패턴이라고 한다.
// 요청이 들어오면 이에 해당하는 액션 객체를 생성해주는 클래스이다.

public class MemberActionFactory {
	private MemberActionFactory() {}
	private static MemberActionFactory instance = new MemberActionFactory();
	public static MemberActionFactory getInstance() {return instance;}

	public Action getAction(String command) {
		Action action = null;

		if (command.equals("Register")) {
			action = new RegisterAction();
		} else if (command.equals("Login")) {
			action = new LoginAction();
		} else if (command.equals("AdminLogin")) {
			action = new AdminLoginAction();
		} else if (command.equals("Logout")) {
			action = new LogoutAction();
		} else if (command.equals("EditProfile")) {
			action = new EditProfileAction();
		} else if (command.equals("GetProfile")) {
			action = new GetProfileAction();
		} else if(command.equals("MemberDelete")) {
			action = new MemberDeleteAction();
		} else if(command.equals("AccountClose")) {
			action = new AccountCloseAction();
		} else if(command.equals("AccountCloseComplete")) {
			action = new AccountCloseCompleteAction();
		} else if(command.equals("IdCheck")) {
			action = new IdCheckAction();
		}
		return action;
	}

}

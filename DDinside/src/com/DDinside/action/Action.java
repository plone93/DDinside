package com.DDinside.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 모델역할을 하는 모든 클래스를 컨트롤러가 동일한 방식으로 접근할 수 있도록 하기 위한 모델들의 인터페이스
// 모든 모델들은 액션 인터페이스의 상속을 받아 구현해야한다.
// 객체를 생성해서 클래스를 따로 설계해서 작업하는 것을 팩토리 패턴이라고 한다.
// 컨트롤러에서 요청이 들어오면 한가지 방식으로 모델 내의 비지니스로직이 수행되도록
// 하기 위한 추상 메서드를 인터페이스에 정의한다.

public interface Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}

package com.iu.start.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MemberInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// Overriding 한 것이므로 매개변수를 바꿀 수 없다
		HttpSession session = request.getSession();
		//memberController에서 session에 넣은 키 값으로 호출
		Object obj = session.getAttribute("member");
		
		if(obj != null) {
			System.out.println("로그인 성공");
			return true;
		}else {
			System.out.println("로그인 안함");
			response.sendRedirect("../../../../../../../member/login.iu");
			return false;
		}
		//return super.preHandle(request, response, handler);
	}
	

}

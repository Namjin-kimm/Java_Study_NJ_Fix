package com.iu.start.Interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.test.members.BankMembersDTO;

public class WriterCheckInterceptor extends HandlerInterceptorAdapter{

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		String method = request.getMethod();
		if(method.equals("POST")) {
			return ;
		}
		
		// 로그인한 사용자의 ID와 DTO의 작성자가 일치하는지 여부?
		
		//로그인한 사용자의 정보
		HttpSession session = request.getSession();
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
		
		//DTO
		Map<String, Object> map = modelAndView.getModel();
		
		BoardDTO boardDTO = (BoardDTO)map.get("boardDTO");
		
		if(!bankMembersDTO.getUsername().equals(boardDTO.getWriter())) {
			modelAndView.addObject("message", "작성자만 수정 가능");
			modelAndView.addObject("url", "./list.iu");
			modelAndView.setViewName("common/result");
		}
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
	

}

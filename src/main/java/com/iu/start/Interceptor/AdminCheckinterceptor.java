package com.iu.start.Interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.start.test.members.BankMembersDTO;
import com.iu.start.test.members.RoleDTO;

public class AdminCheckinterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	         throws Exception {
	      //1.로그인한 사람이 관리자냐 아니냐를 판단해야 함
	      //memberDTO를 꺼내야 함
	      //admin만 통과
	      BankMembersDTO bankMembersDTO = (BankMembersDTO) request.getSession().getAttribute("member");
	      
	      boolean check=false;
	      
	      for(RoleDTO roleDTO:bankMembersDTO.getRoleDTOs()) {
	         System.out.println(roleDTO.getRoleName());
	         System.out.println(roleDTO.getRoleNum());
	         if(roleDTO.getRoleName().equals("admin")) {
	            check=true;
	            break;
	         }
	      }
	      
	      //admin이 아닐 때
	      //jsp로 보내려고 함
	      if(!check) {
	         request.setAttribute("message", "권한이 없습니다.");
	         //모델은 곧 Request다!!
	         request.setAttribute("url", "../../../../../../../");
	         RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");//jsp의 경로를 작성할 것
	         view.forward(request, response);
	      }
	      
	      return check;
	   }

}

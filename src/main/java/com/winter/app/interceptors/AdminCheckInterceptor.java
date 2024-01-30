package com.winter.app.interceptors;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.winter.app.member.MemberDTO;
import com.winter.app.member.role.RoleDTO;

@Component //bean 생성 이름 클래스 소문자로 //servlet-context.xml
public class AdminCheckInterceptor extends HandlerInterceptorAdapter{
	
	//Controller 진입전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		List<RoleDTO> ar = memberDTO.getRoleDTOs();
		System.out.println("관리자 권한 체크 인터셉터");
		
		for(RoleDTO r: ar) {
			if(r.getRoleName().equals("ROLE_ADMIN")) {
				System.out.println("관리자 입니다.");
				return true;
			}
		}
		System.out.println("관리자 아님.");
		request.setAttribute("msg", "관리자만 가능");
		request.setAttribute("path", "/");
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/commons/result.jsp");
		view.forward(request, response);
		
		return false;
	}
	
	//Controller 나갈때
	
	//jsp 렌더링 후
}

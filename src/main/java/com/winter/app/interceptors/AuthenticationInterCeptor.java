package com.winter.app.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class AuthenticationInterCeptor  extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session =  request.getSession();
		Object obj = session.getAttribute("member");
		if(obj != null) {
			return true;
		}else {
			System.out.println("로그인 한 사람만 가능");
			//request.getRequestURI()
			
			
			//서블릿에서 jsp 페이지로 이동할때 처리하는 방법 2가지
			
			//1. redirect 방식 (서블릿에서 값을 넘겨주지 않고 페이지만 이동)
			//response.sendRedirect('jsp경로'); 
			
//			response.sendRedirect("../member/login");
			
			//2. forwarding 방식 (서블릿에서 값을 넘겨주고 해당 페이지에서 처리)
			//RequestDispatcher view = request.getRequestDispatcher("경로");   RequestDispatcher 이동할 경로를 설정하고 생성
			//request.setAttribute("key",value);
			//view.forward(request, response);    생성된 객체를 가지고 forward 메소드를 통해 해당 경로 페이지로 이동  (request와 response 객체를 가지고 이동가능)
			
			request.setAttribute("msg", "로그인이 필요한 기능");
			request.setAttribute("path", "../member/login");
																//옛날방식이라 다써줘야함
			RequestDispatcher v = request.getRequestDispatcher("/WEB-INF/views/commons/result.jsp");
			v.forward(request, response);
			
			
			return false;
			
		}
	}
	
	
}

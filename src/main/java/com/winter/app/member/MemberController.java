package com.winter.app.member;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.board.notice.NoticeDTO;

@Controller
@RequestMapping ("/member/*")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("join")
	public void join() throws Exception{
		
	}
	@PostMapping("join")
	public String join(MemberDTO memberDTO, MultipartFile attachs,Model model) throws Exception{
		int result = memberService.join(memberDTO, attachs);
		String msg = "가입 실패했습니다. 다시 시도해주세요.";
		String path ="./join";
		if(result == 1) {
			msg = "가입 성공되었습니다. 환영합니다.";
			path="../";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("path", path);
		return "/commons/result";
	}
	
	@GetMapping("login")
	public void getLogin() throws Exception{
		
	}
	@PostMapping("login")
	public String getLogin(MemberDTO memberDTO, HttpSession session, Model model) throws Exception{
		memberDTO = memberService.getLogin(memberDTO);
		
		if(memberDTO == null) {
			model.addAttribute("msg","ID 또는 PW 확인");
			return "member/login";
		}
		
		//내장객체 session
		//request.getSession(), 매개: HttpServletRequest request 또는
		session.setAttribute("member", memberDTO);
		System.out.println("Login : "+memberDTO);
		
		return "redirect:../";
	}
	
	@GetMapping("logout")
	public String getLogout(HttpSession session) throws Exception{
		//방법1
		//session.setAttribute("member", null);
		//방법2,3,4
		//session.removeAttribute("member");
		//session.removeValue("member"); 쓰지x
		//방법4 시간 0으로 
		session.invalidate();
		return "redirect:../";
	}
	
	@GetMapping("mypage")
	public void getMypage(HttpSession session) throws Exception{
		session.setAttribute("dto", session);
		
	}
	
}

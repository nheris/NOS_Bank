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

	//join	
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
	
	//login
	
	
	
	
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
		
		//내장객체 session  <-로그인 유지되어야함으로 session에 저장
		//request.getSession(), 매개: HttpServletRequest request 또는
		session.setAttribute("member", memberDTO);
		//System.out.println("Login : "+memberDTO);
		
		return "redirect:../";
	}
	
	
	//logout
	@GetMapping("logout")
	public String getLogout(HttpSession session) throws Exception{
		//방법1
		//session.setAttribute("member", null);
		//방법2,3
		//session.removeAttribute("member");
		//session.removeValue("member"); 쓰지x
		//방법4 Session 삭제:유효시간을 0으로 만듦
		session.invalidate();
		return "redirect:../";
	}
	
	//mypage
	@GetMapping("mypage")
	public void getMypage(HttpSession session, Model model)throws Exception{
		////공백으로 회원정보 수정했을때 다시로그인해야 뜨는거..수정? 공백은db에 저장안되니 db에서 새로꺼냄
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		memberDTO = memberService.getDetail(memberDTO);
		model.addAttribute("member", memberDTO);
	}
	
	//update
	@GetMapping("update")
	public void setUpdate(HttpSession session, Model model) throws Exception{
		//db에서 새로꺼냄
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		memberDTO = memberService.getDetail(memberDTO);
		model.addAttribute("member", memberDTO);
	}
	@PostMapping("update")
	public String setUpdate(MemberDTO memberDTO, HttpSession session) throws Exception{
		//DB에 업데이트 후 mypage로 이동
		MemberDTO m = (MemberDTO)session.getAttribute("member");
		memberDTO.setUserName(m.getUserName());
		
		//수정후 새정보 바로뜨게 근데 이제 db에서 새로꺼내니 필요없을듯..?
		session.setAttribute("member", memberDTO);
		
		int result = memberService.setUpdate(memberDTO);
		
		return"redirect:./mypage"; 
	}
	
	//join시 약관동의
	@GetMapping("agreement")
	public void setAgreement() throws Exception{
		
	}
	
	//id 중복검사
	@GetMapping("idCheck")
	public String getIdCheck(MemberDTO memberDTO, Model model)throws Exception{
		memberDTO = memberService.getDetail(memberDTO);

		int result=0;
		if(memberDTO == null) {
			result=1; //중복x
		}
		model.addAttribute("result", result);

		return "commons/ajaxResult"; //태그까지 다들고오니 다지움
	}
}

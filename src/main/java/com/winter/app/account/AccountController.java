package com.winter.app.account;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.winter.app.member.MemberDTO;
import com.winter.app.product.ProductDTO;
import com.winter.app.util.Pager;

@Controller
@RequestMapping("/account/*")
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@GetMapping("add")
	public void add(ProductDTO productDTO, Model model) throws Exception {
		Long productNum = productDTO.getProductNum();
		
		model.addAttribute("num", productNum);
		
	}
	@PostMapping("add")
	public String add(AccountDTO accountDTO,HttpSession session) throws Exception {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		Long nowTime = System.currentTimeMillis();
		
		accountDTO.setUserName(memberDTO.getUserName());
		accountDTO.setAccountNum(nowTime);
		
		int result = accountService.add(accountDTO);
		
		return "redirect: ../products/list";
	}
	
	@GetMapping("list")
	public void list(HttpSession session, Model model, Pager pager) throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		
		List<Object> ar = accountService.list(pager, memberDTO);
		
		model.addAttribute("list", ar);
		
	}
}

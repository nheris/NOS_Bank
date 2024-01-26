package com.winter.app.wishlist;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.winter.app.account.AccountDTO;
import com.winter.app.member.MemberDTO;
import com.winter.app.product.ProductDTO;
import com.winter.app.util.Pager;

@Controller
@RequestMapping("/wishlist/*")
public class WishlistController {
	@Autowired
	private WishlistService wishlistService;
	
	@GetMapping("add")
	public String add(AccountDTO accountDTO, HttpSession session, Model model) throws Exception{
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		accountDTO.setUserName(memberDTO.getUserName());
		int result = wishlistService.add(accountDTO);
		model.addAttribute("result",result);
		return "commons/ajaxResult";
	}
	
	@GetMapping("list")
	public void list(HttpSession session, Model model) throws Exception{
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		List<ProductDTO> ar = wishlistService.list(memberDTO);
		model.addAttribute("list", ar);
	}
	
	@PostMapping("delete")
	public String delete(Long [] productNum, HttpSession session, Model model) throws Exception{
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		int result = wishlistService.delete(productNum, memberDTO);
		List<ProductDTO> ar = wishlistService.list(memberDTO);
		
		//model.addAttribute("result", result);
		//다시 조회
		model.addAttribute("list", ar);
		
		//return "commons/ajaxResult";
		return "wishlist/ajaxList";
	}
}

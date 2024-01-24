package com.winter.app.account;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.member.MemberDTO;
import com.winter.app.product.ProductDTO;

@Service
public class AccountService {
	
	@Autowired
	private AccountDAO accountDAO;

	public int add(AccountDTO accountDTO) throws Exception {
		
		return accountDAO.add(accountDTO);
	}

	public List<ProductDTO> list(MemberDTO memberDTO) throws Exception {
		
		
		
		return accountDAO.list(memberDTO);
	}
}

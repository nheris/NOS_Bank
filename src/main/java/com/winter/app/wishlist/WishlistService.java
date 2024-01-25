package com.winter.app.wishlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.account.AccountDTO;
import com.winter.app.member.MemberDTO;
import com.winter.app.product.ProductDTO;

@Service
public class WishlistService {
	@Autowired
	private WishlistDAO wishlistDAO;

	public int add(AccountDTO accountDTO) throws Exception {
		return wishlistDAO.add(accountDTO);
	}

	public void list(MemberDTO memberDTO) {
		return wishlistDAO.list(memberDTO);
	}
	
	
}

package com.winter.app.wishlist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public List<ProductDTO> list(MemberDTO memberDTO) throws Exception {
		return wishlistDAO.list(memberDTO);
	}

	public int delete(Long[] productNum, MemberDTO memberDTO) throws Exception{
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("member", memberDTO);
		map.put("nums",productNum);
		
		
		return wishlistDAO.delete(map);
	}
	
	
}

package com.winter.app.wishlist;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.account.AccountDTO;
import com.winter.app.member.MemberDTO;
import com.winter.app.product.ProductDTO;

@Repository
public class WishlistDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE ="com.winter.app.wishlist.WishlistDAO."; 
	
	public int add(AccountDTO accountDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"add", accountDTO);
	}

	public Object list(MemberDTO memberDTO) {
		return sqlSession.selectList(NAMESPACE+"list", memberDTO);
	}
	
}

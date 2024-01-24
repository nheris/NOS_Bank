package com.winter.app.account;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.member.MemberDTO;
import com.winter.app.product.ProductDTO;

@Repository
public class AccountDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE ="com.winter.app.account.AccountDAO.";
	
	public int add(AccountDTO accountDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"add", accountDTO);
	}

	public List<Object> list(Map<String, Object> map) throws Exception{
		return sqlSession.selectList(NAMESPACE+"list", map);
	}
}

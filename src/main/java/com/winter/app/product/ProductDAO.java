package com.winter.app.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.util.Pager;

@Repository
public class ProductDAO {
	@Autowired
	private SqlSession sqlSession;
	
	private final String namespace="com.winter.app.product.ProductDAO.";
	
	//list
	public List<ProductDTO> getList(Pager pager) throws Exception{
		return sqlSession.selectList(namespace+"getList", pager);
		
	}
	public Long getTotal(Pager pager) throws Exception{
		return sqlSession.selectOne(namespace+"getTotal", pager);
	}
}

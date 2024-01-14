package com.winter.app.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {
	private SqlSession sqlSession;
	private String namespace="com.winter.app.product.ProductDAO.";
	
	public List<ProductDTO> getList() throws Exception{
		return sqlSession.selectList(namespace+"getList");
		
	}
}

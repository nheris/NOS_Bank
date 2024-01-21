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
	
	//detail
	public ProductDTO detail(ProductDTO productDTO) {
		return sqlSession.selectOne(namespace+"detail", productDTO);
	}
	
	//add
	public int add(ProductDTO productDTO) {
		return sqlSession.insert(namespace+"add", productDTO);
	}
	public int fileAdd(ProductFileDTO productFileDTO) {
		return sqlSession.insert(namespace+"fileAdd", productFileDTO);
	}
	
	//update
	public int update(ProductDTO productDTO) {
		return sqlSession.update(namespace+"update", productDTO);
	}
	
	//delete
	public List<ProductFileDTO> fileList(ProductDTO productDTO) {
		return sqlSession.selectList(namespace+"fileList", productDTO);
	}
	public int delete(ProductDTO productDTO) {
		return sqlSession.update(namespace+"delete", productDTO);
	}
	
}

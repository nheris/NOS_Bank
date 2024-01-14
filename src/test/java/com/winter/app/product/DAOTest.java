package com.winter.app.product;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.MyTest;

public class DAOTest extends MyTest{
	
	@Autowired
	private ProductDAO productDAO;
	
	@Test
	public void test() throws Exception {
		List<ProductDTO> ar = productDAO.getList();
		System.out.println(ar.size());
		assertNotEquals(0, ar.size());
	}

}

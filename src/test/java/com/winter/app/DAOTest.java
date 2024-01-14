package com.winter.app;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.product.ProductDAO;
import com.winter.app.product.ProductDTO;

public class DAOTest extends MyTest{
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Test
	public void test() throws Exception {
		Connection con= dataSource.getConnection();
		
		assertNotNull(con);
	}
	
	
	//@Test
//	public void test2() throws Exception {
//		List<ProductDTO> ar = productDAO.getList();
//		
//	}

}

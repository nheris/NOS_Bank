package com.winter.app;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.product.ProductDAO;
import com.winter.app.product.ProductDTO;


public class DBTest extends MyTest{
	@Autowired
	private DataSource dataSource;


	@Test
	public void test() throws Exception {
		Connection con= dataSource.getConnection();
		
		assertNotNull(con);
	}
	

}

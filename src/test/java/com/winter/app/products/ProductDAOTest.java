package com.winter.app.products;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.MyTest;

public class ProductDAOTest extends MyTest{
	@Autowired
	private ProductDAO productDAO;
	
	@Test
	public void addTest() throws Exception{
		ProductDTO productDTO = new ProductDTO();
		
		for(int i=0; i<100;i++) {
			productDTO.setProductName("상품"+i);
			int result = productDAO.add(productDTO);
			if(i%10==0) {
				Thread.sleep(500);
			}
		}
		System.out.println("100개 입력 완료");
	}
}

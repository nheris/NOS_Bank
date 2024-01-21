package com.winter.app.product;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.MyTest;
import com.winter.app.board.BoardDTO;

public class DAOTest extends MyTest{
	
	@Autowired
	private ProductDAO productDAO;
	
	@Test
	public void test() throws Exception {
//		List<ProductDTO> ar = productDAO.getList();
//		System.out.println(ar.size());
//		assertNotEquals(0, ar.size());
		
		ProductDTO productDTO = new ProductDTO();
		
		for(int i=0;i<60;i++) {
			productDTO.setProductName("상품");
			productDTO.setProductContents("설명");
			productDTO.setProductRate(0.0);
			
			int result = productDAO.add(productDTO);
//			if(i%10==0) {
//				Thread.sleep(500);//0.5초
//				
//			}
		}
		System.out.println("입력 완료");
	}

}

package com.winter.app.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
//	//list
//	public List<ProductDTO> getList() {
//		
//	}
}

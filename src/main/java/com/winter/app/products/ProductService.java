package com.winter.app.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	//list
	public List<ProductDTO> getList() {
		List<ProductDTO> ar = productDAO.getList();
		return ar;
	}
	
	//add
	public int add(ProductDTO productDTO) {
		int result = productDAO.add(productDTO);
		return result;
		
	}
}

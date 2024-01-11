package com.winter.app.products;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.util.FileManager;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private FileManager fileManager;
	
	//list
	public List<ProductDTO> getList() throws Exception {
		List<ProductDTO> ar = productDAO.getList();
		return ar;
	}
	
	//add
	public int add(ProductDTO productDTO, MultipartFile[] file) throws Exception {
		int result = productDAO.add(productDTO);
		
		String path = servletContext.getRealPath("/resources/upload/products");
		System.out.println(path);
		
		
		
		String[] filename = fileManager.fileSave(path, file);
		
		ProductFileDTO productFileDTO = new ProductFileDTO();
		productFileDTO.setFileName(filename);
		productFileDTO.setOriName(file.getOriginalFilename());
		productFileDTO.setProductNum(file.getpro);
		
		productDAO.addFile()
		
		return result;
		
	}
}

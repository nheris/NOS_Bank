package com.winter.app.product;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.util.FileManager;
import com.winter.app.util.Pager;

@Service
public class ProductService {
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	FileManager fileManager;
	@Autowired
	ServletContext servletContext;
	//list
	public List<ProductDTO> getList(Pager pager) throws Exception {
		Long totalCount = productDAO.getTotal(pager);
		pager.makeRow();
		pager.makeNum(totalCount);
		
		return productDAO.getList(pager);
	}
	
	//detail
	public ProductDTO detail(ProductDTO productDTO) throws Exception {
		return productDAO.detail(productDTO);
		
	}
	
	//add
	public int add(ProductDTO productDTO, MultipartFile []attachs) throws Exception {
		int result = productDAO.add(productDTO);
		String path = servletContext.getRealPath("/resources/upload/product");
		
		for(MultipartFile f: attachs) {
			if(f.isEmpty()) {
				continue;
			}
			String fileName = fileManager.fileSave(path, f);
			
			ProductFileDTO productFileDTO = new ProductFileDTO();
			productFileDTO.setFileName(fileName);
			productFileDTO.setOriName(f.getOriginalFilename());
			productFileDTO.setProductNum(productDTO.getProductNum());
			
			result = productDAO.fileAdd(productFileDTO);
			
		}
		return result;
	}
	
	//update
	public int update(ProductDTO productDTO, MultipartFile[] attachs) throws Exception {
		int result = productDAO.update(productDTO);		

		return result;
	}

	public int delete(ProductDTO productDTO) throws Exception {
		List<ProductFileDTO> ar = productDAO.fileList(productDTO);
		String path = servletContext.getRealPath("/resources/upload/product");
		for(ProductFileDTO f : ar) {
			
			fileManager.fileDelete(path, f.getFileName());
		}
		int result = productDAO.delete(productDTO);
		return result;
	}
	
}

package com.winter.app.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping (value = "/products/*")
public class ProductController {
	@Autowired
	private ProductService productService;
	
//	@RequestMapping(value = "list")
//	public void getList() throws Exception{
//		ModelAndView mv = new ModelAndView();
//		
//		List<RegionDto> ar = ProductService.getList();
//		
//		mv.addObject("list",ar);
//		mv.setViewName("products/list");
//		
//		return null;
//		
//	}
}

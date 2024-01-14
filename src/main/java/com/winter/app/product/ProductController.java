package com.winter.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//annotations
@Controller
@RequestMapping("/products/*")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping (value = "list", method = RequestMethod.GET)
	public ModelAndView getList(ModelAndView mv) throws Exception{
		
		List<ProductDTO> ar = productService.getList();
		mv.addObject("list", ar);
		mv.setViewName("products/list");
		return mv;
	}
	
	@RequestMapping (value = "add", method = RequestMethod.GET)
	public void add() throws Exception{
		
	}
}

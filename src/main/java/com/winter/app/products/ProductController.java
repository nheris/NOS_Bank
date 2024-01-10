package com.winter.app.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping (value = "/products/*")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getList() {
		ModelAndView mv= new ModelAndView();
		
		List<ProductDTO> ar = productService.getList();
		
		mv.addObject("list", ar);
		mv.setViewName("products/list");
		
		return mv;
	}
	
	@RequestMapping (value = "add", method = RequestMethod.GET)
	public String add() {
		return "products/add";
	}
	@RequestMapping (value = "add", method = RequestMethod.POST)
	public void add(ProductDTO productDTO, Model model) {
		
	}
}

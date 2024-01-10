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
	public String add(ProductDTO productDTO, ModelAndView mv) {
		int result = productService.add(productDTO);
		String msg ="등록 실패. 다시 시도해 주세요.";
		if(result ==1) {
			msg = "등록 되었습니다.";
		}
		mv.addObject("msg", msg);
		mv.addObject("path","./list");
		
		return "commons/result";
		
	}
}

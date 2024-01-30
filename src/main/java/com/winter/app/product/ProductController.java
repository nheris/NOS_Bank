package com.winter.app.product;

import java.sql.SQLDataException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import com.winter.app.util.Pager;

//annotations
@Controller
@RequestMapping("/products/*")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	//예외 처리 메서드------------------------------
	@ExceptionHandler(NullPointerException.class)//발생한예외Class명.발생하면 밑 실행
	public String nullHandler() {
		return "errors/error";
	}
	@ExceptionHandler(Exception.class)//부모
	public String Handler() {
		return "errors/error";
	}
	//일일이 처리 귀찮으니 예외 전역처리  @ControllerAdvice 어느 컨트롤러든 여기서 처리
	
	//-----------------------------------------
	
	//list
	@RequestMapping (value = "list", method = RequestMethod.GET)
	public ModelAndView getList(ModelAndView mv, Pager pager) throws Exception{
		
		List<ProductDTO> ar = productService.getList(pager);
		
		//강제 예외 발생
		if(ar.size()%2==0) {
			throw new NullPointerException();
		}else if(ar.size()%2 ==1) {
			throw new SQLDataException();
		}
		
		mv.addObject("pager", pager);
		mv.addObject("list", ar);
		mv.setViewName("products/list");
		return mv;
	}
	
	//detail
	@GetMapping("detail")
	public Model detail(ProductDTO productDTO, Model model) throws Exception {
		productDTO = productService.detail(productDTO);
		model.addAttribute("dto", productDTO);
		
//		//처음 가지고 올때만 댓글 목록도 조회

		
		return model;
	}
	
	//add
	@RequestMapping (value = "add", method = RequestMethod.GET)
	public void add() throws Exception{
	}
	@PostMapping("add")
	public String add(ProductDTO productDTO, MultipartFile [] attachs) throws Exception{
		int result = productService.add(productDTO, attachs);
		
		return "redirect:./list";
	}
	
	//update
	@GetMapping("update")
	public String update(ProductDTO productDTO, Model model) throws Exception{
		productDTO = productService.detail(productDTO);
		model.addAttribute("dto", productDTO);
		return "products/update";
	}
	
	@PostMapping("update")
	public String update(ProductDTO productDTO, MultipartFile [] attachs, Model model) throws Exception{
		int result = productService.update(productDTO, attachs);
		String msg = "다시 시도해주세요.";
		String path = "./update";
		if(result == 1) {
			msg = "수정 완료";
			path = "./list";
		}
		model.addAttribute("msg",msg);
		model.addAttribute("path",path);
		
		return "commons/result";
	}
	
	//delete
	@PostMapping("delete")
	public String  delete(ProductDTO productDTO)  throws Exception {
		int result = productService.delete(productDTO);
				
		return "redirect:./list";
	}
}

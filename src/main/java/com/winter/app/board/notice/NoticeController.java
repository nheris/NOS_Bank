package com.winter.app.board.notice;

import java.lang.reflect.Method;
import java.util.List;

import org.apache.ibatis.reflection.MetaClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.winter.app.board.BoardDTO;
import com.winter.app.board.BoardService;
import com.winter.app.util.Pager;

import oracle.security.crypto.core.ECC;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired
	//이름을 지정하지 않으면 클래스명의 첫글자를 소문자로 만든것이 이름으로 지정 (NoticeService->noticeService)
	@Qualifier("noticeService")
	private BoardService boardService;
	
	//list
	//@RequestMapping(value = "list", method=RequestMethod.GET)
	@GetMapping("list")
	public String gerList(Pager pager, Model model) throws Exception{
		List<BoardDTO> ar = boardService.getList(pager);
		model.addAttribute("list",ar);
		return "board/list";
	}
	
	//detail
	@GetMapping("detail")
	public void detail()throws Exception{
		
	}
	
	//add
	@GetMapping("add")
	public String setAdd() throws Exception{
		return "board/add";
	}
	@PostMapping("add")
	public String setAdd(BoardDTO boardDTO) throws Exception{
		int result = boardService.setAdd(boardDTO);
		return "redirect:./list";
	}
}


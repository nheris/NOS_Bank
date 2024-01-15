package com.winter.app.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.winter.app.board.BoardDTO;
import com.winter.app.board.BoardService;
import com.winter.app.util.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	@Autowired
	@Qualifier("qnaService")
	private BoardService boardService;
	
	@GetMapping("list")
	public String getList(Pager pager,Model model) throws Exception{
		List<BoardDTO> ar = boardService.getList(pager);
		model.addAttribute("list",ar);
		
		return "board/list";
	}
	//detail
	@GetMapping("detail")
	public String getDetail(BoardDTO boardDTO, Model model)throws Exception{
		boardDTO = qnaService.getDetail(boardDTO);
		model.addAttribute("boardDTO", boardDTO);
		return "board/detail";
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

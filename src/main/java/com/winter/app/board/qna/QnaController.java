package com.winter.app.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	private QnaService boardService;
	
	@GetMapping("list")
	public String getList(Pager pager,Model model) throws Exception{
		List<BoardDTO> ar = boardService.getList(pager);
		model.addAttribute("list",ar);
		model.addAttribute("board","QnA");
		return "board/list";
	}
	//detail
	@GetMapping("detail")
	public String getDetail(BoardDTO boardDTO, Model model)throws Exception{
		boardDTO = boardService.getDetail(boardDTO);
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
	
	//reply Num만 필요하니 매개 BoardDTO NoticeDTO 둘다 상관없음
	@GetMapping("reply")
	public String setReply(BoardDTO boardDTO, Model model) throws Exception{
		model.addAttribute("boardDTO", boardDTO);
		return "board/reply";
	}
	@PostMapping("reply")
	public String setReply(QnaDTO qnaDTO) throws Exception{
		int result = boardService.setReply(qnaDTO);
		return "redirect:./list";
	}
	
	//모든메서드에 적용?
	@ModelAttribute("board")
	public String getBoard() {
		return "QnA";
	}
	
	//답글 있 1 없 0 
	@ModelAttribute("bbs")
	public Integer getKind() {
		return 1;
	}
}

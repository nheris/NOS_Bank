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
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.board.BoardDTO;
import com.winter.app.board.BoardService;
import com.winter.app.util.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	@Autowired
	@Qualifier("qnaService")
	private QnaService boardService;
	
	//모든메서드에 적용
	@ModelAttribute("board")
	public String getBoard() {
		return "qna";
	}
	
	//답글 있 1 없 0 
	@ModelAttribute("bbs")
	public Integer getKind() {
		return 1;
	}
		
	//list
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
	public String setAdd(BoardDTO boardDTO, MultipartFile[] attachs) throws Exception{
		int result = boardService.setAdd(boardDTO, attachs);
		return "redirect:./list";
	}
	
	//reply 
	@GetMapping("reply")
						//Num만 필요하니 매개 BoardDTO NoticeDTO 둘다 상관없음
	public String setReply(BoardDTO boardDTO, Model model) throws Exception{
		model.addAttribute("boardDTO", boardDTO);
		return "board/reply";
	}
	@PostMapping("reply")
	public String setReply(QnaDTO qnaDTO, MultipartFile[] attachs) throws Exception{
		int result = boardService.setReply(qnaDTO, attachs);
		return "redirect:./list";
	}
	//update
	@GetMapping("update")
	public String setUpdate (BoardDTO boardDTO, Model model)throws Exception{
		boardDTO = boardService.getDetail(boardDTO);
		model.addAttribute("boardDTO", boardDTO);
		return "board/update";
	}
	@PostMapping("update")
	public String setUpdate (BoardDTO boardDTO,MultipartFile[] attachs) throws Exception{
		int result =boardService.setUpdate(boardDTO, attachs);
		return "redirect:./list";
	}
	
	
	//delete
	@PostMapping("delete")
	public String setDelete(QnaDTO boardDTO)throws Exception{
		boardDTO.setFlag(1);
		int result = boardService.setDelete(boardDTO);
		return "redirect:./list";
	}
	
	
	
}

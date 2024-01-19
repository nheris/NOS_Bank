package com.winter.app.board.notice;

import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.reflection.MetaClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.board.BoardDTO;
import com.winter.app.board.BoardService;
import com.winter.app.member.MemberDTO;
import com.winter.app.util.Pager;

import oracle.security.crypto.core.ECC;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired
	//이름을 지정하지 않으면 클래스명의 첫글자를 소문자로 만든것이 이름으로 지정 (NoticeService->noticeService)
	@Qualifier("noticeService")
	private BoardService boardService;
	
	//Controller의 모든 메서드에 공통 Data들을 model에 담으려 할 때 사용
	@ModelAttribute("board")
	public String getBoard() {
		return "notice";
	}
	@ModelAttribute("bbs")
	public Integer getKind() {
		return 0;
	}
	
	
	//list
	//@RequestMapping(value = "list", method=RequestMethod.GET)
	@GetMapping("list")
	public String gerList(Pager pager, Model model) throws Exception{
		List<BoardDTO> ar = boardService.getList(pager);
		model.addAttribute("pager", pager);
		model.addAttribute("list",ar);
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
	public String setAdd(BoardDTO boardDTO, MultipartFile[] attachs, HttpSession session) throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		boardDTO.setBoardWriter(memberDTO.getUserName());
				
		int result = boardService.setAdd(boardDTO, attachs);
		return "redirect:./list";
		
	}
	
	//update
	@GetMapping("update")
	public String setUpdate(BoardDTO boardDTO, Model model) throws Exception{
		boardDTO = boardService.getDetail(boardDTO);
		model.addAttribute("boardDTO", boardDTO);
		
		return "board/update";
		//return "redirect:./detail?boardNum="+boardDTO.getBoardNum();
	}
	@PostMapping("update")
	public String setUpdate(BoardDTO boardDTO, MultipartFile[] attachs)throws Exception{
		int result = boardService.setUpdate(boardDTO, attachs);
		return "redirect:./list";
	} 
	
	//delete
	@PostMapping("delete")
	public String setDelete(BoardDTO boardDTO) throws Exception{
		int result=boardService.setDelete(boardDTO);
		return "redirect:./list";
	}
}


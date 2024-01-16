package com.winter.app.board.qna;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.board.BoardDAO;
import com.winter.app.board.BoardDTO;
import com.winter.app.board.BoardFileDTO;
import com.winter.app.board.BoardService;
import com.winter.app.util.FileManager;
import com.winter.app.util.Pager;
@Service
public class QnaService implements BoardService{
	@Autowired
	@Qualifier("qnaDAO")
	private QnaDAO boardDAO;
	@Autowired
	private FileManager fileManager;
	@Autowired
	private ServletContext servletContext;
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		pager.makeRow();
		
		return boardDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return boardDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO, MultipartFile[] attachs) throws Exception {
		int result = boardDAO.setAdd(boardDTO);
		String path = servletContext.getRealPath("/resources/upload/qna");
		for(MultipartFile f: attachs) {
			if(f.isEmpty()) {
				continue;
			}
			String fileName = fileManager.fileSave(path, f);
			
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(f.getOriginalFilename());
			boardFileDTO.setBoardNum(boardDTO.getBoardNum());
//			result = boardDAO.setFileAdd(boardFileDTO);
		}
		
		
		return 0;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// 1. file 을 삭제
		List<BoardFileDTO> files = qnaDAO.getFileList();
		String path = servletContext.getRealPath("/resources/upload/qna")
		for(BoardFileDTO b: files) {
			fileManager.fileDelete(path, null)
			
		}
		//2, file table의 정보 사게
		//3. qna 정보를 수정
		
		return 0;
	}
	
	//reply
	public int setReply(QnaDTO qnaDTO) throws Exception{
		//boardNum : 부모의 글번호
		//boardTitle : 답글 제목
		//boardWeiter : 답글 작성자
		//boardContents : 답글내용
		//1. 부모의 정보를 조회(REF, STEP, DEPTH)
		QnaDTO parent =  (QnaDTO)boardDAO.getDetail(qnaDTO);
		
		//2. 답글 정보 저장(REF, STEP, DEPTH)
		qnaDTO.setBoardRef(parent.getBoardRef());
		qnaDTO.setBoardStep(parent.getBoardStep()+1);
		qnaDTO.setBoardDepth(parent.getBoardDepth()+1);
		
		//3. 부모의 정보로 step을 업데이트
		int result = boardDAO.setReplyUpdate(parent);
	
		
		//4. db에 답글을 저장
		result = boardDAO.setReplyAdd(qnaDTO);
		return result;
		
	}
}

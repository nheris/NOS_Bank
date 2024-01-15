package com.winter.app.board.notice;

import java.util.List;

import com.winter.app.board.BoardDTO;
import com.winter.app.board.BoardFileDTO;

public class NoticeDTO extends BoardDTO{
	private List<BoardFileDTO> fileDTOs;

	public List<BoardFileDTO> getFileDTOs() {
		return fileDTOs;
	}

	public void setFileDTOs(List<BoardFileDTO> fileDTOs) {
		this.fileDTOs = fileDTOs;
	}
	
	
}

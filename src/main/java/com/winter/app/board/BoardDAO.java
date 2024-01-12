package com.winter.app.board;

import java.util.List;

//@ x
public interface BoardDAO {
	//totalCount
	public Long getTotalCount() throws Exception;
	
	//list
	public List<BoardDTO> getList() throws Exception;
	
	//detail
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception;
	
	//add
	public int setAdd(BoardDTO boardDTO) throws Exception;
	
	//update
	public int setUpdate(BoardDTO boardDTO) throws Exception;
	
	//delete
	public int setDelete(BoardDTO boardDTO) throws Exception;
}

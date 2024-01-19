package com.winter.app.board.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.board.BoardDAO;
import com.winter.app.board.BoardDTO;
import com.winter.app.board.BoardFileDTO;
import com.winter.app.util.Pager;

@Repository("na")
public class NoticeDAO implements BoardDAO{
	@Autowired
	private SqlSession sqlSession;
	
	private final String namespace="com.winter.app.board.notice.NoticeDAO.";
	
	//list
	@Override
	public Long getTotalCount(Pager pager) throws Exception {
		return sqlSession.selectOne(namespace+"getTotalCount", pager);
	}
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(namespace+"getList", pager);
	}
	
	//detail
	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectOne(namespace+"getDetail", boardDTO);
	}
	
	//add
	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(namespace+"setAdd", boardDTO);
	}
	public int setFileAdd(BoardFileDTO boardFileDTO) throws Exception{
		return sqlSession.insert(namespace+"setFileAdd", boardFileDTO);
	}
	
	
	//update
	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(namespace+"setUpdate", boardDTO);
	}
	
	//delete
	public List<BoardFileDTO> getFileList(BoardDTO boardDTO)throws Exception{
		return sqlSession.selectList(namespace+"getFileList", boardDTO);
	}
	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return sqlSession.delete(namespace+"setDelete", boardDTO);
	}
	
	
}

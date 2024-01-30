package com.winter.app.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE ="com.winter.app.product.ReplyDAO.";
	
	public int setReply(ReplyDTO replyDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setReply", replyDTO);
	}
	
	//list
	public List<ReplyDTO> getList(Map<String , Object> map) {
		return sqlSession.selectList(NAMESPACE+"getList", map);
	}
	public Long getTotalCount(ReplyDTO replyDTO) {
		return sqlSession.selectOne(NAMESPACE+"getTotalCount", replyDTO);
	}
	
	//delete
	public int setDelete(ReplyDTO replyDTO)throws Exception{
		return sqlSession.delete(NAMESPACE+"setDelete", replyDTO);
	}
	
	//update
	public int setUpdate(ReplyDTO replyDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"setUpdate", replyDTO);
	}
}

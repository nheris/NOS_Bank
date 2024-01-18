package com.winter.app.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE ="com.winter.app.member.MemberDAO.";
	
	public int join(MemberDTO memberDTO)throws Exception {
		return sqlSession.insert(NAMESPACE+"join", memberDTO);
	}
	
	public int setFileAdd(AvatarDTO avatarDTO) throws Exception  {
		return sqlSession.insert(NAMESPACE+"setFileAdd", avatarDTO);
	}
	
	public MemberDTO getDetail(MemberDTO memberDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getDetail", memberDTO);
	}
	
}

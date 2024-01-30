package com.winter.app.member;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.multi.MultiOptionPaneUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.util.FileManager;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private FileManager fileManager;
	@Autowired
	private ServletContext servletContext;
	
	
	//join
	public int join(MemberDTO memberDTO, MultipartFile attachs) throws Exception {
		int result = memberDAO.join(memberDTO);
		
		if(attachs.isEmpty()) {
			return result;
		}
		
		String path = servletContext.getRealPath("resources/upload/member");
		String fileName = fileManager.fileSave(path, attachs);
		
		AvatarDTO avatarDTO = new AvatarDTO();
		avatarDTO.setFileName(fileName);
		avatarDTO.setOriName(attachs.getOriginalFilename());
		avatarDTO.setUserName(memberDTO.getUserName());
		
		result = memberDAO.setFileAdd(avatarDTO);

		
		return result;
	}
	
	//login
	public MemberDTO getLogin(MemberDTO memberDTO) throws Exception{
		MemberDTO m= memberDAO.getDetail(memberDTO);
		
		if(m != null) {
			if(m.getPassword().equals(memberDTO.getPassword())) {
				//공백으로 회원정보 수정했을때 다시로그인해야 뜨는거..수정?
				// 걍 @GetMapping("mypage")에서 새로 db 에서 꺼낼거임
				return m;
			}else {
				m=null;
				//return null;
			}
		}
		return m;
	}
	
	//update
	public int setUpdate(MemberDTO memberDTO) throws Exception {
		return memberDAO.setUpdate(memberDTO);
	}
	
	//mypage
	
	public MemberDTO getDetail(MemberDTO memberDTO) throws Exception {
		return memberDAO.getDetail(memberDTO);
	}
	
}

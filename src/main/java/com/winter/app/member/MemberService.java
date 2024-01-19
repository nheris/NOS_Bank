package com.winter.app.member;

import javax.servlet.ServletContext;
import javax.swing.plaf.multi.MultiOptionPaneUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
				return m;
			}else {
				m=null;
				//return null;
			}
		}
		return m;
	}
	
}

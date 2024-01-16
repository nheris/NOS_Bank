package com.winter.app.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;


@Component
public class FileManager {
	//파일삭제
	public boolean fileDelete(String path, String fileName)throws Exception{
		File file = new File(path, fileName);
		return file.delete();
	}

	//파일저장
	public String fileSave(String path, MultipartFile file) throws Exception{
		
		System.out.println(path);
		
		// path : realpath
		File f = new File(path);
		

		
		if(f.isFile()) {
			//파일 있다면 메서드 종료
			throw new Exception();
			//return;
		}
		//경로에 폴더 없을경우
		if(!f.exists()) {
			//폴더 만들어
			f.mkdirs();
		}
		
		//2. 어떤 파일명으로 저장할 것인가? 중복이름안되게끔보장 ,확장자
			//1) 시간 사용 또는
		Calendar ca = Calendar.getInstance();
		String filename = ca.getTimeInMillis()+"_"+file.getOriginalFilename();
		System.out.println(filename);
			//2) UUID 클래스 사용
		filename = UUID.randomUUID().toString()+"_"+file.getOriginalFilename();
		System.out.println(filename);
		
		f = new File(f, filename);
		//3. 파일을 저장
			//1) FileCopyUtils 클래스 사용 또는 
//		FileCopyUtils.copy(file.getBytes(), f);//path 주소로 사진 들어와있는지 확인랴ㅣ
		
			//2)MultipartFile 클래스 transferTo() 메서드 사용
		file.transferTo(f); //어디에 저장할거임?
		
		return filename;
		
	}
}

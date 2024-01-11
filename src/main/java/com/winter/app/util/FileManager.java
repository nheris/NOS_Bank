package com.winter.app.util;

import java.io.File;
import java.util.Calendar;

import org.springframework.web.multipart.MultipartFile;

public class FileManager {
	//파일 저장
	public String[] fileSave(String path, MultipartFile[] file) throws Exception {
		
		File f = new File(path);
		if(f.isFile()) {
			throw new Exception();
		}
		if(!f.exists()) {
			f.mkdirs();
		}
		
		
		Calendar cal = Calendar.getInstance();
		
		String[] fileName = new String[file.length];
		for(int i=0; i<file.length ;i++) {
			fileName[i] = cal.getTimeInMillis() +"_"+file[i].getOriginalFilename();
			
			f = new File(f, fileName[i]);
			
			file[i].transferTo(f); 
			
		}
		
		return fileName;
	}
}

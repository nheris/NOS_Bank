package com.winter.app.board.notice;

import static org.junit.Assert.assertNotEquals;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.MyTest;
import com.winter.app.board.BoardDAO;
import com.winter.app.board.BoardDTO;
import com.winter.app.util.Pager;

public class NoticeDAOTest extends MyTest{
	@Autowired
	private NoticeDAO noticeDAO;
	
	//@Test
	public void test() throws Exception{
		this.getListTest();
	}
	
	
	
	
	public void getListTest() throws Exception{
		Pager pager = new Pager();
		pager.makeRow();
		List<BoardDTO> ar = noticeDAO.getList(pager);
		assertNotEquals(0, ar.size());
	}
	
	@Test
	public void test2() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		
		Calendar calendar = null;
		Date time = (Date) calendar.getTime();
		for(int i=0;i<60;i++) {
			boardDTO.setBoardTitle("TITLE"+i);
			boardDTO.setBoardWriter("관리자");
			boardDTO.setBoardContents("내용");
			boardDTO.setBoardDate(time);
			boardDTO.setBoardCheck(0L);
			
			int result = noticeDAO.setAdd(boardDTO);
			if(i%10==0) {
				Thread.sleep(500);//0.5초
				
			}
		}
		System.out.println("60개 입력 완료");
		//assertEquals(1, result);

	}
}

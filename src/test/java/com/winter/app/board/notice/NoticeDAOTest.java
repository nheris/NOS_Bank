package com.winter.app.board.notice;

import static org.junit.Assert.assertNotEquals;

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
	
	@Test
	public void test() throws Exception{
		this.getListTest();
	}
	
	
	
	
	public void getListTest() throws Exception{
		Pager pager = new Pager();
		pager.makeRow();
		List<BoardDTO> ar = noticeDAO.getList(pager);
		assertNotEquals(0, ar.size());
	}
}

package com.iu.start.board.noticeDAOTest;

import static org.junit.Assert.*;

import java.util.List;

import javax.servlet.ServletContext;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.web.WebAppConfiguration;

import com.iu.start.MyAbstractTest;
import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.notice.NoticeDAO;
import com.iu.start.board.notice.NoticeDTO;

@WebAppConfiguration
public class NoticeDAOTest extends MyAbstractTest{

	@Autowired
	private NoticeDAO noticeDAO;
	
//	@Autowired
//	private ServletContext servletContext;
	
	@Test
	public void setAddTest() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
//		NoticeDTO noticeDTO = new NoticeDTO();
		for(int i = 0; i <44; i++) {
		boardDTO.setTitle("KK" + i);
		boardDTO.setWriter("KNJ" + i);
		boardDTO.setContents("kkkkkk" + i);
		int result = noticeDAO.setAdd(boardDTO);
		
			if(i%10 == 0) {
				Thread.sleep(500);
				}
		}
		System.out.println("Finish!!!");
//		assertEquals(1, result);
	}
	
//	@Test
//	public void getListTest() throws Exception {
//		List<BoardDTO> ar = noticeDAO.getList();
//		assertNotEquals(0, ar.size());
//	}
	
//	@Test
	public void getDetailTest() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
//		NoticeDTO noticeDTO = new NoticeDTO();
		boardDTO.setNum(1L);
		boardDTO = (NoticeDTO) noticeDAO.getDetail(boardDTO);
		assertNotNull(boardDTO);
	}
	
//	@Test
	public void setUpdateTest() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
//		NoticeDTO noticeDTO = new NoticeDTO();
		boardDTO.setNum(1L);
		boardDTO.setTitle("hahaha");
		boardDTO.setContents("hahahahaha");
		int result = noticeDAO.setUpdate(boardDTO);
		assertEquals(1, result);
	}
	
//	@Test
	public void setDeleteTest() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
//		NoticeDTO noticeDTO = new NoticeDTO();
		boardDTO.setNum(1L);
		int result = noticeDAO.setDelete(boardDTO);
		assertEquals(1, result);
	}
	
//	@Test
//	public void getCount() throws Exception {
//		long result = noticeDAO.getCount(pager);
//		System.out.println(result);
//	}

}

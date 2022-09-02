package com.iu.start.board.qna;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.MyAbstractTest;
import com.iu.start.board.impl.BoardDAO;
import com.iu.start.board.impl.BoardDTO;

public class QnaDAOTest extends MyAbstractTest{
	
	@Autowired
	private QnaDAO qnaDAO;

//	@Test
//	public void getListTest() throws Exception {
//		List<BoardDTO> ar = qnaDAO.getList();
//		assertNotEquals(0, ar);
//	}
	
//	@Test
	public void setAdd() throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("hahaho");
		qnaDTO.setWriter("hoho");
		qnaDTO.setContents("hahaha");
		int result = qnaDAO.setAdd(qnaDTO);
		assertEquals(1, result);
	}
	
//	@Test
	public void getDetail() throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setNum(62L);
		qnaDTO = (QnaDTO) qnaDAO.getDetail(qnaDTO);
		assertNotNull(qnaDTO);
	}
	
//	@Test
	public void setUpdate() throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("hahahaha");
		qnaDTO.setContents("hahahaha");
		qnaDTO.setNum(62L);
		int result = qnaDAO.setUpdate(qnaDTO);
		assertEquals(1, result);
	}
	
//	@Test
	public void setDelete() throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setNum(62L);
		int result = qnaDAO.setDelete(qnaDTO);
		assertEquals(1, result);
	}

}

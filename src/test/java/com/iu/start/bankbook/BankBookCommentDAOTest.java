package com.iu.start.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;

import com.iu.start.MyAbstractTest;
import com.iu.start.util.CommentPager;

@WebAppConfiguration
public class BankBookCommentDAOTest extends MyAbstractTest{
	
	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;

//	@Test
	public void setCommentAddTest() throws Exception{
		BankBookCommentDTO bankBookCommentDTO = new BankBookCommentDTO();
		bankBookCommentDTO.setWriter("hoho");
		bankBookCommentDTO.setContents("hoho");
		bankBookCommentDTO.setBookNum(1L);
		
		int result = bankBookCommentDAO.setCommentAdd(bankBookCommentDTO);
		assertEquals(1, result);
	}
	
	@Test
	public void getCommentList()throws Exception {
		CommentPager commentPager = new CommentPager();
		commentPager.getRowNum();
		List<BankBookCommentDTO> ar = bankBookCommentDAO.getCommentList(commentPager);
		assertNotNull(ar.size());
	}

}

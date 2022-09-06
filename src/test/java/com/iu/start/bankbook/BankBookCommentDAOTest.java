package com.iu.start.bankbook;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BankBookCommentDAOTest {
	
	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;

	@Test
	public void setCommentAddTest() throws Exception{
		BankBookCommentDTO bankBookCommentDTO = new BankBookCommentDTO();
		bankBookCommentDTO.setWriter("hoho");
		bankBookCommentDTO.setContents("hoho");
		bankBookCommentDTO.setBookNum(1L);
		
		int result = bankBookCommentDAO.setCommentAdd(bankBookCommentDTO);
		assertEquals(1, result);
	}

}

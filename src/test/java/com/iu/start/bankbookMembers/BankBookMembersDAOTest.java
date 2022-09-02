package com.iu.start.bankbookMembers;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.MyAbstractTest;
import com.iu.start.test.members.BankMembersDAO;
import com.iu.start.test.members.BankMembersDTO;

public class BankBookMembersDAOTest extends MyAbstractTest{
	@Autowired
	private BankMembersDAO bankMembersDAO;
	
	@Test
	public void getMyPageTest() throws Exception {
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUsername("QQQQQQQ");
		bankMembersDTO.setEmail("QQQ@QQQQ");
		bankMembersDTO.setName("QQQQQQQQ");
		bankMembersDTO.setPhone("QQ");
		bankMembersDTO = bankMembersDAO.getMyPage(bankMembersDTO);
		System.out.println(bankMembersDTO.getEmail());
		assertNotNull(bankMembersDTO);
	}
	
//	@Test
	public void setJoinTest()throws Exception{
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUsername("QQQQQQQ");
		bankMembersDTO.setPassword("QQQQQQ");
		bankMembersDTO.setEmail("QQQ@QQQQ");
		bankMembersDTO.setName("QQQQQQQQ");
		bankMembersDTO.setPhone("QQ");
		int result = bankMembersDAO.setJoin(bankMembersDTO);
//		throw new Exception();
		assertEquals(1, result);
	}
	
//	@Test
	public void getLoginTest()throws Exception{
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUsername("RR");
		bankMembersDTO.setPassword("WW");
		Object obj = bankMembersDAO.getLogin(bankMembersDTO);
		assertNotNull(obj);
	}
	
//	@Test
	public void getSearch() throws Exception{
		String search = "ㅎ";
		List<BankMembersDTO> ar = bankMembersDAO.getSearchById(search);
		assertNotEquals(0, ar.size());
	}
}

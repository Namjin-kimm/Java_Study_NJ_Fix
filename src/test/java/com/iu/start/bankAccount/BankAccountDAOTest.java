package com.iu.start.bankAccount;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.MyAbstractTest;
import com.iu.start.test.members.BankMembersDTO;

public class BankAccountDAOTest extends MyAbstractTest{

	@Autowired
	private BankAccountDAO bankAccountDAO;
	
	@Test
	public void getListTest()throws Exception {
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUsername("RR");
		List<BankAccountDTO> ar = bankAccountDAO.getListByUserName(bankMembersDTO);
		assertNotEquals(0, ar.size());
	}

}

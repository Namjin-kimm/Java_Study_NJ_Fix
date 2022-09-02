package com.iu.start.bankAccount;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.start.test.members.BankMembersDTO;

@Service
public class BankAccountService {
	
	@Autowired
	private BankAccountDAO bankAccountDAO;

	public int add(BankAccountDTO bankAccountDTO) throws Exception{
		return bankAccountDAO.add(bankAccountDTO);
	}
	
	public List<BankAccountDTO> getList(BankMembersDTO bankMembersDTO)throws Exception{
	      return bankAccountDAO.getListByUserName(bankMembersDTO);
	   }

	}


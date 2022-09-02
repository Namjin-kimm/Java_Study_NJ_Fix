package com.iu.start.test.members;

import java.util.List;

public interface MembersDAO {
	
	//bankMembers 회원가입
	public int setJoin(BankMembersDTO bankMembersDTO)throws Exception;
	
	public List<BankMembersDTO> getSearchById(String search) throws Exception;

	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO)throws Exception;
	
	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO)throws Exception;
}

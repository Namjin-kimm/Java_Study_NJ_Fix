package com.iu.start.test.members;

import java.util.List;

import com.iu.start.bankAccount.BankAccountDTO;

public class BankMembersDTO {
	private String username;
	private String password;
	private String name;
	private String email;
	private String phone;
	private List<BankAccountDTO> bankAccountDTOs;
	private BankMembersFileDTO bankMembersFileDTO;
	
	
	
	public BankMembersFileDTO getBankMembersFileDTO() {
		return bankMembersFileDTO;
	}
	public void setBankMembersFileDTO(BankMembersFileDTO bankMembersFileDTO) {
		this.bankMembersFileDTO = bankMembersFileDTO;
	}
	public List<BankAccountDTO> getBankAccountDTOs() {
		return bankAccountDTOs;
	}
	public void setBankAccountDTOs(List<BankAccountDTO> bankAccountDTOs) {
		this.bankAccountDTOs = bankAccountDTOs;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}

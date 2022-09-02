package com.iu.start.bankAccount;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.test.members.BankMembersDTO;

@Controller
@RequestMapping("/bankAccount/*")
public class BankAccountController {
	
	@Autowired
	private BankAccountService bankAccountService;
	
	@RequestMapping(value = "add.iu", method = RequestMethod.GET)
	public ModelAndView add(BankAccountDTO bankAccountDTO, HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("BankAccount Add");
		System.out.println(bankAccountDTO.getBookNum());
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
		bankAccountDTO.setUserName(bankMembersDTO.getUsername());
		//DTO : userName, bankNum
		int result = this.bankAccountService.add(bankAccountDTO);
		mv.addObject("account", bankMembersDTO);
		mv.setViewName("redirect:/");
		
		return mv;
	}

}

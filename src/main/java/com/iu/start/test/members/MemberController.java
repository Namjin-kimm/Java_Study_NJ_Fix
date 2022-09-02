package com.iu.start.test.members;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.bankAccount.BankAccountService;
import com.iu.start.bankbook.BankBookDTO;

@Controller
@RequestMapping(value = "/member/*")
//이 클래스는 Controller 역할
//Container에게 이 클래스의 객체를 생성 위임
public class MemberController {
	@Autowired
	private BankMembersService bankMembersService;
	
//	@Autowired
//	private BankAccountService bankAccountService;
	
	//annotation
	//@ : 설명 + 실행
	
	@RequestMapping(value = "myPage.iu", method = RequestMethod.GET)
	public ModelAndView myPage(HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		BankMembersDTO bankMembersDTO = (BankMembersDTO) session.getAttribute("member");
		bankMembersDTO = bankMembersService.getMyPage(bankMembersDTO);
		mv.addObject("myPage", bankMembersDTO);
		mv.setViewName("member/mypage");
		System.out.println(bankMembersDTO.getBankMembersFileDTO().getFileName());
		return mv;
	}
	@RequestMapping(value = "logout.nj", method = RequestMethod.GET )
	public String logout(HttpSession session)throws Exception{
		session.invalidate();
		return "redirect: ../";
	}
	
	// /member/login
	@RequestMapping(value = "login.iu", method= RequestMethod.GET)
	
	public void login() {
		System.out.println("로그인 실행");
		
//		return "/member/login";
	}
	
@RequestMapping(value = "login.iu", method= RequestMethod.POST)
	
	public String login(BankMembersDTO bankMembersDTO, HttpSession session) throws Exception{
		System.out.println("DB 로그인 실행");
		bankMembersDTO = bankMembersService.getLogin(bankMembersDTO);
		System.out.println(bankMembersDTO);
//		"redirect: 다시접속할 URL주소(절대경로,상대경로)"
//		model.addAttribute("member", bankMembersDTO);
		session.setAttribute("member", bankMembersDTO);
		return "redirect:../";
	}
	
	// /member/search  GET  -> 아이디를 입력하는 폼
	// /WEB-INF/views/member/search.jsp
	// id를 입력해서 검색 -> /member/search POST   출력 /WEB-INF/views/member/list.jsp
	@RequestMapping(value = "search", method = RequestMethod.GET)
	public void getSearchById() {
		System.out.println("search 실행");
//		return "/member/search";
	}
	
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public ModelAndView getSearchById(String search, ModelAndView mv) throws Exception {
		System.out.println("search 실행");
		List<BankMembersDTO> ar = bankMembersService.getSearchById(search);
		mv.setViewName("member/list");
		mv.addObject("search", ar);
		return mv;
	}
	
	@GetMapping(value = "agree.iu")
	public String getAgree()throws Exception {
		System.out.println("agree get 실행");
		return "member/agree";
	}
	
	//join /member/join
	@RequestMapping(value = "join.iu", method = RequestMethod.GET)
	
	public String join() {
		System.out.println("조인 GET 실행");
		
		return "member/join";
		
		
	}
	
	@RequestMapping(value = "join.iu", method = RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO, MultipartFile photo, HttpSession session) throws Exception {
		System.out.println("조인 POST 실행");
		System.out.println("upload 파일명 : " + photo.getOriginalFilename());
		System.out.println("upload 파라미터명 : " + photo.getName());
		System.out.println("upload 파일 크기 : " + photo.getSize());
		
//		BankMembersDTO bankMembersDTO = new BankMembersDTO();
//		bankMembersDTO.setUsername(request.getParameter("id"));
//		bankMembersDTO.setPassword(request.getParameter("pw"));
//		bankMembersDTO.setName(request.getParameter("name"));
//		bankMembersDTO.setEmail(request.getParameter("email"));
//		bankMembersDTO.setPhone(request.getParameter("phone"));
		
		
			int result = bankMembersService.setJoin(bankMembersDTO, photo, session.getServletContext());
//			System.out.println(result == 1);
		return "redirect:login.iu";
	}
	
//	public String join(String id, String pw, String name, String email, String phone) throws Exception {
//		System.out.println("조인 POST 실행");
//		BankMembersDTO bankMembersDTO = new BankMembersDTO();
//		bankMembersDTO.setUsername(id);
//		bankMembersDTO.setPassword(pw);
//		bankMembersDTO.setName(name);
//		bankMembersDTO.setEmail(email);
//		bankMembersDTO.setPhone(phone);
//		
//		
//			int result = bankMembersDAO.setJoin(bankMembersDTO);
//			System.out.println(result);
//		return "/member/join";
//	}
}

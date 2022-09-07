package com.iu.start.bankbook;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.util.CommentPager;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankBookController {
	@Autowired
	private BankBookService bankBookService;
	
	
//	@PostMapping(value = "commentAdd")
//	public ModelAndView commentAdd(BankBookCommentDTO bankBookCommentDTO) throws Exception{
//		System.out.println(bankBookCommentDTO.getBookNum());
//		System.out.println(bankBookCommentDTO.getWriter());
//		System.out.println(bankBookCommentDTO.getContents());
//		int result = bankBookService.setCommentAdd(bankBookCommentDTO);
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("result", result);
//		mv.setViewName("common/ajaxResult");
//		return mv;
//	}
	
	
	//1.JSP에 출력하고 결과물을 응답으로 전
	@GetMapping(value = "commentList")
	@ResponseBody
	public Map<String, Object> commentList(CommentPager commentPager)throws Exception {
		ModelAndView mv = new ModelAndView();
		List<BankBookCommentDTO> list = bankBookService.getCommentList(commentPager);
//		mv.addObject("commentList", list);
//		mv.setViewName("common/commentList");
		
		//json
		//DTO == {}
		//num=1 == {"num":1, "bookNum":123, "writer":"name"}
		//["num":1, "bookNum":123, "writer"
		//totalCount도 보내야 하고 commentPager도 보내야 하니 Map을 사용한다
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("pager", commentPager);
		
		return map;
	}
	
//	@GetMapping(value = "commentList")
//	@ResponseBody
//	public String commentList(CommentPager commentPager)throws Exception {
//		List<BankBookCommentDTO> list = bankBookService.getCommentList(commentPager);
//		String jsonResult = "{\"list\":\""+ list + "\"}";
//		System.out.println(list.size());
//		return jsonResult;
//	}
	
	@PostMapping(value = "commentAdd")
	@ResponseBody
	public String commentAdd(BankBookCommentDTO bankBookCommentDTO) throws Exception{
		int result = bankBookService.setCommentAdd(bankBookCommentDTO);
		ModelAndView mv = new ModelAndView();
		//{}
		String jsonResult = "{\"result\":\""+result+"\"}";
		return jsonResult;
	}
	
	// /bankbook/delete GET
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView delete(BankBookDTO bankBookDTO) throws Exception{
		System.out.println("delete 실행");
		ModelAndView mv = new ModelAndView();
		int result = bankBookService.setDelete(bankBookDTO);
		System.out.println(result);
		mv.setViewName("redirect: list.iu");
		
		return mv;
		
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(BankBookDTO bankBookDTO, Model model) throws Exception{
		System.out.println("update 실행");
		System.out.println(bankBookDTO.getBookNum());
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		model.addAttribute("dto", bankBookDTO);
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(BankBookDTO bankBookDTO) throws Exception{
		System.out.println("update post 실행");
		ModelAndView mv = new ModelAndView();
		int result = bankBookService.setUpdate(bankBookDTO);
		System.out.println(result);
		mv.setViewName("redirect: detail?bookNum=" + bankBookDTO.getBookNum());
		return mv;
	}
	
	@RequestMapping(value = "list.iu", method = RequestMethod.GET)
	public String list(Model model) throws Exception{
		System.out.println("list 실행");
//		ModelAndView mv = new ModelAndView();
		List<BankBookDTO> ar = bankBookService.getList();
		model.addAttribute("list", ar);
		return "bankbook/list";
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView detail(BankBookDTO bankBookDTO)throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("detail 실행");
//		System.out.println("bookNum :" + bookNum);
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		mv.setViewName("bankbook/detail");
		mv.addObject("detail", bankBookDTO);
		
		return mv;
		
//		return "bankbook/detail";
	}
	
	// /bankbook/add GET /WEB-INF/views/bankbook/add.jsp
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() {
		System.out.println("add 실행");
//		return "/bankbook/add";
//		요청한 URI주소와 View(jsp)의 경로명이 일치 할 경우 리턴타입을 void로 할 수 있다
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView add(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("실행");
		bankBookDTO.setBookNum(Calendar.getInstance().getTimeInMillis());
		bankBookDTO.setBookSale(1);
		ModelAndView mv = new ModelAndView();
		int result = bankBookService.setBankBook(bankBookDTO);
		System.out.println(result);
		mv.setViewName("redirect:list.iu");
		return mv;
	}

}

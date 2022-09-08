package com.iu.start.board.notice;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.test.members.BankMembersDTO;
import com.iu.start.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "notice";
	}
	
//	글목록
	@RequestMapping(value = "list.iu", method = RequestMethod.GET)
	public ModelAndView getList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println(pager.getPage());
//		System.out.println("Page : " + page);
		System.out.println(pager.getSearch());
		System.out.println(pager.getKind());
		
		List<BoardDTO> ar = noticeService.getList(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
//		mv.addObject("board", "Notice");
		mv.setViewName("board/list");
		return mv;
	}
	
//	글상세
	@RequestMapping(value = "detail.iu", method = RequestMethod.GET)
	public ModelAndView getDetail(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getDetail(boardDTO);
		mv.addObject("boardDTO", boardDTO);
//		mv.addObject("board", "Notice");
		mv.setViewName("board/detail");
		return mv;
	}
	
//	글작성
	@RequestMapping(value = "add.iu", method = RequestMethod.GET)
	public String setAdd(HttpSession session)throws Exception{
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
		
		if(bankMembersDTO != null) {
			return "board/add";
		}else {
			return "redirect:../member/login.iu";
		}
	}
	
	@RequestMapping(value = "add.iu", method = RequestMethod.POST)
	public ModelAndView setAdd(BoardDTO boardDTO, MultipartFile [] files, HttpSession session)throws Exception{
		int result = noticeService.setAdd(boardDTO, files, session.getServletContext());
		ModelAndView mv = new ModelAndView();
		
		String url = "list.iu";
		String message = "등록 실패";
		if(result != 0) {
			message = "등록 성공";
		}
		mv.addObject("url", url);
		mv.addObject("message", message);
		
		mv.setViewName("common/result");
		return mv;
	}
	
//	글수정
	@RequestMapping(value = "update.iu") // method 안 쓰면 GET 이다.
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv)throws Exception{
		boardDTO = noticeService.getDetail(boardDTO);
		mv.addObject("boardDTO", boardDTO);
//		mv.addObject("board", "Notice");
		mv.setViewName("board/update");
		return mv;
	}
	@RequestMapping(value = "update.iu", method = RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO)throws Exception{
		int result = noticeService.setUpdate(boardDTO);
		return "redirect:detail.iu?num=" + boardDTO.getNum();
	}
	
//	글삭제
	@RequestMapping(value = "delete.iu")
	public String setDelete(BoardDTO boardDTO)throws Exception{
		int result = noticeService.setDelete(boardDTO);
		return "redirect:list.iu";
	}

}

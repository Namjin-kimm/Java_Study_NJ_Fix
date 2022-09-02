package com.iu.start.board.qna;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.util.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "qna";
	}
	
	@PostMapping("reply.iu")
	public String setReply(QnaDTO qnaDTO)throws Exception{
		//qnaDTO에는 num, writer, title, contents 데이터가 들어가있다.
		int result = qnaService.setReply(qnaDTO);
		return "redirect:list.iu";
	}
	
	@GetMapping("reply.iu")
	public ModelAndView setReply(BoardDTO boardDTO, ModelAndView mv)throws Exception {
		//이 때 받아오는 boardDTO에는 detail.jsp에서 넘어온 num의 정보만 들어가 있다.
		mv.addObject("boardDTO", boardDTO);
		mv.setViewName("board/reply");
		return mv;
	}

	@RequestMapping(value = "list.iu")
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = qnaService.getList(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
//		mv.addObject("board", "QnA");
		mv.setViewName("board/list");
		return mv;
	}
	
	@RequestMapping(value = "detail.iu")
	public ModelAndView getDetail(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardDTO = qnaService.getDetail(boardDTO);
		mv.addObject("boardDTO", boardDTO);
//		mv.addObject("board", "QnA");
		mv.setViewName("board/detail");
		return mv;
	}
	
	@RequestMapping(value = "add.iu")
	public ModelAndView setAdd() throws Exception {
		ModelAndView mv = new ModelAndView();
//		mv.addObject("board", "QnA");
		mv.setViewName("board/add");
		return mv;
	}
	@RequestMapping(value = "add.iu", method = RequestMethod.POST)
	public String setAdd(BoardDTO boardDTO, MultipartFile [] files, HttpSession session) throws Exception {
		int result = qnaService.setAdd(boardDTO, files, session.getServletContext());
		return "redirect:list.iu";
	}
	
	@RequestMapping(value = "update.iu")
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv) throws Exception {
		boardDTO = qnaService.getDetail(boardDTO);
		mv.addObject("boardDTO", boardDTO);
//		mv.addObject("board", "QnA");
		mv.setViewName("board/update");
		return mv;
	}
	
	@RequestMapping(value = "update.iu", method = RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO) throws Exception {
		int result = qnaService.setUpdate(boardDTO);
		return "redirect:detail.iu?num=" + boardDTO.getNum();
	}
	
	@RequestMapping(value = "delete.iu")
	public String setDelete(BoardDTO boardDTO) throws Exception {
		int result = qnaService.setDelete(boardDTO);
		return "redirect:list.iu";
	}
}

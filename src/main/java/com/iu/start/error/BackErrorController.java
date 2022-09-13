package com.iu.start.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/errors/*")
public class BackErrorController {

	@GetMapping("error404")
	public ModelAndView error404()throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("404");
		mv.setViewName("/errors/error_404");
		return mv;
	}
	@GetMapping("error400")
	public ModelAndView error400()throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("400");
		mv.setViewName("/errors/error_404");
		return mv;
	}
}

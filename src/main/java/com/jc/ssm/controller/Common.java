package com.jc.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Common {
	@RequestMapping("/pageNoFound")
	public ModelAndView pageNoFound(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/404");
		return mv; 
	}	
}

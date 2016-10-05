package com.jc.ssm.controller.base;

import org.springframework.web.servlet.ModelAndView;

import com.jc.ssm.model.User;
import com.jc.ssm.util.SysContext;

public class BaseController {

	public ModelAndView errMsg(String errMsg){
		SysContext.getSession().setAttribute("errMsg", errMsg);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/manage/common/errMsg");
		return mv;
	}
	
	public ModelAndView infoMsg(String infoMsg){
		SysContext.getSession().setAttribute("infoMsg", infoMsg);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/manage/common/infoMsg");
		return mv;
	}

	public ModelAndView infoMsg(String infoMsg, String backToUrl){
		SysContext.getSession().setAttribute("infoMsg", infoMsg);
		SysContext.getSession().setAttribute("backToUrl", backToUrl);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/manage/common/infoMsg");
		return mv;
	}
	
	public User getCurrentUser(){
		User user = (User)SysContext.getSession().getAttribute("user");
		return user;
	}
	
	public long getCurrentUserId(){
		return getCurrentUser().getId();
	}
}

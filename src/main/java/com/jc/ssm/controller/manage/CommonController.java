package com.jc.ssm.controller.manage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jc.ssm.util.SysContext;

@Controller
public class CommonController {
	
	@RequestMapping("/manage/common/infoMsg")
	public ModelAndView showInfoMsg(){
		String infoMsg = (String) SysContext.getSession().getAttribute("infoMsg");
		String backToUrl = (String) SysContext.getSession().getAttribute("backToUrl");
		
		HttpServletRequest request = SysContext.getRequest();
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
				+ "/";
		
		if (backToUrl == null){
			backToUrl = "javascript:history.go(-1)";
		} else {
			backToUrl = basePath + backToUrl;
			SysContext.getSession().removeAttribute("backToUrl");
		}
		SysContext.getSession().removeAttribute("infoMsg");
		ModelAndView mv = new ModelAndView();
		mv.addObject("infoMsg", infoMsg);
		mv.addObject("backToUrl", backToUrl);
		mv.setViewName("common/infoMsg");
		return mv;
	}
	@RequestMapping("/manage/common/errMsg")
	public ModelAndView showErrMsg(){
		String errMsg = (String) SysContext.getSession().getAttribute("errMsg");
		SysContext.getSession().removeAttribute("errMsg");
		ModelAndView mv = new ModelAndView();
		mv.addObject("errMsg", errMsg);
		mv.setViewName("common/errMsg");
		return mv;
	}
}

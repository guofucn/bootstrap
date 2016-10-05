package com.jc.ssm.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jc.ssm.model.User;
import com.jc.ssm.service.UserService;
import com.jc.ssm.util.SysContext;

@Controller
public class Index {
	private UserService userSerivce;

	public UserService getUserSerivce() {
		return userSerivce;
	}

	@Resource
	public void setUserSerivce(UserService userSerivce) {
		this.userSerivce = userSerivce;
	}

	/**
	 * @Title: login @Description: 显示登录页面 @param @return @return
	 *         ModelAndView @throws
	 */
	@RequestMapping(value = "/manage/user/login", method = RequestMethod.GET)
	public ModelAndView login(String err) {
		ModelAndView mv = new ModelAndView();
		if (err != null && err.equals("1")) {
			mv.addObject("errMsg", "用户名或密码错误");
		}
		mv.setViewName("user/login");
		return mv;
	}

	/**
	 * 
	 * @Title: login @Description: 验证登录 @param @param userName @param @param
	 *         password @param @return @return ModelAndView @throws
	 */
	@RequestMapping(value = "/manage/user/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(value = "userName", required = true) String userName,
			@RequestParam(value = "password") String password) {
		ModelAndView mv = new ModelAndView();
		User user = userSerivce.checkPassword(userName, password);

		if (user != null) {
			SysContext.getSession().setAttribute("user", user);
			mv.setViewName("redirect:/manage/main/index");
		} else {
			mv.setViewName("redirect:/manage/user/login?err=1");
		}
		return mv;
	}
}

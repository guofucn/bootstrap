package com.jc.ssm.controller.manage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
* @ClassName: Main  
* @Description: 后台首页
* @author guofu 81378536_qq_com  
* @date 2016年5月14日 下午8:15:12  
 */
@Controller
public class MainController {
	
	@RequestMapping("/manage/main/index")
	public ModelAndView index(){
		return new ModelAndView("main/index");
	}
}

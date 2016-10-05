package com.jc.ssm.aspectj;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.jc.ssm.model.User;
import com.jc.ssm.util.SysContext;

@Component
@Aspect
public class ControllerAOP {

	// @Pointcut("within(@org.springframework.stereotype.Controller *)")
	// public void cutController() {
	// }
	//
	// @Before("cutController()")
	// public void doBefore(JoinPoint joinPoint) {
	// System.out.println("before");
	// }

	/**
	 * 
	* @Title: 后台权限控制  
	* @Description: 
	* @param @param pjp
	* @param @return
	* @param @throws Throwable
	* @return Object
	* @throws
	 */
	// @Around("within(@org.springframework.stereotype.Controller *)")
	@Around("execution(* com.jc.ssm.controller.manage.*.* (..))")
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		HttpServletRequest request = SysContext.getRequest();
		HttpServletResponse response = SysContext.getResponse();
		HttpSession session = SysContext.getSession();
		User user = (User) session.getAttribute("user");

		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
				+ "/";

		try {
			if (user == null || user.getUserName() == null) {
				throw new Exception();
			}
		} catch (Exception e) {
			response.sendRedirect(basePath + "manage/user/login");
			return null;
		}

		Object object = pjp.proceed();// 执行该方法
		return object;
	}
}

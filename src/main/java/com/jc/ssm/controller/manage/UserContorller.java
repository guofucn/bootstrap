package com.jc.ssm.controller.manage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jc.ssm.controller.base.BaseController;
import com.jc.ssm.model.ConnectSet;
import com.jc.ssm.model.MarketPlace;
import com.jc.ssm.model.Shop;
import com.jc.ssm.model.User;
import com.jc.ssm.service.ConnectSetService;
import com.jc.ssm.service.MarketPlaceService;
import com.jc.ssm.service.ShopService;
import com.jc.ssm.service.UserService;
import com.jc.ssm.util.SysContext;

@Controller
public class UserContorller extends BaseController{
	private UserService userService;
	private ConnectSetService connectSetService;
	private ShopService shopService;
	private MarketPlaceService marketPlaceSerivce;

	public ShopService getShopService() {
		return shopService;
	}

	@Resource
	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}

	public ConnectSetService getConnectSetService() {
		return connectSetService;
	}

	@Resource
	public void setConnectSetService(ConnectSetService connectSetService) {
		this.connectSetService = connectSetService;
	}

	public UserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(UserService userSerivce) {
		this.userService = userSerivce;
	}
	
	@RequestMapping("/manage/user/userInfo")
	public ModelAndView userInfo() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/userInfo");
		return mv;
	}

	@RequestMapping(value = "/manage/user/editPassword", method = RequestMethod.GET)
	public ModelAndView editPassword() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/editPassword");
		return mv;
	}
	
	@RequestMapping(value = "/manage/user/editPassword", method = RequestMethod.POST)
	public ModelAndView editPassword(@RequestParam(value = "oldPassword") String oldPassword,
			@RequestParam(value = "newPassword") String newPassword, @RequestParam(value = "newPassword2") String newPassword2) {
		if (newPassword == null || newPassword.length() == 0){
			return errMsg("请输入新密码"); 
		} else if (newPassword.length() > 10){
			return errMsg("密码不能超过10位"); 
		} else if (!newPassword.equals(newPassword2)){
			return errMsg("两次密码不一致"); 
		} else {
			User user = (User) SysContext.getSession().getAttribute("user");
			user = userService.checkPassword(user.getUserName(), oldPassword);
			
			if (user == null){
				return errMsg("旧密码输入错误");
			} else{
				if (userService.changePassword(user.getId(), newPassword)){
					return infoMsg("修改密码成功");
				} else{
					return errMsg("修改密码失败");
				}
			}
		}
	}

	@RequestMapping("/manage/user/logout")
	public ModelAndView logout(){
		SysContext.getSession().removeAttribute("user");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@RequestMapping(value = "/manage/user/connectSet", method = RequestMethod.GET)
	public ModelAndView connectSet(){
		ConnectSet connectSet = connectSetService.getConnectSet(getCurrentUserId());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("connectSet", connectSet);
		ModelAndView mv = new ModelAndView("user/connectSet", map);
		return mv;
	}
	
	@RequestMapping(value = "/manage/user/connectSet", method = RequestMethod.POST)
	public ModelAndView connectSet(ConnectSet connectSet){
		long userId = getCurrentUserId();
		connectSet.setUserId(userId);
		connectSetService.updateConnectSet(connectSet);
		return infoMsg("操作成功");
	}
	
	@RequestMapping(value = "/manage/user/listShop", method = RequestMethod.GET)
	public ModelAndView listShop(){
		List<Shop> shops = shopService.listShop(getCurrentUserId());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("shops", shops);
		ModelAndView mv = new ModelAndView("user/listShop", map);
		return mv;
	}
	
	@RequestMapping(value = "/manage/user/editShop", method = RequestMethod.GET)
	public ModelAndView editShop(Long id){
		Shop shop = null;
		if (id != null && id > 0){
			shop = shopService.getShopById(id);
		}
		List<MarketPlace> marketPlaces = marketPlaceSerivce.listAll();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("shop", shop);
		map.put("marketPlaces", marketPlaces);
		return new ModelAndView("user/editShop", map);
	}
	
	@RequestMapping(value = "/manage/user/editShop", method = RequestMethod.POST)
	public ModelAndView editShop(Shop shop){
		if (shop.getShopName() == null || shop.getShopName().length() == 0){
			return errMsg("请输入店铺名");
		}
		
		if (shop.getPlaceId() == null || shop.getPlaceId() == 0){
			return errMsg("请选择店铺所在地区");
		}
		
		shop.setUserId(getCurrentUserId());
		shopService.saveShop(shop);
		return infoMsg("操作成功", "/manage/user/listShop");
	}
	@RequestMapping("/manage/user/delShop")
	public ModelAndView delShop(Long id){
		if (id == null){
			return errMsg("删除失败");
		}
		shopService.delUserShop(getCurrentUserId(), id);
		return infoMsg("删除成功","/manage/user/listShop");
	}

	public MarketPlaceService getMarketPlaceSerivce() {
		return marketPlaceSerivce;
	}

	@Resource
	public void setMarketPlaceSerivce(MarketPlaceService marketPlaceSerivce) {
		this.marketPlaceSerivce = marketPlaceSerivce;
	}
}

package com.jc.ssm.controller.manage;

import java.util.Date;
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
import com.jc.ssm.model.SalesOrder;
import com.jc.ssm.service.SalesOrderService;
import com.jc.ssm.util.DateTimeUtil;
import com.jc.ssm.util.Helper;
import com.jc.ssm.util.Pagination;
import com.jc.ssm.util.SysContext;

@Controller
public class OrderController extends BaseController{
	private SalesOrderService salesOrderService;
	
	public SalesOrderService getSalesOrderService() {
		return salesOrderService;
	}

	@Resource
	public void setSalesOrderService(SalesOrderService salesOrderService) {
		this.salesOrderService = salesOrderService;
	}


	@RequestMapping("/manage/order/list")
	public ModelAndView list(@RequestParam(value = "startDate", required=false) String startDate,
			@RequestParam(value = "endDate", required=false) String endDate,
			@RequestParam(value = "status", required=false) String status,
			@RequestParam(value = "pageNo", required=false) String pageNo){
		
		Date date1 = null;
		Date date2 = null;
		if (startDate != null){
			date1 = DateTimeUtil.StrToDate(startDate);
			if (date1 == null){
				date1 = DateTimeUtil.addDay(DateTimeUtil.currentDate(), -7);
			}
		} else {
			date1 = DateTimeUtil.addDay(DateTimeUtil.currentDate(), -7);
			startDate = DateTimeUtil.DateToStr(date1);
		}
		
		if (endDate != null){
			date2 = DateTimeUtil.StrToDate(endDate);
			if (date2 == null){
				date2 = DateTimeUtil.currentDate();
			}
		} else {
			date2 = DateTimeUtil.currentDate();
			endDate = DateTimeUtil.DateToStr(date2);
		}
		int pageSize = 20; 
		int iPageNo = Helper.StrToInt(pageNo, 1);
		List<SalesOrder> salesOrders = salesOrderService.search(getCurrentUserId(), date1, date2, status, iPageNo, pageSize);
		int rowCount = salesOrderService.searchCount(getCurrentUserId(), date1, date2, status);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("salesOrders", salesOrders);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		map.put("status", status);
		map.put("pageNo", pageNo);
		map.put("rowCount", rowCount);
		map.put("pagination", Pagination.genPagination(iPageNo, pageSize, rowCount, SysContext.getRequest(), "/manage/order/list")); 
		return new ModelAndView("order/list", map);
	}
	
	@RequestMapping(value = "/manage/order/sync", method= RequestMethod.GET)
	public ModelAndView syncOrder(){
		return new ModelAndView("order/sync");
	}
	
	@RequestMapping(value = "/manage/order/sync", method= RequestMethod.POST)
	public ModelAndView syncOrder(@RequestParam(value = "startDate", required=false) Date startDate){
		String result = salesOrderService.syncOrder(getCurrentUserId());
		if (result == null){
			return infoMsg("同步完成");
		} else {
			return errMsg(result);
		}
	}
	
}
